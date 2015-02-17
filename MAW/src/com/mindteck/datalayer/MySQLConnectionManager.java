package com.mindteck.datalayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MySQLConnectionManager {

	private static final Logger logger = LogManager.getLogger();
	private static final String USERNAME = "root";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/mindteckacademy";
	
	static {
		
		try { Class.forName(DRIVER); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
	}
	
	public static DataSource getDBCPBasicDataSource() {
		
		BasicDataSource bds = new BasicDataSource();
		
		try {
			bds.setUrl(URL);
			bds.setUsername(USERNAME);
			bds.setPassword("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bds;
	}
	
	public static Connection getConnection() {
		
		DataSource ds = getDBCPBasicDataSource();	
		Connection conn = null;
		
		logger.debug("Requesting DB Connection");
		try { 
			conn = ds.getConnection();
		} 
		catch (SQLException e) {
			logger.error("Connection Request Failure");
			e.printStackTrace(); 
		}
		logger.debug("Connection Request Success");
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		logger.debug("Attempting to close DB Connection");
		try { 
			conn.close(); 
		}
		catch (SQLException e) {
			logger.error("Connection Close Failure");
			e.printStackTrace(); 
		}
		logger.debug("Connection Close Success");
	}
	
	//Insert, Delete, Update
	public static int executeUpdate(Connection conn, String query) throws MySQLIntegrityConstraintViolationException {
		Statement stmt = null;
		int success = 0;
		
		logger.warn("Executing: [" + query + "]");
		try {
			stmt = conn.prepareStatement(query);
			success = stmt.executeUpdate(query);
		}
		catch (MySQLIntegrityConstraintViolationException me) {
			throw me;
		}
		catch (SQLException e) {
			logger.error("Failed To Execute: [" + query + "]");
			e.printStackTrace();
		}
		
		return success;
	}
	
	//Select
	public static ResultSet executeQuery(Connection conn, String query) {
		Statement stmt = null;
		ResultSet rs = null;
		
		logger.warn("Executing: [" + query + "]");
		try { 
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery(query);
		} 
		catch (SQLException e) {
			logger.error("Failed To Execute: [" + query + "]");
			e.printStackTrace(); 
		}
		
		return rs;
	}
}
