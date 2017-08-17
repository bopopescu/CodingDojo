package com.sushma.DojoOverflow.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="answers")
public class Answers {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	@Size(min=3, max=200)
	private String answer;

	@Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
//	@OneToOne(mappedBy="answer", fetch=FetchType.LAZY)
//	private QuestionsModel question;
//	
	public Answers() {
		
	}
	
	public Answers(String answer, QuestionsModel question) {
		this.answer = answer;
		//this.question = question;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

//	public QuestionsModel getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(QuestionsModel question) {
//		this.question = question;
//	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
