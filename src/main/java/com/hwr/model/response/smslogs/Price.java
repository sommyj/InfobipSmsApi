/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.model.response.smslogs;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author somto
 */
//@XmlRootElement
public class Price {
   private BigDecimal pricePerMessage;
   private String currency;

    public Price() {
    }

    public Price(BigDecimal pricePerMessage, String currency) {
        this.pricePerMessage = pricePerMessage;
        this.currency = currency;
    }

    public BigDecimal getPricePerMessage() {
        return pricePerMessage;
    }

    public void setPricePerMessage(BigDecimal pricePerMessage) {
        this.pricePerMessage = pricePerMessage;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Price{" + "pricePerMessage=" + pricePerMessage + ", currency=" + currency + '}';
    }
   
   
}
