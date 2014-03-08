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
 * Get Service Status Result
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
 * GetServiceStatusResult complex type.
 *
 * XML schema:
 *
 * <pre>
 * &lt;complexType name="GetServiceStatusResult"&gt;
 *    &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *          &lt;sequence&gt;
 *             &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *             &lt;element name="MessageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="Messages" type="{https://mws.amazonservices.com/Orders/2013-09-01}Message" maxOccurs="unbounded"/&gt;
 *          &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *    &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class GetServiceStatusResult extends AbstractMwsObject {

    private String status;

    private XMLGregorianCalendar timestamp;

    private String messageId;

    private List<Message> messages;

    /**
     * Get the value of Status.
     *
     * @return The value of Status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the value of Status.
     *
     * @param status
     *            The new value to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Check to see if Status is set.
     *
     * @return true if Status is set.
     */
    public boolean isSetStatus() {
        return status != null;
    }

    /**
     * Set the value of Status, return this.
     *
     * @param status
     *             The new value to set.
     *
     * @return This instance.
     */
    public GetServiceStatusResult withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get the value of Timestamp.
     *
     * @return The value of Timestamp.
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Set the value of Timestamp.
     *
     * @param timestamp
     *            The new value to set.
     */
    public void setTimestamp(XMLGregorianCalendar timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Check to see if Timestamp is set.
     *
     * @return true if Timestamp is set.
     */
    public boolean isSetTimestamp() {
        return timestamp != null;
    }

    /**
     * Set the value of Timestamp, return this.
     *
     * @param timestamp
     *             The new value to set.
     *
     * @return This instance.
     */
    public GetServiceStatusResult withTimestamp(XMLGregorianCalendar timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get the value of MessageId.
     *
     * @return The value of MessageId.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Set the value of MessageId.
     *
     * @param messageId
     *            The new value to set.
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * Check to see if MessageId is set.
     *
     * @return true if MessageId is set.
     */
    public boolean isSetMessageId() {
        return messageId != null;
    }

    /**
     * Set the value of MessageId, return this.
     *
     * @param messageId
     *             The new value to set.
     *
     * @return This instance.
     */
    public GetServiceStatusResult withMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    /**
     * Get the value of Messages.
     *
     * @return The value of Messages.
     */
    public List<Message> getMessages() {
        if (messages==null) {
            messages = new ArrayList<Message>();
        }
        return messages;
    }

    /**
     * Set the value of Messages.
     *
     * @param messages
     *            The new value to set.
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Clear Messages.
     */
    public void unsetMessages() {
        this.messages = null;
    }

    /**
     * Check to see if Messages is set.
     *
     * @return true if Messages is set.
     */
    public boolean isSetMessages() {
        return messages != null && !messages.isEmpty();
    }

    /**
     * Add values for Messages, return this.
     *
     * @param messages
     *             New values to add.
     *
     * @return This instance.
     */
    public GetServiceStatusResult withMessages(Message... values) {
        List<Message> list = getMessages();
        for (Message value : values) {
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
        status = r.read("Status", String.class);
        timestamp = r.read("Timestamp", XMLGregorianCalendar.class);
        messageId = r.read("MessageId", String.class);
        messages = r.readList("Messages", "Message", Message.class);
    }

    /**
     * Write members to a MwsWriter.
     *
     * @param w
     *      The writer to write to.
     */
    @Override
    public void writeFragmentTo(MwsWriter w) {
        w.write("Status", status);
        w.write("Timestamp", timestamp);
        w.write("MessageId", messageId);
        w.writeList("Messages", "Message", messages);
    }

    /**
     * Write tag, xmlns and members to a MwsWriter.
     *
     * @param w
     *         The Writer to write to.
     */
    @Override
    public void writeTo(MwsWriter w) {
        w.write("https://mws.amazonservices.com/Orders/2013-09-01", "GetServiceStatusResult",this);
    }

    /** Value constructor. */
    public GetServiceStatusResult(String status,XMLGregorianCalendar timestamp,String messageId,List<Message> messages) {
        this.status = status;
        this.timestamp = timestamp;
        this.messageId = messageId;
        this.messages = messages;
    }

    /** Default constructor. */
    public GetServiceStatusResult() {
        super();
    }

}
