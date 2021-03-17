/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Bassam Adam Husein
 */
@Named(value = "drickaBean")
@SessionScoped
public class DrickaBean implements Serializable {

    /**
     * Creates a new instance of DrickaBean
     */
    public DrickaBean() {
    }
    
}
