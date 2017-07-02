package com.hwr.consumption;

import com.hwr.model.request.SendMessage;
import com.hwr.model.response.send.SMSResponse;

/**
 *
 * @author somto
 */
public interface Consume {
    
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
     public SMSResponse sendMessage(SendMessage sendMessage,String auth, String contentType, String accept);
}
