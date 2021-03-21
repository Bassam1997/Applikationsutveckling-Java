package se.miun.josd1802.antons;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "kitchen")
public class Kitchen
{
    @Element(name = "id")
    private Integer id;
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


    public Kitchen()
    {

    }
}

@Root(name = "kitchens")
class kitchens
{
    @ElementList(name = "kitchen", inline = true, required = false)
    private ArrayList<Kitchen> l_dinner;

    public ArrayList<Kitchen> getL_dinner()
    {
        return l_dinner;
    }
}

