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
package com.amazonservices.mws.orders._2013_09_01.mock;


import java.io.InputStream;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.Date;

import com.amazonservices.mws.orders._2013_09_01.*;
import com.amazonservices.mws.orders._2013_09_01.model.*;

import com.amazonservices.mws.client.MwsObject;
import com.amazonservices.mws.client.MwsUtl;
import com.amazonservices.mws.client.MwsXmlReader;

/**
 * A mock implementation of MarketplaceWebServiceOrders that uses pre-populated set of 
 * XML files that serve local data.
 *
 * It simulates responses from the Marketplace Web Service Orders service.
 *
 * Use this to test your application without making actual service calls.
 *
 * This mock implementation does not validate requests.
 */
public class MarketplaceWebServiceOrdersMock 
        implements MarketplaceWebServiceOrders, MarketplaceWebServiceOrdersAsync {

    /**
     * Create a future that will immediately return the given response.
     *
     * @param response
     *
     * @return Future
     */
    private <T> Future<T> newFuture(final T response) {
        FutureTask<T> t = new FutureTask<T>(new Callable<T>() {
                @Override
                public T call() {
                    return response;
                }
            });
        t.run();
        return t;
    }

    /**
     * Create a new response object.
     * 
     * @param cls
     * 
     * @return The object.
     */
    private <T extends MwsObject> T newResponse(
            Class<T> cls) {
        InputStream is = null;
        try {
            is = this.getClass().getResourceAsStream(cls.getSimpleName()+".xml");
            MwsXmlReader reader = new MwsXmlReader(is);
            T obj = cls.newInstance();
            obj.readFragmentFrom(reader);
            ResponseHeaderMetadata rhmd = new ResponseHeaderMetadata(
                "mockRequestId", Arrays.asList("A","B","C"), "mockTimestamp", 0d, 0d, new Date());
            cls.getMethod("setResponseHeaderMetadata", rhmd.getClass()).invoke(obj,  rhmd);
            return obj;
        } catch (Exception e) {
            throw MwsUtl.wrap(e);
        } finally {
            MwsUtl.close(is);
        }
    }

    /**
     * Get Order
     * This operation takes up to 50 order ids and returns the corresponding orders.
     *
     * @param request
     *           GetOrderRequest request.
     *
     * @return GetOrderResponse response.
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public GetOrderResponse getOrder(GetOrderRequest request) 
            throws MarketplaceWebServiceOrdersException {
        return newResponse(GetOrderResponse.class);
    }

    /**
    * Get Order
    * This operation takes up to 50 order ids and returns the corresponding orders.
    *
    * @param request
    *           GetOrderRequest request.
    *
    * @return Future<GetOrderResponse> Future containing completed response
    *
    * @throws MarketplaceWebServiceOrdersException
    */
    public Future<GetOrderResponse> getOrderAsync(GetOrderRequest request) {
        return newFuture(getOrder(request));
    }

    /**
     * Get Service Status
     * Returns the service status of a particular MWS API section. The operation
     * 		takes no input.
     *
     * @param request
     *           GetServiceStatusRequest request.
     *
     * @return GetServiceStatusResponse response.
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public GetServiceStatusResponse getServiceStatus(GetServiceStatusRequest request) 
            throws MarketplaceWebServiceOrdersException {
        return newResponse(GetServiceStatusResponse.class);
    }

    /**
    * Get Service Status
    * Returns the service status of a particular MWS API section. The operation
     * 		takes no input.
    *
    * @param request
    *           GetServiceStatusRequest request.
    *
    * @return Future<GetServiceStatusResponse> Future containing completed response
    *
    * @throws MarketplaceWebServiceOrdersException
    */
    public Future<GetServiceStatusResponse> getServiceStatusAsync(GetServiceStatusRequest request) {
        return newFuture(getServiceStatus(request));
    }

    /**
     * List Order Items
     * This operation can be used to list the items of the order indicated by the
     *         given order id (only a single Amazon order id is allowed).
     *
     * @param request
     *           ListOrderItemsRequest request.
     *
     * @return ListOrderItemsResponse response.
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrderItemsResponse listOrderItems(ListOrderItemsRequest request) 
            throws MarketplaceWebServiceOrdersException {
        return newResponse(ListOrderItemsResponse.class);
    }

    /**
    * List Order Items
    * This operation can be used to list the items of the order indicated by the
     *         given order id (only a single Amazon order id is allowed).
    *
    * @param request
    *           ListOrderItemsRequest request.
    *
    * @return Future<ListOrderItemsResponse> Future containing completed response
    *
    * @throws MarketplaceWebServiceOrdersException
    */
    public Future<ListOrderItemsResponse> listOrderItemsAsync(ListOrderItemsRequest request) {
        return newFuture(listOrderItems(request));
    }

    /**
     * List Order Items By Next Token
     * If ListOrderItems cannot return all the order items in one go, it will
     *         provide a nextToken. That nextToken can be used with this operation to
     *         retrive the next batch of items for that order.
     *
     * @param request
     *           ListOrderItemsByNextTokenRequest request.
     *
     * @return ListOrderItemsByNextTokenResponse response.
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrderItemsByNextTokenResponse listOrderItemsByNextToken(ListOrderItemsByNextTokenRequest request) 
            throws MarketplaceWebServiceOrdersException {
        return newResponse(ListOrderItemsByNextTokenResponse.class);
    }

    /**
    * List Order Items By Next Token
    * If ListOrderItems cannot return all the order items in one go, it will
     *         provide a nextToken. That nextToken can be used with this operation to
     *         retrive the next batch of items for that order.
    *
    * @param request
    *           ListOrderItemsByNextTokenRequest request.
    *
    * @return Future<ListOrderItemsByNextTokenResponse> Future containing completed response
    *
    * @throws MarketplaceWebServiceOrdersException
    */
    public Future<ListOrderItemsByNextTokenResponse> listOrderItemsByNextTokenAsync(ListOrderItemsByNextTokenRequest request) {
        return newFuture(listOrderItemsByNextToken(request));
    }

    /**
     * List Orders
     * ListOrders can be used to find orders that meet the specified criteria.
     *
     * @param request
     *           ListOrdersRequest request.
     *
     * @return ListOrdersResponse response.
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrdersResponse listOrders(ListOrdersRequest request) 
            throws MarketplaceWebServiceOrdersException {
        return newResponse(ListOrdersResponse.class);
    }

    /**
    * List Orders
    * ListOrders can be used to find orders that meet the specified criteria.
    *
    * @param request
    *           ListOrdersRequest request.
    *
    * @return Future<ListOrdersResponse> Future containing completed response
    *
    * @throws MarketplaceWebServiceOrdersException
    */
    public Future<ListOrdersResponse> listOrdersAsync(ListOrdersRequest request) {
        return newFuture(listOrders(request));
    }

    /**
     * List Orders By Next Token
     * If ListOrders returns a nextToken, thus indicating that there are more orders
     *         than returned that matched the given filter criteria, ListOrdersByNextToken
     *         can be used to retrieve those other orders using that nextToken.
     *
     * @param request
     *           ListOrdersByNextTokenRequest request.
     *
     * @return ListOrdersByNextTokenResponse response.
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    public ListOrdersByNextTokenResponse listOrdersByNextToken(ListOrdersByNextTokenRequest request) 
            throws MarketplaceWebServiceOrdersException {
        return newResponse(ListOrdersByNextTokenResponse.class);
    }

    /**
    * List Orders By Next Token
    * If ListOrders returns a nextToken, thus indicating that there are more orders
     *         than returned that matched the given filter criteria, ListOrdersByNextToken
     *         can be used to retrieve those other orders using that nextToken.
    *
    * @param request
    *           ListOrdersByNextTokenRequest request.
    *
    * @return Future<ListOrdersByNextTokenResponse> Future containing completed response
    *
    * @throws MarketplaceWebServiceOrdersException
    */
    public Future<ListOrdersByNextTokenResponse> listOrdersByNextTokenAsync(ListOrdersByNextTokenRequest request) {
        return newFuture(listOrdersByNextToken(request));
    }

}
