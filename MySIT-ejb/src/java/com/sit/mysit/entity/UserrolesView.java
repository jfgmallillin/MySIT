/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
//@Entity
@Table(name = "userroles_view", catalog = "mysit", schema = "")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "UserrolesView.findAll", query = "SELECT u FROM UserrolesView u"),
//    @NamedQuery(name = "UserrolesView.findByUsername", query = "SELECT u FROM UserrolesView u WHERE u.username = :username"),
//    @NamedQuery(name = "UserrolesView.findByPassword", query = "SELECT u FROM UserrolesView u WHERE u.password = :password"),
//    @NamedQuery(name = "UserrolesView.findByRolename", query = "SELECT u FROM UserrolesView u WHERE u.rolename = :rolename")})
public class UserrolesView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(nullable = false, length = 64)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String rolename;

    public UserrolesView() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    
}
