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
 * Order Item
 * API Version: 2013-09-01
 * Library Version: 2013-09-01
 * Generated: Thu Feb 06 16:04:52 GMT 2014
 */
package com.amazonservices.mws.orders._2013_09_01.model;

import java.util.List;
import java.util.ArrayList;

import com.amazonservices.mws.client.*;

/**
 * OrderItem complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="OrderItem"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="ASIN" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="SellerSKU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="OrderItemId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="QuantityOrdered" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *             &lt;element name="QuantityShipped" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *             &lt;element name="ItemPrice" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="ShippingPrice" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="GiftWrapPrice" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="ItemTax" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="ShippingTax" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="GiftWrapTax" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="ShippingDiscount" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="PromotionDiscount" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="PromotionIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *             &lt;element name="CODFee" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="CODFeeDiscount" type="{https://mws.amazonservices.com/Orders/2013-09-01}Money" minOccurs="0"/&gt;
 *             &lt;element name="GiftMessageText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="GiftWrapLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="InvoiceData" type="{https://mws.amazonservices.com/Orders/2013-09-01}InvoiceData" minOccurs="0"/&gt;
 *             &lt;element name="ConditionNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ConditionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ConditionSubtypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ScheduledDeliveryStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="ScheduledDeliveryEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class OrderItem extends AbstractMwsObject {

    private String asin;

    private String sellerSKU;

    private String orderItemId;

    private String title;

    private int quantityOrdered;

    private Integer quantityShipped;

    private Money itemPrice;

    private Money shippingPrice;

    private Money giftWrapPrice;

    private Money itemTax;

    private Money shippingTax;

    private Money giftWrapTax;

    private Money shippingDiscount;

    private Money promotionDiscount;

    private List<String> promotionIds;

    private Money codFee;

    private Money codFeeDiscount;

    private String giftMessageText;

    private String giftWrapLevel;

    private InvoiceData invoiceData;

    private String conditionNote;

    private String conditionId;

    private String conditionSubtypeId;

    private String scheduledDeliveryStartDate;

    private String scheduledDeliveryEndDate;

    /**
     * Get the value of ASIN.
     *
     * @return The value of ASIN.
     */
    public String getASIN() {
        return asin;
    }

    /**
     * Set the value of ASIN.
     *
     * @param asin
     *            The new value to set.
     */
    public void setASIN(String asin) {
        this.asin = asin;
    }

    /**
     * Check to see if ASIN is set.
     *
     * @return true if ASIN is set.
     */
    public boolean isSetASIN() {
        return asin != null;
    }

    /**
     * Set the value of ASIN, return this.
     *
     * @param asin
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withASIN(String asin) {
        this.asin = asin;
        return this;
    }

    /**
     * Get the value of SellerSKU.
     *
     * @return The value of SellerSKU.
     */
    public String getSellerSKU() {
        return sellerSKU;
    }

    /**
     * Set the value of SellerSKU.
     *
     * @param sellerSKU
     *            The new value to set.
     */
    public void setSellerSKU(String sellerSKU) {
        this.sellerSKU = sellerSKU;
    }

    /**
     * Check to see if SellerSKU is set.
     *
     * @return true if SellerSKU is set.
     */
    public boolean isSetSellerSKU() {
        return sellerSKU != null;
    }

    /**
     * Set the value of SellerSKU, return this.
     *
     * @param sellerSKU
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withSellerSKU(String sellerSKU) {
        this.sellerSKU = sellerSKU;
        return this;
    }

    /**
     * Get the value of OrderItemId.
     *
     * @return The value of OrderItemId.
     */
    public String getOrderItemId() {
        return orderItemId;
    }

    /**
     * Set the value of OrderItemId.
     *
     * @param orderItemId
     *            The new value to set.
     */
    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * Check to see if OrderItemId is set.
     *
     * @return true if OrderItemId is set.
     */
    public boolean isSetOrderItemId() {
        return orderItemId != null;
    }

    /**
     * Set the value of OrderItemId, return this.
     *
     * @param orderItemId
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
        return this;
    }

    /**
     * Get the value of Title.
     *
     * @return The value of Title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of Title.
     *
     * @param title
     *            The new value to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Check to see if Title is set.
     *
     * @return true if Title is set.
     */
    public boolean isSetTitle() {
        return title != null;
    }

    /**
     * Set the value of Title, return this.
     *
     * @param title
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get the value of QuantityOrdered.
     *
     * @return The value of QuantityOrdered.
     */
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    /**
     * Set the value of QuantityOrdered.
     *
     * @param quantityOrdered
     *            The new value to set.
     */
    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    /**
     * Set the value of QuantityOrdered, return this.
     *
     * @param quantityOrdered
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
        return this;
    }

    /**
     * Get the value of QuantityShipped.
     *
     * @return The value of QuantityShipped.
     */
    public Integer getQuantityShipped() {
        return quantityShipped;
    }

    /**
     * Set the value of QuantityShipped.
     *
     * @param quantityShipped
     *            The new value to set.
     */
    public void setQuantityShipped(Integer quantityShipped) {
        this.quantityShipped = quantityShipped;
    }

    /**
     * Check to see if QuantityShipped is set.
     *
     * @return true if QuantityShipped is set.
     */
    public boolean isSetQuantityShipped() {
        return quantityShipped != null;
    }

    /**
     * Set the value of QuantityShipped, return this.
     *
     * @param quantityShipped
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withQuantityShipped(Integer quantityShipped) {
        this.quantityShipped = quantityShipped;
        return this;
    }

    /**
     * Get the value of ItemPrice.
     *
     * @return The value of ItemPrice.
     */
    public Money getItemPrice() {
        return itemPrice;
    }

    /**
     * Set the value of ItemPrice.
     *
     * @param itemPrice
     *            The new value to set.
     */
    public void setItemPrice(Money itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Check to see if ItemPrice is set.
     *
     * @return true if ItemPrice is set.
     */
    public boolean isSetItemPrice() {
        return itemPrice != null;
    }

    /**
     * Set the value of ItemPrice, return this.
     *
     * @param itemPrice
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withItemPrice(Money itemPrice) {
        this.itemPrice = itemPrice;
        return this;
    }

    /**
     * Get the value of ShippingPrice.
     *
     * @return The value of ShippingPrice.
     */
    public Money getShippingPrice() {
        return shippingPrice;
    }

    /**
     * Set the value of ShippingPrice.
     *
     * @param shippingPrice
     *            The new value to set.
     */
    public void setShippingPrice(Money shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    /**
     * Check to see if ShippingPrice is set.
     *
     * @return true if ShippingPrice is set.
     */
    public boolean isSetShippingPrice() {
        return shippingPrice != null;
    }

    /**
     * Set the value of ShippingPrice, return this.
     *
     * @param shippingPrice
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withShippingPrice(Money shippingPrice) {
        this.shippingPrice = shippingPrice;
        return this;
    }

    /**
     * Get the value of GiftWrapPrice.
     *
     * @return The value of GiftWrapPrice.
     */
    public Money getGiftWrapPrice() {
        return giftWrapPrice;
    }

    /**
     * Set the value of GiftWrapPrice.
     *
     * @param giftWrapPrice
     *            The new value to set.
     */
    public void setGiftWrapPrice(Money giftWrapPrice) {
        this.giftWrapPrice = giftWrapPrice;
    }

    /**
     * Check to see if GiftWrapPrice is set.
     *
     * @return true if GiftWrapPrice is set.
     */
    public boolean isSetGiftWrapPrice() {
        return giftWrapPrice != null;
    }

    /**
     * Set the value of GiftWrapPrice, return this.
     *
     * @param giftWrapPrice
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withGiftWrapPrice(Money giftWrapPrice) {
        this.giftWrapPrice = giftWrapPrice;
        return this;
    }

    /**
     * Get the value of ItemTax.
     *
     * @return The value of ItemTax.
     */
    public Money getItemTax() {
        return itemTax;
    }

    /**
     * Set the value of ItemTax.
     *
     * @param itemTax
     *            The new value to set.
     */
    public void setItemTax(Money itemTax) {
        this.itemTax = itemTax;
    }

    /**
     * Check to see if ItemTax is set.
     *
     * @return true if ItemTax is set.
     */
    public boolean isSetItemTax() {
        return itemTax != null;
    }

    /**
     * Set the value of ItemTax, return this.
     *
     * @param itemTax
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withItemTax(Money itemTax) {
        this.itemTax = itemTax;
        return this;
    }

    /**
     * Get the value of ShippingTax.
     *
     * @return The value of ShippingTax.
     */
    public Money getShippingTax() {
        return shippingTax;
    }

    /**
     * Set the value of ShippingTax.
     *
     * @param shippingTax
     *            The new value to set.
     */
    public void setShippingTax(Money shippingTax) {
        this.shippingTax = shippingTax;
    }

    /**
     * Check to see if ShippingTax is set.
     *
     * @return true if ShippingTax is set.
     */
    public boolean isSetShippingTax() {
        return shippingTax != null;
    }

    /**
     * Set the value of ShippingTax, return this.
     *
     * @param shippingTax
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withShippingTax(Money shippingTax) {
        this.shippingTax = shippingTax;
        return this;
    }

    /**
     * Get the value of GiftWrapTax.
     *
     * @return The value of GiftWrapTax.
     */
    public Money getGiftWrapTax() {
        return giftWrapTax;
    }

    /**
     * Set the value of GiftWrapTax.
     *
     * @param giftWrapTax
     *            The new value to set.
     */
    public void setGiftWrapTax(Money giftWrapTax) {
        this.giftWrapTax = giftWrapTax;
    }

    /**
     * Check to see if GiftWrapTax is set.
     *
     * @return true if GiftWrapTax is set.
     */
    public boolean isSetGiftWrapTax() {
        return giftWrapTax != null;
    }

    /**
     * Set the value of GiftWrapTax, return this.
     *
     * @param giftWrapTax
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withGiftWrapTax(Money giftWrapTax) {
        this.giftWrapTax = giftWrapTax;
        return this;
    }

    /**
     * Get the value of ShippingDiscount.
     *
     * @return The value of ShippingDiscount.
     */
    public Money getShippingDiscount() {
        return shippingDiscount;
    }

    /**
     * Set the value of ShippingDiscount.
     *
     * @param shippingDiscount
     *            The new value to set.
     */
    public void setShippingDiscount(Money shippingDiscount) {
        this.shippingDiscount = shippingDiscount;
    }

    /**
     * Check to see if ShippingDiscount is set.
     *
     * @return true if ShippingDiscount is set.
     */
    public boolean isSetShippingDiscount() {
        return shippingDiscount != null;
    }

    /**
     * Set the value of ShippingDiscount, return this.
     *
     * @param shippingDiscount
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withShippingDiscount(Money shippingDiscount) {
        this.shippingDiscount = shippingDiscount;
        return this;
    }

    /**
     * Get the value of PromotionDiscount.
     *
     * @return The value of PromotionDiscount.
     */
    public Money getPromotionDiscount() {
        return promotionDiscount;
    }

    /**
     * Set the value of PromotionDiscount.
     *
     * @param promotionDiscount
     *            The new value to set.
     */
    public void setPromotionDiscount(Money promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    /**
     * Check to see if PromotionDiscount is set.
     *
     * @return true if PromotionDiscount is set.
     */
    public boolean isSetPromotionDiscount() {
        return promotionDiscount != null;
    }

    /**
     * Set the value of PromotionDiscount, return this.
     *
     * @param promotionDiscount
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withPromotionDiscount(Money promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
        return this;
    }

    /**
     * Get the value of PromotionIds.
     *
     * @return The value of PromotionIds.
     */
    public List<String> getPromotionIds() {
        if (promotionIds==null) {
            promotionIds = new ArrayList<String>();
        }
        return promotionIds;
    }

    /**
     * Set the value of PromotionIds.
     *
     * @param promotionIds
     *            The new value to set.
     */
    public void setPromotionIds(List<String> promotionIds) {
        this.promotionIds = promotionIds;
    }

    /**
     * Clear PromotionIds.
     */
    public void unsetPromotionIds() {
        this.promotionIds = null;
    }

    /**
     * Check to see if PromotionIds is set.
     *
     * @return true if PromotionIds is set.
     */
    public boolean isSetPromotionIds() {
        return promotionIds != null && !promotionIds.isEmpty();
    }

    /**
     * Add values for PromotionIds, return this.
     *
     * @param promotionIds
     *             New values to add.
     *
     * @return This instance.
     */
    public OrderItem withPromotionIds(String... values) {
        List<String> list = getPromotionIds();
        for (String value : values) {
            list.add(value);
        }
        return this;
    }

    /**
     * Get the value of CODFee.
     *
     * @return The value of CODFee.
     */
    public Money getCODFee() {
        return codFee;
    }

    /**
     * Set the value of CODFee.
     *
     * @param codFee
     *            The new value to set.
     */
    public void setCODFee(Money codFee) {
        this.codFee = codFee;
    }

    /**
     * Check to see if CODFee is set.
     *
     * @return true if CODFee is set.
     */
    public boolean isSetCODFee() {
        return codFee != null;
    }

    /**
     * Set the value of CODFee, return this.
     *
     * @param codFee
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withCODFee(Money codFee) {
        this.codFee = codFee;
        return this;
    }

    /**
     * Get the value of CODFeeDiscount.
     *
     * @return The value of CODFeeDiscount.
     */
    public Money getCODFeeDiscount() {
        return codFeeDiscount;
    }

    /**
     * Set the value of CODFeeDiscount.
     *
     * @param codFeeDiscount
     *            The new value to set.
     */
    public void setCODFeeDiscount(Money codFeeDiscount) {
        this.codFeeDiscount = codFeeDiscount;
    }

    /**
     * Check to see if CODFeeDiscount is set.
     *
     * @return true if CODFeeDiscount is set.
     */
    public boolean isSetCODFeeDiscount() {
        return codFeeDiscount != null;
    }

    /**
     * Set the value of CODFeeDiscount, return this.
     *
     * @param codFeeDiscount
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withCODFeeDiscount(Money codFeeDiscount) {
        this.codFeeDiscount = codFeeDiscount;
        return this;
    }

    /**
     * Get the value of GiftMessageText.
     *
     * @return The value of GiftMessageText.
     */
    public String getGiftMessageText() {
        return giftMessageText;
    }

    /**
     * Set the value of GiftMessageText.
     *
     * @param giftMessageText
     *            The new value to set.
     */
    public void setGiftMessageText(String giftMessageText) {
        this.giftMessageText = giftMessageText;
    }

    /**
     * Check to see if GiftMessageText is set.
     *
     * @return true if GiftMessageText is set.
     */
    public boolean isSetGiftMessageText() {
        return giftMessageText != null;
    }

    /**
     * Set the value of GiftMessageText, return this.
     *
     * @param giftMessageText
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withGiftMessageText(String giftMessageText) {
        this.giftMessageText = giftMessageText;
        return this;
    }

    /**
     * Get the value of GiftWrapLevel.
     *
     * @return The value of GiftWrapLevel.
     */
    public String getGiftWrapLevel() {
        return giftWrapLevel;
    }

    /**
     * Set the value of GiftWrapLevel.
     *
     * @param giftWrapLevel
     *            The new value to set.
     */
    public void setGiftWrapLevel(String giftWrapLevel) {
        this.giftWrapLevel = giftWrapLevel;
    }

    /**
     * Check to see if GiftWrapLevel is set.
     *
     * @return true if GiftWrapLevel is set.
     */
    public boolean isSetGiftWrapLevel() {
        return giftWrapLevel != null;
    }

    /**
     * Set the value of GiftWrapLevel, return this.
     *
     * @param giftWrapLevel
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withGiftWrapLevel(String giftWrapLevel) {
        this.giftWrapLevel = giftWrapLevel;
        return this;
    }

    /**
     * Get the value of InvoiceData.
     *
     * @return The value of InvoiceData.
     */
    public InvoiceData getInvoiceData() {
        return invoiceData;
    }

    /**
     * Set the value of InvoiceData.
     *
     * @param invoiceData
     *            The new value to set.
     */
    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }

    /**
     * Check to see if InvoiceData is set.
     *
     * @return true if InvoiceData is set.
     */
    public boolean isSetInvoiceData() {
        return invoiceData != null;
    }

    /**
     * Set the value of InvoiceData, return this.
     *
     * @param invoiceData
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
        return this;
    }

    /**
     * Get the value of ConditionNote.
     *
     * @return The value of ConditionNote.
     */
    public String getConditionNote() {
        return conditionNote;
    }

    /**
     * Set the value of ConditionNote.
     *
     * @param conditionNote
     *            The new value to set.
     */
    public void setConditionNote(String conditionNote) {
        this.conditionNote = conditionNote;
    }

    /**
     * Check to see if ConditionNote is set.
     *
     * @return true if ConditionNote is set.
     */
    public boolean isSetConditionNote() {
        return conditionNote != null;
    }

    /**
     * Set the value of ConditionNote, return this.
     *
     * @param conditionNote
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withConditionNote(String conditionNote) {
        this.conditionNote = conditionNote;
        return this;
    }

    /**
     * Get the value of ConditionId.
     *
     * @return The value of ConditionId.
     */
    public String getConditionId() {
        return conditionId;
    }

    /**
     * Set the value of ConditionId.
     *
     * @param conditionId
     *            The new value to set.
     */
    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    /**
     * Check to see if ConditionId is set.
     *
     * @return true if ConditionId is set.
     */
    public boolean isSetConditionId() {
        return conditionId != null;
    }

    /**
     * Set the value of ConditionId, return this.
     *
     * @param conditionId
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withConditionId(String conditionId) {
        this.conditionId = conditionId;
        return this;
    }

    /**
     * Get the value of ConditionSubtypeId.
     *
     * @return The value of ConditionSubtypeId.
     */
    public String getConditionSubtypeId() {
        return conditionSubtypeId;
    }

    /**
     * Set the value of ConditionSubtypeId.
     *
     * @param conditionSubtypeId
     *            The new value to set.
     */
    public void setConditionSubtypeId(String conditionSubtypeId) {
        this.conditionSubtypeId = conditionSubtypeId;
    }

    /**
     * Check to see if ConditionSubtypeId is set.
     *
     * @return true if ConditionSubtypeId is set.
     */
    public boolean isSetConditionSubtypeId() {
        return conditionSubtypeId != null;
    }

    /**
     * Set the value of ConditionSubtypeId, return this.
     *
     * @param conditionSubtypeId
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withConditionSubtypeId(String conditionSubtypeId) {
        this.conditionSubtypeId = conditionSubtypeId;
        return this;
    }

    /**
     * Get the value of ScheduledDeliveryStartDate.
     *
     * @return The value of ScheduledDeliveryStartDate.
     */
    public String getScheduledDeliveryStartDate() {
        return scheduledDeliveryStartDate;
    }

    /**
     * Set the value of ScheduledDeliveryStartDate.
     *
     * @param scheduledDeliveryStartDate
     *            The new value to set.
     */
    public void setScheduledDeliveryStartDate(String scheduledDeliveryStartDate) {
        this.scheduledDeliveryStartDate = scheduledDeliveryStartDate;
    }

    /**
     * Check to see if ScheduledDeliveryStartDate is set.
     *
     * @return true if ScheduledDeliveryStartDate is set.
     */
    public boolean isSetScheduledDeliveryStartDate() {
        return scheduledDeliveryStartDate != null;
    }

    /**
     * Set the value of ScheduledDeliveryStartDate, return this.
     *
     * @param scheduledDeliveryStartDate
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withScheduledDeliveryStartDate(String scheduledDeliveryStartDate) {
        this.scheduledDeliveryStartDate = scheduledDeliveryStartDate;
        return this;
    }

    /**
     * Get the value of ScheduledDeliveryEndDate.
     *
     * @return The value of ScheduledDeliveryEndDate.
     */
    public String getScheduledDeliveryEndDate() {
        return scheduledDeliveryEndDate;
    }

    /**
     * Set the value of ScheduledDeliveryEndDate.
     *
     * @param scheduledDeliveryEndDate
     *            The new value to set.
     */
    public void setScheduledDeliveryEndDate(String scheduledDeliveryEndDate) {
        this.scheduledDeliveryEndDate = scheduledDeliveryEndDate;
    }

    /**
     * Check to see if ScheduledDeliveryEndDate is set.
     *
     * @return true if ScheduledDeliveryEndDate is set.
     */
    public boolean isSetScheduledDeliveryEndDate() {
        return scheduledDeliveryEndDate != null;
    }

    /**
     * Set the value of ScheduledDeliveryEndDate, return this.
     *
     * @param scheduledDeliveryEndDate
     *             The new value to set.
     *
     * @return This instance.
     */
    public OrderItem withScheduledDeliveryEndDate(String scheduledDeliveryEndDate) {
        this.scheduledDeliveryEndDate = scheduledDeliveryEndDate;
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
        asin = r.read("ASIN", String.class);
        sellerSKU = r.read("SellerSKU", String.class);
        orderItemId = r.read("OrderItemId", String.class);
        title = r.read("Title", String.class);
        quantityOrdered = r.read("QuantityOrdered", int.class);
        quantityShipped = r.read("QuantityShipped", Integer.class);
        itemPrice = r.read("ItemPrice", Money.class);
        shippingPrice = r.read("ShippingPrice", Money.class);
        giftWrapPrice = r.read("GiftWrapPrice", Money.class);
        itemTax = r.read("ItemTax", Money.class);
        shippingTax = r.read("ShippingTax", Money.class);
        giftWrapTax = r.read("GiftWrapTax", Money.class);
        shippingDiscount = r.read("ShippingDiscount", Money.class);
        promotionDiscount = r.read("PromotionDiscount", Money.class);
        promotionIds = r.readList("PromotionIds", "PromotionId", String.class);
        codFee = r.read("CODFee", Money.class);
        codFeeDiscount = r.read("CODFeeDiscount", Money.class);
        giftMessageText = r.read("GiftMessageText", String.class);
        giftWrapLevel = r.read("GiftWrapLevel", String.class);
        invoiceData = r.read("InvoiceData", InvoiceData.class);
        conditionNote = r.read("ConditionNote", String.class);
        conditionId = r.read("ConditionId", String.class);
        conditionSubtypeId = r.read("ConditionSubtypeId", String.class);
        scheduledDeliveryStartDate = r.read("ScheduledDeliveryStartDate", String.class);
        scheduledDeliveryEndDate = r.read("ScheduledDeliveryEndDate", String.class);
    }

    /**
     * Write members to a MwsWriter.
     *
     * @param w
     *      The writer to write to.
     */
    @Override
    public void writeFragmentTo(MwsWriter w) {
        w.write("ASIN", asin);
        w.write("SellerSKU", sellerSKU);
        w.write("OrderItemId", orderItemId);
        w.write("Title", title);
        w.write("QuantityOrdered", quantityOrdered);
        w.write("QuantityShipped", quantityShipped);
        w.write("ItemPrice", itemPrice);
        w.write("ShippingPrice", shippingPrice);
        w.write("GiftWrapPrice", giftWrapPrice);
        w.write("ItemTax", itemTax);
        w.write("ShippingTax", shippingTax);
        w.write("GiftWrapTax", giftWrapTax);
        w.write("ShippingDiscount", shippingDiscount);
        w.write("PromotionDiscount", promotionDiscount);
        w.writeList("PromotionIds", "PromotionId", promotionIds);
        w.write("CODFee", codFee);
        w.write("CODFeeDiscount", codFeeDiscount);
        w.write("GiftMessageText", giftMessageText);
        w.write("GiftWrapLevel", giftWrapLevel);
        w.write("InvoiceData", invoiceData);
        w.write("ConditionNote", conditionNote);
        w.write("ConditionId", conditionId);
        w.write("ConditionSubtypeId", conditionSubtypeId);
        w.write("ScheduledDeliveryStartDate", scheduledDeliveryStartDate);
        w.write("ScheduledDeliveryEndDate", scheduledDeliveryEndDate);
    }

    /**
     * Write tag, xmlns and members to a MwsWriter.
     *
     * @param w
     *         The Writer to write to.
     */
    @Override
    public void writeTo(MwsWriter w) {
        w.write("https://mws.amazonservices.com/Orders/2013-09-01", "OrderItem",this);
    }

    /** Value constructor. */
    public OrderItem(String asin,String sellerSKU,String orderItemId,String title,int quantityOrdered,Integer quantityShipped,Money itemPrice,Money shippingPrice,Money giftWrapPrice,Money itemTax,Money shippingTax,Money giftWrapTax,Money shippingDiscount,Money promotionDiscount,List<String> promotionIds,Money codFee,Money codFeeDiscount,String giftMessageText,String giftWrapLevel,InvoiceData invoiceData,String conditionNote,String conditionId,String conditionSubtypeId,String scheduledDeliveryStartDate,String scheduledDeliveryEndDate) {
        this.asin = asin;
        this.sellerSKU = sellerSKU;
        this.orderItemId = orderItemId;
        this.title = title;
        this.quantityOrdered = quantityOrdered;
        this.quantityShipped = quantityShipped;
        this.itemPrice = itemPrice;
        this.shippingPrice = shippingPrice;
        this.giftWrapPrice = giftWrapPrice;
        this.itemTax = itemTax;
        this.shippingTax = shippingTax;
        this.giftWrapTax = giftWrapTax;
        this.shippingDiscount = shippingDiscount;
        this.promotionDiscount = promotionDiscount;
        this.promotionIds = promotionIds;
        this.codFee = codFee;
        this.codFeeDiscount = codFeeDiscount;
        this.giftMessageText = giftMessageText;
        this.giftWrapLevel = giftWrapLevel;
        this.invoiceData = invoiceData;
        this.conditionNote = conditionNote;
        this.conditionId = conditionId;
        this.conditionSubtypeId = conditionSubtypeId;
        this.scheduledDeliveryStartDate = scheduledDeliveryStartDate;
        this.scheduledDeliveryEndDate = scheduledDeliveryEndDate;
    }

    /** Default constructor. */
    public OrderItem() {
        super();
    }

}
