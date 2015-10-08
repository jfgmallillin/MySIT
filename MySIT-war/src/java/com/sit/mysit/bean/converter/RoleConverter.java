/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.bean.converter;

import com.sit.mysit.entity.Role;
import com.sit.mysit.facade.MySITFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author jack
 */
@FacesConverter("RoleConverter")
public class RoleConverter implements Converter{

    private MySITFacade facade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        MySITServiceLocator locator = MySITServiceLocator.getInstance();
        facade = (MySITFacade) locator.locateFacade(MySITFacade.class);
        Object result = null;
        if(value != null){
            result = facade.find(Integer.parseInt(value), Role.class);
        }
        return result;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String result = "";
        if(value != null){
            try{
                result = ((Role) value).getId().toString();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    
}
