package com.sushma.web.models;

public class Cat extends Animal implements Pet{
	public Cat(String name, String breed, Double weight) {
		super(name, breed, weight);
	}

	public String showAffection(){
		return "Your "+getBreed()+ " "+ getName()+" cat, looked at you with some affection. You think.";
	}
}
