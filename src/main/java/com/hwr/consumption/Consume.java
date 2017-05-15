/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.consumption;

import com.hwr.model.request.SendMessage;
import com.hwr.model.response.delivery.SMSReportResponse;
import com.hwr.model.response.send.SMSResponse;
import com.hwr.model.response.smslogs.SMSLogsResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author somto
 */
public class Consume {
    RestTemplate restTemplate= new RestTemplate();
    
    HttpHeaders headers = new HttpHeaders();
    
////    String string ="DFLTD:Test12345";
////    Base64 encoded string: REZMVEQ6IFRlc3QxMjM0NQ==;
    
    
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
    public SMSResponse sendMessage(SendMessage sendMessage,String auth, String ContentType, String accept){
        headers.add("Authorization", auth);
        headers.add("Content-Type", ContentType);
        headers.add("accept", accept);
        
        SMSResponse smsResponse= new SMSResponse();
        HttpEntity<SendMessage> entity = new HttpEntity<>(sendMessage, headers);
    
        smsResponse = restTemplate.postForObject("https://api.infobip.com/sms/1/text/single", entity, SMSResponse.class);
      
        System.out.print(smsResponse.toString());
        return smsResponse;
    }
    
    /**
     * Getting delivery reports from Controller class without any query parameter
     * Delivery report will be returned only once!
     * Delivery reports are returned only once. 
     * Additional delivery report request will return empty collection.
     * @param auth
     * @param accept
     * @return 
     */
    public SMSReportResponse getDeliveryReport(String auth, String accept){
        SMSReportResponse smsReportResponse = new SMSReportResponse();
        headers.add("Authorization", auth);
        headers.add("accept", accept);  
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<SMSReportResponse> response= restTemplate.exchange("https://api.infobip.com/sms/1/reports", HttpMethod.GET, entity, SMSReportResponse.class);
       smsReportResponse= response.getBody();
        System.out.print(smsReportResponse.toString());
        return smsReportResponse; 
    }
    
   /**
    * Getting the initial stated delivery reports from Controller class
    * Delivery report will be returned only once!
    * Delivery reports are returned only once. 
    * Additional delivery report request will return empty collection.
    * @param limit
     * @param auth
     * @param accept
    * @return 
    */ 
    public SMSReportResponse getDeliveryReportRange(String limit, String auth, String accept){
        SMSReportResponse smsReportResponse = new SMSReportResponse();
        headers.add("Authorization", auth);
        headers.add("accept", accept);
        HttpEntity entity = new HttpEntity(headers);
        
       ResponseEntity<SMSReportResponse> response= restTemplate.exchange("https://api.infobip.com/sms/1/reports"+"?limit="+limit, HttpMethod.GET, entity, SMSReportResponse.class);
         smsReportResponse= response.getBody();
       System.out.print(smsReportResponse.toString());
        return smsReportResponse; 
    }
    
    /**
     * Getting the stated messageId delivery reports from Controller class
     * Delivery report will be returned only once!
     * Delivery reports are returned only once. 
     * Additional delivery report request will return empty collection.
     * @param messageId
     * @param auth
     * @param accept
     * @return 
     */
    public SMSReportResponse getDeliveryReportMessageId(String messageId, String auth, String accept){
        headers.add("Authorization", auth);
        headers.add("accept", accept);
        HttpEntity entity = new HttpEntity(headers);
        SMSReportResponse smsReportResponse = new SMSReportResponse();
        ResponseEntity<SMSReportResponse> response= restTemplate.exchange("https://api.infobip.com/sms/1/reports"+"?messageId="+messageId, HttpMethod.GET, entity, SMSReportResponse.class);
         smsReportResponse= response.getBody();
       System.out.print(smsReportResponse.toString());
        return smsReportResponse; 
    }
    
    /**
     * Getting the stated bulkId delivery reports from Controller class
     * Delivery report will be returned only once!
     * Delivery reports are returned only once. 
     * Additional delivery report request will return empty collection.
     * @param bulkId
     * @param auth
     * @param accept
     * @return 
     */
    public SMSReportResponse getDeliveryReportBulkId(String bulkId, String auth, String accept){
        headers.add("Authorization", auth);
        headers.add("accept", accept);
        HttpEntity entity = new HttpEntity(headers);
        SMSReportResponse smsReportResponse = new SMSReportResponse();
        ResponseEntity<SMSReportResponse> response= restTemplate.exchange("https://api.infobip.com/sms/1/reports"+"?bulkId="+bulkId, HttpMethod.GET, entity, SMSReportResponse.class);
        smsReportResponse= response.getBody();
        System.out.print(smsReportResponse.toString());
        return smsReportResponse; 
    }
    
    /**
     * Getting logs from Controller class without any query parameter 
     * This request will return last 50 message logs from last 48h by default.
     * @param auth
     * @param accept
     * @return 
     */
    public SMSLogsResponse getSmsLogs(String auth, String accept){
        headers.add("Authorization", auth);
        headers.add("accept", accept);
        HttpEntity entity = new HttpEntity(headers);
        SMSLogsResponse smsLogsResponse= new SMSLogsResponse();
        ResponseEntity <SMSLogsResponse> response= restTemplate.exchange("https://api.infobip.com/sms/1/logs", HttpMethod.GET, entity, SMSLogsResponse.class); 
        smsLogsResponse= response.getBody();
        System.out.print(smsLogsResponse.toString());
        return smsLogsResponse;
    }
    
    /**
     * Getting logs from Controller class with from, to and limit as filters
     * This request will filter last messages by rule - of all messages sent from from, return last limit messages with destinations to.
     * @param from
     * @param to
     * @param auth
     * @param accept
     * @param limit
     * @return 
     */
    public SMSLogsResponse getSmsLogsFrom(String from, String to, String auth, String accept){
        headers.add("Authorization", auth);
        headers.add("Content-Type", accept);
        headers.add("accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        SMSLogsResponse smsLogsResponse= new SMSLogsResponse();
        ResponseEntity <SMSLogsResponse> response= restTemplate.exchange("https://api.infobip.com/sms/1/logs"+"?from="+from+"&to="+to+"&limit=1", HttpMethod.GET, entity, SMSLogsResponse.class); 
       smsLogsResponse= response.getBody();
        System.out.print(smsLogsResponse.toString());
        return smsLogsResponse;
    }
    
    /**
     * Getting logs from Controller class with multiple bulkIds as filters
     * This request will return messages that have bulkId among the specified bulkIds in filter.
     * @param bulkIds
     * @param auth
     * @param accept
     * @return 
     */
    public SMSLogsResponse getSmsLogsBulkIds(String bulkIds, String auth, String accept){
        headers.add("Authorization", auth);
        headers.add("Content-Type", accept);
        headers.add("accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        SMSLogsResponse smsLogsResponse= new SMSLogsResponse();
        ResponseEntity <SMSLogsResponse> response= restTemplate.exchange("https://api.infobip.com/sms/1/logs"+"?bulkId="+bulkIds, HttpMethod.GET, entity, SMSLogsResponse.class); 
      smsLogsResponse= response.getBody();
        System.out.print(smsLogsResponse.toString());
        return smsLogsResponse;
    }
}
