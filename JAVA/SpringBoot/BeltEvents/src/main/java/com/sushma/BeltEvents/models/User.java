package com.sushma.BeltEvents.models;

import java.util.Date;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
	@Column
	@Email
	@Size(min=1, message="Email must be greater than 1 character")
    private String username; //email
	@Column
    @Size(min=1, message="First Name must be greater than 1 character")
	private String firstName;
	@Column
    @Size(min=1, message="Last Name must be greater than 1 character")
	private String lastName;
	@Column
    @Size(min=1, message="Cities must be greater than 1 character")
	private String cities;
	@Column
	private String state;
	@Column
	@Size(min=5, message="Password must be greater than 1 character")
    private String password;
    @Transient
    private String passwordConfirmation;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Event> events;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Message> messages;

    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_messages", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "message_id")
    )
    private List<Message> messagesforevent;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "events_attending", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> eventsattending;

    
    public User() {}

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

	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Event> getEventsattending() {
		return eventsattending;
	}

	public void setEventsattending(List<Event> eventsattending) {
		this.eventsattending = eventsattending;
	}

    @PrePersist
    protected void onCreate(){
    this.setCreatedAt(new Date());
    }

    @PreUpdate
    protected void onUpdate(){
    this.setUpdatedAt(new Date());
    }

	public List<Message> getMessagesforevent() {
		return messagesforevent;
	}

	public void setMessagesforevent(List<Message> messagesforevent) {
		this.messagesforevent = messagesforevent;
	}



}
