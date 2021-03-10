/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import entities.Lunch;
import java.beans.Statement;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.RollbackException;

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
    
    
    /**
    Class.forName(org.apache.derby.jdbc.ClientDriver);
    String URL = "jdbc:derby://localhost:1527/sample";
    Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
    
     * Creates a new instance of LunchBean
     */
    public LunchBean() {
    }
    private String description;

    public void persist(Lunch lunch) {
        try {
            utx.begin();
            em.persist(lunch);
            utx.commit();
        } catch (RollbackException exception) {
            Logger.getLogger(Lunch.class().getName().log(Level.SEVERE, "exception caught", exception);
            throw new RuntimeException(exception);
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
     public void spara(){
     
     Lunch lunch = new Lunch();
     lunch.setDescription(description);
     
    
     
     
     }
     
    
}
