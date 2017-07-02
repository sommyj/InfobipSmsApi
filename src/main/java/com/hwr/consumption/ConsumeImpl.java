package com.hwr.consumption;

import com.hwr.model.request.SendMessage;
import com.hwr.model.response.delivery.SMSReportResponse;
import com.hwr.model.response.send.SMSResponse;
import com.hwr.model.response.smslogs.SMSLogsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of Consume
 * Sends and receives JSON objects from the Consume platform
 * This utility class provides an abstraction layer for sending json
 * POST and GET requests to a web server
 * @author somto
 */
public class ConsumeImpl implements Consume{
    private final RestTemplate restTemplate;
    private final HttpHeaders headers;
    
////    String string ="DFLTD:Test12345";
////    Base64 encoded string: REZMVEQ6IFRlc3QxMjM0NQ==;
    @Autowired
    public ConsumeImpl() {
        this.headers = new HttpHeaders();
        this.restTemplate = new RestTemplate();
    }
    
    
    /**
     * Single textual message to one or multiple destinations
     * Long SMS:Maximum length for one message is 160 characters for GSM7 standard 
     * or 70 characters Unicode encoded messages
     * If you send text which exceeds the maximum number of supported characters for one message, 
     * the sent message will be segmented and charged accordingly
     * One Long SMS that consists of two SMS counts as two SMS.
     * @param sendMessage
     * @param auth
     * @param contentType
     * @param accept
     * @return 
     */
    public SMSResponse sendMessage(SendMessage sendMessage,String auth, String contentType, String accept){
        headers.add("Authorization", auth);
        headers.add("Content-Type", contentType);
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
        String too= to.substring(0,1).equals("+") ? to.substring(1, to.length()) : to;
        ResponseEntity <SMSLogsResponse> response= restTemplate.exchange("https://api.infobip.com/sms/1/logs"+"?from="+from+"&to="+too+"&limit=1", HttpMethod.GET, entity, SMSLogsResponse.class); 
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
    
    /**
     * Getting logs with date range and general status as filters
     * This request will return messages with status that matches the generalStatus parameter, which are sent between sentSince and current time
     * @param date
     * @param status
     * @param auth
     * @param accept
     * @return 
     */
    public SMSLogsResponse getSmsLogsDate(String date, String status, String auth, String accept){
        headers.add("Authorization", auth);
        headers.add("Content-Type", accept);
        headers.add("accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        SMSLogsResponse smsLogsResponse= new SMSLogsResponse();
        ResponseEntity <SMSLogsResponse> response= restTemplate.exchange("https://api.infobip.com/sms/1/logs"+"?sentSince="+date+"&generalStatus="+status, HttpMethod.GET, entity, SMSLogsResponse.class); 
      smsLogsResponse= response.getBody();
        System.out.print(smsLogsResponse.toString());
        return smsLogsResponse;
    }
}
