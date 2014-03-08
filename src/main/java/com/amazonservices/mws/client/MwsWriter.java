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

import org.w3c.dom.Element;

import java.io.Closeable;
import java.util.Collection;

/**
 * Interface for objects that write data and complex types to some format. XML
 * and JSON for example.
 * 
 * @author mayerj
 */
public interface MwsWriter extends Closeable {

    /**
     * Write a begin tag for an object value. Can be nested.
     * <p>
     * Must follow with matching endObject call eventually.
     * 
     * <p>
     * For JSON writes <code>[,]name: {</code> or <code>{</code>
     * <p>
     * For XML writes <code> &lt;name&gt; </code>
     * 
     * @param name
     */
    void beginObject(String name);

    @Override
    void close();

    /**
     * Write the end of an object value.
     * <p>
     * Must previously have written a matching beginObject.
     * <p>
     * For JSON writes: <code>}</code>
     * <p>
     * For XML writes: <code>&lt;/name&gt;</code>
     * 
     * @param name
     */
    void endObject(String name);

    /**
     * Write out an object with a namespace attribute.
     * <p>
     * Same as calling:
     * <code>
     *  if (value!=null) {
     *      w.beginObject(name);
     *      w.writeAttribute("xmlns",name);
     *      value.writeFragmentTo(w);
     *      w.endObject(name);
     *  }
     * </code>
     *
     * @param name
     *            The label for the value.
     * 
     * @param value
     *            The value to output.
     */
    void write(String namespace, String name, MwsObject value);

    /**
     * Write out a value, with proper escaping and delimiters for the context.
     * May be called nested in beginObject/endObject.
     * <p>
     * The value must be one of: null, Boolean, Number, String, MwsObject.
     * <p>
     * Calling with a null value does nothing and returns.
     * <p>
     * For JSON: <code>[,]label:value</code> or <code>[,]value</code>
     * <p>
     * For XML: <code>&lt;label&gt;valueFragment&lt;/label&gt;
     * 
     * @param name
     *            The label for the value.
     * 
     * @param value
     *            The value to output.
     */
    void write(String name, Object value);

    /**
     * Write out a labeled attribute value with proper escaping and delimiters
     * for the context.
     * <p>
     * Can only be called after beginObject or writeAttribute methods.
     * <p>
     * The value must be one of: null, Boolean, Number, String.
     * <p>
     * Calling with a null value does nothing and returns.
     * <p>
     * For JSON: <code>same as write(name,value)</code>
     * <p>
     * For XML: <code>label = &quot;value&quot; inside the object tag.</code>
     * 
     * @param name
     * @param value
     */
    void writeAttribute(String name, Object value);

    /**
     * Write a list using sibling elements.
     * <p>
     * For JSON: <code>[,]name:[values...]</code> or <code>[values...]</code>
     * <p>
     * For XML: <code>&lt;name&gt;value&lt;/name&gt;...</code>
     * 
     * @param name
     * @param list
     */
    void writeList(String name, Collection<?> list);

    /**
     * Write a list using child elements.
     * <p>
     * For JSON: <code>[,]name:[values...]</code> or <code>[values...]</code>
     * <p>
     * For XML: <code>&lt;name&gt;&lt;memberName&gt;value&lt;/memberName&gt;...</code>
     *
     * @param name
     * @param memberName
     * @param list
     */
    void writeList(String name, String memberName, Collection<?> list);

    /**
     * Write a list of arbitrary elements.
     *
     * @param elements Collection of w3c DOM elements to write
     */
    void writeAny(Collection<Element> elements);

    /**
     * Write out an unlabeled value.
     * <p>
     * Calling with null value does nothing and returns.
     * <p>
     * For JSON: <code>[,]Value:value</code> or <code>[,]value</code>
     * <p>
     * For XML: <code>value</code>
     * 
     * @param value
     *            The object value.
     */
    void writeValue(Object value);

}
