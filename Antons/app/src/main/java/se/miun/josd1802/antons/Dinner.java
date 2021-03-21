package se.miun.josd1802.antons;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Root(name = "dinner")
public class Dinner implements Serializable
{
    @Element(name = "id")
    private Integer id;
    @Element(name = "price")
    private Integer price;
    @Element(name = "name")
    private String name;
    @Element(name = "description", required = false)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return this.name.toString();
    }

    public Dinner()
    {

    }
}

@Root(name = "dinners")
class dishes
{
    @ElementList(name = "dinner", inline = true, required = false)
    private ArrayList<Dinner> l_dinner;

    public ArrayList<Dinner> getL_dinner()
    {
        return l_dinner;
    }
}
