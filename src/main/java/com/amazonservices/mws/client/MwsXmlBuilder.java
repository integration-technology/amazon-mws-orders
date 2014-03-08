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
 * A MwsWriter that builds a XML string.
 * 
 * @author mayerj
 */
public class MwsXmlBuilder extends MwsXmlWriter {

    /** The buffer to build into. */
    private StringBuilder buf;

    @Override
    protected void append(String v) {
        buf.append(v);
    }

    @Override
    protected void append(String v, int start, int end) {
        buf.append(v, start, end);
    }

    @Override
    public String toString() {
        return buf.toString();
    }

    /**
     * Create a new builder.
     */
    MwsXmlBuilder() {
        super(null);
        buf = new StringBuilder();
    }

}
