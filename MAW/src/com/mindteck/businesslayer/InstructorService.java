package com.mindteck.businesslayer;

import java.util.List;

import com.mindteck.datalayer.AcademyDAOFactory;
import com.mindteck.datalayer.InstructorDAO;
import com.mindteck.entities.Instructor;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class InstructorService {

	AcademyDAOFactory academyDAOFactory = AcademyDAOFactory.getAcademyDAOFactory(AcademyDAOFactory.MYSQL_DAO_FACTORY);
	InstructorDAO instructorDAO = academyDAOFactory.getInstructorDAO();
	
	public int addInstructorDetails(Instructor instructor) {
		return instructorDAO.createInstructor(instructor);
	}
	
	public int deleteInstructor(int id) throws MySQLIntegrityConstraintViolationException {
		return instructorDAO.deleteInstructorDetails(id);
	}
	
	public int updateInstructor(Instructor instructor) {
		return instructorDAO.updateInstructor(instructor);
	}
	
	public Instructor getInstructorDetails(String lastName) {
		return instructorDAO.getInstructorDetails(lastName);
	}
	
	public Instructor getInstructorDetails(int id) {
		return instructorDAO.getInstructorDetails(id);
	}
	
	public List<Instructor> getAllInstructorDetails() {
		return instructorDAO.getAllInstructorDetails();
	}
	
}
