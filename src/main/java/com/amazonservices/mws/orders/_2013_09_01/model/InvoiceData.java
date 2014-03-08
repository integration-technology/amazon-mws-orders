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
 * Invoice Data
 * API Version: 2013-09-01
 * Library Version: 2013-09-01
 * Generated: Thu Feb 06 16:04:52 GMT 2014
 */
package com.amazonservices.mws.orders._2013_09_01.model;

import com.amazonservices.mws.client.*;

/**
 * InvoiceData complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="InvoiceData"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="InvoiceRequirement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="BuyerSelectedInvoiceCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="InvoiceTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="InvoiceInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class InvoiceData extends AbstractMwsObject {

    private String invoiceRequirement;

    private String buyerSelectedInvoiceCategory;

    private String invoiceTitle;

    private String invoiceInformation;

    /**
     * Get the value of InvoiceRequirement.
     *
     * @return The value of InvoiceRequirement.
     */
    public String getInvoiceRequirement() {
        return invoiceRequirement;
    }

    /**
     * Set the value of InvoiceRequirement.
     *
     * @param invoiceRequirement
     *            The new value to set.
     */
    public void setInvoiceRequirement(String invoiceRequirement) {
        this.invoiceRequirement = invoiceRequirement;
    }

    /**
     * Check to see if InvoiceRequirement is set.
     *
     * @return true if InvoiceRequirement is set.
     */
    public boolean isSetInvoiceRequirement() {
        return invoiceRequirement != null;
    }

    /**
     * Set the value of InvoiceRequirement, return this.
     *
     * @param invoiceRequirement
     *             The new value to set.
     *
     * @return This instance.
     */
    public InvoiceData withInvoiceRequirement(String invoiceRequirement) {
        this.invoiceRequirement = invoiceRequirement;
        return this;
    }

    /**
     * Get the value of BuyerSelectedInvoiceCategory.
     *
     * @return The value of BuyerSelectedInvoiceCategory.
     */
    public String getBuyerSelectedInvoiceCategory() {
        return buyerSelectedInvoiceCategory;
    }

    /**
     * Set the value of BuyerSelectedInvoiceCategory.
     *
     * @param buyerSelectedInvoiceCategory
     *            The new value to set.
     */
    public void setBuyerSelectedInvoiceCategory(String buyerSelectedInvoiceCategory) {
        this.buyerSelectedInvoiceCategory = buyerSelectedInvoiceCategory;
    }

    /**
     * Check to see if BuyerSelectedInvoiceCategory is set.
     *
     * @return true if BuyerSelectedInvoiceCategory is set.
     */
    public boolean isSetBuyerSelectedInvoiceCategory() {
        return buyerSelectedInvoiceCategory != null;
    }

    /**
     * Set the value of BuyerSelectedInvoiceCategory, return this.
     *
     * @param buyerSelectedInvoiceCategory
     *             The new value to set.
     *
     * @return This instance.
     */
    public InvoiceData withBuyerSelectedInvoiceCategory(String buyerSelectedInvoiceCategory) {
        this.buyerSelectedInvoiceCategory = buyerSelectedInvoiceCategory;
        return this;
    }

    /**
     * Get the value of InvoiceTitle.
     *
     * @return The value of InvoiceTitle.
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * Set the value of InvoiceTitle.
     *
     * @param invoiceTitle
     *            The new value to set.
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    /**
     * Check to see if InvoiceTitle is set.
     *
     * @return true if InvoiceTitle is set.
     */
    public boolean isSetInvoiceTitle() {
        return invoiceTitle != null;
    }

    /**
     * Set the value of InvoiceTitle, return this.
     *
     * @param invoiceTitle
     *             The new value to set.
     *
     * @return This instance.
     */
    public InvoiceData withInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
        return this;
    }

    /**
     * Get the value of InvoiceInformation.
     *
     * @return The value of InvoiceInformation.
     */
    public String getInvoiceInformation() {
        return invoiceInformation;
    }

    /**
     * Set the value of InvoiceInformation.
     *
     * @param invoiceInformation
     *            The new value to set.
     */
    public void setInvoiceInformation(String invoiceInformation) {
        this.invoiceInformation = invoiceInformation;
    }

    /**
     * Check to see if InvoiceInformation is set.
     *
     * @return true if InvoiceInformation is set.
     */
    public boolean isSetInvoiceInformation() {
        return invoiceInformation != null;
    }

    /**
     * Set the value of InvoiceInformation, return this.
     *
     * @param invoiceInformation
     *             The new value to set.
     *
     * @return This instance.
     */
    public InvoiceData withInvoiceInformation(String invoiceInformation) {
        this.invoiceInformation = invoiceInformation;
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
        invoiceRequirement = r.read("InvoiceRequirement", String.class);
        buyerSelectedInvoiceCategory = r.read("BuyerSelectedInvoiceCategory", String.class);
        invoiceTitle = r.read("InvoiceTitle", String.class);
        invoiceInformation = r.read("InvoiceInformation", String.class);
    }

    /**
     * Write members to a MwsWriter.
     *
     * @param w
     *      The writer to write to.
     */
    @Override
    public void writeFragmentTo(MwsWriter w) {
        w.write("InvoiceRequirement", invoiceRequirement);
        w.write("BuyerSelectedInvoiceCategory", buyerSelectedInvoiceCategory);
        w.write("InvoiceTitle", invoiceTitle);
        w.write("InvoiceInformation", invoiceInformation);
    }

    /**
     * Write tag, xmlns and members to a MwsWriter.
     *
     * @param w
     *         The Writer to write to.
     */
    @Override
    public void writeTo(MwsWriter w) {
        w.write("https://mws.amazonservices.com/Orders/2013-09-01", "InvoiceData",this);
    }

    /** Value constructor. */
    public InvoiceData(String invoiceRequirement,String buyerSelectedInvoiceCategory,String invoiceTitle,String invoiceInformation) {
        this.invoiceRequirement = invoiceRequirement;
        this.buyerSelectedInvoiceCategory = buyerSelectedInvoiceCategory;
        this.invoiceTitle = invoiceTitle;
        this.invoiceInformation = invoiceInformation;
    }

    /** Default constructor. */
    public InvoiceData() {
        super();
    }

}
