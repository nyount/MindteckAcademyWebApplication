package com.mindteck.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Instructor implements Serializable {
	private static final long serialVersionUID = -7631149128416311127L;
	
	private int instructorId;
	private String firstName;
	private String lastName;
	private String skill;
	private List<Course> courseList = new ArrayList<Course>();
	
	public void removeCourse(Course c) {
		courseList.remove(c);
	}
	public void addCourse(Course c) {
		courseList.add(c);
	}
	
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
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
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", skill=" + skill
				+ ", courseList=" + courseList + "]";
	}
	
}
