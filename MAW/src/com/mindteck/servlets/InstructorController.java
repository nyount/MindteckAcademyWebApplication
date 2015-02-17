package com.mindteck.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.businesslayer.InstructorService;
import com.mindteck.entities.Instructor;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class InstructorController {

	private InstructorService instructorService = new InstructorService();
	
	public void getAllInstructorDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("instructorList", instructorService.getAllInstructorDetails());	
		RequestDispatcher view = request.getRequestDispatcher("jsp/instructor.jsp");
		view.forward(request, response);

	}
	
	public void addInstructor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("jsp/instructorForm.jsp");
		view.forward(request, response);
	
	}
	
	public void insertInstructor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	
		Instructor instructor = new Instructor();
		instructor.setFirstName(request.getParameter("first_name"));
		instructor.setLastName(request.getParameter("last_name"));
		instructor.setSkill(request.getParameter("skill"));
		
		int result = instructorService.addInstructorDetails(instructor);
		
		if (result == 0) {
			request.setAttribute("add", "failure");
		}
		else {
			request.setAttribute("add", "success");
		}
		
		getAllInstructorDetails(request, response);
	
	}
	
	public void editInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int instructorId = Integer.parseInt(request.getParameter("id"));
		Instructor instructor = instructorService.getInstructorDetails(instructorId);
		request.setAttribute("first_name", instructor.getFirstName());
		request.setAttribute("last_name", instructor.getLastName());
		request.setAttribute("skill", instructor.getSkill());
		
		RequestDispatcher view = request.getRequestDispatcher("jsp/editInstructorForm.jsp");
		view.forward(request, response);
	
	}
	
	public void updateInstructor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		int instructorId = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String skill = request.getParameter("skill");

		Instructor instructor = new Instructor();
		instructor.setInstructorId(instructorId);
		instructor.setFirstName(firstName);
		instructor.setLastName(lastName);
		instructor.setSkill(skill);
		
		int result = instructorService.updateInstructor(instructor);
		
		if (result == 0) {
			request.setAttribute("update", "failure");
		}
		else {
			request.setAttribute("update", "success");
		}
	
		getAllInstructorDetails(request, response);
	
	}
	
	public void deleteInstructor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MySQLIntegrityConstraintViolationException {	
	
		int instructorId = Integer.parseInt(request.getParameter("id"));
		instructorService.deleteInstructor(instructorId);
		request.setAttribute("delete", "success");
		getAllInstructorDetails(request, response);
		
	}
}
