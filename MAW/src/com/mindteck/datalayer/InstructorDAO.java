package com.mindteck.datalayer;

import java.util.List;

import com.mindteck.entities.Instructor;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface InstructorDAO {

	public int createInstructor(Instructor instructor);
	public int deleteInstructorDetails(int id) throws MySQLIntegrityConstraintViolationException;
	public int updateInstructor(Instructor instructor);
	public Instructor getInstructorDetails(String lastName);
	public Instructor getInstructorDetails(int id);
	public List<Instructor> getAllInstructorDetails();
	
}
