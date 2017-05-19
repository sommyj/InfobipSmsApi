/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.controller;

import com.hwr.consumption.Consume;
import com.hwr.model.request.SendMessage;
import com.hwr.model.response.delivery.SMSReportResponse;
import com.hwr.model.response.send.SMSResponse;
import com.hwr.model.response.smslogs.SMSLogsResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author somto
 */
@RestController
public class Controller {
   
   Consume consume= new Consume();
     
    /**
     * Single textual message to one or multiple destinations
     * Long SMS:Maximum length for one message is 160 characters for GSM7 standard 
     * or 70 characters Unicode encoded messages. 
     * If you send text which exceeds the maximum number of supported characters for one message, 
     * the sent message will be segmented and charged accordingly. One Long SMS that consists of two SMS counts as two SMS.
     * @param sendMessage
     * @param auth
     * @param ContentType
     * @param accept
     * @return 
     */
    @RequestMapping("sendMessage")
    public SMSResponse getSMSResponse(@RequestBody SendMessage sendMessage, @RequestHeader(value="Authorization") String auth,
                                                                            @RequestHeader(value="Content-Type") String ContentType,
                                                                            @RequestHeader(value="accept") String accept){
        return consume.sendMessage(sendMessage, auth, ContentType, accept);
    }
    
    /**
     * Getting the delivery reports without any query parameter or by limit, messageId or bulkId
     * Delivery report will be returned only once!
     * Delivery reports are returned only once. 
     * @param limit
     * @param messageId
     * @param bulkId
     * @param auth
     * @param accept
     * @return 
     */
    @RequestMapping("deliveryReport")
    public SMSReportResponse getSMSReportResponse(@RequestParam(value="limit", defaultValue="") String limit, 
                                                  @RequestParam(value="messageId", defaultValue="") String messageId,
                                                  @RequestParam(value="bulkId", defaultValue="") String bulkId,
                                                  @RequestHeader(value="Authorization") String auth,
                                                  @RequestHeader(value="accept") String accept){
        
       if(!limit.isEmpty()){return consume.getDeliveryReportRange(limit, auth, accept);}
       if(!messageId.isEmpty()){return consume.getDeliveryReportMessageId(messageId, auth, accept);}
       if(!bulkId.isEmpty()){return consume.getDeliveryReportBulkId(bulkId, auth, accept);}
        return consume.getDeliveryReport(auth, accept);
    } 
    
    /**
     * Getting logs without any query parameter or by from,to and bulkIds
     * This request will return logs from last 48h by default.
     * For more specific info see Consume class in com.hwr.consumption package
     * @param from
     * @param to
     * @param bulkIds
     * @param auth
     * @param accept
     * @return 
     */
    @RequestMapping("smsLogs")
    public SMSLogsResponse getSMSLogsResponse(@RequestParam(value="from", defaultValue="") String from,
                                              @RequestParam(value="to", defaultValue="") String to,
                                              @RequestParam(value="bulkIds", defaultValue="") String bulkIds,
                                              @RequestHeader(value="Authorization") String auth,
                                              @RequestHeader(value="accept") String accept){
        if(from != null && to != null){return consume.getSmsLogsFrom(from, to, auth, accept);}
        if(bulkIds != null){return consume.getSmsLogsBulkIds(bulkIds, auth, accept);}
       return consume.getSmsLogs(auth, accept);
    }
        
}
