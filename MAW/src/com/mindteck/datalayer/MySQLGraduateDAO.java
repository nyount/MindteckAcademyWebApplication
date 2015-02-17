package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.entities.Graduate;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MySQLGraduateDAO implements GraduateDAO {
	private static final String TABLE = "graduate";

	@Override
	public int createGraduate(Graduate grad) {

		Connection conn = MySQLConnectionManager.getConnection();

		StringBuilder query = new StringBuilder(
				"INSERT INTO "
						+ TABLE
						+ " (`first_name`, `last_name`, `address1`, `address2`, `dob`, `course_id`) VALUES ('"
						+ grad.getFirstName() + "', '" + grad.getLastName()
						+ "', '" + grad.getAddress1() + "', '"
						+ grad.getAddress2() + "', '" + new Date(grad.getDob().getTime()) + "', '"
						+ grad.getCourseId() + "')");

		int result = 0;
		try {
			result = MySQLConnectionManager.executeUpdate(conn, query.toString());
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

	@Override
	public int deleteGraduate(int id) throws MySQLIntegrityConstraintViolationException {

		Connection conn = MySQLConnectionManager.getConnection();

		StringBuilder query = new StringBuilder("DELETE FROM " + TABLE
				+ " WHERE grad_id = " + id);

		int result = MySQLConnectionManager.executeUpdate(conn, query.toString());
		MySQLConnectionManager.closeConnection(conn);
		return result;

	}

	@Override
	public int updateGraduate(Graduate grad) {

		Connection conn = MySQLConnectionManager.getConnection();

		StringBuilder query = new StringBuilder("UPDATE " + TABLE
				+ " SET first_name = '" + grad.getFirstName()
				+ "', last_name = '" + grad.getLastName() + "', address1 = '"
				+ grad.getAddress1() + "', address2 = '" + grad.getAddress2()
				+ "', dob = '" + new Date(grad.getDob().getTime()) + "', course_id = '"
				+ grad.getCourseId() + "' WHERE grad_id = "
				+ grad.getGraduateId());

		int result = 0;
		try {
			result = MySQLConnectionManager.executeUpdate(conn, query.toString());
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		MySQLConnectionManager.closeConnection(conn);
		return result;
	}

	@Override
	public Graduate getGraduateDetails(int id) {
		Connection conn = MySQLConnectionManager.getConnection();
		Graduate grad = null;
		StringBuilder query = new StringBuilder("SELECT * FROM " + TABLE
				+ " WHERE grad_id = " + "'" + id + "'");
		
		ResultSet rs = MySQLConnectionManager.executeQuery(conn, query.toString());

		try {
			if (rs.next()) {
				grad = new Graduate();
				grad.setGraduateId(rs.getInt(1));
				grad.setFirstName(rs.getString(2));
				grad.setLastName(rs.getString(3));
				grad.setAddress1(rs.getString(4));
				grad.setAddress2(rs.getString(5));
				grad.setDob(rs.getDate(6));
				grad.setCourseId(rs.getInt(8));
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return grad;
	}
	
	@Override
	public Graduate getGraduateDetails(String name) {
		
		Connection conn = MySQLConnectionManager.getConnection();
		Graduate grad = null;

		StringBuilder query = new StringBuilder("SELECT * FROM " + TABLE
				+ " WHERE last_name = " + "'" + name + "'");

		ResultSet rs = MySQLConnectionManager.executeQuery(conn, query.toString());

		try {
			if (rs.next()) {
				grad = new Graduate();
				grad.setGraduateId(rs.getInt(1));
				grad.setFirstName(rs.getString(2));
				grad.setLastName(rs.getString(3));
				grad.setAddress1(rs.getString(4));
				grad.setAddress2(rs.getString(5));
				grad.setDob(rs.getDate(6));
				grad.setCourseId(rs.getInt(8));
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return grad;
		
	}

	@Override
	public List<Graduate> getAllGraduateDetails() {

		Connection conn = MySQLConnectionManager.getConnection();
		Graduate grad = null;
		List<Graduate> grads = new ArrayList<Graduate>();

		StringBuilder query = new StringBuilder("SELECT * FROM " + TABLE);

		ResultSet rs = MySQLConnectionManager.executeQuery(conn, query.toString());

		try {
			while (rs.next()) {
				grad = new Graduate();
				grad.setGraduateId(rs.getInt(1));
				grad.setFirstName(rs.getString(2));
				grad.setLastName(rs.getString(3));
				grad.setAddress1(rs.getString(4));
				grad.setAddress2(rs.getString(5));
				grad.setDob(rs.getDate(6));
				grad.setCourseId(rs.getInt(8));
				grads.add(grad);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

		MySQLConnectionManager.closeConnection(conn);
		
		return grads;
		
	}

}
