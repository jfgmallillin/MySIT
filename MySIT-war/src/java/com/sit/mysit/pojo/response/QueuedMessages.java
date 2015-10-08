/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.pojo.response;

import java.util.List;

/**
 *
 * @author jack
 */
public class QueuedMessages {
    private List<String> queued_messages;

    /**
     * @return the queued_messages
     */
    public List<String> getQueued_messages() {
        return queued_messages;
    }

    /**
     * @param queued_messages the queued_messages to set
     */
    public void setQueued_messages(List<String> queued_messages) {
        this.queued_messages = queued_messages;
    }
}
