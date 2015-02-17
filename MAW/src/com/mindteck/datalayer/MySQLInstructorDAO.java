package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.entities.Instructor;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MySQLInstructorDAO implements InstructorDAO {
	
	private static final String TABLE_NAME = "instructor";
	
	@Override
	public int createInstructor(Instructor instructor) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder builder = new StringBuilder();
		
		builder.append(
			"INSERT INTO `" + TABLE_NAME + "` " +
			"(`first_name`, `last_name`, `skill`) VALUES ('" +
			instructor.getFirstName() + "', '" +
			instructor.getLastName() + "', '" + 
			instructor.getSkill() + "');"
		);
		
		int result = 0;
		try {
			result = MySQLConnectionManager.executeUpdate(conn, builder.toString());
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

	@Override
	public int deleteInstructorDetails(int id) throws MySQLIntegrityConstraintViolationException {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder builder = new StringBuilder();
		
		builder.append(
			"DELETE FROM `" + TABLE_NAME + "` " +
			"WHERE instructor_id = " + id
		);
		
		int result = MySQLConnectionManager.executeUpdate(conn, builder.toString());
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

	@Override
	public int updateInstructor(Instructor instructor) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder builder = new StringBuilder();
		
		builder.append("UPDATE " + TABLE_NAME +
					   " SET first_name = '" + instructor.getFirstName() + "', " +
					   	   "last_name = '" + instructor.getLastName() + "', " +
					   	   "skill = '" + instructor.getSkill() + "' " +
					   " WHERE instructor_id = " + instructor.getInstructorId()
		);
		
		int result = 0;
		try {
			result = MySQLConnectionManager.executeUpdate(conn, builder.toString());
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

	@Override
	public Instructor getInstructorDetails(String lastName) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder builder = new StringBuilder();
		Instructor instructor = null;
		
		builder.append("SELECT * FROM " + TABLE_NAME + 
						" WHERE last_name = '" + lastName + "'"
		);
		
		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, builder.toString());
		
		try {
			if (resultSet.next()) {
				instructor = new Instructor();
				instructor.setInstructorId(resultSet.getInt(1));
				instructor.setFirstName(resultSet.getString(2));
				instructor.setLastName(resultSet.getString(3));
				instructor.setSkill(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return instructor;
	}
	
	@Override
	public Instructor getInstructorDetails(int id) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder builder = new StringBuilder();
		Instructor instructor = null;
		
		builder.append("SELECT * FROM " + TABLE_NAME + 
						" WHERE instructor_id = '" + id + "'"
		);
		
		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, builder.toString());
		
		try {
			if (resultSet.next()) {
				instructor = new Instructor();
				instructor.setInstructorId(resultSet.getInt(1));
				instructor.setFirstName(resultSet.getString(2));
				instructor.setLastName(resultSet.getString(3));
				instructor.setSkill(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return instructor;
	}

	@Override
	public List<Instructor> getAllInstructorDetails() {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder builder = new StringBuilder();
		Instructor instructor = null;
		List<Instructor> instructorList = new ArrayList<Instructor>();
		
		builder.append("SELECT * FROM " + TABLE_NAME);

		ResultSet resultSet = MySQLConnectionManager.executeQuery(conn, builder.toString());
		
		try {
			while (resultSet.next()) {
				instructor = new Instructor();
				instructor.setInstructorId(resultSet.getInt(1));
				instructor.setFirstName(resultSet.getString(2));
				instructor.setLastName(resultSet.getString(3));
				instructor.setSkill(resultSet.getString(4));
				instructorList.add(instructor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return instructorList;
	}
}
