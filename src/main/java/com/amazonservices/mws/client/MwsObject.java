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

/**
 * An object that can read/write from MwsReader/MwsWriter.
 * 
 * @author mayerj
 */
public interface MwsObject {

    /**
     * Read from a reader not including any enclosing tags/markers.
     * <p>
     * For XML reads inner tags for elements but not the enclosing tag. This
     * method will read attributes if the reader is positioned on a start tag
     * otherwise it will not act as if no attributes were present.
     * <p>
     * For JSON reads the name: elements but not the enclosing braces.
     * 
     * @param r
     *            The reader to read from.
     */
    void readFragmentFrom(MwsReader r);

    /**
     * Write self to a JSON object representation.
     * <p>
     * This includes beginning brace, labe:value contents, and ending brace.
     * 
     * @return The JSON object representation.
     */
    String toJSON();

    /**
     * Render self to a fragment of JSON.
     * <p>
     * This would be just the contents of the braces for the whole JSON object.
     * 
     * @return The JSON fragment.
     */
    String toJSONFragment();

    /**
     * Write self to a XML object representation.
     * <p>
     * This includes begin tag, attributes, inner tags, and end tag.
     * 
     * @return The XML object representation.
     */
    String toXML();

    /**
     * Render self to an XML fragment.
     * <p>
     * This includes the inner tags of the full XML representation, but not the
     * outer tag or any attributes.
     * 
     * @return The XML Fragment.
     */
    String toXMLFragment();

    /**
     * Write the inner contents to a writer.
     * <p>
     * Attributes are written. Then the inner values are written. 
     * No begin or end markers are written.
     * 
     * @param w
     *            The write to write to.
     */
    void writeFragmentTo(MwsWriter w);

    /**
     * Write the entire object to a writer.
     * <p>
     * This includes the beginning marker, attribute values, inner contents and
     * ending marker.
     * 
     * @param w
     *            The writer to write to.
     */
    void writeTo(MwsWriter w);

}
