/******************************************************************************* 
 * Copyright 2009-2012 Amazon Services. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 *
 * You may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 *******************************************************************************
 * Marketplace Web Service Runtime Client Library
 */
package com.amazonservices.mws.client;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A MwsReader that reads XML from a java.io.Reader.
 * 
 * @author mayerj
 */
public class MwsXmlReader implements MwsReader {

    /** The input reader under the stream reader. */
    private final InputStream is;

    /** The parsed document. */
    private final Document document;

    /**
     * The current document element. null if beginObject on missing element.
     */
    private Element currentElement;

    /**
     * The current child of element or null if element has no children. Used for
     * round robin searching for elements by name. Most efficient when children
     * of element are looked up in order as is the usual case.
     */
    private Node currentChild;

    /**
     * Lookup a child element by tag name.
     * <p>
     * Will round-robin search using the child field. When returning an element,
     * child is set to next element after the found element.
     * 
     * @param name
     *            The tag name to find.
     * 
     * @return The child element or null.
     */
    private Element getChildElement(String name) {
        if (currentChild == null) {
            // element has no children.
            return null;
        }
        Node start = currentChild;
        do {
            Node node = currentChild;
            currentChild = currentChild.getNextSibling();
            if (currentChild == null) {
                currentChild = currentElement.getFirstChild();
            }
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && node.getNodeName().equals(name)) {
                return (Element) node;
            }
        } while (currentChild != start);
        return null;
    }

    /**
     * Read begin tag, text, end tag.
     * 
     * @param name
     * 
     * @return The trimmed text content or null.
     */
    private String getElementText(Element element) {
        Node node = element.getFirstChild();
        if (node == null || node.getNodeType() != Node.TEXT_NODE) {
            return null;
        }
        return node.getNodeValue().trim();
    }

    /**
     * Read an element into a new instance of a class.
     * 
     * @param element
     *            The element, if null returns null.
     * 
     * @param cls
     *            The class to create an instance of.
     * 
     * @return The new instance.
     */
    @SuppressWarnings("unchecked")
    private <T> T parseElement(Element element, Class<T> cls) {
        T value;
        if (element == null) {
            value = null;
        } else if (MwsObject.class.isAssignableFrom(cls)) {
            value = MwsUtl.newInstance(cls);
            Element holdElement = currentElement;
            Node holdChild = currentChild;
            setCurrentElement(element);
            ((MwsObject) value).readFragmentFrom(this);
            currentElement = holdElement;
            currentChild = holdChild;
        } else if (cls == Object.class) {
            value = (T)element;
        } else {
            String v = getElementText(element);
            value = parseString(v, cls);
        }
        return value;
    }

    /**
     * Parse a string to a value of the given class.
     * 
     * @param v
     *            The string to parse.
     * @param cls
     *            The class to parse it to.
     * 
     * @return The parsed value may be null.
     */
    @SuppressWarnings("unchecked")
    private <T> T parseString(String v, Class<T> cls) {
        Object value;
        if (v == null || v.length() == 0) {
            value = null;
        } else if (cls == String.class) {
            value = v;
        } else if (cls == Boolean.class || cls == boolean.class) {
            if (v.equalsIgnoreCase("true")) {
                value = Boolean.TRUE;
            } else if (v.equalsIgnoreCase("false")) {
                value = Boolean.FALSE;
            } else {
                throw new IllegalStateException(
                        "Expected true/false, found text '" + v + "'.");
            }
        } else if (cls == Integer.class || cls == int.class) {
            value = Integer.valueOf(v);
        } else if (cls == Long.class || cls == long.class) {
            value = Long.valueOf(v);
        } else if (cls == Float.class || cls == float.class) {
            value = Float.valueOf(v);
        } else if (cls == Double.class || cls == double.class) {
            value = Double.valueOf(v);
        } else if (cls == BigDecimal.class) {
            value = new BigDecimal(v);
        } else if (XMLGregorianCalendar.class == cls) {
            value = MwsUtl.getDTF().newXMLGregorianCalendar(v);
        } else if (Enum.class.isAssignableFrom(cls)) {
            value = MwsUtl.getEnumValue(cls, v);
        } else {
            throw new IllegalArgumentException(String.format("Unable to parse String %s to Class %s", v, cls));
        }
        return (T) value;
    }

    /**
     * Set the current element and positions to its first child.
     * 
     * @param element
     */
    private void setCurrentElement(Element element) {
        currentElement = element;
        currentChild = element.getFirstChild();
    }

    @Override
    public void close() {
        MwsUtl.close(is);
    }

    @Override
    public <T> T read(String name, Class<T> cls) {
        Element element = getChildElement(name);
        T value = parseElement(element, cls);
        return value;
    }

    @Override
    public <T> T readAttribute(String name, Class<T> cls) {
        return parseString(currentElement.getAttribute(name), cls);
    }

    @Override
    public <T> List<T> readList(String memberName, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        Node node = currentElement.getFirstChild();
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE
                    && node.getNodeName().equals(memberName)) {

                // Handle repeating-sibling style lists <current><name></name><name></name>...</current>
                T value = parseElement((Element) node, cls);
                list.add(value);
                currentChild = node;
            }
            node = node.getNextSibling();
        }
        return list;
    }

    @Override
    public <T> List<T> readList(String name, String memberName, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        Node node = currentElement.getFirstChild();
        while (node != null && list.isEmpty()) { // Stop if list is non-empty
            if (node.getNodeType() == Node.ELEMENT_NODE &&
                    node.getNodeName().equals(name)) {

                // Handle child-member style lists <current><name><member></member><member></member>...</name></current>
                if(node.hasChildNodes()) {
                    Node childNode = node.getFirstChild();
                    while (childNode != null) {
                        if(childNode.getNodeType() == Node.ELEMENT_NODE &&
                                childNode.getNodeName().equals(memberName)) {
                            T value = parseElement((Element) childNode, cls);
                            list.add(value);
                        }
                        childNode = childNode.getNextSibling();
                    }
                }
                currentChild = node;
            }
            node = node.getNextSibling();
        }
        return list;
    }

    @Override
    public List<Element> readAny() {
        List<Element> list = new ArrayList<Element>();
        Node node = currentElement.getFirstChild();
        while (node != null) {
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                list.add((Element) node);
            }
            node = node.getNextSibling();
        }
        return list;
    }

    @Override
    public <T> T readValue(Class<T> cls) {
        return parseElement(currentElement, cls);
    }

    /**
     * Create a MwsXmlReader instance around a java.io.InputStream
     * 
     * This constructor wraps the input stream, to close it call the close
     * method on the returned instance.
     * 
     * @param is
     *            The input stream to wrap.
     */
    public MwsXmlReader(InputStream is) {
        try {
            this.is = is;
            DocumentBuilder docBuilder = MwsUtl.getDBF().newDocumentBuilder();
            document = docBuilder.parse(is);
            Element root = document.getDocumentElement();
            root.normalize();
            setCurrentElement(root);
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

    /**
     * Create a MwsXmlReader instance that reads a string.
     */
    public MwsXmlReader(String xml) {
        try {
            this.is = null;
            InputSource src = new InputSource(new StringReader(xml));
            DocumentBuilder docBuilder = MwsUtl.getDBF().newDocumentBuilder();
            document = docBuilder.parse(src);
            Element root = document.getDocumentElement();
            root.normalize();
            setCurrentElement(root);
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

}
