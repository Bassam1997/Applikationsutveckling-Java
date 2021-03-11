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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rabso
 */
@Named(value = "lunchLista")
@SessionScoped
public class LunchLista implements Serializable {
    
    
    @PersistenceContext(unitName = "Antons_SkafferiNy1PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    private String insertedLunch = new String();
    @ManagedProperty("#{param.dag}")
    private String lunchIndex = new String();

    public String getLunchIndex() {
        return lunchIndex;
    }

    public void setLunchIndex(String lunchIndex) {
        this.lunchIndex = lunchIndex;
    }
    private ArrayList<String> lista = new ArrayList<String>();

    public ArrayList<String> getLista() {
        return lista;
    }
    /**
     * Creates a new instance of LunchLista
     */
    public LunchLista() {
        /*lista.add("Pannkaka");
        lista.add("lax");*/
        lista.add("");
        lista.add("");
        lista.add("");
        lista.add("");
        lista.add("");
    }

    public String getDagensLunch(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int day = cal.get(Calendar.DAY_OF_WEEK);
        
        int index = day -2;
        if(lista.size() <= index) {
            return  "";
        }
        
        return lista.get(index);
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
    
    public void log(){
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("dag");
        this.lunchIndex = value;
        System.out.println(this.insertedLunch);
        System.out.println(this.lunchIndex);
        int index = Integer.parseInt(this.lunchIndex);
        this.lista.add(index, this.insertedLunch);
    }

    /**
     * @return the lista
     */
    /*
    public List<String> getLista() {
        
        return lista;
    }*/

    /**
     * @param lista the lista to set
     */
    /*
    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
    }*/
    
    public String getInsertedLunch() {
        return this.insertedLunch;
    }
    
    public void setInsertedLunch(String insertedLunch) {
        this.insertedLunch = insertedLunch;
    }
     
}
