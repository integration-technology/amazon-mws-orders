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
 * List Orders Request
 * API Version: 2013-09-01
 * Library Version: 2013-09-01
 * Generated: Thu Feb 06 16:04:52 GMT 2014
 */
package com.amazonservices.mws.orders._2013_09_01.model;

import java.util.List;
import java.util.ArrayList;

import javax.xml.datatype.XMLGregorianCalendar;

import com.amazonservices.mws.client.*;

/**
 * ListOrdersRequest complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ListOrdersRequest"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="SellerId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="CreatedAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="CreatedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="LastUpdatedAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="LastUpdatedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="OrderStatus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *             &lt;element name="MarketplaceId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *             &lt;element name="FulfillmentChannel" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *             &lt;element name="PaymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *             &lt;element name="BuyerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="SellerOrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="MaxResultsPerPage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="TFMShipmentStatus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class ListOrdersRequest extends AbstractMwsObject {

    private String sellerId;

    private XMLGregorianCalendar createdAfter;

    private XMLGregorianCalendar createdBefore;

    private XMLGregorianCalendar lastUpdatedAfter;

    private XMLGregorianCalendar lastUpdatedBefore;

    private List<String> orderStatus;

    private List<String> marketplaceId;

    private List<String> fulfillmentChannel;

    private List<String> paymentMethod;

    private String buyerEmail;

    private String sellerOrderId;

    private Integer maxResultsPerPage;

    private List<String> tfmShipmentStatus;

    /**
     * Get the value of SellerId.
     *
     * @return The value of SellerId.
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * Set the value of SellerId.
     *
     * @param sellerId
     *            The new value to set.
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * Check to see if SellerId is set.
     *
     * @return true if SellerId is set.
     */
    public boolean isSetSellerId() {
        return sellerId != null;
    }

    /**
     * Set the value of SellerId, return this.
     *
     * @param sellerId
     *             The new value to set.
     *
     * @return This instance.
     */
    public ListOrdersRequest withSellerId(String sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    /**
     * Get the value of CreatedAfter.
     *
     * @return The value of CreatedAfter.
     */
    public XMLGregorianCalendar getCreatedAfter() {
        return createdAfter;
    }

    /**
     * Set the value of CreatedAfter.
     *
     * @param createdAfter
     *            The new value to set.
     */
    public void setCreatedAfter(XMLGregorianCalendar createdAfter) {
        this.createdAfter = createdAfter;
    }

    /**
     * Check to see if CreatedAfter is set.
     *
     * @return true if CreatedAfter is set.
     */
    public boolean isSetCreatedAfter() {
        return createdAfter != null;
    }

    /**
     * Set the value of CreatedAfter, return this.
     *
     * @param createdAfter
     *             The new value to set.
     *
     * @return This instance.
     */
    public ListOrdersRequest withCreatedAfter(XMLGregorianCalendar createdAfter) {
        this.createdAfter = createdAfter;
        return this;
    }

    /**
     * Get the value of CreatedBefore.
     *
     * @return The value of CreatedBefore.
     */
    public XMLGregorianCalendar getCreatedBefore() {
        return createdBefore;
    }

    /**
     * Set the value of CreatedBefore.
     *
     * @param createdBefore
     *            The new value to set.
     */
    public void setCreatedBefore(XMLGregorianCalendar createdBefore) {
        this.createdBefore = createdBefore;
    }

    /**
     * Check to see if CreatedBefore is set.
     *
     * @return true if CreatedBefore is set.
     */
    public boolean isSetCreatedBefore() {
        return createdBefore != null;
    }

    /**
     * Set the value of CreatedBefore, return this.
     *
     * @param createdBefore
     *             The new value to set.
     *
     * @return This instance.
     */
    public ListOrdersRequest withCreatedBefore(XMLGregorianCalendar createdBefore) {
        this.createdBefore = createdBefore;
        return this;
    }

    /**
     * Get the value of LastUpdatedAfter.
     *
     * @return The value of LastUpdatedAfter.
     */
    public XMLGregorianCalendar getLastUpdatedAfter() {
        return lastUpdatedAfter;
    }

    /**
     * Set the value of LastUpdatedAfter.
     *
     * @param lastUpdatedAfter
     *            The new value to set.
     */
    public void setLastUpdatedAfter(XMLGregorianCalendar lastUpdatedAfter) {
        this.lastUpdatedAfter = lastUpdatedAfter;
    }

    /**
     * Check to see if LastUpdatedAfter is set.
     *
     * @return true if LastUpdatedAfter is set.
     */
    public boolean isSetLastUpdatedAfter() {
        return lastUpdatedAfter != null;
    }

    /**
     * Set the value of LastUpdatedAfter, return this.
     *
     * @param lastUpdatedAfter
     *             The new value to set.
     *
     * @return This instance.
     */
    public ListOrdersRequest withLastUpdatedAfter(XMLGregorianCalendar lastUpdatedAfter) {
        this.lastUpdatedAfter = lastUpdatedAfter;
        return this;
    }

    /**
     * Get the value of LastUpdatedBefore.
     *
     * @return The value of LastUpdatedBefore.
     */
    public XMLGregorianCalendar getLastUpdatedBefore() {
        return lastUpdatedBefore;
    }

    /**
     * Set the value of LastUpdatedBefore.
     *
     * @param lastUpdatedBefore
     *            The new value to set.
     */
    public void setLastUpdatedBefore(XMLGregorianCalendar lastUpdatedBefore) {
        this.lastUpdatedBefore = lastUpdatedBefore;
    }

    /**
     * Check to see if LastUpdatedBefore is set.
     *
     * @return true if LastUpdatedBefore is set.
     */
    public boolean isSetLastUpdatedBefore() {
        return lastUpdatedBefore != null;
    }

    /**
     * Set the value of LastUpdatedBefore, return this.
     *
     * @param lastUpdatedBefore
     *             The new value to set.
     *
     * @return This instance.
     */
    public ListOrdersRequest withLastUpdatedBefore(XMLGregorianCalendar lastUpdatedBefore) {
        this.lastUpdatedBefore = lastUpdatedBefore;
        return this;
    }

    /**
     * Get the value of OrderStatus.
     *
     * @return The value of OrderStatus.
     */
    public List<String> getOrderStatus() {
        if (orderStatus==null) {
            orderStatus = new ArrayList<String>();
        }
        return orderStatus;
    }

    /**
     * Set the value of OrderStatus.
     *
     * @param orderStatus
     *            The new value to set.
     */
    public void setOrderStatus(List<String> orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Clear OrderStatus.
     */
    public void unsetOrderStatus() {
        this.orderStatus = null;
    }

    /**
     * Check to see if OrderStatus is set.
     *
     * @return true if OrderStatus is set.
     */
    public boolean isSetOrderStatus() {
        return orderStatus != null && !orderStatus.isEmpty();
    }

    /**
     * Add values for OrderStatus, return this.
     *
     * @param orderStatus
     *             New values to add.
     *
     * @return This instance.
     */
    public ListOrdersRequest withOrderStatus(String... values) {
        List<String> list = getOrderStatus();
        for (String value : values) {
            list.add(value);
        }
        return this;
    }

    /**
     * Get the value of MarketplaceId.
     *
     * @return The value of MarketplaceId.
     */
    public List<String> getMarketplaceId() {
        if (marketplaceId==null) {
            marketplaceId = new ArrayList<String>();
        }
        return marketplaceId;
    }

    /**
     * Set the value of MarketplaceId.
     *
     * @param marketplaceId
     *            The new value to set.
     */
    public void setMarketplaceId(List<String> marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    /**
     * Clear MarketplaceId.
     */
    public void unsetMarketplaceId() {
        this.marketplaceId = null;
    }

    /**
     * Check to see if MarketplaceId is set.
     *
     * @return true if MarketplaceId is set.
     */
    public boolean isSetMarketplaceId() {
        return marketplaceId != null && !marketplaceId.isEmpty();
    }

    /**
     * Add values for MarketplaceId, return this.
     *
     * @param marketplaceId
     *             New values to add.
     *
     * @return This instance.
     */
    public ListOrdersRequest withMarketplaceId(String... values) {
        List<String> list = getMarketplaceId();
        for (String value : values) {
            list.add(value);
        }
        return this;
    }

    /**
     * Get the value of FulfillmentChannel.
     *
     * @return The value of FulfillmentChannel.
     */
    public List<String> getFulfillmentChannel() {
        if (fulfillmentChannel==null) {
            fulfillmentChannel = new ArrayList<String>();
        }
        return fulfillmentChannel;
    }

    /**
     * Set the value of FulfillmentChannel.
     *
     * @param fulfillmentChannel
     *            The new value to set.
     */
    public void setFulfillmentChannel(List<String> fulfillmentChannel) {
        this.fulfillmentChannel = fulfillmentChannel;
    }

    /**
     * Clear FulfillmentChannel.
     */
    public void unsetFulfillmentChannel() {
        this.fulfillmentChannel = null;
    }

    /**
     * Check to see if FulfillmentChannel is set.
     *
     * @return true if FulfillmentChannel is set.
     */
    public boolean isSetFulfillmentChannel() {
        return fulfillmentChannel != null && !fulfillmentChannel.isEmpty();
    }

    /**
     * Add values for FulfillmentChannel, return this.
     *
     * @param fulfillmentChannel
     *             New values to add.
     *
     * @return This instance.
     */
    public ListOrdersRequest withFulfillmentChannel(String... values) {
        List<String> list = getFulfillmentChannel();
        for (String value : values) {
            list.add(value);
        }
        return this;
    }

    /**
     * Get the value of PaymentMethod.
     *
     * @return The value of PaymentMethod.
     */
    public List<String> getPaymentMethod() {
        if (paymentMethod==null) {
            paymentMethod = new ArrayList<String>();
        }
        return paymentMethod;
    }

    /**
     * Set the value of PaymentMethod.
     *
     * @param paymentMethod
     *            The new value to set.
     */
    public void setPaymentMethod(List<String> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Clear PaymentMethod.
     */
    public void unsetPaymentMethod() {
        this.paymentMethod = null;
    }

    /**
     * Check to see if PaymentMethod is set.
     *
     * @return true if PaymentMethod is set.
     */
    public boolean isSetPaymentMethod() {
        return paymentMethod != null && !paymentMethod.isEmpty();
    }

    /**
     * Add values for PaymentMethod, return this.
     *
     * @param paymentMethod
     *             New values to add.
     *
     * @return This instance.
     */
    public ListOrdersRequest withPaymentMethod(String... values) {
        List<String> list = getPaymentMethod();
        for (String value : values) {
            list.add(value);
        }
        return this;
    }

    /**
     * Get the value of BuyerEmail.
     *
     * @return The value of BuyerEmail.
     */
    public String getBuyerEmail() {
        return buyerEmail;
    }

    /**
     * Set the value of BuyerEmail.
     *
     * @param buyerEmail
     *            The new value to set.
     */
    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    /**
     * Check to see if BuyerEmail is set.
     *
     * @return true if BuyerEmail is set.
     */
    public boolean isSetBuyerEmail() {
        return buyerEmail != null;
    }

    /**
     * Set the value of BuyerEmail, return this.
     *
     * @param buyerEmail
     *             The new value to set.
     *
     * @return This instance.
     */
    public ListOrdersRequest withBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
        return this;
    }

    /**
     * Get the value of SellerOrderId.
     *
     * @return The value of SellerOrderId.
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * Set the value of SellerOrderId.
     *
     * @param sellerOrderId
     *            The new value to set.
     */
    public void setSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
    }

    /**
     * Check to see if SellerOrderId is set.
     *
     * @return true if SellerOrderId is set.
     */
    public boolean isSetSellerOrderId() {
        return sellerOrderId != null;
    }

    /**
     * Set the value of SellerOrderId, return this.
     *
     * @param sellerOrderId
     *             The new value to set.
     *
     * @return This instance.
     */
    public ListOrdersRequest withSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }

    /**
     * Get the value of MaxResultsPerPage.
     *
     * @return The value of MaxResultsPerPage.
     */
    public Integer getMaxResultsPerPage() {
        return maxResultsPerPage;
    }

    /**
     * Set the value of MaxResultsPerPage.
     *
     * @param maxResultsPerPage
     *            The new value to set.
     */
    public void setMaxResultsPerPage(Integer maxResultsPerPage) {
        this.maxResultsPerPage = maxResultsPerPage;
    }

    /**
     * Check to see if MaxResultsPerPage is set.
     *
     * @return true if MaxResultsPerPage is set.
     */
    public boolean isSetMaxResultsPerPage() {
        return maxResultsPerPage != null;
    }

    /**
     * Set the value of MaxResultsPerPage, return this.
     *
     * @param maxResultsPerPage
     *             The new value to set.
     *
     * @return This instance.
     */
    public ListOrdersRequest withMaxResultsPerPage(Integer maxResultsPerPage) {
        this.maxResultsPerPage = maxResultsPerPage;
        return this;
    }

    /**
     * Get the value of TFMShipmentStatus.
     *
     * @return The value of TFMShipmentStatus.
     */
    public List<String> getTFMShipmentStatus() {
        if (tfmShipmentStatus==null) {
            tfmShipmentStatus = new ArrayList<String>();
        }
        return tfmShipmentStatus;
    }

    /**
     * Set the value of TFMShipmentStatus.
     *
     * @param tfmShipmentStatus
     *            The new value to set.
     */
    public void setTFMShipmentStatus(List<String> tfmShipmentStatus) {
        this.tfmShipmentStatus = tfmShipmentStatus;
    }

    /**
     * Clear TFMShipmentStatus.
     */
    public void unsetTFMShipmentStatus() {
        this.tfmShipmentStatus = null;
    }

    /**
     * Check to see if TFMShipmentStatus is set.
     *
     * @return true if TFMShipmentStatus is set.
     */
    public boolean isSetTFMShipmentStatus() {
        return tfmShipmentStatus != null && !tfmShipmentStatus.isEmpty();
    }

    /**
     * Add values for TFMShipmentStatus, return this.
     *
     * @param tfmShipmentStatus
     *             New values to add.
     *
     * @return This instance.
     */
    public ListOrdersRequest withTFMShipmentStatus(String... values) {
        List<String> list = getTFMShipmentStatus();
        for (String value : values) {
            list.add(value);
        }
        return this;
    }

    /**
     * Read members from a MwsReader.
     *
     * @param r
     *      The reader to read from.
     */
    @Override
    public void readFragmentFrom(MwsReader r) {
        sellerId = r.read("SellerId", String.class);
        createdAfter = r.read("CreatedAfter", XMLGregorianCalendar.class);
        createdBefore = r.read("CreatedBefore", XMLGregorianCalendar.class);
        lastUpdatedAfter = r.read("LastUpdatedAfter", XMLGregorianCalendar.class);
        lastUpdatedBefore = r.read("LastUpdatedBefore", XMLGregorianCalendar.class);
        orderStatus = r.readList("OrderStatus", "Status", String.class);
        marketplaceId = r.readList("MarketplaceId", "Id", String.class);
        fulfillmentChannel = r.readList("FulfillmentChannel", "Channel", String.class);
        paymentMethod = r.readList("PaymentMethod", "Method", String.class);
        buyerEmail = r.read("BuyerEmail", String.class);
        sellerOrderId = r.read("SellerOrderId", String.class);
        maxResultsPerPage = r.read("MaxResultsPerPage", Integer.class);
        tfmShipmentStatus = r.readList("TFMShipmentStatus", "Status", String.class);
    }

    /**
     * Write members to a MwsWriter.
     *
     * @param w
     *      The writer to write to.
     */
    @Override
    public void writeFragmentTo(MwsWriter w) {
        w.write("SellerId", sellerId);
        w.write("CreatedAfter", createdAfter);
        w.write("CreatedBefore", createdBefore);
        w.write("LastUpdatedAfter", lastUpdatedAfter);
        w.write("LastUpdatedBefore", lastUpdatedBefore);
        w.writeList("OrderStatus", "Status", orderStatus);
        w.writeList("MarketplaceId", "Id", marketplaceId);
        w.writeList("FulfillmentChannel", "Channel", fulfillmentChannel);
        w.writeList("PaymentMethod", "Method", paymentMethod);
        w.write("BuyerEmail", buyerEmail);
        w.write("SellerOrderId", sellerOrderId);
        w.write("MaxResultsPerPage", maxResultsPerPage);
        w.writeList("TFMShipmentStatus", "Status", tfmShipmentStatus);
    }

    /**
     * Write tag, xmlns and members to a MwsWriter.
     *
     * @param w
     *         The Writer to write to.
     */
    @Override
    public void writeTo(MwsWriter w) {
        w.write("https://mws.amazonservices.com/Orders/2013-09-01", "ListOrdersRequest",this);
    }

    /** Value constructor. */
    public ListOrdersRequest(String sellerId,XMLGregorianCalendar createdAfter,XMLGregorianCalendar createdBefore,XMLGregorianCalendar lastUpdatedAfter,XMLGregorianCalendar lastUpdatedBefore,List<String> orderStatus,List<String> marketplaceId,List<String> fulfillmentChannel,List<String> paymentMethod,String buyerEmail,String sellerOrderId,Integer maxResultsPerPage,List<String> tfmShipmentStatus) {
        this.sellerId = sellerId;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.lastUpdatedAfter = lastUpdatedAfter;
        this.lastUpdatedBefore = lastUpdatedBefore;
        this.orderStatus = orderStatus;
        this.marketplaceId = marketplaceId;
        this.fulfillmentChannel = fulfillmentChannel;
        this.paymentMethod = paymentMethod;
        this.buyerEmail = buyerEmail;
        this.sellerOrderId = sellerOrderId;
        this.maxResultsPerPage = maxResultsPerPage;
        this.tfmShipmentStatus = tfmShipmentStatus;
    }

    /** Default constructor. */
    public ListOrdersRequest() {
        super();
    }

}
