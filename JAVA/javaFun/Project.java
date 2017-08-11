import java.lang.*;
import java.util.*;
public class Project{
    private String name;
    private String description;
    private double initialCost;

    //new Project()
    public Project(){

    }

    //new Project("PlanA")
    public Project(String name){
        this.name = name;
    }

    //new Project("PlanA", "Agile Waterfall")
    public Project(String name, String description){
        this.name = name;
        this.description = description;
        this.initialCost = 0;
    }
    public String elevatorPitch(){
        return name+": ("+initialCost+"): "+description;
    }
    
    //getter for name
    public String getName(){
        return name;
    }

    //getter for description
    public String getDescription(){
        return description;
    }

    //setter for name
    public void setName(String name){
        this.name = name;
    }

    //setter for description
    public void setDescription(String name){
        this.description = description;
    }

    //getter for initalCost
    public Double getInitialCost(){
        return initialCost;
    }

    //setter for initalCost
    public void setinitialCost(double initialCost){
        this.initialCost = initialCost;
    }



}

