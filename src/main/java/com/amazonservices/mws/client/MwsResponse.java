package com.amazonservices.mws.client;

/**
 * Response from MwsCall.call method.
 * <p>
 * Immutable object providing access to MwsCall response elements.
 * 
 * @author mayerj
 */
public class MwsResponse {

    /** The http status of the response, ie 200,400,500,503,... */
    private final int status;

    /** The message from the http status line. */
    private final String message;

    /** The response header metadata constructed from the response headers. */
    private final MwsResponseHeaderMetadata rhmd;

    /** The body content of the response. */
    private final String content;

    /**
     * Get the HTTP status code from the response.
     * 
     * @return The HTTP status code from the response.
     */
    public int getHttpStatus() {
        return status;
    }

    /**
     * Get the HTTP status message from the response.
     * 
     * @return The HTTP status message from the response.
     */
    public String getHttpMessage() {
        return message;
    }

    /**
     * Get the response header metadata from the response http headers.
     * 
     * @return The Response Header metadata.
     */
    public MwsResponseHeaderMetadata getResponseHeaderMetadata() {
        return rhmd;
    }

    /**
     * Get the response body contents.
     * 
     * @return The response body content as a String.
     */
    public String getBodyContent() {
        return content;
    }

    /**
     * Construct immutable response.
     * 
     * @param status
     * @param message
     * @param rhmd
     * @param content
     */
    MwsResponse(int status, String message, MwsResponseHeaderMetadata rhmd, String content) {
        this.status = status;
        this.message = message;
        this.rhmd = rhmd;
        this.content=content;
    }

}
