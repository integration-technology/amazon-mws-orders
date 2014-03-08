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
import org.w3c.dom.Node;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Writer;
import java.util.Collection;

/**
 * An MwsWriter that writes XML to a StringBuilder.
 * 
 * @author mayerj
 */
public class MwsXmlWriter implements MwsWriter {

    /** Escape sequences for escaped chars, in order. */
    private static final String[] ESCAPE_SEQ = new String[]{"&amp;", "&lt;",
            "&gt;", "&#039;", "&quot;"};

    /** Chars that must be escaped for XML. */
    private static final String ESCAPED_CHARS = "&<>'\"";

    /**
     * Writer to write output to.
     */
    protected Writer writer;

    /** True if output contains start of begin tag but not closing '>'. */
    private boolean inTag;

    /**
     * Append a value to output.
     * 
     * @param value
     */
    private void appendValue(Object value) {
        if (value instanceof Boolean) {
            closeTag();
            append(value.toString());
        } else if (value instanceof Number) {
            closeTag();
            append(value.toString());
        } else if (value instanceof String) {
            closeTag();
            escape((String) value);
        } else if (value instanceof MwsObject) {
            ((MwsObject) value).writeFragmentTo(this);
        } else if (value instanceof Node) {
            closeTag();
            append(MwsUtl.toXmlString((Node) value));
        } else if (value instanceof Enum) {
            closeTag();
            append(((Enum<?>) value).toString());
        } else if (value instanceof XMLGregorianCalendar) {
            closeTag();
            append(((XMLGregorianCalendar) value).toXMLFormat());
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Append a begin tag without a closing '>'.
     * 
     * @param name
     */
    private void beginTag(String name) {
        closeTag();
        append("<");
        append(name);
        inTag = true;
    }

    /**
     * if inTag close it.
     */
    private void closeTag() {
        if (inTag) {
            append(">");
            inTag = false;
        }
    }

    /**
     * Append an end tag.
     * 
     * @param name
     */
    private void endTag(String name) {
        closeTag();
        append("</");
        append(name);
        append(">");
    }

    /**
     * Output escaped value.
     * 
     * @param value
     */
    private void escape(String value) {
        int n = value.length();
        int i = 0;
        for (int j = 0; j < n; ++j) {
            int k = ESCAPED_CHARS.indexOf(value.charAt(j));
            if (k >= 0) {
                if (i < j) {
                    append(value, i, j);
                }
                append(ESCAPE_SEQ[k]);
                i = j + 1;
            }
        }
        if (i < n) {
            append(value, i, n);
        }
    }

    /**
     * Append a string to the output.
     * 
     * @param v
     */
    protected void append(String v) {
        try {
            writer.write(v);
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

    /**
     * Append range of a string to the output.
     * 
     * @param v
     * @param start
     * @param end
     */
    protected void append(String v, int start, int end) {
        try {
            writer.write(v, start, end - start);
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

    @Override
    public void beginObject(String name) {
        beginTag(name);
    }

    @Override
    public void close() {
        MwsUtl.close(writer);
    }

    @Override
    public void endObject(String name) {
        endTag(name);
    }

    @Override
    public void write(String namespace, String name, MwsObject value) {
        if (value != null) {
            beginObject(name);
            writeAttribute("xmlns", namespace);
            value.writeFragmentTo(this);
            endObject(name);
        }
    }

    @Override
    public void write(String name, Object value) {
        if (value == null) {
            return;
        }
        beginTag(name);
        appendValue(value);
        endTag(name);
    }

    @Override
    public void writeAttribute(String name, Object value) {
        if (!inTag) {
            throw new IllegalStateException();
        }
        if (value == null) {
            return;
        }
        append(" ");
        append(name);
        append("=\"");
        escape(String.valueOf(value));
        append("\"");
    }

    @Override
    public void writeList(String name, Collection<?> list) {
        if (list != null) {
            for (Object v : list) {
                write(name, v);
            }
        }
    }

    @Override
    public void writeList(String name, String memberName, Collection<?> list) {
        if (list != null && list.size()>0) {
            beginObject(name);
            for (Object v : list) {
                write(memberName, v);
            }
            endObject(name);
        }
    }

    @Override
    public void writeAny(Collection<Element> elements) {
        for(Element element : elements) {
            appendValue(element);
        }
    }

    @Override
    public void writeValue(Object value) {
        closeTag();
        if (value != null) {
            appendValue(value);
        }
    }

    /**
     * Create instance that outputs to a java.io.Writer.
     * 
     * @param writer
     *            The writer to wrap.
     */
    public MwsXmlWriter(Writer writer) {
        this.writer = writer;
    }

}
