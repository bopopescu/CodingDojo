package com.sushma.BeltEvents.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="messages")

public class Message {
	@Id
	@GeneratedValue
	private Long id;
	@Column
    @Size(min=1)
	private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY) //, cascade=CascadeType.REMOVE
    @JoinColumn(name="event_id")
    private Event event;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_messages", 
        joinColumns = @JoinColumn(name = "message_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> commenters;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<User> getCommenters() {
		return commenters;
	}

	public void setCommenters(List<User> commenters) {
		this.commenters = commenters;
	}
    


}
