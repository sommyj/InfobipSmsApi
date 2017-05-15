/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.model.response.send;

/**
 *
 * @author somto
 */
public class SMSResponseDetails {
     private String to;
    private Status status;
    private int smsCount;
    private String messageId;

    public SMSResponseDetails() {
    }

    public SMSResponseDetails(String to, Status status, int smsCount, String messageId) {
        this.to = to;
        this.status = status;
        this.smsCount = smsCount;
        this.messageId = messageId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "SMSResponseDetails{" + "to=" + to + ", status=" + status + ", smsCount=" + smsCount + ", messageId=" + messageId + '}';
    }

    
    
}
