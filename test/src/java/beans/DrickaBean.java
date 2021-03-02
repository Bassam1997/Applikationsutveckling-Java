/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Dricka;
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
@Named(value = "drickaBean")
@SessionScoped
public class DrickaBean implements Serializable {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of DrickaBean
     */
    public DrickaBean() {
    }
    public String getName(){
        TypedQuery<Dricka> DrickaQuery = em.createNamedQuery("Dricka.findAll", Dricka.class);
        List<Dricka> resultList = DrickaQuery.getResultList();
        return resultList.get(0).getName();
    }
    
    public String getHuset(){
        TypedQuery<Dricka> DrickaQuery = em.createNamedQuery("Dricka.findAll", Dricka.class);
        List<Dricka> resultList = DrickaQuery.getResultList();
        return resultList.get(1).getName();
    }
    public String getCranberry(){
        TypedQuery<Dricka> DrickaQuery = em.createNamedQuery("Dricka.findAll", Dricka.class);
        List<Dricka> resultList = DrickaQuery.getResultList();
        return resultList.get(2).getName();
    }
    public String getFireball(){
        TypedQuery<Dricka> DrickaQuery = em.createNamedQuery("Dricka.findAll", Dricka.class);
        List<Dricka> resultList = DrickaQuery.getResultList();
        return resultList.get(3).getName();
    }
    public String getRed(){
        TypedQuery<Dricka> DrickaQuery = em.createNamedQuery("Dricka.findAll", Dricka.class);
        List<Dricka> resultList = DrickaQuery.getResultList();
        return resultList.get(4).getName();
    }
    public String getVit(){
        TypedQuery<Dricka> DrickaQuery = em.createNamedQuery("Dricka.findAll", Dricka.class);
        List<Dricka> resultList = DrickaQuery.getResultList();
        return resultList.get(5).getName();
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
