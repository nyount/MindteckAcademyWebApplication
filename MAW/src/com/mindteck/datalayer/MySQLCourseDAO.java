package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.entities.Course;
import com.mindteck.entities.Graduate;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MySQLCourseDAO implements CourseDAO {
	private static final String TABLE_NAME = "course";
	private static final String HELPER_TABLE = "graduate";

	// Add a new course to the database
	@Override
	public int createCourse(Course c) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder query = new StringBuilder();
		// If the course has been assigned an instructor
		if (c.getInstructorId() > 0) {
			query.append("INSERT INTO `"
					+ TABLE_NAME
					+ "` (`start_date`, `end_date`, `location`, `type`, `description`, `instructor_id`) VALUES ('"
					+ new Date(c.getStartDate().getTime()) + "', '"
					+ new Date(c.getEndDate().getTime()) + "', '"
					+ c.getLocation() + "', '" + c.getType() + "', '"
					+ c.getDescription() + "', '" + c.getInstructorId() + "')");
			// If the course has not been assigned an instructor
		} else {
			query.append("INSERT INTO `"
					+ TABLE_NAME
					+ "` (`start_date`, `end_date`, `location`, `type`, `description`) VALUES ('"
					+ new Date(c.getStartDate().getTime()) + "', '"
					+ new Date(c.getEndDate().getTime()) + "', '"
					+ c.getLocation() + "', '" + c.getType() + "', '"
					+ c.getDescription() + "')");
		}

		int result = 0;
		try {
			result = MySQLConnectionManager.executeUpdate(conn, query.toString());
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

	// Delete a course from the database
	@Override
	public int deleteCourse(int id) throws MySQLIntegrityConstraintViolationException {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder delete = new StringBuilder("DELETE FROM `" + TABLE_NAME
				+ "` WHERE course_id = " + id);
		int result = MySQLConnectionManager.executeUpdate(conn, delete.toString());
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

	// Update a course in the database
	@Override
	public int updateCourse(Course c) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder update = new StringBuilder("UPDATE `" + TABLE_NAME
				+ "` SET `start_date` = '"
				+ new Date(c.getStartDate().getTime()) + "', `end_date` = '"
				+ new Date(c.getEndDate().getTime()) + "', `location` = '"
				+ c.getLocation() + "', `type` = '" + c.getType()
				+ "', `description` = '" + c.getDescription()
				+ "', `instructor_id` = '" + c.getInstructorId()
				+ "' WHERE course_id = " + c.getCourseId());
		
		int result = 0;
		try {
			result = MySQLConnectionManager.executeUpdate(conn, update.toString());
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

	// Helper function for creating a Course from ResultSet data
	// Removed a lot of duplicate code
	private Course getCourseDetailsHelper(Connection conn, ResultSet rs) {
		Course c = null;
		try {
			// Get the course data
			if (rs.next()) {
				c = new Course();
				c.setCourseId(rs.getInt("course_id"));
				c.setStartDate(rs.getDate("start_date"));
				c.setEndDate(rs.getDate("end_date"));
				c.setLocation(rs.getString("location"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				c.setInstructorId(rs.getInt("instructor_id"));

				StringBuilder getGraduates = new StringBuilder(
						"SELECT * FROM `" + HELPER_TABLE
								+ "` WHERE `course_id` = " + c.getCourseId());
				
				rs = MySQLConnectionManager.executeQuery(conn, getGraduates.toString());
				
				List<Graduate> grads = new ArrayList<Graduate>();
				while (rs.next()) {
					Graduate g = new Graduate();
					g.setGraduateId(rs.getInt("graduate_id"));
					g.setFirstName(rs.getString("first_name"));
					g.setLastName(rs.getString("last_name"));
					g.setAddress1(rs.getString("address1"));
					if (rs.getString("address2") != null) {
						g.setAddress2(rs.getString("address2"));
					}
					g.setDob(rs.getDate("dob"));
					grads.add(g);
				}
				c.setGraduateList(grads);
			}
		} catch (SQLException e) {
			System.err.println("Error parsing result set: " + e);
		}

		return c;
	}

	// Retrieve Course details from the database searching by course_id
	@Override
	public Course getCourseDetails(int id) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder query = new StringBuilder("SELECT * FROM `" + TABLE_NAME
				+ "` WHERE `course_id` = " + id);
		ResultSet rs = MySQLConnectionManager.executeQuery(conn,
				query.toString());

		Course c = getCourseDetailsHelper(conn, rs);
		MySQLConnectionManager.closeConnection(conn);
		return c;
	}

	// Retrieve Course details from the database searching by type
	@Override
	public Course getCourseDetails(String type) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder query = new StringBuilder("SELECT * FROM `" + TABLE_NAME
				+ "` WHERE `type` = '" + type + "'");
		ResultSet rs = MySQLConnectionManager.executeQuery(conn,
				query.toString());

		Course c = getCourseDetailsHelper(conn, rs);
		MySQLConnectionManager.closeConnection(conn);
		return c;
	}

	// Retrieve Course details from the database for all courses
	@Override
	public List<Course> getAllCourseDetails() {
		Connection conn = MySQLConnectionManager.getConnection();
		List<Course> results = new ArrayList<Course>();
		Course c = null;
		StringBuilder query = new StringBuilder("SELECT * FROM `" + TABLE_NAME + "`");

		ResultSet courseSet = MySQLConnectionManager.executeQuery(conn, query.toString());

		while ((c = getCourseDetailsHelper(conn, courseSet)) != null) {
			results.add(c);
		}
		
		MySQLConnectionManager.closeConnection(conn);
		
		return results;
	}
}
