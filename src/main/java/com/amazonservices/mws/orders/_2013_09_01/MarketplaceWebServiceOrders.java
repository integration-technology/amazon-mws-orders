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

import com.amazonservices.mws.orders._2013_09_01.model.*;

/**
 * This contains the Order Retrieval API section of the Marketplace Web Service.
 */
public interface MarketplaceWebServiceOrders {

    /**
     * Get Order
     *
     * This operation takes up to 50 order ids and returns the corresponding orders.
     *
     * @param request
     *           GetOrderRequest request.
     *
     * @return GetOrderResponse response.
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    GetOrderResponse getOrder(
        GetOrderRequest request)
        throws MarketplaceWebServiceOrdersException;

    /**
     * Get Service Status
     *
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
    GetServiceStatusResponse getServiceStatus(
        GetServiceStatusRequest request)
        throws MarketplaceWebServiceOrdersException;

    /**
     * List Order Items
     *
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
    ListOrderItemsResponse listOrderItems(
        ListOrderItemsRequest request)
        throws MarketplaceWebServiceOrdersException;

    /**
     * List Order Items By Next Token
     *
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
    ListOrderItemsByNextTokenResponse listOrderItemsByNextToken(
        ListOrderItemsByNextTokenRequest request)
        throws MarketplaceWebServiceOrdersException;

    /**
     * List Orders
     *
     * ListOrders can be used to find orders that meet the specified criteria.
     *
     * @param request
     *           ListOrdersRequest request.
     *
     * @return ListOrdersResponse response.
     *
     * @throws MarketplaceWebServiceOrdersException
     */
    ListOrdersResponse listOrders(
        ListOrdersRequest request)
        throws MarketplaceWebServiceOrdersException;

    /**
     * List Orders By Next Token
     *
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
    ListOrdersByNextTokenResponse listOrdersByNextToken(
        ListOrdersByNextTokenRequest request)
        throws MarketplaceWebServiceOrdersException;

}
