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
 * Order
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
 * Order complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="Order"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="AmazonOrderId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="SellerOrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="PurchaseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *             &lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *             &lt;element name="OrderStatus" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="FulfillmentChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="SalesChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="OrderChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ShipServiceLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ShippingAddress" type="{https://mws.amazonservices.com/Orders/2013-09-01}Address" minOccurs="0"/&gt;
 *             &lt;element name="OrderTotal" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="NumberOfItemsShipped" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="NumberOfItemsUnshipped" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="PaymentExecutionDetail" type="{https://mws.amazonservices.com/Orders/2013-09-01}PaymentExecutionDetailItem" maxOccurs="unbounded"/&gt;
 *             &lt;element name="PaymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="MarketplaceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="BuyerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="BuyerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ShipmentServiceLevelCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ShippedByAmazonTFM" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *             &lt;element name="TFMShipmentStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="CbaDisplayableShippingLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="EarliestShipDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="LatestShipDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="EarliestDeliveryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="LatestDeliveryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class Order extends AbstractMwsObject {

    private String amazonOrderId;

    private String sellerOrderId;

    private XMLGregorianCalendar purchaseDate;

    private XMLGregorianCalendar lastUpdateDate;

    private String orderStatus;

    private String fulfillmentChannel;

    private String salesChannel;

    private String orderChannel;

    private String shipServiceLevel;

    private Address shippingAddress;

    private Money orderTotal;

    private Integer numberOfItemsShipped;

    private Integer numberOfItemsUnshipped;

    private List<PaymentExecutionDetailItem> paymentExecutionDetail;

    private String paymentMethod;

    private String marketplaceId;

    private String buyerEmail;

    private String buyerName;

    private String shipmentServiceLevelCategory;

    private Boolean shippedByAmazonTFM;

    private String tfmShipmentStatus;

    private String cbaDisplayableShippingLabel;

    private String orderType;

    private XMLGregorianCalendar earliestShipDate;

    private XMLGregorianCalendar latestShipDate;

    private XMLGregorianCalendar earliestDeliveryDate;

    private XMLGregorianCalendar latestDeliveryDate;

    /**
     * Get the value of AmazonOrderId.
     *
     * @return The value of AmazonOrderId.
     */
    public String getAmazonOrderId() {
        return amazonOrderId;
    }

    /**
     * Set the value of AmazonOrderId.
     *
     * @param amazonOrderId
     *            The new value to set.
     */
    public void setAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId;
    }

    /**
     * Check to see if AmazonOrderId is set.
     *
     * @return true if AmazonOrderId is set.
     */
    public boolean isSetAmazonOrderId() {
        return amazonOrderId != null;
    }

    /**
     * Set the value of AmazonOrderId, return this.
     *
     * @param amazonOrderId
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withAmazonOrderId(String amazonOrderId) {
        this.amazonOrderId = amazonOrderId;
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
    public Order withSellerOrderId(String sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
        return this;
    }

    /**
     * Get the value of PurchaseDate.
     *
     * @return The value of PurchaseDate.
     */
    public XMLGregorianCalendar getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Set the value of PurchaseDate.
     *
     * @param purchaseDate
     *            The new value to set.
     */
    public void setPurchaseDate(XMLGregorianCalendar purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * Check to see if PurchaseDate is set.
     *
     * @return true if PurchaseDate is set.
     */
    public boolean isSetPurchaseDate() {
        return purchaseDate != null;
    }

    /**
     * Set the value of PurchaseDate, return this.
     *
     * @param purchaseDate
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withPurchaseDate(XMLGregorianCalendar purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    /**
     * Get the value of LastUpdateDate.
     *
     * @return The value of LastUpdateDate.
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Set the value of LastUpdateDate.
     *
     * @param lastUpdateDate
     *            The new value to set.
     */
    public void setLastUpdateDate(XMLGregorianCalendar lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Check to see if LastUpdateDate is set.
     *
     * @return true if LastUpdateDate is set.
     */
    public boolean isSetLastUpdateDate() {
        return lastUpdateDate != null;
    }

    /**
     * Set the value of LastUpdateDate, return this.
     *
     * @param lastUpdateDate
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withLastUpdateDate(XMLGregorianCalendar lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * Get the value of OrderStatus.
     *
     * @return The value of OrderStatus.
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Set the value of OrderStatus.
     *
     * @param orderStatus
     *            The new value to set.
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Check to see if OrderStatus is set.
     *
     * @return true if OrderStatus is set.
     */
    public boolean isSetOrderStatus() {
        return orderStatus != null;
    }

    /**
     * Set the value of OrderStatus, return this.
     *
     * @param orderStatus
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    /**
     * Get the value of FulfillmentChannel.
     *
     * @return The value of FulfillmentChannel.
     */
    public String getFulfillmentChannel() {
        return fulfillmentChannel;
    }

    /**
     * Set the value of FulfillmentChannel.
     *
     * @param fulfillmentChannel
     *            The new value to set.
     */
    public void setFulfillmentChannel(String fulfillmentChannel) {
        this.fulfillmentChannel = fulfillmentChannel;
    }

    /**
     * Check to see if FulfillmentChannel is set.
     *
     * @return true if FulfillmentChannel is set.
     */
    public boolean isSetFulfillmentChannel() {
        return fulfillmentChannel != null;
    }

    /**
     * Set the value of FulfillmentChannel, return this.
     *
     * @param fulfillmentChannel
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withFulfillmentChannel(String fulfillmentChannel) {
        this.fulfillmentChannel = fulfillmentChannel;
        return this;
    }

    /**
     * Get the value of SalesChannel.
     *
     * @return The value of SalesChannel.
     */
    public String getSalesChannel() {
        return salesChannel;
    }

    /**
     * Set the value of SalesChannel.
     *
     * @param salesChannel
     *            The new value to set.
     */
    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    /**
     * Check to see if SalesChannel is set.
     *
     * @return true if SalesChannel is set.
     */
    public boolean isSetSalesChannel() {
        return salesChannel != null;
    }

    /**
     * Set the value of SalesChannel, return this.
     *
     * @param salesChannel
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
        return this;
    }

    /**
     * Get the value of OrderChannel.
     *
     * @return The value of OrderChannel.
     */
    public String getOrderChannel() {
        return orderChannel;
    }

    /**
     * Set the value of OrderChannel.
     *
     * @param orderChannel
     *            The new value to set.
     */
    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }

    /**
     * Check to see if OrderChannel is set.
     *
     * @return true if OrderChannel is set.
     */
    public boolean isSetOrderChannel() {
        return orderChannel != null;
    }

    /**
     * Set the value of OrderChannel, return this.
     *
     * @param orderChannel
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
        return this;
    }

    /**
     * Get the value of ShipServiceLevel.
     *
     * @return The value of ShipServiceLevel.
     */
    public String getShipServiceLevel() {
        return shipServiceLevel;
    }

    /**
     * Set the value of ShipServiceLevel.
     *
     * @param shipServiceLevel
     *            The new value to set.
     */
    public void setShipServiceLevel(String shipServiceLevel) {
        this.shipServiceLevel = shipServiceLevel;
    }

    /**
     * Check to see if ShipServiceLevel is set.
     *
     * @return true if ShipServiceLevel is set.
     */
    public boolean isSetShipServiceLevel() {
        return shipServiceLevel != null;
    }

    /**
     * Set the value of ShipServiceLevel, return this.
     *
     * @param shipServiceLevel
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withShipServiceLevel(String shipServiceLevel) {
        this.shipServiceLevel = shipServiceLevel;
        return this;
    }

    /**
     * Get the value of ShippingAddress.
     *
     * @return The value of ShippingAddress.
     */
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Set the value of ShippingAddress.
     *
     * @param shippingAddress
     *            The new value to set.
     */
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Check to see if ShippingAddress is set.
     *
     * @return true if ShippingAddress is set.
     */
    public boolean isSetShippingAddress() {
        return shippingAddress != null;
    }

    /**
     * Set the value of ShippingAddress, return this.
     *
     * @param shippingAddress
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    /**
     * Get the value of OrderTotal.
     *
     * @return The value of OrderTotal.
     */
    public Money getOrderTotal() {
        return orderTotal;
    }

    /**
     * Set the value of OrderTotal.
     *
     * @param orderTotal
     *            The new value to set.
     */
    public void setOrderTotal(Money orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * Check to see if OrderTotal is set.
     *
     * @return true if OrderTotal is set.
     */
    public boolean isSetOrderTotal() {
        return orderTotal != null;
    }

    /**
     * Set the value of OrderTotal, return this.
     *
     * @param orderTotal
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withOrderTotal(Money orderTotal) {
        this.orderTotal = orderTotal;
        return this;
    }

    /**
     * Get the value of NumberOfItemsShipped.
     *
     * @return The value of NumberOfItemsShipped.
     */
    public Integer getNumberOfItemsShipped() {
        return numberOfItemsShipped;
    }

    /**
     * Set the value of NumberOfItemsShipped.
     *
     * @param numberOfItemsShipped
     *            The new value to set.
     */
    public void setNumberOfItemsShipped(Integer numberOfItemsShipped) {
        this.numberOfItemsShipped = numberOfItemsShipped;
    }

    /**
     * Check to see if NumberOfItemsShipped is set.
     *
     * @return true if NumberOfItemsShipped is set.
     */
    public boolean isSetNumberOfItemsShipped() {
        return numberOfItemsShipped != null;
    }

    /**
     * Set the value of NumberOfItemsShipped, return this.
     *
     * @param numberOfItemsShipped
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withNumberOfItemsShipped(Integer numberOfItemsShipped) {
        this.numberOfItemsShipped = numberOfItemsShipped;
        return this;
    }

    /**
     * Get the value of NumberOfItemsUnshipped.
     *
     * @return The value of NumberOfItemsUnshipped.
     */
    public Integer getNumberOfItemsUnshipped() {
        return numberOfItemsUnshipped;
    }

    /**
     * Set the value of NumberOfItemsUnshipped.
     *
     * @param numberOfItemsUnshipped
     *            The new value to set.
     */
    public void setNumberOfItemsUnshipped(Integer numberOfItemsUnshipped) {
        this.numberOfItemsUnshipped = numberOfItemsUnshipped;
    }

    /**
     * Check to see if NumberOfItemsUnshipped is set.
     *
     * @return true if NumberOfItemsUnshipped is set.
     */
    public boolean isSetNumberOfItemsUnshipped() {
        return numberOfItemsUnshipped != null;
    }

    /**
     * Set the value of NumberOfItemsUnshipped, return this.
     *
     * @param numberOfItemsUnshipped
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withNumberOfItemsUnshipped(Integer numberOfItemsUnshipped) {
        this.numberOfItemsUnshipped = numberOfItemsUnshipped;
        return this;
    }

    /**
     * Get the value of PaymentExecutionDetail.
     *
     * @return The value of PaymentExecutionDetail.
     */
    public List<PaymentExecutionDetailItem> getPaymentExecutionDetail() {
        if (paymentExecutionDetail==null) {
            paymentExecutionDetail = new ArrayList<PaymentExecutionDetailItem>();
        }
        return paymentExecutionDetail;
    }

    /**
     * Set the value of PaymentExecutionDetail.
     *
     * @param paymentExecutionDetail
     *            The new value to set.
     */
    public void setPaymentExecutionDetail(List<PaymentExecutionDetailItem> paymentExecutionDetail) {
        this.paymentExecutionDetail = paymentExecutionDetail;
    }

    /**
     * Clear PaymentExecutionDetail.
     */
    public void unsetPaymentExecutionDetail() {
        this.paymentExecutionDetail = null;
    }

    /**
     * Check to see if PaymentExecutionDetail is set.
     *
     * @return true if PaymentExecutionDetail is set.
     */
    public boolean isSetPaymentExecutionDetail() {
        return paymentExecutionDetail != null && !paymentExecutionDetail.isEmpty();
    }

    /**
     * Add values for PaymentExecutionDetail, return this.
     *
     * @param paymentExecutionDetail
     *             New values to add.
     *
     * @return This instance.
     */
    public Order withPaymentExecutionDetail(PaymentExecutionDetailItem... values) {
        List<PaymentExecutionDetailItem> list = getPaymentExecutionDetail();
        for (PaymentExecutionDetailItem value : values) {
            list.add(value);
        }
        return this;
    }

    /**
     * Get the value of PaymentMethod.
     *
     * @return The value of PaymentMethod.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Set the value of PaymentMethod.
     *
     * @param paymentMethod
     *            The new value to set.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Check to see if PaymentMethod is set.
     *
     * @return true if PaymentMethod is set.
     */
    public boolean isSetPaymentMethod() {
        return paymentMethod != null;
    }

    /**
     * Set the value of PaymentMethod, return this.
     *
     * @param paymentMethod
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    /**
     * Get the value of MarketplaceId.
     *
     * @return The value of MarketplaceId.
     */
    public String getMarketplaceId() {
        return marketplaceId;
    }

    /**
     * Set the value of MarketplaceId.
     *
     * @param marketplaceId
     *            The new value to set.
     */
    public void setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    /**
     * Check to see if MarketplaceId is set.
     *
     * @return true if MarketplaceId is set.
     */
    public boolean isSetMarketplaceId() {
        return marketplaceId != null;
    }

    /**
     * Set the value of MarketplaceId, return this.
     *
     * @param marketplaceId
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
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
    public Order withBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
        return this;
    }

    /**
     * Get the value of BuyerName.
     *
     * @return The value of BuyerName.
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * Set the value of BuyerName.
     *
     * @param buyerName
     *            The new value to set.
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    /**
     * Check to see if BuyerName is set.
     *
     * @return true if BuyerName is set.
     */
    public boolean isSetBuyerName() {
        return buyerName != null;
    }

    /**
     * Set the value of BuyerName, return this.
     *
     * @param buyerName
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withBuyerName(String buyerName) {
        this.buyerName = buyerName;
        return this;
    }

    /**
     * Get the value of ShipmentServiceLevelCategory.
     *
     * @return The value of ShipmentServiceLevelCategory.
     */
    public String getShipmentServiceLevelCategory() {
        return shipmentServiceLevelCategory;
    }

    /**
     * Set the value of ShipmentServiceLevelCategory.
     *
     * @param shipmentServiceLevelCategory
     *            The new value to set.
     */
    public void setShipmentServiceLevelCategory(String shipmentServiceLevelCategory) {
        this.shipmentServiceLevelCategory = shipmentServiceLevelCategory;
    }

    /**
     * Check to see if ShipmentServiceLevelCategory is set.
     *
     * @return true if ShipmentServiceLevelCategory is set.
     */
    public boolean isSetShipmentServiceLevelCategory() {
        return shipmentServiceLevelCategory != null;
    }

    /**
     * Set the value of ShipmentServiceLevelCategory, return this.
     *
     * @param shipmentServiceLevelCategory
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withShipmentServiceLevelCategory(String shipmentServiceLevelCategory) {
        this.shipmentServiceLevelCategory = shipmentServiceLevelCategory;
        return this;
    }

    /**
     * Check the value of ShippedByAmazonTFM.
     *
     * @return true if ShippedByAmazonTFM is set to true.
     */
    public boolean isShippedByAmazonTFM() {
        return shippedByAmazonTFM!=null && shippedByAmazonTFM.booleanValue();
    }

    /**
     * Get the value of ShippedByAmazonTFM.
     *
     * @return The value of ShippedByAmazonTFM.
     */
    public Boolean getShippedByAmazonTFM() {
        return shippedByAmazonTFM;
    }

    /**
     * Set the value of ShippedByAmazonTFM.
     *
     * @param shippedByAmazonTFM
     *            The new value to set.
     */
    public void setShippedByAmazonTFM(Boolean shippedByAmazonTFM) {
        this.shippedByAmazonTFM = shippedByAmazonTFM;
    }

    /**
     * Check to see if ShippedByAmazonTFM is set.
     *
     * @return true if ShippedByAmazonTFM is set.
     */
    public boolean isSetShippedByAmazonTFM() {
        return shippedByAmazonTFM != null;
    }

    /**
     * Set the value of ShippedByAmazonTFM, return this.
     *
     * @param shippedByAmazonTFM
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withShippedByAmazonTFM(Boolean shippedByAmazonTFM) {
        this.shippedByAmazonTFM = shippedByAmazonTFM;
        return this;
    }

    /**
     * Get the value of TFMShipmentStatus.
     *
     * @return The value of TFMShipmentStatus.
     */
    public String getTFMShipmentStatus() {
        return tfmShipmentStatus;
    }

    /**
     * Set the value of TFMShipmentStatus.
     *
     * @param tfmShipmentStatus
     *            The new value to set.
     */
    public void setTFMShipmentStatus(String tfmShipmentStatus) {
        this.tfmShipmentStatus = tfmShipmentStatus;
    }

    /**
     * Check to see if TFMShipmentStatus is set.
     *
     * @return true if TFMShipmentStatus is set.
     */
    public boolean isSetTFMShipmentStatus() {
        return tfmShipmentStatus != null;
    }

    /**
     * Set the value of TFMShipmentStatus, return this.
     *
     * @param tfmShipmentStatus
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withTFMShipmentStatus(String tfmShipmentStatus) {
        this.tfmShipmentStatus = tfmShipmentStatus;
        return this;
    }

    /**
     * Get the value of CbaDisplayableShippingLabel.
     *
     * @return The value of CbaDisplayableShippingLabel.
     */
    public String getCbaDisplayableShippingLabel() {
        return cbaDisplayableShippingLabel;
    }

    /**
     * Set the value of CbaDisplayableShippingLabel.
     *
     * @param cbaDisplayableShippingLabel
     *            The new value to set.
     */
    public void setCbaDisplayableShippingLabel(String cbaDisplayableShippingLabel) {
        this.cbaDisplayableShippingLabel = cbaDisplayableShippingLabel;
    }

    /**
     * Check to see if CbaDisplayableShippingLabel is set.
     *
     * @return true if CbaDisplayableShippingLabel is set.
     */
    public boolean isSetCbaDisplayableShippingLabel() {
        return cbaDisplayableShippingLabel != null;
    }

    /**
     * Set the value of CbaDisplayableShippingLabel, return this.
     *
     * @param cbaDisplayableShippingLabel
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withCbaDisplayableShippingLabel(String cbaDisplayableShippingLabel) {
        this.cbaDisplayableShippingLabel = cbaDisplayableShippingLabel;
        return this;
    }

    /**
     * Get the value of OrderType.
     *
     * @return The value of OrderType.
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Set the value of OrderType.
     *
     * @param orderType
     *            The new value to set.
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * Check to see if OrderType is set.
     *
     * @return true if OrderType is set.
     */
    public boolean isSetOrderType() {
        return orderType != null;
    }

    /**
     * Set the value of OrderType, return this.
     *
     * @param orderType
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    /**
     * Get the value of EarliestShipDate.
     *
     * @return The value of EarliestShipDate.
     */
    public XMLGregorianCalendar getEarliestShipDate() {
        return earliestShipDate;
    }

    /**
     * Set the value of EarliestShipDate.
     *
     * @param earliestShipDate
     *            The new value to set.
     */
    public void setEarliestShipDate(XMLGregorianCalendar earliestShipDate) {
        this.earliestShipDate = earliestShipDate;
    }

    /**
     * Check to see if EarliestShipDate is set.
     *
     * @return true if EarliestShipDate is set.
     */
    public boolean isSetEarliestShipDate() {
        return earliestShipDate != null;
    }

    /**
     * Set the value of EarliestShipDate, return this.
     *
     * @param earliestShipDate
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withEarliestShipDate(XMLGregorianCalendar earliestShipDate) {
        this.earliestShipDate = earliestShipDate;
        return this;
    }

    /**
     * Get the value of LatestShipDate.
     *
     * @return The value of LatestShipDate.
     */
    public XMLGregorianCalendar getLatestShipDate() {
        return latestShipDate;
    }

    /**
     * Set the value of LatestShipDate.
     *
     * @param latestShipDate
     *            The new value to set.
     */
    public void setLatestShipDate(XMLGregorianCalendar latestShipDate) {
        this.latestShipDate = latestShipDate;
    }

    /**
     * Check to see if LatestShipDate is set.
     *
     * @return true if LatestShipDate is set.
     */
    public boolean isSetLatestShipDate() {
        return latestShipDate != null;
    }

    /**
     * Set the value of LatestShipDate, return this.
     *
     * @param latestShipDate
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withLatestShipDate(XMLGregorianCalendar latestShipDate) {
        this.latestShipDate = latestShipDate;
        return this;
    }

    /**
     * Get the value of EarliestDeliveryDate.
     *
     * @return The value of EarliestDeliveryDate.
     */
    public XMLGregorianCalendar getEarliestDeliveryDate() {
        return earliestDeliveryDate;
    }

    /**
     * Set the value of EarliestDeliveryDate.
     *
     * @param earliestDeliveryDate
     *            The new value to set.
     */
    public void setEarliestDeliveryDate(XMLGregorianCalendar earliestDeliveryDate) {
        this.earliestDeliveryDate = earliestDeliveryDate;
    }

    /**
     * Check to see if EarliestDeliveryDate is set.
     *
     * @return true if EarliestDeliveryDate is set.
     */
    public boolean isSetEarliestDeliveryDate() {
        return earliestDeliveryDate != null;
    }

    /**
     * Set the value of EarliestDeliveryDate, return this.
     *
     * @param earliestDeliveryDate
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withEarliestDeliveryDate(XMLGregorianCalendar earliestDeliveryDate) {
        this.earliestDeliveryDate = earliestDeliveryDate;
        return this;
    }

    /**
     * Get the value of LatestDeliveryDate.
     *
     * @return The value of LatestDeliveryDate.
     */
    public XMLGregorianCalendar getLatestDeliveryDate() {
        return latestDeliveryDate;
    }

    /**
     * Set the value of LatestDeliveryDate.
     *
     * @param latestDeliveryDate
     *            The new value to set.
     */
    public void setLatestDeliveryDate(XMLGregorianCalendar latestDeliveryDate) {
        this.latestDeliveryDate = latestDeliveryDate;
    }

    /**
     * Check to see if LatestDeliveryDate is set.
     *
     * @return true if LatestDeliveryDate is set.
     */
    public boolean isSetLatestDeliveryDate() {
        return latestDeliveryDate != null;
    }

    /**
     * Set the value of LatestDeliveryDate, return this.
     *
     * @param latestDeliveryDate
     *             The new value to set.
     *
     * @return This instance.
     */
    public Order withLatestDeliveryDate(XMLGregorianCalendar latestDeliveryDate) {
        this.latestDeliveryDate = latestDeliveryDate;
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
        amazonOrderId = r.read("AmazonOrderId", String.class);
        sellerOrderId = r.read("SellerOrderId", String.class);
        purchaseDate = r.read("PurchaseDate", XMLGregorianCalendar.class);
        lastUpdateDate = r.read("LastUpdateDate", XMLGregorianCalendar.class);
        orderStatus = r.read("OrderStatus", String.class);
        fulfillmentChannel = r.read("FulfillmentChannel", String.class);
        salesChannel = r.read("SalesChannel", String.class);
        orderChannel = r.read("OrderChannel", String.class);
        shipServiceLevel = r.read("ShipServiceLevel", String.class);
        shippingAddress = r.read("ShippingAddress", Address.class);
        orderTotal = r.read("OrderTotal", Money.class);
        numberOfItemsShipped = r.read("NumberOfItemsShipped", Integer.class);
        numberOfItemsUnshipped = r.read("NumberOfItemsUnshipped", Integer.class);
        paymentExecutionDetail = r.readList("PaymentExecutionDetail", "PaymentExecutionDetailItem", PaymentExecutionDetailItem.class);
        paymentMethod = r.read("PaymentMethod", String.class);
        marketplaceId = r.read("MarketplaceId", String.class);
        buyerEmail = r.read("BuyerEmail", String.class);
        buyerName = r.read("BuyerName", String.class);
        shipmentServiceLevelCategory = r.read("ShipmentServiceLevelCategory", String.class);
        shippedByAmazonTFM = r.read("ShippedByAmazonTFM", Boolean.class);
        tfmShipmentStatus = r.read("TFMShipmentStatus", String.class);
        cbaDisplayableShippingLabel = r.read("CbaDisplayableShippingLabel", String.class);
        orderType = r.read("OrderType", String.class);
        earliestShipDate = r.read("EarliestShipDate", XMLGregorianCalendar.class);
        latestShipDate = r.read("LatestShipDate", XMLGregorianCalendar.class);
        earliestDeliveryDate = r.read("EarliestDeliveryDate", XMLGregorianCalendar.class);
        latestDeliveryDate = r.read("LatestDeliveryDate", XMLGregorianCalendar.class);
    }

    /**
     * Write members to a MwsWriter.
     *
     * @param w
     *      The writer to write to.
     */
    @Override
    public void writeFragmentTo(MwsWriter w) {
        w.write("AmazonOrderId", amazonOrderId);
        w.write("SellerOrderId", sellerOrderId);
        w.write("PurchaseDate", purchaseDate);
        w.write("LastUpdateDate", lastUpdateDate);
        w.write("OrderStatus", orderStatus);
        w.write("FulfillmentChannel", fulfillmentChannel);
        w.write("SalesChannel", salesChannel);
        w.write("OrderChannel", orderChannel);
        w.write("ShipServiceLevel", shipServiceLevel);
        w.write("ShippingAddress", shippingAddress);
        w.write("OrderTotal", orderTotal);
        w.write("NumberOfItemsShipped", numberOfItemsShipped);
        w.write("NumberOfItemsUnshipped", numberOfItemsUnshipped);
        w.writeList("PaymentExecutionDetail", "PaymentExecutionDetailItem", paymentExecutionDetail);
        w.write("PaymentMethod", paymentMethod);
        w.write("MarketplaceId", marketplaceId);
        w.write("BuyerEmail", buyerEmail);
        w.write("BuyerName", buyerName);
        w.write("ShipmentServiceLevelCategory", shipmentServiceLevelCategory);
        w.write("ShippedByAmazonTFM", shippedByAmazonTFM);
        w.write("TFMShipmentStatus", tfmShipmentStatus);
        w.write("CbaDisplayableShippingLabel", cbaDisplayableShippingLabel);
        w.write("OrderType", orderType);
        w.write("EarliestShipDate", earliestShipDate);
        w.write("LatestShipDate", latestShipDate);
        w.write("EarliestDeliveryDate", earliestDeliveryDate);
        w.write("LatestDeliveryDate", latestDeliveryDate);
    }

    /**
     * Write tag, xmlns and members to a MwsWriter.
     *
     * @param w
     *         The Writer to write to.
     */
    @Override
    public void writeTo(MwsWriter w) {
        w.write("https://mws.amazonservices.com/Orders/2013-09-01", "Order",this);
    }

    /** Value constructor. */
    public Order(String amazonOrderId,String sellerOrderId,XMLGregorianCalendar purchaseDate,XMLGregorianCalendar lastUpdateDate,String orderStatus,String fulfillmentChannel,String salesChannel,String orderChannel,String shipServiceLevel,Address shippingAddress,Money orderTotal,Integer numberOfItemsShipped,Integer numberOfItemsUnshipped,List<PaymentExecutionDetailItem> paymentExecutionDetail,String paymentMethod,String marketplaceId,String buyerEmail,String buyerName,String shipmentServiceLevelCategory,Boolean shippedByAmazonTFM,String tfmShipmentStatus,String cbaDisplayableShippingLabel,String orderType,XMLGregorianCalendar earliestShipDate,XMLGregorianCalendar latestShipDate,XMLGregorianCalendar earliestDeliveryDate,XMLGregorianCalendar latestDeliveryDate) {
        this.amazonOrderId = amazonOrderId;
        this.sellerOrderId = sellerOrderId;
        this.purchaseDate = purchaseDate;
        this.lastUpdateDate = lastUpdateDate;
        this.orderStatus = orderStatus;
        this.fulfillmentChannel = fulfillmentChannel;
        this.salesChannel = salesChannel;
        this.orderChannel = orderChannel;
        this.shipServiceLevel = shipServiceLevel;
        this.shippingAddress = shippingAddress;
        this.orderTotal = orderTotal;
        this.numberOfItemsShipped = numberOfItemsShipped;
        this.numberOfItemsUnshipped = numberOfItemsUnshipped;
        this.paymentExecutionDetail = paymentExecutionDetail;
        this.paymentMethod = paymentMethod;
        this.marketplaceId = marketplaceId;
        this.buyerEmail = buyerEmail;
        this.buyerName = buyerName;
        this.shipmentServiceLevelCategory = shipmentServiceLevelCategory;
        this.shippedByAmazonTFM = shippedByAmazonTFM;
        this.tfmShipmentStatus = tfmShipmentStatus;
        this.cbaDisplayableShippingLabel = cbaDisplayableShippingLabel;
        this.orderType = orderType;
        this.earliestShipDate = earliestShipDate;
        this.latestShipDate = latestShipDate;
        this.earliestDeliveryDate = earliestDeliveryDate;
        this.latestDeliveryDate = latestDeliveryDate;
    }

    /** Default constructor. */
    public Order() {
        super();
    }

}
