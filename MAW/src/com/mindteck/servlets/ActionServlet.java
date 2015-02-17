package com.mindteck.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.contains("instructor")) {

			InstructorController instructorController = new InstructorController();

			if (action.equals("instructor")) {
				instructorController.getAllInstructorDetails(request, response);
			}

			else if (action.equals("addinstructor")) {
				instructorController.addInstructor(request, response);
			}

			else if (action.equals("insertinstructor")) {
				instructorController.insertInstructor(request, response);
			}

			else if (action.equals("editinstructor")) {
				instructorController.editInstructor(request, response);
			}

			else if (action.equals("updateinstructor")) {
				instructorController.updateInstructor(request, response);
			}

			else if (action.equals("deleteinstructor")) {
				try {
					instructorController.deleteInstructor(request, response);
				} catch (MySQLIntegrityConstraintViolationException e) {
					request.setAttribute("delete", "failure");
					instructorController.getAllInstructorDetails(request,
							response);
				}
			}
		}

		if (action.contains("graduate")) {

			GraduateController graduateController = new GraduateController();

			if (action.equals("graduate")) {
				graduateController.getAllGraduateDetails(request, response);
			}

			else if (action.equals("addgraduate")) {
				graduateController.addGraduate(request, response);
			}

			else if (action.equals("insertgraduate")) {
				graduateController.insertGraduate(request, response);
			}

			else if (action.equals("editgraduate")) {
				graduateController.editGraduate(request, response);
			}

			else if (action.equals("updategraduate")) {
				graduateController.updateGraduate(request, response);
			}

			else if (action.equals("deletegraduate")) {
				try {
					graduateController.deleteGraduate(request, response);
				} catch (MySQLIntegrityConstraintViolationException e) {
					request.setAttribute("delete", "failure");
					graduateController.getAllGraduateDetails(request, response);
				}
			}
		}

		if (action.contains("course")) {

			CourseController courseController = new CourseController();

			if (action.equals("course")) {
				courseController.getAllCourseDetails(request, response);
			}

			else if (action.equals("addcourse")) {
				courseController.addCourse(request, response);
			}

			else if (action.equals("insertcourse")) {
				courseController.insertCourse(request, response);
			}

			else if (action.equals("editcourse")) {
				courseController.editCourse(request, response);
			}

			else if (action.equals("updatecourse")) {
				courseController.updateCourse(request, response);
			}

			else if (action.equals("deletecourse")) {
				try {
					courseController.deleteCourse(request, response);
				} catch (MySQLIntegrityConstraintViolationException e) {
					request.setAttribute("delete", "failure");
					courseController.getAllCourseDetails(request, response);
				}
			}
		}
		
		if (action.contains("assignment")) {

			AssignmentController assignmentController = new AssignmentController();

			if (action.equals("assignment")) {
				assignmentController.getAllAssignmentDetails(request, response);
			}

			else if (action.equals("addassignment")) {
				assignmentController.addAssignment(request, response);
			}

			else if (action.equals("insertassignment")) {
				assignmentController.insertAssignment(request, response);
			}

			else if (action.equals("editassignment")) {
				assignmentController.editAssignment(request, response);
			}

			else if (action.equals("updateassignment")) {
				assignmentController.updateAssignment(request, response);
			}

			else if (action.equals("deleteassignment")) {
				try {
					assignmentController.deleteAssignment(request, response);
				} catch (MySQLIntegrityConstraintViolationException e) {
					request.setAttribute("delete", "failure");
					assignmentController.getAllAssignmentDetails(request, response);
				}
			}
		}

	}

}
