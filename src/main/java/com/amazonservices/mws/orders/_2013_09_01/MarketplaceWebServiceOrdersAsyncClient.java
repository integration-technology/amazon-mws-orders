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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.amazonservices.mws.orders._2013_09_01.model.*;

public class MarketplaceWebServiceOrdersAsyncClient extends MarketplaceWebServiceOrdersClient implements MarketplaceWebServiceOrdersAsync {

    public MarketplaceWebServiceOrdersAsyncClient(
            String accessKey,
            String secretKey,
            String applicationName,
            String applicationVersion,
            MarketplaceWebServiceOrdersConfig config,
            ExecutorService executor) {
        super(accessKey, secretKey, applicationName, applicationVersion, config);
        connection.setExecutorService(executor);
    }

    public MarketplaceWebServiceOrdersAsyncClient(
            String accessKey,
            String secretKey,
            String applicationName,
            String applicationVersion,
            MarketplaceWebServiceOrdersConfig config) {
        super(accessKey, secretKey, applicationName, applicationVersion, config);
    }

    public MarketplaceWebServiceOrdersAsyncClient(
            String accessKey,
            String secretKey,
            MarketplaceWebServiceOrdersConfig config) {
        super(accessKey, secretKey, config);
    }

    public MarketplaceWebServiceOrdersAsyncClient(
            String accessKey,
            String secretKey,
            String applicationName,
            String applicationVersion) {
        super(accessKey, secretKey, applicationName, applicationVersion);
    }

    public Future<GetOrderResponse> getOrderAsync(
        GetOrderRequest request) {
        return connection.callAsync(
            new RequestType("GetOrder", GetOrderResponse.class, servicePath),
            request);
    }

    public Future<GetServiceStatusResponse> getServiceStatusAsync(
        GetServiceStatusRequest request) {
        return connection.callAsync(
            new RequestType("GetServiceStatus", GetServiceStatusResponse.class, servicePath),
            request);
    }

    public Future<ListOrderItemsResponse> listOrderItemsAsync(
        ListOrderItemsRequest request) {
        return connection.callAsync(
            new RequestType("ListOrderItems", ListOrderItemsResponse.class, servicePath),
            request);
    }

    public Future<ListOrderItemsByNextTokenResponse> listOrderItemsByNextTokenAsync(
        ListOrderItemsByNextTokenRequest request) {
        return connection.callAsync(
            new RequestType("ListOrderItemsByNextToken", ListOrderItemsByNextTokenResponse.class, servicePath),
            request);
    }

    public Future<ListOrdersResponse> listOrdersAsync(
        ListOrdersRequest request) {
        return connection.callAsync(
            new RequestType("ListOrders", ListOrdersResponse.class, servicePath),
            request);
    }

    public Future<ListOrdersByNextTokenResponse> listOrdersByNextTokenAsync(
        ListOrdersByNextTokenRequest request) {
        return connection.callAsync(
            new RequestType("ListOrdersByNextToken", ListOrdersByNextTokenResponse.class, servicePath),
            request);
    }


}
