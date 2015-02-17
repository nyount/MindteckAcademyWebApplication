package com.mindteck.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
	private static final long serialVersionUID = -8150992005206910842L;
	
	private int courseId;
	private int instructorId;
	private Date startDate;
	private Date endDate;
	private String location;
	private String type;
	private String description;
	private List<Graduate> graduateList = new ArrayList<Graduate>();
	
	public void removeGraduate(Graduate g) {
		graduateList.remove(g);
	}
	public void addGraduate(Graduate g) {
		graduateList.add(g);
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Graduate> getGraduateList() {
		return graduateList;
	}
	public void setGraduateList(List<Graduate> graduateList) {
		this.graduateList = graduateList;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", instructorId="
				+ instructorId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", location=" + location + ", type=" + type
				+ ", description=" + description + ", graduateList="
				+ graduateList + "]";
	}
	
}
