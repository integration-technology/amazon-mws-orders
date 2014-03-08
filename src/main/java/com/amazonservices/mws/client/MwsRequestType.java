package com.amazonservices.mws.client;

/**
 * Defines metadata for an operation.
 * <p>
 * This includes the service, version, operation name, response object class,
 * and call parameters.
 * 
 * @author mayerj
 */
public interface MwsRequestType {

    /**
     * Get the class that will be thrown for an exception response.
     * 
     * @return The exception class.
     */
    MwsException wrapException(Throwable e);

    /**
     * Get the operation name that identifies the operation within the service
     * version.
     * 
     * @return The operation name.
     */
    String getOperationName();

    /**
     * Get the class that will hold a successful response.
     * 
     * @return The response class.
     */
    Class<? extends MwsObject> getResponseClass();

    /**
     * Wrap response header metadata and set into response object.
     * 
     * @param response
     * @param rhmd
     */
    void setRHMD(MwsObject response, MwsResponseHeaderMetadata rhmd);

    /**
     * Get the service path string that identifies the service and version to
     * call on the server.
     * 
     * @return The service path.
     */
    String getServicePath();

}
