package com.mindteck.datalayer;

import java.util.List;

import com.mindteck.entities.Assignment;

public interface AssignmentDAO {
	public int createAssignment(Assignment assignment);
	public int deleteAssignment(int id);
	public int updateAssignment(Assignment assignment);
	public Assignment getAssignmentDetails(int id);
	public List<Assignment> getAllAssignments();
}
