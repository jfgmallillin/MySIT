/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.bean.converter;

import com.sit.mysit.entity.MemberProfile;
import com.sit.mysit.facade.MySITFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author jack
 */
@FacesConverter("MemberProfileConverter")
public class MemberProfileConverter implements Converter{

    private MySITFacade facade;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        MySITServiceLocator locator = MySITServiceLocator.getInstance();
        facade = (MySITFacade) locator.locateFacade(MySITFacade.class);
        Object result = null;
        if(value != null){
            result = facade.find(Integer.parseInt(value), MemberProfile.class);
        }
        return result;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String result = "";
        if(value != null){
            try{
                result = ((MemberProfile) value).getProfileId().toString();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    
}
