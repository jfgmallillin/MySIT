/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.pojo.response;

import com.sit.mysit.pojo.AckPojo;

/**
 *
 * @author jack
 */
public class AckPayload {
    private AckPojo payload;

    /**
     * @return the payload
     */
    public AckPojo getPayload() {
        return payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(AckPojo payload) {
        this.payload = payload;
    }
}
