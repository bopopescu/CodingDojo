package com.sushma.web.models;

public class Dog extends Animal implements Pet{
	public Dog(String name, String breed, Double weight) {
		super(name, breed, weight);
	}

	public String showAffection(){
		if(getWeight() >= 30) {
			return "You created a "+getBreed()+"! "+getName()+" curl up next to you";
		}
		else {
			return "You created a "+getBreed()+"! "+getName()+" hopped into your lap and cuddles you!";
		}
	}

}
