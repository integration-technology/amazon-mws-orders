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

import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/**
 * An connection to a server to send requests to for processing.
 * <p>
 * Parameters that describe a MwsConnection are Server address and port, caller
 * credentials and network connection configuration.
 * <p>
 * Simplest use case is:
 * 
 * <pre>
 * 1) Create an MwsConnection instance.
 * 2) Configure the connection using setter methods.
 * 3) Create and initialize a Request object.
 * 4) Call response = connection.execute(requestObject)
 * 5) Use the response object or handle exceptions.
 * 6) Repeat steps 3-5 as necessary.
 * 7) Close the connection object.
 * </pre>
 * 
 * @author mayerj
 */
public class MwsConnection implements Cloneable, Closeable {

    /**
     * Immutable service and version URI for an endpoint.
     * 
     * @author mayerj
     */
    static class ServiceEndpoint {

        /** The service name. */
        final String service;

        /** The service and version name as service/version. */
        final String servicePath;

        /** The combined uri of the connection, service name, and version. */
        final URI uri;

        /** The service version. */
        final String version;

        /**
         * Create a service endpoint.
         * 
         * @param baseUri
         * @param servicePath
         */
        ServiceEndpoint(URI baseUri, String servicePath) {
            this.servicePath = servicePath;
            int j = servicePath.lastIndexOf('/');
            this.service = servicePath.substring(0, j);
            this.version = servicePath.substring(j + 1);
            this.uri = baseUri.resolve("/" + servicePath);
        }
    }

    /** Commons logging. */
    private static final Log log = LogFactory.getLog(MwsConnection.class);

    /** The global shared connection manager (lazy created). */
    private static ClientConnectionManager sharedCM;

    /** The global shared executor service (lazy created). */
    private static ExecutorService sharedES;

    /** The client application name. */
    private String applicationName;

    /** The client application version. */
    private String applicationVersion;

    /** The AWS access key id. */
    private String awsAccessKeyId;

    /** The AWS secret key id. */
    private String awsSecretKeyId;

    /** Connection manager to use for httpClient. */
    private ClientConnectionManager connectionManager;

    /** The connection timeout in milliseconds. */
    private int connectionTimeout = 50000;

    /** The socket timeout. */
    private int socketTimeout = 50000;

    /** Max async threads to run concurrently. */
    private int maxAsyncThreads = 30;

    /** Max async queue size before thread stealing. */
    private int maxAsyncQueueSize = 300;

    /** Use endpoint URI. */
    private URI endpoint = null;

    /** Custom executor service for async calls . */
    private ExecutorService executorService;

    /** Set to true when httpClient is created and properties are frozen. */
    private volatile boolean frozen;

    /** Created http client instance. */
    private HttpClient httpClient;

    /** Context to use for httpClient. */
    private HttpContext httpContext;

    /** Max number of connections. */
    private int maxConnections = 100;

    /** Max retry count. */
    private int maxErrorRetry = 3;

    /** The MWS Client library version being used. */
    private String libraryVersion = "1.0.0";

    /** HTTP proxy host name. */
    private String proxyHost = null;

    /** HTTP proxy password. */
    private String proxyPassword = null;

    /** HTTP proxy port number. */
    private int proxyPort = -1;

    /** HTTP proxy username. */
    private String proxyUsername = null;

    /** A map from servicePath to cached ServiceEndpoint. */
    private Map<String, ServiceEndpoint> serviceMap;

    /** Method to use to create signature. */
    private String signatureMethod = "HmacSHA256";

    /** Use signature version. */
    private String signatureVersion = "2";

    /** Send user-agent. */
    private String userAgent = null;

    /** Additional headers to set on requests */
    private Map<String, String> headers = new HashMap<String, String>();

    /**
     * Ensure that the connection has not been used and the properties are still
     * updatable.
     */
    private void checkUpdatable() {
        if (frozen) {
            throw new IllegalStateException(
                    "Cannot change MwsConnection properties after connected.");
        }
    }

