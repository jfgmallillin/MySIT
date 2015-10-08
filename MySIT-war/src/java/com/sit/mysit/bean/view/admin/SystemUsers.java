/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.bean.view.admin;

import com.sit.mysit.entity.Userlogin;
import com.sit.mysit.facade.MySITFacade;
import com.sit.mysit.service.SystemService;
import com.sit.mysit.util.SHA256Encryptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author jack
 */
@Named("systemUsers")
@ViewScoped
public class SystemUsers implements Serializable {

    private final Logger LOGGER = Logger.getLogger(SystemUsers.class.getSimpleName());
    
    @EJB
    private MySITFacade facade;
    
    
    @EJB
    private SystemService service;
    
    private List<Userlogin> userlist;
    
    private Userlogin newUser;

    @PostConstruct
    public void init() {
        LOGGER.info("init");
        userlist = new ArrayList<>(facade.findAll(Userlogin.class));

    }
    
    public void initNewUser(){
        LOGGER.info("initNewUser()");
        newUser = new Userlogin();
    }
    
    public void resetPassword(Userlogin user){
        LOGGER.info("resetPassword");   
        user.setPassword(SHA256Encryptor.encrypt(user.getUsername()));
    }
    
    public void add(){
        if(newUser != null){
            try {
                newUser.setId(service.getNextUserloginId());
                newUser.setStatus(Userlogin.STATUS_ACTIVE);
                newUser.setPassword(SHA256Encryptor.encrypt(newUser.getUsername()));
                facade.create(newUser);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to add new user"));
            }
        }
    }    
    public void onRowEdit(RowEditEvent event) {
        LOGGER.info("onRowEdit");
        facade.edit(event.getObject());
    }

    /**
     * @return the userlist
     */
    public List<Userlogin> getUserlist() {
        return userlist;
    }

    /**
     * @param userlist the userlist to set
     */
    public void setUserlist(List<Userlogin> userlist) {
        this.userlist = userlist;
    }

    /**
     * @return the newUser
     */
    public Userlogin getNewUser() {
        return newUser;
    }

    /**
     * @param newUser the newUser to set
     */
    public void setNewUser(Userlogin newUser) {
        this.newUser = newUser;
    }
}
