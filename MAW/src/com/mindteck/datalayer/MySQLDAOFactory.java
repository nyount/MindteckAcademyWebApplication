package com.mindteck.datalayer;

public class MySQLDAOFactory extends AcademyDAOFactory {

	@Override
	public InstructorDAO getInstructorDAO() {
		return new MySQLInstructorDAO();
	}
	
	@Override
	public AssignmentDAO getAssignmentDAO() {
		return new MySQLAssignmentDAO();
	}

	@Override
	public GraduateDAO getGraduateDAO() {
		return new MySQLGraduateDAO();
	}

	@Override
	public CourseDAO getCourseDAO() {
		return new MySQLCourseDAO();
	}

}
