/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.service;

import com.sit.mysit.entity.Role;
import com.sit.mysit.entity.Userlogin;
import com.sit.mysit.facade.MySITFacade;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jack
 */
@Stateless
public class SystemService {

    private final Logger LOGGER = Logger.getLogger(SystemService.class.getSimpleName());
    @EJB
    private MySITFacade facade;
    
    public Integer getNextUserloginId(){
        LOGGER.info("getNextUserloginId()");
        Integer result  = null;
        
        try {
            result = (Integer) facade.getEntityManager().createNamedQuery("Userlogin.findMaxId").getSingleResult();
            LOGGER.info("Next ID: " + result);
        } catch (Exception e) {
            result = 1;
            LOGGER.info("Set default: 1");
        }
        
        return null;
    }
    
    public void addRole(Userlogin user,Role role){
        LOGGER.info("addRole()");
        LOGGER.info(user.getId() + " " + role.getId());
        user.getRoleList().add(role);
        role.getUserloginList().add(user);
        facade.edit(user);
        facade.edit(role);
    }
    
    public List<Userlogin> getUsersByRole(Role role) {
        LOGGER.info("getUsers(): " + role.getId());
        Role resultRole = null;
        try {
            resultRole = facade.getEntityManager().createNamedQuery("Role.findById", Role.class).setParameter("id", role.getId()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultRole != null) {
            LOGGER.info("size: " + resultRole.getUserloginList().size());
            for(Userlogin ul : resultRole.getUserloginList()){
                LOGGER.info("ul: " + ul.getRoleList().size());
            }
            return resultRole.getUserloginList();
        }
        return null;
    }

    public void removeUsersFromRole(Role focusRole, List<Userlogin> usersToRemove) {
        LOGGER.info("delete");
        for(Userlogin ul : usersToRemove){
            focusRole.getUserloginList().remove(ul);
            ul.getRoleList().remove(focusRole);
            facade.edit(ul);
        }
        facade.edit(focusRole);
    }

}
