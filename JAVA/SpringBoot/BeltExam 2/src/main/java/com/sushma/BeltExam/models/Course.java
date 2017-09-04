package com.sushma.BeltExam.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.sushma.BeltExam.models.User;

@Entity
@Table(name="courses")
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	@Size(min=1)
	private String name;
	@Column
    @Size(min=1)
	private String day;
	@Column
    @Size(min=1)
	private String time;
	@Column
	private int capacity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="semester_id")
    private Semester semester;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "course_student", 
        joinColumns = @JoinColumn(name = "course_id"), 
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<User> userstakingcourse;
    
	public Course() {}
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
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public List<User> getUserstakingcourse() {
		return userstakingcourse;
	}
	public void setUserstakingcourse(List<User> userstakingcourse) {
		this.userstakingcourse = userstakingcourse;
	}



}
