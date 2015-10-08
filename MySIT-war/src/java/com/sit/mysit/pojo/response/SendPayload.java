/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.pojo.response;

import com.sit.mysit.pojo.SendPojo;

/**
 *
 * @author jack
 */
public class SendPayload {
    private SendPojo payload;

    /**
     * @return the payload
     */
    public SendPojo getPayload() {
        return payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(SendPojo payload) {
        this.payload = payload;
    }
}
