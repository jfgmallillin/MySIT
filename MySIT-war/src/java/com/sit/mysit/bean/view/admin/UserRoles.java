/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.bean.view.admin;

import com.sit.mysit.entity.Role;
import com.sit.mysit.entity.Userlogin;
import com.sit.mysit.facade.MySITFacade;
import com.sit.mysit.service.SystemService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author jack
 */
@Named("userRoles")
@ViewScoped
public class UserRoles implements Serializable {

    private final Logger LOGGER = Logger.getLogger(UserRoles.class.getSimpleName());
    @EJB
    private MySITFacade facade;
    private Role focusRole;
    private Userlogin newUser;
    
    private List<Role> roleList;
    private List<Userlogin> userList;
    
    private List<Userlogin> focusUsers;
    private List<Userlogin> selectedUsers;

    @EJB
    SystemService service;
    
    @PostConstruct
    public void init() {
        LOGGER.info("init");
        setRoleList(new ArrayList<>(facade.findAll(Role.class)));
        setUserList(new ArrayList<>(facade.findAll(Userlogin.class)));
    }
    
    public void roleSelectionChanged(final AjaxBehaviorEvent event){
        LOGGER.info("roleSelectionChanged()");
        if(focusRole != null){
//            setFocusUsers(service.getUsers(focusRole));
        }
    }
    
    public void delete(){
        LOGGER.info("delete");
        if(focusRole != null && (selectedUsers != null && !selectedUsers.isEmpty())){
            try {
                service.removeUsersFromRole(focusRole, selectedUsers);
                selectedUsers.clear(); 
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete user/s"));
            }
        }
    }
    
    public void addUserToRole(){
        LOGGER.info("add");
        if(focusRole != null && (newUser != null)){
            try {
                service.addRole(newUser, focusRole);
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
     * @return the roleList
     */
    public List<Role> getRoleList() {
        return roleList;
    }

    /**
     * @param roleList the roleList to set
     */
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    /**
     * @return the focusUsers
     */
    public List<Userlogin> getFocusUsers() {
        return focusUsers;
    }

    /**
     * @param focusUsers the focusUsers to set
     */
    public void setFocusUsers(List<Userlogin> focusUsers) {
        this.focusUsers = focusUsers;
    }

    /**
     * @return the focusRole
     */
    public Role getFocusRole() {
        return focusRole;
    }

    /**
     * @param focusRole the focusRole to set
     */
    public void setFocusRole(Role focusRole) {
        this.focusRole = focusRole;
    }

    /**
     * @return the selectedUsers
     */
    public List<Userlogin> getSelectedUsers() {
        return selectedUsers;
    }

    /**
     * @param selectedUsers the selectedUsers to set
     */
    public void setSelectedUsers(List<Userlogin> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    /**
     * @return the userList
     */
    public List<Userlogin> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<Userlogin> userList) {
        this.userList = userList;
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
