package com.team.models;

public class Player {
    public String first_name;
    public String last_name;
    public Integer age;
    
    public Player(){
    }

    public Player (String first_name, String last_name, Integer age){
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}



}
