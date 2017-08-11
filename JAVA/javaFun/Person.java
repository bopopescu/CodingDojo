import java.lang.*;
import java.util.*;
public class Person{


    protected int energy;
    protected String name;
    Person(){
        this(0);
    }

    Person(int energy){
        this.energy = energy;
        this.name = "None";
    }

    Person(int energy, String name){
        this.energy = energy;
        this.name = name;
    }

    void setEnergy(int energy){
        this.energy = energy;
    }

    int getEnergy(){
        return this.energy;
    }


    void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }
    void sayHello(){
        System.out.println("Hiiiiii");
    }
}

