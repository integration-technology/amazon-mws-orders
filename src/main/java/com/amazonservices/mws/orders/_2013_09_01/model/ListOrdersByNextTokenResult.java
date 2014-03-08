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
 * List Orders By Next Token Result
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
 * ListOrdersByNextTokenResult complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="ListOrdersByNextTokenResult"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="NextToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="CreatedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="LastUpdatedBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="Orders" type="{https://mws.amazonservices.com/Orders/2013-09-01}Order" maxOccurs="unbounded"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class ListOrdersByNextTokenResult extends AbstractMwsObject {

    private String nextToken;

    private XMLGregorianCalendar createdBefore;

    private XMLGregorianCalendar lastUpdatedBefore;

    private List<Order> orders;

    /**
     * Get the value of NextToken.
     *
     * @return The value of NextToken.
     */
    public String getNextToken() {
        return nextToken;
    }

    /**
     * Set the value of NextToken.
     *
     * @param nextToken
     *            The new value to set.
     */
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }

    /**
     * Check to see if NextToken is set.
     *
     * @return true if NextToken is set.
     */
    public boolean isSetNextToken() {
        return nextToken != null;
    }

    /**
     * Set the value of NextToken, return this.
     *
     * @param nextToken
     *             The new value to set.
     *
     * @return This instance.
     */
    public ListOrdersByNextTokenResult withNextToken(String nextToken) {
        this.nextToken = nextToken;
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
    public ListOrdersByNextTokenResult withCreatedBefore(XMLGregorianCalendar createdBefore) {
        this.createdBefore = createdBefore;
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
    public ListOrdersByNextTokenResult withLastUpdatedBefore(XMLGregorianCalendar lastUpdatedBefore) {
        this.lastUpdatedBefore = lastUpdatedBefore;
        return this;
    }

    /**
     * Get the value of Orders.
     *
     * @return The value of Orders.
     */
    public List<Order> getOrders() {
        if (orders==null) {
            orders = new ArrayList<Order>();
        }
        return orders;
    }

    /**
     * Set the value of Orders.
     *
     * @param orders
     *            The new value to set.
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Clear Orders.
     */
    public void unsetOrders() {
        this.orders = null;
    }

    /**
     * Check to see if Orders is set.
     *
     * @return true if Orders is set.
     */
    public boolean isSetOrders() {
        return orders != null && !orders.isEmpty();
    }

    /**
     * Add values for Orders, return this.
     *
     * @param orders
     *             New values to add.
     *
     * @return This instance.
     */
    public ListOrdersByNextTokenResult withOrders(Order... values) {
        List<Order> list = getOrders();
        for (Order value : values) {
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
        nextToken = r.read("NextToken", String.class);
        createdBefore = r.read("CreatedBefore", XMLGregorianCalendar.class);
        lastUpdatedBefore = r.read("LastUpdatedBefore", XMLGregorianCalendar.class);
        orders = r.readList("Orders", "Order", Order.class);
    }

    /**
     * Write members to a MwsWriter.
     *
     * @param w
     *      The writer to write to.
     */
    @Override
    public void writeFragmentTo(MwsWriter w) {
        w.write("NextToken", nextToken);
        w.write("CreatedBefore", createdBefore);
        w.write("LastUpdatedBefore", lastUpdatedBefore);
        w.writeList("Orders", "Order", orders);
    }

    /**
     * Write tag, xmlns and members to a MwsWriter.
     *
     * @param w
     *         The Writer to write to.
     */
    @Override
    public void writeTo(MwsWriter w) {
        w.write("https://mws.amazonservices.com/Orders/2013-09-01", "ListOrdersByNextTokenResult",this);
    }

    /** Value constructor. */
    public ListOrdersByNextTokenResult(String nextToken,XMLGregorianCalendar createdBefore,XMLGregorianCalendar lastUpdatedBefore,List<Order> orders) {
        this.nextToken = nextToken;
        this.createdBefore = createdBefore;
        this.lastUpdatedBefore = lastUpdatedBefore;
        this.orders = orders;
    }

    /** Default constructor. */
    public ListOrdersByNextTokenResult() {
        super();
    }

}
