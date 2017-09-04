package com.sushma.BeltExam.models;

import java.util.List;


import javax.persistence.*;

@Entity
@Table(name="roles")

public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
    
    public Role() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}