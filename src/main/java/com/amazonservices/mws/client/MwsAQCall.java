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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.w3c.dom.Element;

import com.amazonservices.mws.client.MwsConnection.ServiceEndpoint;

/**
 * An implementation of {@link MwsCall} that uses AWSQuery protocol.
 * 
 * @author mayerj
 */
class MwsAQCall implements MwsCall {

    /** The connection to use. */
    private final MwsConnection connection;

    /** The name of the operation to perform. */
    private final String operationName;

    /** Container for parameters. */
    private final Map<String, String> parameters = new TreeMap<String, String>();

    /** The service endpoint from the servicePath. */
    private final ServiceEndpoint serviceEndpoint;

    /** The response header metadata from the call. */
    private MwsResponseHeaderMetadata rhmd;

    /**
     * Add authentication related and version parameter and set request body
     * with all of the parameters
     * 
     * @param request
     */
    private void addRequiredParametersToRequest(HttpPost request) {
        parameters.put("Action", operationName);
        parameters.put("Version", serviceEndpoint.version);
        parameters.put("Timestamp", MwsUtl.getFormattedTimestamp());
        parameters.put("AWSAccessKeyId", connection.getAwsAccessKeyId());
        String signature = MwsUtl.signParameters(serviceEndpoint.uri,
                connection.getSignatureVersion(),
                connection.getSignatureMethod(), parameters,
                connection.getAwsSecretKeyId());
        parameters.put("Signature", signature);
        List<NameValuePair> parameterList = new ArrayList<NameValuePair>();
        for (Entry<String, String> entry : parameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!(key == null || key.equals("") || value == null || value
                    .equals(""))) {
                parameterList.add(new BasicNameValuePair(key, value));
            }
        }
        try {
            request.setEntity(new UrlEncodedFormEntity(parameterList, "UTF-8"));
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

    /**
     * Read stream into string
     * 
     * @param postResponse
     *            The response to get the body from.
     * 
     * @return The response body.
     */
    private String getResponseBody(HttpResponse postResponse) {
        InputStream input = null;
        try {
            input = postResponse.getEntity().getContent();
            Reader reader = new InputStreamReader(input,
                    MwsUtl.DEFAULT_ENCODING);
            StringBuilder b = new StringBuilder();
            char[] c = new char[1024];
            int len;
            while (0 < (len = reader.read(c))) {
                b.append(c, 0, len);
            }
            return b.toString();
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        } finally {
            MwsUtl.close(input);
        }
    }

    /**
     * Get the metadata from the response headers.
     * 
     * @param response
     * 
     * @return The metadata.
     */
    private MwsResponseHeaderMetadata getResponseHeaderMetadata(HttpResponse response) {
        Header requestIdHeader = response.getFirstHeader("x-mws-request-id");
        String requestId = requestIdHeader == null ? null : requestIdHeader.getValue();

        Header timestampHeader = response.getFirstHeader("x-mws-timestamp");
        String timestamp = timestampHeader == null ? null : timestampHeader.getValue();

        Header contextHeader = response.getFirstHeader("x-mws-response-context");
        String contextString = contextHeader==null ? "" : contextHeader.getValue();
        List<String> context = Collections.unmodifiableList(Arrays.asList(contextString.split(",")));

        Double quotaMax;
        try {
            Header quotaMaxHeader = response.getFirstHeader("x-mws-quota-max");
            quotaMax = quotaMaxHeader == null ? null : Double.valueOf(quotaMaxHeader.getValue());
        } catch (NumberFormatException ex) {
            quotaMax = null;
        }

        Double quotaRemaining;
        try {
            Header quotaRemainingHeader = response.getFirstHeader("x-mws-quota-remaining");
            quotaRemaining = quotaRemainingHeader == null ? null : Double.valueOf(quotaRemainingHeader.getValue());
        } catch (NumberFormatException ex) {
            quotaRemaining = null;
        }

        Date quotaResetDate;
        try {
            Header quotaResetHeader = response.getFirstHeader("x-mws-quota-resetsOn");
            quotaResetDate = quotaResetHeader == null ? null : MwsUtl.parseTimestamp(quotaResetHeader.getValue());
        } catch (java.text.ParseException ex) {
            quotaResetDate = null;
        }

        return new MwsResponseHeaderMetadata(requestId, context, timestamp, quotaMax, quotaRemaining, quotaResetDate);
    }

    /**
     * Random exponential back-off sleep on failed request.
     * 
     * If retry needed sleeps and then return true.
     * 
     * Sleep is random so that retry requests do not form spikes.
     * 
     * @param retries
     *            current retry, 0 for first retry
     * 
     * @return true if should retry.
     */
    private boolean pauseIfRetryNeeded(int retries) {
        if (retries >= connection.getMaxErrorRetry()) {
            return false;
        }
        long delay = (long) (Math.random() * Math.pow(4, retries) * 125);
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
        return true;
    }

    @Override
    public void beginObject(String name) {
        parameterPrefix.append(name);
        parameterPrefix.append('.');
    }

    @Override
    public void close() {
        // close does not need to do anything here.
    }

    @Override
    public void endObject(String name) {
        int nlen = name.length();
        int pplen = parameterPrefix.length();
        if (pplen<nlen+1 || parameterPrefix.charAt(pplen-1)!='.' ||
                !parameterPrefix.subSequence(pplen-nlen-1, pplen-1).equals(name)) {
            throw new IllegalStateException();
        }
        parameterPrefix.setLength(pplen-nlen-1);
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
     * Create a HttpPost request for this call and add required headers and parameters to it.
     * 
     * @return The Post Request.
     */
    private HttpPost createRequest() {
        HttpPost request = new HttpPost(serviceEndpoint.uri);
        try {
            request.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            request.addHeader("X-Amazon-User-Agent", connection.getUserAgent());
            for(Map.Entry<String, String> header : connection.getRequestHeaders().entrySet()) {
                request.addHeader(header.getKey(), header.getValue());
            }
            addRequiredParametersToRequest(request);
        } catch (Exception e) {
            request.releaseConnection();
            throw MwsUtl.wrap(e);
        }
        return request;
    }

    /**
     * Execute a request on this calls connection and context.
     * 
     * @param request
     * 
     * @return The response to executing the request.
     */
    private HttpResponse executeRequest(HttpPost request) throws Exception {
        try {
            HttpClient httpClient = connection.getHttpClient();
            HttpContext httpContext = connection.getHttpContext();
            HttpResponse response = httpClient.execute(request, httpContext);
            return response;
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        }
    }

    /**
     * Perform a synchronous call with no retry or error handling.
     * 
     * @return
     */
    @Override
    public MwsResponse execute() {
        HttpPost request = createRequest();
        try {
            HttpResponse hr = executeRequest(request);
            StatusLine statusLine = hr.getStatusLine();
            int status = statusLine.getStatusCode();
            String message = statusLine.getReasonPhrase();
            rhmd = getResponseHeaderMetadata(hr);
            String body = getResponseBody(hr);
            MwsResponse response = new MwsResponse(status,message,rhmd,body);
            return response;
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        } finally {
             request.releaseConnection();
        }
    }

    /**
     * Perform a synchronous call with error handling and back-off/retry.
     * 
     * @return A MwsReader to read the response from.
     */
    @Override
    public MwsReader invoke() {
        HttpPost request = createRequest();
        for (int retryCount = 0;;retryCount++) {
            try {
                HttpResponse response = executeRequest(request);
                StatusLine statusLine = response.getStatusLine();
                int status = statusLine.getStatusCode();
                String message = statusLine.getReasonPhrase();
                rhmd = getResponseHeaderMetadata(response);
                String body = getResponseBody(response);
                if (status == HttpStatus.SC_OK) {
                    return new MwsXmlReader(body);
                }
                if (status == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                    if (pauseIfRetryNeeded(retryCount)) {
                        continue;
                    }
                }
                throw new MwsException(status, message, null, null, body, rhmd);
            } catch (Exception e) {
                throw MwsUtl.wrap(e);
            } finally {
                request.releaseConnection();
            }
        }
    }

    /** The parameter prefix */
    private StringBuilder parameterPrefix = new StringBuilder();

    /**
     * Put a value into the parameters.
     * <p>
     * Uses parameterPrefix, suppresses nulls and empty string values.
     * <p>
     * May have side effect of appending to parameterPrefix.
     * 
     * @param value
     */
    private void putValue(Object value) {
        if (value==null) {
            return;
        }
        if (value instanceof MwsObject) {
            parameterPrefix.append('.');
            ((MwsObject)value).writeFragmentTo(this);
            return;
        }
        String svalue = value.toString();
        if (svalue!=null && svalue.length()>0) {
            String name = parameterPrefix.toString();
            parameters.put(name, svalue);
        }
    }

    @Override
    public void write(String name, Object value) {
        int holdParameterPrefixLen = parameterPrefix.length();
        parameterPrefix.append(name);
        putValue(value);
        parameterPrefix.setLength(holdParameterPrefixLen);
    }

    @Override
    public void write(String namespace, String name, MwsObject value) {
        value.writeFragmentTo(this);
    }

    @Override
    public void writeAttribute(String name, Object value) {
        write(name, value);
    }

    @Override
    public void writeList(String name, String memberName, Collection<?> list) {
        if (name==null && memberName==null) {
            throw new RuntimeException("Both name and memberName cannot be null.");
        }
        if (list == null) {
            return;
        }
        int holdParameterPrefixLen = parameterPrefix.length();
        if (name!=null) {
            parameterPrefix.append(name);
        }
        if (name!=null && memberName!=null) {
            parameterPrefix.append('.');
        }
        if (memberName!=null) {
            parameterPrefix.append(memberName);
        }
        parameterPrefix.append('.');
        int dotLen = parameterPrefix.length();
        int i = 1;
        for (Object value : list) {
            parameterPrefix.setLength(dotLen);
            parameterPrefix.append(i);
            putValue(value);
            i++;
        }
        parameterPrefix.setLength(holdParameterPrefixLen);
    }

    @Override
    public void writeList(String name, Collection<?> list) {
        writeList(null, name, list);
    }

    @Override
    public void writeAny(Collection<Element> elements) {
        throw new RuntimeException("writeAny not supported.");
    }

    @Override
    public void writeValue(Object value) {
        throw new RuntimeException("writeValue not supported.");
    }

    /**
     * Start a new request on the operation.
     * 
     * @param connection
     *            The connection to use to connect to the end-point.
     * 
     * @param serviceEndpoint
     *            The service endpoint.
     * 
     * @param operationName
     *            The operation name.
     */
    MwsAQCall(MwsConnection connection, ServiceEndpoint serviceEndpoint,
            String operationName) {
        this.connection = connection;
        this.serviceEndpoint = serviceEndpoint;
        this.operationName = operationName;
    }

}
