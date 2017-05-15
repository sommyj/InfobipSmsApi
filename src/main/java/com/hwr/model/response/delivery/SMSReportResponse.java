/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.model.response.delivery;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author somto
 */
//@XmlRootElement
public class SMSReportResponse {
    private SentSMSReport[] results;

    public SMSReportResponse() {
    }

    public SMSReportResponse(SentSMSReport[] results) {
        this.results = results;
    }

    public SentSMSReport[] getResults() {
        return results;
    }

    public void setResults(SentSMSReport[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "SMSReportResponse{" + "results=" + results + '}';
    }
    
    
}
