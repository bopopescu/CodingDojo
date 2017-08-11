package com.sushma.web.models;

public class Animal {
    public String name;
    public String breed;
    public Double weight;

    public Animal(){
    }

    public Animal (String name, String breed, Double weight){
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
