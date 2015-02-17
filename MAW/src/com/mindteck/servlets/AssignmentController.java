package com.mindteck.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.businesslayer.AssignmentService;
import com.mindteck.businesslayer.GraduateService;
import com.mindteck.entities.Assignment;
import com.mindteck.entities.Graduate;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class AssignmentController {

	private AssignmentService assignmentService = new AssignmentService();
	
	public void getAllAssignmentDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Assignment> assignmentList = assignmentService.getAllAssignments();
		
		GraduateService graduateService = new GraduateService();
		List<Graduate> graduateList = graduateService.getAllGraduateDetails();
		request.setAttribute("graduateList", graduateList);
		
		Map<Integer, String> convertMap = new HashMap<Integer, String>();
		for (Assignment a : assignmentList) {
			for (Graduate g : graduateList) {
				if (g.getGraduateId() == a.getGraduateId()) {
					convertMap.put(a.getGraduateId(), g.getLastName());
				}
			}
		}
		request.setAttribute("convertMap", convertMap);
		
		request.setAttribute("assignmentList", assignmentService.getAllAssignments());	
		RequestDispatcher view = request.getRequestDispatcher("jsp/assignment.jsp");
		view.forward(request, response);

	}
	
	public void addAssignment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GraduateService graduateService = new GraduateService();
		List<Graduate> graduateList = graduateService.getAllGraduateDetails();
		request.setAttribute("graduateList", graduateList);
		
		RequestDispatcher view = request.getRequestDispatcher("jsp/assignmentForm.jsp");
		view.forward(request, response);
	
	}
	
	public void insertAssignment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	
		Assignment assignment = new Assignment();
		assignment.setType(request.getParameter("type"));
		assignment.setGraduateId(Integer.parseInt(request.getParameter("grad_id")));
		assignment.setScore(Integer.parseInt(request.getParameter("score")));
		
		int result = assignmentService.addAssignment(assignment);
		
		if (result == 0) {
			request.setAttribute("add", "failure");
		}
		else {
			request.setAttribute("add", "success");
		}
		
		getAllAssignmentDetails(request, response);
	
	}
	
	public void editAssignment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		GraduateService graduateService = new GraduateService();
		List<Graduate> graduateList = graduateService.getAllGraduateDetails();
		request.setAttribute("graduateList", graduateList);
		
		int assignmentId = Integer.parseInt(request.getParameter("id"));
		Assignment assignment = assignmentService.getAssignmentDetails(assignmentId);
		request.setAttribute("type", assignment.getType());
		request.setAttribute("grad_id", assignment.getGraduateId());
		request.setAttribute("score", assignment.getScore());
		
		RequestDispatcher view = request.getRequestDispatcher("jsp/editAssignmentForm.jsp");
		view.forward(request, response);
	
	}
	
	public void updateAssignment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		int assignmentId = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		int graduateId = Integer.parseInt(request.getParameter("grad_id"));
		int score = Integer.parseInt(request.getParameter("score"));

		Assignment assignment = new Assignment();
		assignment.setAssignmentId(assignmentId);
		assignment.setType(type);
		assignment.setGraduateId(graduateId);
		assignment.setScore(score);
		
		int result = assignmentService.updateAssignment(assignment);
		
		if (result == 0) {
			request.setAttribute("update", "failure");
		}
		else {
			request.setAttribute("update", "success");
		}
	
		getAllAssignmentDetails(request, response);
	
	}
	
	public void deleteAssignment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MySQLIntegrityConstraintViolationException {	
	
		int assignmentId = Integer.parseInt(request.getParameter("id"));
		assignmentService.deleteAssignment(assignmentId);
		request.setAttribute("delete", "success");
		getAllAssignmentDetails(request, response);
		
	}
}
