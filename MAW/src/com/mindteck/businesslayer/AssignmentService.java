package com.mindteck.businesslayer;

import java.util.List;

import com.mindteck.datalayer.AcademyDAOFactory;
import com.mindteck.datalayer.AssignmentDAO;
import com.mindteck.entities.Assignment;

public class AssignmentService {
	AcademyDAOFactory academyDAOFactory = AcademyDAOFactory.getAcademyDAOFactory(AcademyDAOFactory.MYSQL_DAO_FACTORY);
	AssignmentDAO assignmentDAO = academyDAOFactory.getAssignmentDAO();
	
	public int addAssignment(Assignment assignment) {
		return assignmentDAO.createAssignment(assignment);
	}
	
	public int deleteAssignment(int id) {
		return assignmentDAO.deleteAssignment(id);
	}
	
	public int updateAssignment(Assignment assignment) {
		return assignmentDAO.updateAssignment(assignment);
	}
	
	public Assignment getAssignmentDetails(int id) {
		return assignmentDAO.getAssignmentDetails(id);
	}
	
	public List<Assignment> getAllAssignments() {
		return assignmentDAO.getAllAssignments();
	}
	
}
