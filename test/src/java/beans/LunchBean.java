/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
@Named(value = "lunchBean")
@SessionScoped
public class LunchBean implements Serializable {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of LunchBean
     */
    public LunchBean() {
    }
    public String getLunch(){
        TypedQuery<Lunch> LunchQuery = em.createNamedQuery("Lunch.findAll", Lunch.class);
        List<Lunch> resultList = LunchQuery.getResultList();
        return resultList.get(0).getName();
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
