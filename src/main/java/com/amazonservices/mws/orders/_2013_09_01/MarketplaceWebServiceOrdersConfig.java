/*******************************************************************************
 * Copyright 2009-2014 Amazon Services. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 *
 * You may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 *******************************************************************************
 * Marketplace Web Service Orders
 * API Version: 2013-09-01
 * Library Version: 2013-09-01
 * Generated: Thu Feb 06 16:04:52 GMT 2014
 */
package com.amazonservices.mws.orders._2013_09_01;

import java.net.URI;
import com.amazonservices.mws.client.MwsConnection;
import com.amazonservices.mws.client.MwsUtl;

/**
 * Configuration for a connection.
 */
public class MarketplaceWebServiceOrdersConfig {

    /** The service path for this API. */
    static final String DEFAULT_SERVICE_PATH = "Orders/2013-09-01";

    /** The service path. */
    private String servicePath;

    /** A connection used to hold configuration. */
    private final MwsConnection cc = new MwsConnection();

    /**
     * Get a clone of the configured connection.
     *
     * @return A clone of the configured connection.
     */
    MwsConnection copyConnection() {
        return cc.clone();
    }

    /**
     * Gets MaxConnections property
     *
     * @return Max number of http connections
     */
    public int getMaxConnections() {
        return cc.getMaxConnections();
    }
    
    public void setMaxConnections(int maxConnections) {
        cc.setMaxConnections(maxConnections);
    }

    public MarketplaceWebServiceOrdersConfig withMaxConnections(int maxConnections) {
        cc.setMaxConnections(maxConnections);
        return this;
    }

    public boolean isSetMaxConnections() {
        return cc.getMaxConnections() > 0;
    }
    

    /**
     * Gets MaxErrorRetry property
     *
     * @return Max number of retries on 500 errors
     */
    public int getMaxErrorRetry() {
        return cc.getMaxErrorRetry();
    }
    
    public void setMaxErrorRetry(int maxErrorRetry) {
        cc.setMaxErrorRetry(maxErrorRetry);
    }

    public MarketplaceWebServiceOrdersConfig withMaxErrorRetry(int maxErrorRetry) {
        cc.setMaxErrorRetry(maxErrorRetry);
        return this;
    }

    public boolean isSetMaxErrorRetry() {
        return cc.getMaxErrorRetry() > 0;
    }

    /**
     * Gets ProxyHost property
     *
     * @return Proxy Host for connection
     */
    public String getProxyHost() {
        return cc.getProxyHost();
    }
    
    public void setProxyHost(String proxyHost) {
        cc.setProxyHost(proxyHost);
    }

    public MarketplaceWebServiceOrdersConfig withProxyHost(String proxyHost) {
        cc.setProxyHost(proxyHost);
        return this;
    }

    public boolean isSetProxyHost() {
        return cc.getProxyHost() != null;
    }

    /**
     * Gets ProxyPassword property
     *
     * @return Proxy Password
     */
    public String getProxyPassword() {
        return cc.getProxyPassword();
    }
    
    public void setProxyPassword(String proxyPassword) {
        cc.setProxyPassword(proxyPassword);
    }

    public MarketplaceWebServiceOrdersConfig withProxyPassword(String proxyPassword) {
        cc.setProxyPassword(proxyPassword);
        return this;
    }

    public boolean isSetProxyPassword() {
        return cc.getProxyPassword() != null;
    }

    /**
     * Gets ProxyPort property
     *
     * @return Proxy Port for connection
     */
    public int getProxyPort() {
        return cc.getProxyPort();
    }
    
     public void setProxyPort(int proxyPort) {
        cc.setProxyPort(proxyPort);
    }

    public MarketplaceWebServiceOrdersConfig withProxyPort(int proxyPort) {
        cc.setProxyPort(proxyPort);
        return this;
    }

    public boolean isSetProxyPort() {
        return cc.getProxyPort() != -1;
    }

    /**
     * Gets ProxyUsername property
     *
     * @return Proxy Username
     */
    public String getProxyUsername() {
        return cc.getProxyUsername();
    }
    
    public void setProxyUsername(String proxyUsername) {
        cc.setProxyUsername(proxyUsername);
    }

    public MarketplaceWebServiceOrdersConfig withProxyUsername(String proxyUsername) {
        cc.setProxyUsername(proxyUsername);
        return this;
    }

    public boolean isSetProxyUsername() {
        return cc.getProxyUsername() != null;
    }

    public String getServiceVersion() {
        return "2013-09-01";
    }

	/**
	 * Gets the SignatureVersion property
	 *
	 * @return Signature Version
	 */
    public String getSignatureVersion() {
        return cc.getSignatureVersion();
    }

    public void setSignatureVersion(String signatureVersion) {
        cc.setSignatureVersion(signatureVersion);
    }

    public MarketplaceWebServiceOrdersConfig withSignatureVersion(String signatureVersion) {
        cc.setSignatureVersion(signatureVersion);
        return this;
    }

