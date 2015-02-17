package com.mindteck.entities;

import java.io.InvalidObjectException;
import java.io.ObjectInputValidation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Graduate implements Serializable, ObjectInputValidation {
	private static final long serialVersionUID = 213142193098412990L;
	
	private int graduateId;
	private int courseId;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private Date dob;
	private List<Assignment> assignmentList = new ArrayList<Assignment>();
	
	public void removeAssignment(Assignment a) {
		assignmentList.remove(a);
	}
	public void addAssignment(Assignment a) {
		assignmentList.add(a);
	}
	
	public List<Assignment> getAssignmentList() {
		return assignmentList;
	}
	public void setAssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}
	public int getGraduateId() {
		return graduateId;
	}
	public void setGraduateId(int graduateId) {
		this.graduateId = graduateId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int classId) {
		this.courseId = classId;
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Graduate [graduateId=" + graduateId + ", courseId=" + courseId
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address1=" + address1 + ", address2=" + address2
				+ ", dob=" + dob + ", assignmentList=" + assignmentList + "]";
	}
	
	@Override
	public void validateObject() throws InvalidObjectException {
		
	}
	
}
