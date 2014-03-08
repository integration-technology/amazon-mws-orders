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
 * Exception thrown by MWS API requests.
 * 
 * @author mayerj
 */
public class MwsException extends RuntimeException {

    /** Default SVUID. */
    private static final long serialVersionUID = 1L;

    /** The HTTP status code. */
    private int statusCode;

    /** The error message. */
    private String message;

    /** The response xml from server. */
    private String xml;

    /** The error code from server. */
    private String errorCode;

    /** The error type from server. */
    private String errorType;

    /** The error detail. */
    private String detail;

    /** The response header metadata. */
    private MwsResponseHeaderMetadata rhmd;

    /**
     * Set the response header metadata.
     * 
     * @param rhmd
     */
    protected void setResponseHeaderMetadata(MwsResponseHeaderMetadata rhmd) {
        this.rhmd = rhmd;
    }

    /**
     * The error detail information.
     * 
     * @return The debugging detail information.
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Gets error code returned by the service if available.
     * 
     * @return Error Code returned by the service
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Gets error type returned by the service if available.
     * 
     * @return Error Type returned by the service
     */
    public String getErrorType() {
        return errorType;
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * Get the request id from the response header metadata.
     * 
     * @return The request id.
     */
    public String getRequestId() {
        return rhmd==null?null:rhmd.getRequestId();
    }

    /**
     * Get the response header metadata.
     * 
     * @return The response header metadata.
     */
    public MwsResponseHeaderMetadata getResponseHeaderMetadata() {
        return rhmd;
    }

    /**
     * Gets status code returned by the service if available. If status code is
     * set to -1, it means that status code was unavailable at the time
     * exception was thrown
     * 
     * @return status code returned by the service
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Get the timestamp from the response header metadata.
     * 
     * @return The timestamp.
     */
    public String getTimestamp() {
        return rhmd==null?null:rhmd.getTimestamp();
    }

    /**
     * Gets XML returned by the service if available.
     * 
     * @return XML returned by the service
     */
    public String getXML() {
        return xml;
    }

    /**
     * Initializes MwsException with information available from service.
     * 
     * @param statusCode
     *            HTTP status code for error response.
     * @param message
     *            Error message from HTTP header.
     * @param errorCode
     *            Error code from response XML.
     * @param errorType
     *            Error type from response XML.
     * @param xml
     *            Compete XML found in response.
     * @param rhmd
     *            The response header metadata.
     * 
     */
    public MwsException(int statusCode, String message, String errorCode,
            String errorType, String xml, MwsResponseHeaderMetadata rhmd) {

        this.statusCode = statusCode;
        this.rhmd = rhmd;
        this.xml = xml;

        this.message = message;
        this.errorCode = errorCode;
        this.errorType = errorType;

        if (xml != null) {
            try {
                MwsXmlReader r = new MwsXmlReader(xml);
                XmlMwsException parsed = r.read("Error", XmlMwsException.class);
                this.errorType = parsed.getErrorType();
                this.errorCode = parsed.getErrorCode();
                this.message = parsed.getMessage();
                this.detail = parsed.getDetail();
                r.close();
            } catch (Exception e) {
                // eat it.
            }
        }
    }

    /**
     * Initialize and set cause from another exception.
     * <p>
     * If cause is an MwsException copies that exception's attributes to this
     * one, ignoring the statusCode and message parameters that were passed in.
     * <p>
     * 
     * @param statusCode
     * @param message
     * @param cause
     */
    public MwsException(int statusCode, String message, Throwable cause) {
        super(cause);
        if (cause instanceof MwsException) {
            MwsException e = (MwsException) cause;
            this.statusCode = e.getStatusCode();
            this.message = e.getMessage();
            this.errorCode = e.getErrorCode();
            this.errorType = e.getErrorType();
            this.rhmd = e.getResponseHeaderMetadata();
            this.detail = e.getDetail();
            this.xml = e.getXML();
        } else {
            this.statusCode = statusCode;
            this.message = message;
        }
    }

    /**
     * Create wrap around another MwsException.
     * 
     * @param cause Exception to wrap
     */
    public MwsException(Throwable cause) {
        this(0, cause.getMessage(), cause);
    }

    /** Used to read MWSException from XML since MWSException cannot extend AbstractMwsObject. */
    protected static class XmlMwsException extends AbstractMwsObject {

        private String errorCode;
        private String errorType;
        private String message;
        private String detail;

        public String getErrorCode() {
            return errorCode;
        }

        public String getErrorType() {
            return errorType;
        }

        public String getMessage() {
            return message;
        }

        public String getDetail() {
            return detail;
        }

        @Override
        public void readFragmentFrom(MwsReader r) {
            this.errorType = r.read("Type", String.class);
            this.errorCode = r.read("Code", String.class);
            this.message = r.read("Message", String.class);
            this.detail = r.read("Detail", String.class);
        }

        @Override
        public void writeFragmentTo(MwsWriter w) {
            w.write("Code", this.errorCode);
            w.write("Type", this.errorType);
            w.write("Message", this.message);
            w.write("Detail", this.detail);
        }

        @Override
        public void writeTo(MwsWriter w) {
            w.write("Error", this);
        }
    }
}
