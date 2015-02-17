package com.mindteck.datalayer;

import java.util.List;

import com.mindteck.entities.Course;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface CourseDAO {
	public int createCourse(Course c);
	public int deleteCourse(int id) throws MySQLIntegrityConstraintViolationException;
	public int updateCourse(Course c);
	public Course getCourseDetails(int id);
	public Course getCourseDetails(String type);
	public List<Course> getAllCourseDetails();
}
