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
public class ResponsePojo {
    private String success;
    private String task;
    private List<MessagePojo> messages;

    /**
     * @return the success
     */
    public String getSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(String success) {
        this.success = success;
    }

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
