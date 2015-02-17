package com.mindteck.businesslayer;

import java.util.List;

import com.mindteck.datalayer.AcademyDAOFactory;
import com.mindteck.datalayer.CourseDAO;
import com.mindteck.entities.Course;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class CourseService {
	AcademyDAOFactory academyDAOFactory = AcademyDAOFactory.getAcademyDAOFactory(AcademyDAOFactory.MYSQL_DAO_FACTORY);
	CourseDAO courseDAO = academyDAOFactory.getCourseDAO();

	public int createCourse(Course c) {
		return courseDAO.createCourse(c);
	}

	public int deleteCourse(int id) throws MySQLIntegrityConstraintViolationException {
		return courseDAO.deleteCourse(id);
	}

	public int updateCourse(Course c) {
		return courseDAO.updateCourse(c);
	}

	public Course getCourseDetails(int id) {
		return courseDAO.getCourseDetails(id);
	}
	
	public Course getCourseDetails(String type) {
		return courseDAO.getCourseDetails(type);
	}

	public List<Course> getAllCourseDetails() {
		return courseDAO.getAllCourseDetails();
	}
}
