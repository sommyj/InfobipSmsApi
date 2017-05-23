/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.model.request;

/**
 *
 * @author somto
 */
public class SendMessage {
    private String from;
    private String[] to;
    private String text;

    public SendMessage() {
    }

    public SendMessage(String from, String[] to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SendMessage{" + "from=" + from + ", to=" + to + ", text=" + text + '}';
    }
    
}
