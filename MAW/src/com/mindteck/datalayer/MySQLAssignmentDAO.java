package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.entities.Assignment;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


public class MySQLAssignmentDAO implements AssignmentDAO {
	private final String TABLE_NAME = "assignment";

	@Override
	public int createAssignment(Assignment assignment) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder query = new StringBuilder("INSERT INTO ");
		query.append(TABLE_NAME);
		query.append(" (`type`, `score`, `grad_id`) VALUES (");

		query.append("'");
		query.append(assignment.getType());
		query.append("'");
		query.append(",");
		query.append("'");
		query.append(assignment.getScore());
		query.append("'");
		query.append(",");
		query.append("'");
		query.append(assignment.getGraduateId());
		query.append("'");
		query.append(")");

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
	public int deleteAssignment(int id) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder query = new StringBuilder();
		
		query.append("DELETE FROM ");
		query.append(TABLE_NAME);
		query.append(" WHERE assignment_id = ");
		query.append(id);
		
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
	public int updateAssignment(Assignment assignment) {
		Connection conn = MySQLConnectionManager.getConnection();
		StringBuilder query = new StringBuilder("UPDATE ");
		
		query.append(TABLE_NAME);
		query.append(" SET type = '");
		query.append(assignment.getType());
		query.append("', ");
		query.append("score = '");
		query.append(assignment.getScore());
		query.append("', ");
		query.append("grad_id = '");
		query.append(assignment.getGraduateId());
		query.append("'");
		query.append(" WHERE assignment_id = '");
		query.append(assignment.getAssignmentId());
		query.append("'");
		
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
	public Assignment getAssignmentDetails(int id) {
		Connection conn = MySQLConnectionManager.getConnection();
		Assignment assignment = null;
		StringBuilder query = new StringBuilder("SELECT * FROM " + TABLE_NAME
				+ " WHERE assignment_id= '" + id + "'");
		ResultSet resultset = MySQLConnectionManager.executeQuery(conn, query.toString());
		try {
			if (resultset.next()) {
				assignment = new Assignment();

				assignment.setAssignmentId(resultset.getInt("assignment_id"));
				assignment.setScore(resultset.getInt("score"));
				assignment.setType((resultset.getString("type").toString()));
				assignment.setGraduateId((resultset.getInt("grad_id")));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		MySQLConnectionManager.closeConnection(conn);
		return assignment;

	}

	@Override
	public List<Assignment> getAllAssignments() {
		Connection conn = MySQLConnectionManager.getConnection();
		Assignment assignment = null;
		List<Assignment> assignmentList = new ArrayList<Assignment>();

		StringBuilder builder = new StringBuilder();
		builder.append("select * from " + TABLE_NAME);
		ResultSet resultset = MySQLConnectionManager.executeQuery(conn, builder.toString());

		try {

			while (resultset.next()) {
				assignment = new Assignment();
				assignment.setAssignmentId((resultset.getInt("assignment_id")));
				assignment.setScore((resultset.getInt("score")));
				assignment.setType(resultset.getString("type"));
				assignment.setGraduateId(resultset.getInt("grad_id"));
				assignmentList.add(assignment);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		MySQLConnectionManager.closeConnection(conn);
		return assignmentList;
	}
}
