package com.sushma.BeltExam.models;

import java.util.Date;



import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import com.sushma.BeltExam.models.Role;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	@Email
	private String username;
	@Column
    @Size(min=1)
	private String firstName;
	@Column
    @Size(min=1)
	private String lastName;
	@Column
	@Size(min=8)
	private String password;
	@Transient
	private String passwordConfirmation;
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date yepgetsomedueDay;
	@Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="users_roles",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id")
	)
	private List<Role> roles;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_package",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="package_id")
	)
	private List<GetPackage> packages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="package_id")
    private GetPackage getpackage;
	
	public User() {}
	
	public User(String username, String password, Date createdAt) {
		this.username= username;
		this.password = password;
		this.yepgetsomedueDay = new Date();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	@PrePersist
	protected void onCreate() {
		this.setCreatedAt(new Date());
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.setUpdatedAt(new Date());
	}



	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<GetPackage> getPackages() {
		return packages;
	}

	public void setPackages(List<GetPackage> packages) {
		this.packages = packages;
	}



	public Date getYepgetsomedueDay() {
		return yepgetsomedueDay;
	}

	public void setYepgetsomedueDay(Date yepgetsomedueDay) {
		this.yepgetsomedueDay = yepgetsomedueDay;
	}

	public GetPackage getGetpackage() {
		return getpackage;
	}

	public void setGetpackage(GetPackage getpackage) {
		this.getpackage = getpackage;
	}



	
}
