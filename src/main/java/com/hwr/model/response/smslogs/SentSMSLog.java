/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.model.response.smslogs;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author somto
 */
//@XmlRootElement
public class SentSMSLog {
    private String bulkId;
    private String messageId;
    private String to;
    private String from;
    private String text;
    private Date sentAt;
    private Date doneAt;
    private int smsCount;
    private String mccmnc;
    private Price price;
    private Status status;
    private Error error;

    public SentSMSLog() {
    }

    public SentSMSLog(String bulkId, String messageId, String to, String from, String text, Date sentAt, Date doneAt, int smsCount, String mccmnc, Price price, Status status, Error error) {
        this.bulkId = bulkId;
        this.messageId = messageId;
        this.to = to;
        this.from = from;
        this.text = text;
        this.sentAt = sentAt;
        this.doneAt = doneAt;
        this.smsCount = smsCount;
        this.mccmnc = mccmnc;
        this.price = price;
        this.status = status;
        this.error = error;
    }

    public String getBulkId() {
        return bulkId;
    }

    public void setBulkId(String bulkId) {
        this.bulkId = bulkId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }

    public Date getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(Date doneAt) {
        this.doneAt = doneAt;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public String getMccmnc() {
        return mccmnc;
    }

    public void setMccmnc(String mccmnc) {
        this.mccmnc = mccmnc;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "SentSMSLog{" + "bulkId=" + bulkId + ", messageId=" + messageId + ", to=" + to + ", from=" + from + ", text=" + text + ", sentAt=" + sentAt + ", doneAt=" + doneAt + ", smsCount=" + smsCount + ", mccmnc=" + mccmnc + ", price=" + price + ", status=" + status + ", error=" + error + '}';
    }
    
    
}
