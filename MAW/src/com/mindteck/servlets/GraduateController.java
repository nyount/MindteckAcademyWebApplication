package com.mindteck.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindteck.businesslayer.CourseService;
import com.mindteck.businesslayer.GraduateService;
import com.mindteck.entities.Course;
import com.mindteck.entities.Graduate;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class GraduateController {

	private GraduateService graduateService = new GraduateService();

	public void getAllGraduateDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Graduate> graduateList = graduateService.getAllGraduateDetails();
		
		CourseService courseService = new CourseService();
		List<Course> courseList = courseService.getAllCourseDetails();
		request.setAttribute("courseList", courseList);
		
		Map<Integer, String> convertMap = new HashMap<Integer, String>();
		for (Graduate g : graduateList) {
			for (Course c : courseList) {
				if (c.getCourseId() == g.getCourseId()) {
					convertMap.put(g.getGraduateId(), c.getType());
				}
			}
		}
		request.setAttribute("convertMap", convertMap);

		request.setAttribute("graduateList", graduateList);
		RequestDispatcher view = request.getRequestDispatcher("jsp/graduate.jsp");
		view.forward(request, response);

	}

	public void addGraduate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		CourseService courseService = new CourseService();
		List<Course> courseList = courseService.getAllCourseDetails();
		request.setAttribute("courseList", courseList);

		RequestDispatcher view = request.getRequestDispatcher("jsp/graduateForm.jsp");
		view.forward(request, response);

	}

	public void insertGraduate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Graduate graduate = new Graduate();
		graduate.setFirstName(request.getParameter("first_name"));
		graduate.setLastName(request.getParameter("last_name"));
		graduate.setAddress1(request.getParameter("address1"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
		try {
			graduate.setDob(sdf.parse(request.getParameter("dob")));
		} catch (ParseException e) {
			try {
				graduate.setDob(sdf2.parse(request.getParameter("dob")));
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
		}
		graduate.setCourseId(Integer.parseInt(request.getParameter("course_id")));

		int result = graduateService.addGraduateDetails(graduate);

		if (result == 0) {
			request.setAttribute("add", "failure");
		} else {
			request.setAttribute("add", "success");
		}

		getAllGraduateDetails(request, response);

	}

	public void editGraduate(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		CourseService courseService = new CourseService();
		List<Course> courseList = courseService.getAllCourseDetails();
		request.setAttribute("courseList", courseList);

		int graduateId = Integer.parseInt(request.getParameter("id"));
		Graduate graduate = graduateService.getGraduateDetails(graduateId);
		request.setAttribute("first_name", graduate.getFirstName());
		request.setAttribute("last_name", graduate.getLastName());
		request.setAttribute("address1", graduate.getAddress1());
		request.setAttribute("dob", graduate.getDob());
		request.setAttribute("course_id", graduate.getCourseId());

		RequestDispatcher view = request.getRequestDispatcher("jsp/editGraduateForm.jsp");
		view.forward(request, response);

	}

	public void updateGraduate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int graduateId = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String address1 = request.getParameter("address1");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
		Date dob = null;
		try {
			dob = (sdf.parse(request.getParameter("dob")));
		} catch (ParseException e) {
			try {
				dob = (sdf2.parse(request.getParameter("dob")));
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
		}
		int courseId = Integer.parseInt(request.getParameter("course_id"));

		Graduate graduate = new Graduate();
		graduate.setGraduateId(graduateId);
		graduate.setFirstName(firstName);
		graduate.setLastName(lastName);
		graduate.setAddress1(address1);
		graduate.setDob(dob);
		graduate.setCourseId(courseId);

		int result = graduateService.updateGraduate(graduate);

		if (result == 0) {
			request.setAttribute("update", "failure");
		} else {
			request.setAttribute("update", "success");
		}

		getAllGraduateDetails(request, response);

	}

	public void deleteGraduate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			MySQLIntegrityConstraintViolationException {

		int graduateId = Integer.parseInt(request.getParameter("id"));
		graduateService.deleteGraduate(graduateId);
		request.setAttribute("delete", "success");
		getAllGraduateDetails(request, response);

	}
}
