package com.mindteck.datalayer;

import java.util.List;

import com.mindteck.entities.Graduate;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface GraduateDAO {
	public int createGraduate(Graduate grad);
	public int deleteGraduate(int id) throws MySQLIntegrityConstraintViolationException;
	public int updateGraduate(Graduate grad);
	public Graduate getGraduateDetails(int id);
	public Graduate getGraduateDetails(String name);
	public List<Graduate> getAllGraduateDetails();
}
