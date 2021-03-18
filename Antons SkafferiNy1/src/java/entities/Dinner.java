/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bassam Adam Husein
 */
@Entity
@Table(name = "DINNER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dinner.findAll", query = "SELECT d FROM Dinner d"),
    @NamedQuery(name = "Dinner.findById", query = "SELECT d FROM Dinner d WHERE d.id = :id"),
    @NamedQuery(name = "Dinner.findByName", query = "SELECT d FROM Dinner d WHERE d.name = :name"),
    @NamedQuery(name = "Dinner.findByPrice", query = "SELECT d FROM Dinner d WHERE d.price = :price"),
    @NamedQuery(name = "Dinner.findByDescription", query = "SELECT d FROM Dinner d WHERE d.description = :description")})
public class Dinner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 200)
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private Integer price;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;

    public Dinner() {
    }

    public Dinner(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dinner)) {
            return false;
        }
        Dinner other = (Dinner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dinner[ id=" + id + " ]";
    }
    
}
