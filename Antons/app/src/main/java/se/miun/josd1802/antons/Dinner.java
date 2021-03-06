package se.miun.josd1802.antons;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "dish")
public class Dinner
{
    @Element(name = "id")
    private Integer id;
    @Element(name = "price")
    private Integer price;
    @Element(name = "namn")
    private String name;
    @Element(name = "details")
    private String details;

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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Dinner()
    {

    }
}

@Root(name = "dishes")
class dishes
{
    @ElementList(name = "dish", inline = true, required = false)
    private List<Dinner> l_dinner;

    public List<Dinner> getL_dinner()
    {
        return l_dinner;
    }

    public void setL_dinner(List<Dinner> l_dinner)
    {
        this.l_dinner = l_dinner;
    }
}
