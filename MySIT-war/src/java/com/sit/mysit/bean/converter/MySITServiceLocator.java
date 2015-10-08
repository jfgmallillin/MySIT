/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.bean.converter;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author jack
 */
public class MySITServiceLocator implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final String jndiPrefix = "java:global/MySIT/MySIT-ejb/";
    
    private static MySITServiceLocator instance;
    
    private InitialContext ic;
    
    private MySITServiceLocator(){
        try {
            ic = new InitialContext();
        } catch (NamingException ex) {
            Logger.getLogger(MySITServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MySITServiceLocator getInstance(){
        return instance == null ? instance = new MySITServiceLocator() : instance;
    }
    
    public Object locateFacade(Class<?> searchClass){
        Object facadeObject = null;
        try{
            facadeObject = ic.lookup(jndiPrefix + searchClass.getSimpleName());
        }catch(NamingException namingErr){
            namingErr.printStackTrace();
        }
        return facadeObject;
    }
}
