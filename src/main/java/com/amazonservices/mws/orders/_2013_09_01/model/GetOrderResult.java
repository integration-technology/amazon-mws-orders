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
 * Get Order Result
 * API Version: 2013-09-01
 * Library Version: 2013-09-01
 * Generated: Thu Feb 06 16:04:52 GMT 2014
 */
package com.amazonservices.mws.orders._2013_09_01.model;

import java.util.List;
import java.util.ArrayList;

import com.amazonservices.mws.client.*;

/**
 * GetOrderResult complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="GetOrderResult"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="Orders" type="{https://mws.amazonservices.com/Orders/2013-09-01}Order" maxOccurs="unbounded"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class GetOrderResult extends AbstractMwsObject {

    private List<Order> orders;

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
    public GetOrderResult withOrders(Order... values) {
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
        w.write("https://mws.amazonservices.com/Orders/2013-09-01", "GetOrderResult",this);
    }

    /** Value constructor. */
    public GetOrderResult(List<Order> orders) {
        this.orders = orders;
    }

    /** Default constructor. */
    public GetOrderResult() {
        super();
    }

}
