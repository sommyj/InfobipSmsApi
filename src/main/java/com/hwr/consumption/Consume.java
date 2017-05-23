/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.consumption;

import com.hwr.model.request.SendMessage;
import com.hwr.model.response.send.SMSResponse;

/**
 *
 * @author somto
 */
public interface Consume {
     public SMSResponse sendMessage(SendMessage sendMessage,String auth, String contentType, String accept);
}