    /**
     * Initialize the connection.
     */
    synchronized void freeze() {
        if (frozen) {
            return;
        }
        if (userAgent == null) {
            setDefaultUserAgent();
        }
        serviceMap = new HashMap<String, ServiceEndpoint>();
        if (log.isDebugEnabled()) {
            StringBuilder buf = new StringBuilder();
            buf.append("Creating MwsConnection {");
            buf.append("applicationName:");
            buf.append(applicationName);
            buf.append(",applicationVersion:");
            buf.append(applicationVersion);
            buf.append(",awsAccessKeyId:");
            buf.append(awsAccessKeyId);
            buf.append(",uri:");
            buf.append(endpoint.toString());
            buf.append(",userAgent:");
            buf.append(userAgent);
            buf.append(",connectionTimeout:");
            buf.append(connectionTimeout);
            if (proxyHost != null && proxyPort != 0) {
                buf.append(",proxyUsername:");
                buf.append(proxyUsername);
                buf.append(",proxyHost:");
                buf.append(proxyHost);
                buf.append(",proxyPort:");
                buf.append(proxyPort);
            }
            buf.append("}");
            log.debug(buf);
        }

        BasicHttpParams httpParams = new BasicHttpParams();
        httpParams.setParameter(CoreProtocolPNames.USER_AGENT, userAgent);
        HttpConnectionParams
                .setConnectionTimeout(httpParams, connectionTimeout);
        HttpConnectionParams.setSoTimeout(httpParams, socketTimeout);
        HttpConnectionParams.setStaleCheckingEnabled(httpParams, true);
        HttpConnectionParams.setTcpNoDelay(httpParams, true);

        connectionManager = getConnectionManager();
        httpClient = new DefaultHttpClient(connectionManager, httpParams);
        httpContext = new BasicHttpContext();
        if (proxyHost != null && proxyPort != 0) {
            String scheme = MwsUtl.usesHttps(endpoint) ? "https" : "http";
            HttpHost hostConfiguration = new HttpHost(proxyHost, proxyPort, scheme);
            httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, hostConfiguration);

            if (proxyUsername != null && proxyPassword != null) {
                Credentials credentials = new UsernamePasswordCredentials(proxyUsername, proxyPassword);
                CredentialsProvider cprovider = new BasicCredentialsProvider();
                cprovider.setCredentials(new AuthScope(proxyHost, proxyPort), credentials);
                httpContext.setAttribute(ClientContext.CREDS_PROVIDER, cprovider);
            }
        }
        headers = Collections.unmodifiableMap(headers);
        frozen = true;
    }

    /**
     * Get a connection manager to use for this connection.
     * <p>
     * Called late in initialization.
     * <p>
     * Default implementation uses a shared PoolingClientConnectionManager.
     * 
     * @return The connection manager to use.
     */
    private ClientConnectionManager getConnectionManager() {
        synchronized (this.getClass()) {
            if (sharedCM == null) {
                PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
                cm.setMaxTotal(maxConnections);
                cm.setDefaultMaxPerRoute(maxConnections);
                sharedCM = cm;
            }
            return sharedCM;
        }
    }

    /**
     * Get the shared executor service that is used by async calls if no
     * executor is supplied.
     * 
     * @return The shared executor service.
     */
    private ExecutorService getSharedES() {
        synchronized (this.getClass()) {
            if (sharedES != null) {
                return sharedES;
            }
            sharedES = new ThreadPoolExecutor(maxAsyncThreads / 10,
                    maxAsyncThreads, 60L, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<Runnable>(maxAsyncQueueSize),
                    new ThreadFactory() {
                        private final AtomicInteger threadNumber = new AtomicInteger(
                                1);
                        @Override
                        public Thread newThread(Runnable task) {
                            Thread thread = new Thread(task, "MWSClient-"
                                    + threadNumber.getAndIncrement());
                            thread.setDaemon(true);
                            thread.setPriority(Thread.NORM_PRIORITY);
                            return thread;
                        }
                    }, new RejectedExecutionHandler() {
                        @Override
                        public void rejectedExecution(Runnable task,
                                ThreadPoolExecutor executor) {
                            if (!executor.isShutdown()) {
                                log.warn("MWSClient async queue full, running on calling thread.");
                                task.run();
                            } else {
                                throw new RejectedExecutionException();
                            }
                        }
                    });
            return sharedES;
        }
    }

    /**
     * Set the default user agent string. Called when connection first opened if
     * user agent is not set explicitly.
     */
    private void setDefaultUserAgent() {
        setUserAgent(
                MwsUtl.escapeAppName(applicationName),
                MwsUtl.escapeAppVersion(applicationVersion),
                MwsUtl.escapeAttributeValue("Java/"
                        + System.getProperty("java.version") + "/"
                        + System.getProperty("java.class.version") + "/"
                        + System.getProperty("java.vendor")),

                MwsUtl.escapeAttributeName("Platform"),
                MwsUtl.escapeAttributeValue("" + System.getProperty("os.name")
                        + "/" + System.getProperty("os.arch") + "/"
                        + System.getProperty("os.version")),

                MwsUtl.escapeAttributeName("MWSClientVersion"),
                MwsUtl.escapeAttributeValue(libraryVersion));
    }

    /**
     * Get secret key is package protected to keep the secret.
     * 
     * @return The secret key.
     */
    String getAwsSecretKeyId() {
        return awsSecretKeyId;
    }

    /**
     * Get HttpClient to use to make requests.
     * <p>
     * First call to this method applies defaults and freezes the connections
     * configuration properties.
     * 
     * @return The httpClient for this connection.
     */
    HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Get the HttpContext for this connection.
     * 
     * @return The HttpContext.
     */
    HttpContext getHttpContext() {
        return httpContext;
    }

    /**
     * Get a MwsServiceUri for the servicePath.
     * 
     * @param servicePath
     *            The service name and version as name/version, no leading or
     *            trailing slash.
     * 
     * @return The service endpoint instance.
     */
    ServiceEndpoint getServiceEndpoint(String servicePath) {
        synchronized (serviceMap) {
            ServiceEndpoint sep = serviceMap.get(servicePath);
            if (sep == null) {
                sep = new ServiceEndpoint(endpoint, servicePath);
                serviceMap.put(servicePath, sep);
            }
            return sep;
        }
    }

    /**
     * Call an operation and return the response data.
     * 
     * @param requestData
     *            The request data.
     * 
     * @return The response data.
     */
    @SuppressWarnings("unchecked")
    public <T extends MwsObject> T call(MwsRequestType type,
            MwsObject requestData) {
        MwsReader responseReader = null;
        try {
            String servicePath = type.getServicePath();
            String operationName = type.getOperationName();
            MwsCall mc = newCall(servicePath, operationName);
            requestData.writeFragmentTo(mc);
            responseReader = mc.invoke();
            MwsResponseHeaderMetadata rhmd = mc.getResponseHeaderMetadata();
            MwsObject response = MwsUtl.newInstance(type.getResponseClass());
            type.setRHMD(response, rhmd);
            response.readFragmentFrom(responseReader);
            return (T) response;
        } catch (Exception e) {
            throw type.wrapException(e);
        } finally {
            MwsUtl.close(responseReader);
        }
    }

    /**
     * Call a request async, return a future on the response data.
     * 
     * @param requestData
     * 
     * @return A future on the response data.
     */
    public <T extends MwsObject> Future<T> callAsync(final MwsRequestType type,
            final MwsObject requestData) {
        return getExecutorService().submit(new Callable<T>() {
            @Override
            public T call() {
                return MwsConnection.this.call(type, requestData);
            }
        });
    }

    /**
     * Clone this connection, creates an unconnected connection with all the
     * same settings. But in a state as if it were never used.
     */
    @Override
    public synchronized MwsConnection clone() {
        try {
            MwsConnection a = (MwsConnection) super.clone();
            a.serviceMap = null;
            a.connectionManager = null;
            a.httpClient = null;
            a.httpContext = null;
            a.frozen = false;
            return a;
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

    @Override
    public void close() {
        if (connectionManager != null) {
            this.connectionManager.closeIdleConnections(0,
                    TimeUnit.MILLISECONDS);
        }
    }

    /**
     * Get the client application name.
     * 
     * @return The client application name.
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Get the client application version.
     * 
     * @return The client application version.
     */
    public String getApplicationVersion() {
        return applicationVersion;
    }

    /**
     * Get the configured AWS access key id.
     * 
     * @return The AWS access key id.
     */
    public String getAwsAccessKeyId() {
        return awsAccessKeyId;
    }

    /**
     * Get the connection timeout.
     * 
     * @return The connection timeout in milliseconds.
     */
    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    /**
     * Gets end point property.
     * 
     * @return Service end point URI
     */
    public URI getEndpoint() {
        return endpoint;
    }

    /**
     * Get the executor service that will be used for async requests.
     * 
     * @return The service.
     */
    public synchronized ExecutorService getExecutorService() {
        if (executorService == null) {
            executorService = getSharedES();
        }
        return executorService;
    }

    /**
     * Get the client library version.
     * 
     * @return The client library version.
     */
    public String getLibraryVersion() {
        return libraryVersion;
    }

    /**
     * Get the MaxAsyncQueueSize property.
     * 
     * @return MaxAsyncQueueSize.
     */
    public int getMaxAsyncQueueSize() {
        return maxAsyncQueueSize;
    }

    /**
     * Get MaxAsyncThreads property.
     * 
     * @return Max number of threads to be used for async operations
     */
    public int getMaxAsyncThreads() {
        return maxAsyncThreads;
    }

    /**
     * Gets MaxConnections property
     * 
     * @return Max number of http connections
     */
    public int getMaxConnections() {
        return maxConnections;
    }

    /**
     * Gets MaxErrorRetry property
     * 
     * @return Max number of retries on 500th errors
     */
    public int getMaxErrorRetry() {
        return maxErrorRetry;
    }

    /**
     * Gets ProxyHost property
     * 
     * @return Proxy Host for connection
     */
    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * Gets ProxyPassword property
     * 
     * @return Proxy Password
     */
    public String getProxyPassword() {
        return proxyPassword;
    }

    /**
     * Gets ProxyPort property.
     * 
     * @return Proxy Port for connection.
     */
    public int getProxyPort() {
        return proxyPort;
    }

    /**
     * Gets the proxy username property.
     * 
     * @return Proxy username.
     */
    public String getProxyUsername() {
        return proxyUsername;
    }

    /**
     * Gets SignatureMethod property
     * 
     * @return Signature Method for signing requests
     */
    public String getSignatureMethod() {
        return signatureMethod;
    }

    /**
     * Gets SignatureVersion property
     * 
     * @return Signature Version for signing requests
     */
    public String getSignatureVersion() {
        return signatureVersion;
    }

    /**
     * Gets SocketTimeout property
     * 
     * @return Socket Timeout for waiting for data
     */
    public int getSocketTimeout() {
        return socketTimeout;
    }

    /**
     * Gets UserAgent property
     * 
     * @return User Agent String to use when sending request
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Gets the currently set request headers
     *
     * @return Map of all set request headers
     */
    protected Map<String, String> getRequestHeaders() {
        return headers;
    }

    /**
     * Gets the currently set value of a request header
     *
     * @param name the name of the header to get
     * @return value of specified header, or null if not defined
     */
    public String getRequestHeader(String name) {
        return headers.get(name);
    }

    /**
     * Create a new request.
     * <p>
     * After first call to this method connection parameters can no longer be
     * updated.
     * 
     * @param servicePath
     * @param operationName
     * 
     * @return A new request.
     */
    public MwsCall newCall(String servicePath, String operationName) {
        if (!frozen) {
            freeze();
        }
        ServiceEndpoint sep = getServiceEndpoint(servicePath);
        // in future use sep+config to determine MwsCall implementation.
        return new MwsAQCall(this, sep, operationName);
    }

    /**
     * Set the application name.
     * 
     * @param name
     */
    public synchronized void setApplicationName(String name) {
        checkUpdatable();
        applicationName = name;
    }

    /**
     * Set the application version.
     * 
     * @param version
     */
    public synchronized void setApplicationVersion(String version) {
        checkUpdatable();
        applicationVersion = version;
    }

    /**
     * Set the access key id.
     * 
     * @param awsAccessKeyId
     */
    public synchronized void setAwsAccessKeyId(String awsAccessKeyId) {
        checkUpdatable();
        this.awsAccessKeyId = awsAccessKeyId;
    }

    /**
     * Set the secret key.
     * 
     * @param awsSecretKeyId
     */
    public synchronized void setAwsSecretKeyId(String awsSecretKeyId) {
        checkUpdatable();
        this.awsSecretKeyId = awsSecretKeyId;
    }

    /**
     * Set the connection timeout.
     * 
     * @param timeout
     *            The connection timeout in milliseconds;
     */
    public synchronized void setConnectionTimeout(int timeout) {
        checkUpdatable();
        this.connectionTimeout = timeout;
    }

    /**
     * Sets service endpoint property.
     * 
     * @param endpoint
     *            The service end point URI.
     * 
     */
    public synchronized void setEndpoint(URI endpoint) {
        checkUpdatable();
        int port = endpoint.getPort();
        if (port==80||port==443) {
            if (MwsUtl.usesStandardPort(endpoint)) {
                try {
                    //some versions of apache http client cause signature errors when
                    //standard port is explicitly used, so remove that case.
                    endpoint = new URI(endpoint.getScheme(), endpoint.getHost(), 
                            endpoint.getPath(), endpoint.getFragment());
                } catch (URISyntaxException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }
        this.endpoint = endpoint;
    }

    /**
     * Set the executor service to use for async requests.
     * 
     * @param executor
     */
    public synchronized void setExecutorService(ExecutorService executor) {
        checkUpdatable();
        this.executorService = executor;
    }

    /**
     * Set the client library version.
     * <p>
     * Used to create default user agent string.
     * 
     * @param libraryVersion
     * 
     */
    public synchronized void setLibraryVersion(String libraryVersion) {
        checkUpdatable();
        this.libraryVersion = libraryVersion;
    }

    /**
     * Set MaxAsyncQueueSize property.
     * <p>
     * When the async queue is full further async calls will execute on the
     * calling thread.
     * 
     * see {@link #setMaxAsyncThreads(int)}
     * 
     * @param maxAsyncQueueSize
     */
    public synchronized void setMaxAsyncQueueSize(int maxAsyncQueueSize) {
        checkUpdatable();
        this.maxAsyncQueueSize = maxAsyncQueueSize;
    }

    /**
     * Set MaxAsyncThreads property.
     * <p>
     * This is the maximum number of threads to spawn for async operations.
     * <p>
     * When Max number of threads is reached, requests will be stored in the
     * queue. When queue becomes full, request will be executed on the calling
     * thread.
     * <p>
     * Only used to configure default shared executor service when it is first
     * created. If caller supplies an executor service for a connection or the
     * shared executor already exists then this parameter is ignored.
     * 
     * @param maxAsyncThreads
     */
    public synchronized void setMaxAsyncThreads(int maxAsyncThreads) {
        checkUpdatable();
        this.maxAsyncThreads = maxAsyncThreads;
    }

    /**
     * Set MaxConnections property.
     * <p>
     * All MwsConnection instances share the same connection pool. Only the
     * first MwsConnection configures the pool size.
     * 
     * @param maxConnections
     *            Max number of http connections
     * 
     */
    public synchronized void setMaxConnections(int maxConnections) {
        checkUpdatable();
        this.maxConnections = maxConnections;
    }

    /**
     * Sets MaxErrorRetry property
     * 
     * @param maxErrorRetry
     *            Max number of retries on 50x errors
     * 
     */
    public synchronized void setMaxErrorRetry(int maxErrorRetry) {
        checkUpdatable();
        this.maxErrorRetry = maxErrorRetry;
    }

    /**
     * Sets ProxyHost property
     * 
     * @param proxyHost
     *            Proxy Host for connection
     * 
     */
    public synchronized void setProxyHost(String proxyHost) {
        checkUpdatable();
        this.proxyHost = proxyHost;
    }

    /**
     * Sets ProxyPassword property
     * 
     * @param proxyPassword
     *            Proxy Password for connection
     * 
     */
    public synchronized void setProxyPassword(String proxyPassword) {
        checkUpdatable();
        this.proxyPassword = proxyPassword;
    }

    /**
     * Sets ProxyPort property.
     * 
     * @param proxyPort
     *            Proxy Port for connection.
     * 
     */
    public synchronized void setProxyPort(int proxyPort) {
        checkUpdatable();
        this.proxyPort = proxyPort;
    }

    /**
     * Sets ProxyUsername property.
     * 
     * @param proxyUsername
     *            Proxy username for connection.
     * 
     */
    public synchronized void setProxyUsername(String proxyUsername) {
        checkUpdatable();
        this.proxyUsername = proxyUsername;
    }

    /**
     * Sets SignatureMethod property
     * 
     * @param signatureMethod
     *            Signature Method for signing requests
     */
    public synchronized void setSignatureMethod(String signatureMethod) {
        checkUpdatable();
        this.signatureMethod = signatureMethod;
    }

    /**
     * Sets SignatureVersion property
     * 
     * @param signatureVersion
     *            Signature Version for signing requests
     */
    public synchronized void setSignatureVersion(String signatureVersion) {
        checkUpdatable();
        this.signatureVersion = signatureVersion;
    }

    /**
     * Sets SocketTimeout property
     * 
     * @param socketTimeout
     *            Timeout for waiting for data
     */
    public synchronized void setSocketTimeout(int socketTimeout) {
        checkUpdatable();
        this.socketTimeout = socketTimeout;
    }

    /**
     * Sets UserAgent property
     * 
     * @param applicationName
     * @param applicationVersion
     * @param programmingLanguage
     * @param additionalNameValuePairs
     * 
     */
    public synchronized void setUserAgent(String applicationName,
            String applicationVersion, String programmingLanguage,
            String... additionalNameValuePairs) {
        checkUpdatable();
        StringBuilder b = new StringBuilder();
        b.append(applicationName);
        b.append("/");
        b.append(applicationVersion);
        b.append(" (Language=");
        b.append(programmingLanguage);
        int i = 0;
        while (i < additionalNameValuePairs.length) {
            String name = additionalNameValuePairs[i];
            String value = additionalNameValuePairs[i + 1];
            b.append("; ");
            b.append(name);
            b.append("=");
            b.append(value);
            i += 2;
        }
        b.append(")");
        this.userAgent = b.toString();
    }

    /**
     * Sets the value of a request header to be included on every request
     *
     * @param name the name of the header to set
     * @param value value to send with header
     */
    public void includeRequestHeader(String name, String value) {
        checkUpdatable();
        this.headers.put(name, value);
    }

    /**
     * Create with defaults.
     * 
     */
    public MwsConnection() {
    }

    /**
     * Create a connection.
     * 
     * @param endpoint
     *            The endpoint URI.
     * 
     * @param applicationName
     *            The calling applications name.
     * 
     * @param applicationVersion
     *            The calling applications version.
     * 
     * @param awsAccessKeyId
     *            The developer access key id.
     * 
     * @param awsSecretKeyId
     *            The developers secret key id.
     */
    public MwsConnection(URI endpoint, String applicationName,
            String applicationVersion, String awsAccessKeyId,
            String awsSecretKeyId) {
        this();
        setEndpoint(endpoint);
        this.applicationName = applicationName;
        this.applicationVersion = applicationVersion;
        this.awsAccessKeyId = awsAccessKeyId;
        this.awsSecretKeyId = awsSecretKeyId;
    }

}
