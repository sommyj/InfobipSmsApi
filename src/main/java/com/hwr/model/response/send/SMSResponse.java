/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.model.response.send;

import java.util.Arrays;

/**
 *
 * @author somto
 */
public class SMSResponse {
     private String bulkId;
     private SMSResponseDetails[] messages;

    public SMSResponse() {
    }

    public SMSResponse(String bulkId, SMSResponseDetails[] messages) {
        this.bulkId = bulkId;
        this.messages = messages;
    }

    public String getBulkId() {
        return bulkId;
    }

    public void setBulkId(String bulkId) {
        this.bulkId = bulkId;
    }

    public SMSResponseDetails[] getMessages() {
        return messages;
    }

    public void setMessages(SMSResponseDetails[] messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Response{" + "bulkId=" + bulkId + ", messages=" + Arrays.toString(messages) + '}';
    }
    
}
