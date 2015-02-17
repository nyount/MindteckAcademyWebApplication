package com.mindteck.entities;

import java.io.Serializable;

public class Assignment implements Serializable {
	private static final long serialVersionUID = 7724771070709146922L;
	
	private int score;
	private int assignmentId;
	private int graduateId;
	private String type;
	
	public int getGraduateId() {
		return graduateId;
	}
	public void setGraduateId(int graduateId) {
		this.graduateId = graduateId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Assignment [score=" + score + ", assignmentId=" + assignmentId
				+ ", graduateId=" + graduateId + ", type=" + type + "]";
	}
	
}