    public boolean isSetSignatureVersion() {
        return true;
    }

    /**
     * Gets the SignatureMethod property
     *
     * @return Signature Method
     */
    public String getSignatureMethod() {
        return cc.getSignatureMethod();
    }

    public void setSignatureMethod(String signatureMethod) {
        cc.setSignatureMethod(signatureMethod);
    }

    public MarketplaceWebServiceOrdersConfig withSignatureMethod(String signatureMethod) {
        cc.setSignatureMethod(signatureMethod);
        return this;
    }

    public boolean isSetSignatureMethod() {
        return true;
    }

    public String getUserAgent() {
        return cc.getUserAgent();
    }

    public void setUserAgent(String applicationName, String applicationVersion, String programmingLanguage,
            String... additionalNameValuePairs) {
        cc.setUserAgent(applicationName,applicationVersion,programmingLanguage,additionalNameValuePairs);
    }

    public MarketplaceWebServiceOrdersConfig withUserAgent(String applicationName, String applicationVersion,
        String programmingLanguage, String... additionalNameValuePairs) {
        cc.setUserAgent(applicationName, applicationVersion, programmingLanguage, additionalNameValuePairs);
        return this;
    }

    public boolean isSetUserAgent() {
        return cc.getUserAgent() != null;
    }

    /**
     * Gets the path appended after the endpoint
     *
     * @returns the path appended after the endpoint
     */
    String getServicePath() {
        return servicePath;
    }
    
    public String getServiceURL() {
        return cc.getEndpoint().toString() + "/" + servicePath;
    }

    /**
     * Set the service URL to make requests against.
     *
     * This can either be just the host name or can include the full path to the service.
     *
     * @param serviceUrl URL to make requests against
     */
    public void setServiceURL(String serviceUrl) {
        try {
            URI fullURI = URI.create(serviceUrl);
            URI partialURI = new URI(fullURI.getScheme(), null, fullURI.getHost(),
                fullURI.getPort(), null, null, null);
            cc.setEndpoint(partialURI);
            String path = fullURI.getPath();
            if (path != null) {
                path = path.substring(path.startsWith("/") ? 1 : 0);
                path = path.substring(0, path.length() - (path.endsWith("/") ? 1 : 0));
            }
            if (path == null || path.isEmpty()) {
                this.servicePath = DEFAULT_SERVICE_PATH;
            } else {
                this.servicePath = path;
            }
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

    public MarketplaceWebServiceOrdersConfig withServiceURL(String aserviceUrl) {
        setServiceURL(aserviceUrl);
        return this;
    }

    public boolean isSetServiceURL() {
        return servicePath != null;
    }

    /**
     * Get the configured max async queue size.
     * <p>
     * This is the max number of requests to queue before executing
     * requests on the calling thread.
     *
     * @return The max async queue size property.
     */
    public int getMaxAsyncQueueSize() {
        return cc.getMaxAsyncQueueSize();
    }
    
    public void setMaxAsyncQueueSize(int size) {
        cc.setMaxAsyncQueueSize(size);
    }
    
    public MarketplaceWebServiceOrdersConfig withMaxAsyncQueueSize(int size) {
        cc.setMaxAsyncQueueSize(size);
        return this;
    }

    public boolean isSetMaxAsyncQueueSize() {
       return cc.getMaxAsyncQueueSize()>0;
    }

    /**
     * Get the configured max async thread count.
     * <p>
     * This is the number of async threads to process requests from the queue.
     *
     * @return The max async thread count.
     */
    public int getMaxAsyncThreads() {
        return cc.getMaxAsyncThreads();
    }

    public void setMaxAsyncThreads(int threads) {
        cc.setMaxAsyncThreads(threads);
    }

    public MarketplaceWebServiceOrdersConfig withMaxAsyncThreads(int threads) {
        cc.setMaxAsyncThreads(threads);
        return this;
    }

    public boolean isSetMaxAsyncThreads() {
       return cc.getMaxAsyncThreads()>0;
    }

    /**
     * Sets the value of a request header to be included on every request
     *
     * @param name the name of the header to set
     * @param value value to send with header
     */
    public void includeRequestHeader(String name, String value) {
        cc.includeRequestHeader(name, value);
    }

    /**
     * Gets the currently set value of a request header
     *
     * @param name the name of the header to get
     * @return value of specified header, or null if not defined
     */
    public String getRequestHeader(String name) {
        return cc.getRequestHeader(name);
    }

    /**
     * Sets the value of a request header to be included on every request
     *
     * @param name the name of the header to set
     * @param value value to send with header
     * @return the current config object
     */
    public MarketplaceWebServiceOrdersConfig withRequestHeader(String name, String value) {
        cc.includeRequestHeader(name, value);
        return this;
    }

    /**
     * Checks if a request header is set
     *
     * @param name the name of the header to check
     * @return true, if the header is set
     */
    public boolean isSetRequestHeader(String name) {
        return cc.getRequestHeader(name) != null;
    }
}
