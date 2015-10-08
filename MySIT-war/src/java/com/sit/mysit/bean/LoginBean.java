/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.bean;

import com.sit.mysit.entity.Userlogin;
import com.sit.mysit.facade.MySITFacade;
import com.sit.mysit.util.SHA256Encryptor;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author J Mallillin
 */
@Named("loginBean")
@RequestScoped
public class LoginBean {

    @EJB
    MySITFacade facade;
    
    private final Logger LOGGER = Logger.getLogger(LoginBean.class.getSimpleName());

    private String username;
    private String password;

    @PostConstruct
    public void init() {
        LOGGER.info("init()");
        try{
            List<Userlogin> result2 = facade.findAll(Userlogin.class);
            LOGGER.info("Size2: " + result2.size());
            
            List<Object[]> result = facade.fetchTestList();
            LOGGER.info("SIZE: " + result.size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String login() {
        try {
            String hashPwd = SHA256Encryptor.encrypt(password);
//            hashPwd = password;
            ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).login(username, hashPwd);
            LOGGER.info("SUCCESS!!!");
            
            System.out.println("isAdmin:" + FacesContext.getCurrentInstance().getExternalContext().isUserInRole("System Admin"));
            System.out.println("isActivity:" + FacesContext.getCurrentInstance().getExternalContext().isUserInRole("Activity Admin"));
            System.out.println("isDisciple:" + FacesContext.getCurrentInstance().getExternalContext().isUserInRole("Disciple"));
            
            return "admin/index.xhtml";
        } catch (ServletException ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed", "Invalid user credentials."));
        }
        return "";
    }
    
    public String logout(){
        return "index.xhtml";
    }
    

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}


/**
 * <p:calendar id="from" value="#{}" pattern="MMM dd yyyy" navigator="true">
 *  <p:ajax event="dateSelect"/>
 *  <f:convertDateTime pattern="MMM dd yyyy"/>
 * </p:calendar>
 * 
 * <p:selectOneMenu value="" required="true">
 *  <f:selectItem value="#{null}" itemLabel="Select One" noSelectionOption="true"/>
 *  <f:selectItems value="#{}" var="" itemLabel="" itemValue=""/>
 *  <f:converter converterId=""/>
 * </p:selectOneMenu>
 */