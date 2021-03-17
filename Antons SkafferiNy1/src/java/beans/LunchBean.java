/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.Statement;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.validator.internal.util.logging.Log;

/**
 *
 * @author Bassam Adam Husein
 */
@Named(value = "lunchBean")

@SessionScoped
public class LunchBean implements Serializable {

    @PersistenceContext(unitName = "Antons_SkafferiNy1PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
   private String description;
    /**
     * Creates a new instance of LunchBean
     */
    public LunchBean() {
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

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
         
      public String log (){
        System.out.println(this.description);
        return"";
        
    }
    
}
