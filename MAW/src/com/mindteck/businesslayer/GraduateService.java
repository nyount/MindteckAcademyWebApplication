package com.mindteck.businesslayer;

import java.util.List;

import com.mindteck.datalayer.AcademyDAOFactory;
import com.mindteck.datalayer.GraduateDAO;
import com.mindteck.entities.Graduate;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class GraduateService {
	AcademyDAOFactory academyDAOFactory = AcademyDAOFactory.getAcademyDAOFactory(AcademyDAOFactory.MYSQL_DAO_FACTORY);
	GraduateDAO gradDAO = academyDAOFactory.getGraduateDAO();
	
	public int addGraduateDetails(Graduate grad) {
		return gradDAO.createGraduate(grad);
	}
	
	public int deleteGraduate(int id) throws MySQLIntegrityConstraintViolationException {
		return gradDAO.deleteGraduate(id);
	}
	
	public int updateGraduate(Graduate grad) {
		return gradDAO.updateGraduate(grad);
	}
	
	public Graduate getGraduateDetails(int id) {
		return gradDAO.getGraduateDetails(id);
	}
	
	public Graduate getGraduateDetails(String name) {
		return gradDAO.getGraduateDetails(name);
	}
	
	public List<Graduate> getAllGraduateDetails() {
		return gradDAO.getAllGraduateDetails();
	}

}
