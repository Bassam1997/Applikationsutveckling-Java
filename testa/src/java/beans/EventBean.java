/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Event;
import entities.Lunch;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bassam Adam Husein
 */
@Named(value = "eventBean")
@SessionScoped
public class EventBean implements Serializable {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of EventBean
     */
    public EventBean() {
    }
    public String getGuest(){
        TypedQuery<Event> EventQuery = em.createNamedQuery("Event.findAll", Event.class);
        List<Event> resultList = EventQuery.getResultList();
        return resultList.get(0).getGuest();
    }
    public String getVeronica(){
        TypedQuery<Event> EventQuery = em.createNamedQuery("Event.findAll", Event.class);
        List<Event> resultList = EventQuery.getResultList();
        return resultList.get(1).getGuest();
    }
    public String getSeptember(){
        TypedQuery<Event> EventQuery = em.createNamedQuery("Event.findAll", Event.class);
        List<Event> resultList = EventQuery.getResultList();
        return resultList.get(2).getGuest();
    }
    
    public String getMolly(){
        TypedQuery<Event> EventQuery = em.createNamedQuery("Event.findAll", Event.class);
        List<Event> resultList = EventQuery.getResultList();
        return resultList.get(3).getGuest();
    }

    public String getDavid(){
        TypedQuery<Event> EventQuery = em.createNamedQuery("Event.findAll", Event.class);
        List<Event> resultList = EventQuery.getResultList();
        return resultList.get(4).getGuest();
    }
    
    public String getAbba(){
        TypedQuery<Event> EventQuery = em.createNamedQuery("Event.findAll", Event.class);
        List<Event> resultList = EventQuery.getResultList();
        return resultList.get(5).getGuest();
    }
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    
}
