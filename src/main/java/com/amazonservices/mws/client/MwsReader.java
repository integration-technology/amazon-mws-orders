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
import java.util.List;

/**
 * Methods to read an object from XML, JSON or other serial form.
 * <p>
 * MwsReader instances can wrap an input stream or other resource
 * and should be closed to avoid resource leakage.
 * 
 * @author mayerj
 */
public interface MwsReader extends Closeable {

    @Override
    void close();

    /**
     * Read the next labeled value.
     * <p>
     * Returns null if the reader is not positioned on a labeled value
     * of the requested type.
     * <p>
     * For XML reads: <code>&lt;name&gt;value&lt;/name&gt;
     * <p>
     * For JSON reads: <code>name:value</code> if in Object or
     * <code>value</code> if in list.
     * 
     * @param name
     *            The expected label.
     * 
     * @param cls
     *            The expected value class.
     * 
     * @return The read in value.
     */
    public <T> T read(String name, Class<T> cls);

    /**
     * Get an attribute by name.
     * <p>
     * Called when positioned on begin Object.
     * <p>
     * Returns null if the named attribute is not present.
     * 
     * @param name
     *            The attribute name to get.
     * 
     * @return The attribute value or null of not set.
     */
    public <T> T readAttribute(String name, Class<T> cls);

    /**
     * Read a list of sibling elements.
     * <p>
     * For XML reads: <code>&lt;memberName&gt;value&lt;/memberName&gt;...</code>
     * <p>
     * For JSON reads: <code>name:[value...]</code> or <code>[value...]</code>
     * 
     * 
     * @param memberName XML tag name of each member
     * @param cls
     * 
     * @return A List.
     */
    public <T> List<T> readList(String memberName, Class<T> cls);

    /**
     * Read a list of child elements.
     * <p>
     * For XML reads: <code>&lt;name&gt;&lt;memberName&gt;value&lt;/memberName&gt;...</code>
     * <p>
     * For JSON reads: <code>name:[value...]</code> or <code>[value...]</code>
     *
     *
     * @param name XML tag name of list parent
     * @param memberName XML tag name of each member
     * @param cls
     *
     * @return A List.
     */
    public <T> List<T> readList(String name, String memberName, Class<T> cls);

    /**
     * Read a list of all elements, ignoring type and name.
     *
     * @return A List of w3c DOM Elements
     */
    public List<Element> readAny();

    /**
     * Read raw string value.
     * <p>
     * For XML reads: characters up to next tag.
     * <p>
     * For JSON reads: "characters"
     * 
     * @return The read in string value.
     */
    public <T> T readValue(Class<T> cls);

}
