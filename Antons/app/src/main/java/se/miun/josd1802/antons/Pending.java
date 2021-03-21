package se.miun.josd1802.antons;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Root(name = "orderpending")
public class Pending
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

    public Pending()
    {

    }
}

@Root(name = "orderpendings")
class pendings
{
    @ElementList(name = "orderpending", inline = true, required = false)
    private ArrayList<Pending> l_dinner;

    public ArrayList<Pending> getL_dinner()
    {
        return l_dinner;
    }
}