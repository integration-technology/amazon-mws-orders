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
package com.amazonservices.mws.orders._2013_09_01.samples;

import java.util.*;
import java.util.concurrent.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

import com.amazonservices.mws.client.*;
import com.amazonservices.mws.orders._2013_09_01.*;
import com.amazonservices.mws.orders._2013_09_01.model.*;

/** Sample async call for ListOrders. */
public class ListOrdersAsyncSample {

    /**
     * Call the service, log response and exceptions.
     *
     * @param client
     * @param request
     *
     * @return The response.
     */
    public static List<Object> invokeListOrders(
            MarketplaceWebServiceOrdersAsync client, 
            List<ListOrdersRequest> requestList) {
        // Call the service async.
        List<Future<ListOrdersResponse>> futureList = 
            new ArrayList<Future<ListOrdersResponse>>();
        for (ListOrdersRequest request : requestList) {
            Future<ListOrdersResponse> future = 
                client.listOrdersAsync(request);
            futureList.add(future);
        }
        List<Object> responseList = new ArrayList<Object>();
        for (Future<ListOrdersResponse> future : futureList) {
            Object xresponse;
            try {
                ListOrdersResponse response = future.get();
                ResponseHeaderMetadata rhmd = response.getResponseHeaderMetadata();
                // We recommend logging every the request id and timestamp of every call.
                System.out.println("Response:");
                System.out.println("RequestId: "+rhmd.getRequestId());
                System.out.println("Timestamp: "+rhmd.getTimestamp());
                String responseXml = response.toXML();
                System.out.println(responseXml);
                xresponse = response;
            } catch (ExecutionException ee) {
                Throwable cause = ee.getCause();
                if (cause instanceof MarketplaceWebServiceOrdersException) {
                    // Exception properties are important for diagnostics.
                    MarketplaceWebServiceOrdersException ex = 
                        (MarketplaceWebServiceOrdersException)cause;
                    ResponseHeaderMetadata rhmd = ex.getResponseHeaderMetadata();
                    System.out.println("Service Exception:");
                    System.out.println("RequestId: "+rhmd.getRequestId());
                    System.out.println("Timestamp: "+rhmd.getTimestamp());
                    System.out.println("Message: "+ex.getMessage());
                    System.out.println("StatusCode: "+ex.getStatusCode());
                    System.out.println("ErrorCode: "+ex.getErrorCode());
                    System.out.println("ErrorType: "+ex.getErrorType());
                    xresponse = ex;
                } else {
                    xresponse = cause;
                }
            } catch (Exception e) {
                xresponse = e;
            }
            responseList.add(xresponse);
        }
        return responseList;
    }

    /**
     *  Command line entry point.
     */
    public static void main(String[] args) {

        // Get a client connection.
        MarketplaceWebServiceOrdersAsyncClient client = MarketplaceWebServiceOrdersSampleConfig.getAsyncClient();

        // Create a request list.
        List<ListOrdersRequest> requestList = new ArrayList<ListOrdersRequest>();
        ListOrdersRequest request = new ListOrdersRequest();
        String sellerId = "example";
        request.setSellerId(sellerId);
        XMLGregorianCalendar createdAfter = MwsUtl.getDTF().newXMLGregorianCalendar();
        request.setCreatedAfter(createdAfter);
        XMLGregorianCalendar createdBefore = MwsUtl.getDTF().newXMLGregorianCalendar();
        request.setCreatedBefore(createdBefore);
        XMLGregorianCalendar lastUpdatedAfter = MwsUtl.getDTF().newXMLGregorianCalendar();
        request.setLastUpdatedAfter(lastUpdatedAfter);
        XMLGregorianCalendar lastUpdatedBefore = MwsUtl.getDTF().newXMLGregorianCalendar();
        request.setLastUpdatedBefore(lastUpdatedBefore);
        List<String> orderStatus = new ArrayList<String>();
        request.setOrderStatus(orderStatus);
        List<String> marketplaceId = new ArrayList<String>();
        request.setMarketplaceId(marketplaceId);
        List<String> fulfillmentChannel = new ArrayList<String>();
        request.setFulfillmentChannel(fulfillmentChannel);
        List<String> paymentMethod = new ArrayList<String>();
        request.setPaymentMethod(paymentMethod);
        String buyerEmail = "example";
        request.setBuyerEmail(buyerEmail);
        String sellerOrderId = "example";
        request.setSellerOrderId(sellerOrderId);
        Integer maxResultsPerPage = 1;
        request.setMaxResultsPerPage(maxResultsPerPage);
        List<String> tfmShipmentStatus = new ArrayList<String>();
        request.setTFMShipmentStatus(tfmShipmentStatus);
        requestList.add(request);

        // Make the calls.
        ListOrdersAsyncSample.invokeListOrders(client, requestList);

    }

}
