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
import java.util.Collections;
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

    public ArrayList<String> getLista2() {
        
        return lista2;
    }

    public void setLista2(ArrayList<String> lista2) {
        this.lista2 = lista2;
    }

    public ArrayList<String> getLista3() {
        return lista3;
    }

    public void setLista3(ArrayList<String> lista3) {
        this.lista3 = lista3;
    }

    public ArrayList<String> getLista4() {
        return lista4;
    }

    public void setLista4(ArrayList<String> lista4) {
        this.lista4 = lista4;
    }

    public ArrayList<String> getLista5() {
        return lista5;
    }

    public void setLista5(ArrayList<String> lista5) {
        this.lista5 = lista5;
    }
    private ArrayList<String> lista2 = new ArrayList<String>();
    private ArrayList<String> lista3 = new ArrayList<String>();
    private ArrayList<String> lista4 = new ArrayList<String>();
    private ArrayList<String> lista5 = new ArrayList<String>();
    public ArrayList<String> getLista() {
        return lista;
        
    }
    /**
     * Creates a new instance of LunchLista
     */
    public LunchLista() {
        /*lista.add("Pannkaka");
        lista.add("lax");*/
       
      
        
        
    }
    
    
    public ArrayList<String> getDagensLunch(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int day = cal.get(Calendar.DAY_OF_WEEK);
        
        int index = day -2;
          
        //return lista.get(index);
        
        switch(index) {
            case 0:
                return lista;
            case 1:
                return lista2;
            case 2:
                return lista3;
            case 3:
                return lista4;
            case 4:
                return lista5;
        }
       
        return new ArrayList();
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
        this.insertedLunch = null;
        
        
    }
     public void log1(){
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("dag");
        this.lunchIndex = value;
        System.out.println(this.insertedLunch);
        System.out.println(this.lunchIndex);
        int index = Integer.parseInt(this.lunchIndex);
        this.lista2.add(index, this.insertedLunch);
        this.insertedLunch = null;
        
    }
      public void log2(){
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("dag");
        this.lunchIndex = value;
        System.out.println(this.insertedLunch);
        System.out.println(this.lunchIndex);
        int index = Integer.parseInt(this.lunchIndex);
        this.lista3.add(index, this.insertedLunch);
        this.insertedLunch = null;
        
    }
       public void log3(){
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("dag");
        this.lunchIndex = value;
        System.out.println(this.insertedLunch);
        System.out.println(this.lunchIndex);
        int index = Integer.parseInt(this.lunchIndex);
        this.lista4.add(index, this.insertedLunch);
        this.insertedLunch = null;
        
    }
     public void log4(){
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("dag");
        this.lunchIndex = value;
        System.out.println(this.insertedLunch);
        System.out.println(this.lunchIndex);
        int index = Integer.parseInt(this.lunchIndex);
        this.lista5.add(index, this.insertedLunch);
        this.insertedLunch = null;
        
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
    public String delete_action0() {

    Object obj = lista.remove(0); // remove the middle one
    System.out.println(obj);
    return "";
}
    public String delete_action1() {

    Object obj = lista2.remove(0); // remove the middle one
    System.out.println(obj);
    return "";
}
    public String delete_action2() {

    Object obj = lista3.remove(0); // remove the middle one
    System.out.println(obj);
    return "";
}
    public String delete_action3() {

    Object obj = lista4.remove(0); // remove the middle one
    System.out.println(obj);
    return "";
}
    public String delete_action4() {

    Object obj = lista5.remove(0); // remove the middle one
    System.out.println(obj);
    return "";
}
     
}
