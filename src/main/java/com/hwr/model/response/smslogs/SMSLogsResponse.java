/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.model.response.smslogs;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author somto
 */
//@XmlRootElement
public class SMSLogsResponse {
    private SentSMSLog[] results;

    public SMSLogsResponse() {
    }

    public SMSLogsResponse(SentSMSLog[] results) {
        this.results = results;
    }

    public SentSMSLog[] getResults() {
        return results;
    }

    public void setResults(SentSMSLog[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "SMSLogsResponse{" + "results=" + results + '}';
    }
    
    
}
