/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "text_messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TextMessages.findAll", query = "SELECT t FROM TextMessages t"),
    @NamedQuery(name = "TextMessages.findById", query = "SELECT t FROM TextMessages t WHERE t.id = :id"),
    @NamedQuery(name = "TextMessages.findByMessage", query = "SELECT t FROM TextMessages t WHERE t.message = :message")})
public class TextMessages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "MESSAGE")
    private String message;

    public TextMessages() {
    }

    public TextMessages(Integer id) {
        this.id = id;
    }

    public TextMessages(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TextMessages)) {
            return false;
        }
        TextMessages other = (TextMessages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.TextMessages[ id=" + id + " ]";
    }
    
}
