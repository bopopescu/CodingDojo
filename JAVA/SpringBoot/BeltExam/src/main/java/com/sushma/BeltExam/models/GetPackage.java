package com.sushma.BeltExam.models;
import java.util.List;


import javax.persistence.*;

import com.sushma.BeltExam.models.GetPackage;

@Entity
@Table(name="packages")

public class GetPackage {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String available;
    @Column
    private int cost;
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_package",
			joinColumns = @JoinColumn(name="package_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private List<User> users;
	
	@OneToMany(mappedBy="getpackage", fetch = FetchType.LAZY)
    private List<User> getusers;
	
    public GetPackage() {
    }
    
    public GetPackage(String name, int cost) {
    		this.name = name;
    		this.cost = cost;
    		this.available = "Available";
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

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getGetusers() {
		return getusers;
	}

	public void setGetusers(List<User> getusers) {
		this.getusers = getusers;
	}


}