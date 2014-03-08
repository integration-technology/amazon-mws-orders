package com.amazonservices.mws.client;

/**
 * Interface for call instances.
 * <p>
 * Call instances are created by {@link MwsConnection#newCall(String, String)}.
 * 
 * @author mayerj
 * 
 */
public interface MwsCall extends MwsWriter {

    /**
     * Invoke the request synchronously with error handling and backoff/retry logic.
     * <p>
     * Call after writing request body.
     * 
     * @return A reader to read the response body.
     * 
     * @throws MwsException
     */
    MwsReader invoke() throws MwsException;

    /**
     * Execute the request synchronously without error handling or backoff/retry logic.
     * 
     * @return The unparsed response contents (caller must check status for error).
     */
    MwsResponse execute();

    /**
     * Gets metadata from response header.
     * <p>
     * Available after invoke() returns successfully.
     * 
     * @return Response header metadata.
     */
    MwsResponseHeaderMetadata getResponseHeaderMetadata();

}
