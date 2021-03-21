/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bassam Adam Husein
 */
@Named(value = "eventBean")
@SessionScoped
public class EventBean implements Serializable {

    /**
     * Creates a new instance of EventBean
     */
    public EventBean() {
    }
    
    private String EventDe;
    private String EventDes;
    private String EventDescrip;
    private String Artistbeskrivning;
    private String Artistbeskrivning1;
    private String Guest;
    private String Guest2;
    private String GuestDescription;
    private String GuestDescription2;
    private String GuestDescription3;

    public String getGuestDescription() {
        return GuestDescription;
    }

    public void setGuestDescription(String GuestDescription) {
        this.GuestDescription = GuestDescription;
    }

    public String getGuestDescription2() {
        return GuestDescription2;
    }

    public void setGuestDescription2(String GuestDescription2) {
        this.GuestDescription2 = GuestDescription2;
    }

    public String getGuestDescription3() {
        return GuestDescription3;
    }

    public void setGuestDescription3(String GuestDescription3) {
        this.GuestDescription3 = GuestDescription3;
    }
    public String getGuest() {
        return Guest;
    }

    public void setGuest(String Guest) {
        this.Guest = Guest;
    }

    public String getGuest2() {
        return Guest2;
    }

    public void setGuest2(String Guest2) {
        this.Guest2 = Guest2;
    }

    public String getGuest3() {
        return Guest3;
    }

    public void setGuest3(String Guest3) {
        this.Guest3 = Guest3;
    }
    private String Guest3;
    @PersistenceContext(unitName = "Antons_SkafferiNy1PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    private String Artistbeskrivning2;

    public String getEventDe() {
        return EventDe;
    }

    public void setEventDe(String EventDe) {
        this.EventDe = EventDe;
    }

     public String getArtistbeskrivning() {
        return Artistbeskrivning;
    }

    public void setArtistbeskrivning(String Artistbeskrivning) {
        this.Artistbeskrivning = Artistbeskrivning;
    }
    
    
    public String getEventDes() {
        return EventDes;
    }

    public void setEventDes(String EventDes) {
        this.EventDes = EventDes;
    }

    public String getEventDescrip() {
        return EventDescrip;
    }

    public void setEventDescrip(String EventDescrip) {
        this.EventDescrip = EventDescrip;
    }

   

    public String getArtistbeskrivning1() {
        return Artistbeskrivning1;
    }

    public void setArtistbeskrivning1(String Artistbeskrivning1) {
        this.Artistbeskrivning1 = Artistbeskrivning1;
    }

    public String getArtistbeskrivning2() {
        return Artistbeskrivning2;
    }

    public void setArtistbeskrivning2(String Artistbeskrivning2) {
        this.Artistbeskrivning2 = Artistbeskrivning2;
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
    
    public String print(){
        System.out.println(this.getArtistbeskrivning());
        
        
        
        System.out.println(this.getArtistbeskrivning1());
        System.out.println(this.getArtistbeskrivning2());
        System.out.println(this.getEventDe());
        System.out.println(this.getEventDes());
        System.out.println(this.getEventDescrip());
        System.out.println(this.getGuest());
        System.out.println(this.getGuest2());
        System.out.println(this.getGuest3());
        System.out.println(this.getGuestDescription());
        System.out.println(this.getGuestDescription2());
        System.out.println(this.getGuestDescription3());
        
        return"";
    }
}
