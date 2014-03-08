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

import java.io.Writer;
import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * An MwsWriter that writes JSON to a java.io.Writer.
 * 
 * @author mayerj
 */
public class MwsJsonWriter implements MwsWriter {

    /** Escape sequences for escaped chars, in order. */
    private static final String[] ESCAPE_SEQ = new String[]{"\\\"", "\\\\",
            "\\/", "\\b", "\\f", "\\n", "\\r", "\\t"};

    /** Chars that must be escaped for JSON. */
    private static final String ESCAPED_CHARS = "\"\\/\b\f\n\r\t";

    /** Writer that append methods write to. */
    private Writer writer;

    /** Inside an object. */
    private int inObject;

    /** True if after a value. */
    private boolean needComma;

    /**
     * Append chars from a string to the output.
     * 
     * @param value
     * @param start
     * @param end
     */
    protected void append(String value, int start, int end) {
        try {
            writer.write(value, start, end - start);
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

    /**
     * Append string to the output.
     * 
     * @param value
     */
    protected void append(String value) {
        try {
            writer.write(value);
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

    /**
     * Append a value.
     * 
     * @param value
     */
    private void appendValue(Object value) {
        if (value == null) {
            append("null");
        } else if (value instanceof MwsObject) {
            append("{");
            needComma = false;
            ((MwsObject) value).writeFragmentTo(this);
            append("}");
        } else if (value instanceof Boolean || value instanceof Number) {
            append(value.toString());
        } else if (value instanceof String) {
            append("\"");
            escape((String) value);
            append("\"");
        } else if (value instanceof Node) {
            appendValue(MwsUtl.toXmlString((Node) value));
        } else if (value instanceof XMLGregorianCalendar) {
            append(((XMLGregorianCalendar) value).toXMLFormat());
        } else if (value instanceof Enum) {
            append(value.toString());
        } else {
            throw new IllegalArgumentException("Unsupported type "+value.getClass().getName());
        }
        needComma = true;
    }

    /**
     * Output comma and "name": as appropriate for the current output state.
     * 
     * @param name
     */
    private void commaName(String name) {
        if (needComma) {
            append(",");
        }
        append("\"");
        escape(name);
        append("\":");
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
            char c = value.charAt(j);
            int k = ESCAPED_CHARS.indexOf(c);
            if (k >= 0 || c < ' ') {
                if (i < j) {
                    append(value, i, j);
                }
                if (k >= 0) {
                    append(ESCAPE_SEQ[k]);
                } else {
                    append("\\u");
                    append(String.format("%04x", Integer.valueOf(c)));
                }
                i = j + 1;
            }
        }
        if (i < n) {
            append(value, i, n);
        }
    }

    @Override
    public void beginObject(String name) {
        if (inObject>0) {
            commaName(name);
        }
        append("{");
        needComma = false;
        inObject++;
    }

    @Override
    public void endObject(String name) {
        append("}");
        needComma = true;
        inObject--;
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
        if (value != null) {
            commaName(name);
            appendValue(value);
        }
    }

    @Override
    public void writeAttribute(String name, Object value) {
        write(name, value);
    }

    @Override
    public void writeValue(Object value) {
        write("Value", value);
    }

    /**
     * Wrap a writer.
     * 
     * @param writer
     *            The writer to wrap.
     */
    public MwsJsonWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void close() {
        MwsUtl.close(writer);
    }

    @Override
    public void writeList(String name, Collection<?> list) {
        if (list==null) {
            return;
        }
        commaName(name);
        append("[");
        needComma = false;
        for (Object value : list) {
            if (needComma) {
                append(",");
            }
            appendValue(value);
        }
        append("]");
        needComma = true;
    }

    @Override
    public void writeList(String name, String memberName, Collection<?> list) {
        writeList(name, list);
    }

    @Override
    public void writeAny(Collection<Element> elements) {
        if(elements != null) {
            for(Element element : elements) {
                String name = element.getLocalName();
                if(name == null) {
                    name = element.getTagName();
                }
                write(name, element);
            }
        }
    }

}
