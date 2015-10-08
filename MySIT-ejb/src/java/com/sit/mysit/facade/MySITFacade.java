/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.facade;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jack
 */
@Stateless
public class MySITFacade {
    
    @PersistenceContext(unitName="MySIT-ejbPU")
    private EntityManager em;
    
    public static final Logger LOGGER = Logger.getLogger(MySITFacade.class.getSimpleName());
    
    public EntityManager getEntityManager(){
        return em;
    }
    
    public void create(Object entity){
        getEntityManager().persist(entity);
        
        getEntityManager().flush();
        getEntityManager().refresh(entity);
    }
    
    public void edit(Object entity){
        getEntityManager().merge(entity);
    }
    
    public void detach(Object entity){
        getEntityManager().detach(entity);
    }
    
    public void remove(Object entity){
        getEntityManager().remove(entity);
    }
    
    public <T> T find(Object id,Class<T> entityClass){
        return getEntityManager().find(entityClass, id);
    }
    
    @SuppressWarnings({"rawtypes","unchecked"})
    public <T> List<T> findAll(Class<T> entityClass){
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<Object[]> fetchTestList() {
        return getEntityManager().createNativeQuery("SELECT * FROM USERLOGIN").getResultList();
    }


}
