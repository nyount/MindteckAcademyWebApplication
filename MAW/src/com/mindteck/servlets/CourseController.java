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
import com.mindteck.businesslayer.InstructorService;
import com.mindteck.entities.Course;
import com.mindteck.entities.Instructor;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class CourseController {

private CourseService courseService = new CourseService();
	
	public void getAllCourseDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Course> courseList = courseService.getAllCourseDetails();
		
		InstructorService instructorService = new InstructorService();
		List<Instructor> instructorList = instructorService.getAllInstructorDetails();
		request.setAttribute("instructorList", instructorList);
		
		Map<Integer, String> convertMap = new HashMap<Integer, String>();
		for (Course c : courseList) {
			for (Instructor i : instructorList) {
				if (i.getInstructorId() == c.getInstructorId()) {
					convertMap.put(c.getCourseId(), i.getLastName());
				}
			}
		}
		request.setAttribute("convertMap", convertMap);
		
		request.setAttribute("courseList", courseList);
		RequestDispatcher view = request.getRequestDispatcher("jsp/course.jsp");
		view.forward(request, response);

	}
	
	public void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InstructorService instructorService = new InstructorService();
		List<Instructor> instructorList = instructorService.getAllInstructorDetails();
		request.setAttribute("instructorList", instructorList);
		
		RequestDispatcher view = request.getRequestDispatcher("jsp/courseForm.jsp");
		view.forward(request, response);
	
	}
	
	public void insertCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	
		Course course = new Course();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
		try {
			course.setStartDate(sdf.parse(request.getParameter("start_date")));
		} catch (ParseException e) {
			try {
				course.setStartDate(sdf2.parse(request.getParameter("start_date")));
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
		}
		try {
			course.setEndDate(sdf.parse(request.getParameter("end_date")));
		} catch (ParseException e) {
			try {
				course.setEndDate(sdf2.parse(request.getParameter("end_date")));
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
		}
		course.setLocation(request.getParameter("location"));
		course.setType(request.getParameter("type"));
		course.setDescription(request.getParameter("description"));
		course.setInstructorId(Integer.parseInt(request.getParameter("instructor_id")));
		
		int result = courseService.createCourse(course);
		
		if (result == 0) {
			request.setAttribute("add", "failure");
		}
		else {
			request.setAttribute("add", "success");
		}
		
		getAllCourseDetails(request, response);
	
	}
	
	public void editCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		InstructorService instructorService = new InstructorService();
		List<Instructor> instructorList = instructorService.getAllInstructorDetails();
		request.setAttribute("instructorList", instructorList);
		
		int courseId = Integer.parseInt(request.getParameter("id"));
		Course course = courseService.getCourseDetails(courseId);
		request.setAttribute("start_date", course.getStartDate());
		request.setAttribute("end_date", course.getEndDate());
		request.setAttribute("location", course.getLocation());
		request.setAttribute("type", course.getType());
		request.setAttribute("description", course.getDescription());
		request.setAttribute("instructor_id", course.getInstructorId());
		
		RequestDispatcher view = request.getRequestDispatcher("jsp/editCourseForm.jsp");
		view.forward(request, response);
	
	}
	
	public void updateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		int courseId = Integer.parseInt(request.getParameter("id"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = (sdf.parse(request.getParameter("start_date")));
		} catch (ParseException e) {
			try {
				startDate = (sdf2.parse(request.getParameter("start_date")));
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
		}
		try {
			endDate = (sdf.parse(request.getParameter("end_date")));
		} catch (ParseException e) {
			try {
				endDate = (sdf2.parse(request.getParameter("end_date")));
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
		}
		String location = request.getParameter("location");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		int instructorId = Integer.parseInt(request.getParameter("instructor_id"));

		Course course = new Course();
		course.setCourseId(courseId);
		course.setStartDate(startDate);
		course.setEndDate(endDate);
		course.setLocation(location);
		course.setType(type);
		course.setDescription(description);
		course.setInstructorId(instructorId);
		
		int result = courseService.updateCourse(course);
		
		if (result == 0) {
			request.setAttribute("update", "failure");
		}
		else {
			request.setAttribute("update", "success");
		}
	
		getAllCourseDetails(request, response);
	
	}
	
	public void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MySQLIntegrityConstraintViolationException {	
	
		int courseId = Integer.parseInt(request.getParameter("id"));
		courseService.deleteCourse(courseId);
		request.setAttribute("delete", "success");
		getAllCourseDetails(request, response);
		
	}
}
