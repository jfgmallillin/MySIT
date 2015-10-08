/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.bean;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jack
 */
@Named("SMSBean")
@ApplicationScoped
public class SMSBean {

    private final Logger LOGGER = Logger.getLogger(SMSBean.class.getSimpleName());

    @PostConstruct
    public void init() {
        LOGGER.info("init()");
    }

    public void processSMSSyncRequest() throws IOException {
        LOGGER.info("processSMSSyncRequest");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext
                .getExternalContext().getResponse();
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        response.addHeader("Cache-Control", "no-store");
        response.addHeader("Cache-Control", "must-revalidate");
        response.setDateHeader("Expires", System.currentTimeMillis() + (30 * 24 * 60 * 60 * 1000L));
       

        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        LOGGER.info("TEST1: " + requestParams.get("from"));
        LOGGER.info("TEST:2 " + requestParams.toString());



        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.setResponseContentType("application/json");
        externalContext.setResponseCharacterEncoding("UTF-8");
        externalContext.getResponseOutputWriter().write("{\"payload\":{\"success\":false,\"error\":\"testing pa lang naman\"}}");
        facesContext.responseComplete();
    }
}
