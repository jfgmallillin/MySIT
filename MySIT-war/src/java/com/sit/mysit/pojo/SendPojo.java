/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.pojo;

import java.util.List;

/**
 *
 * @author jack
 */
public class SendPojo {
    private String task;
    private List<MessagePojo> messages;

    /**
     * @return the task
     */
    public String getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * @return the messages
     */
    public List<MessagePojo> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<MessagePojo> messages) {
        this.messages = messages;
    }
}
