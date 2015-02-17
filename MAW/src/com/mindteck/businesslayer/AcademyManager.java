package com.mindteck.businesslayer;

import static com.mindteck.businesslayer.InputValidationService.validateDate;
import static com.mindteck.businesslayer.InputValidationService.validateDateDifference;
import static com.mindteck.businesslayer.InputValidationService.validateName;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.mindteck.entities.Assignment;
import com.mindteck.entities.Course;
import com.mindteck.entities.Graduate;
import com.mindteck.entities.Instructor;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class AcademyManager {

	private static Scanner input = new Scanner(System.in);
	
	// MENUS
	public void showWelcomeMessage() {
		System.out.println("Welcome to the Mindteck Academy Management System!");
	}
	public void showGoodByeMessage() {
		System.out.println("\nThanks for using the Mindteck Academy Management System!");
	}
	public void showMainMenu() {
		System.out.println();
		System.out.println("------- Main Menu -------");
		System.out.println("1. Instructor Management");
		System.out.println("2. Course Management");
		System.out.println("3. Gradute Management");
		System.out.println("4. Assignment Management");
		System.out.println("5. Exit");
		System.out.print(">> ");
	}
	public void showInstructorMenu() {
		System.out.println();
		System.out.println("----- Instructor Menu -----");
		System.out.println("1. Add Instructor");
		System.out.println("2. View All Instructors");
		System.out.println("3. Search For An Instructor");
		System.out.println("4. Update An Instructor");
		System.out.println("5. Delete An Instructor");
		System.out.println("6. Exit");
		System.out.print(">> ");
	}
	public void showAssignmentMenu() {
		System.out.println();
		System.out.println("----- Assignment Menu -----");
		System.out.println("1. Add Assignment");
		System.out.println("2. View All Assignments");
		System.out.println("3. Search For An Assignment");
		System.out.println("4. Update An Assignment");
		System.out.println("5. Delete An Assignment");
		System.out.println("6. Exit");
		System.out.print(">> ");
	}
	public void showGraduateMenu() {
		System.out.println();
		System.out.println("----- Graduate Menu -----");
		System.out.println("1. Add Graduate");
		System.out.println("2. View All Graduates");
		System.out.println("3. Search For A Graduate");
		System.out.println("4. Update A Graduate");
		System.out.println("5. Delete A Graduate");
		System.out.println("6. Exit ");
		System.out.print(">> ");
	}
	public void showCourseMenu() {
		System.out.println();
		System.out.println("----- Course Menu -----");
		System.out.println("1. Add Course");
		System.out.println("2. View All Courses");
		System.out.println("3. Search For A Course");
		System.out.println("4. Update A Course");
		System.out.println("5. Delete A Course");
		System.out.println("6. Exit");
		System.out.print(">> ");
	}

	// MAIN MENU HANDLERS
	public void handleInstructor() {

		int userInput = 0;
		boolean valid;
		boolean running = true;
		InstructorService instructorService = new InstructorService();

		while (running) {

			valid = false;
			
			while (!valid) {
				showInstructorMenu();
				try {
					userInput = input.nextInt();
					valid = true;
				}
				catch (Exception e) {
					System.out.println("That is not a valid option.");
					input.nextLine();
				}
			}
			
			switch (userInput) {
			case 1:
				addInstructor(instructorService);
				break;
			case 2:
				getAllInstructors(instructorService);
				break;
			case 3:
				searchInstructors(instructorService);
				break;
			case 4:
				updateInstructor(instructorService);
				break;
			case 5:
				deleteInstructor(instructorService);
				break;
			case 6:
				running = false;
				break;
			default:
				System.out.println("That is not a valid option.");
				break;
			}
		}
	}
	public void handleGraduate() {

		int userInput = 0;
		boolean valid;
		boolean running = true;
		GraduateService graduateService = new GraduateService();

		while (running) {
			
			valid = false;
			
			while (!valid) {
				showGraduateMenu();
				try {
					userInput = input.nextInt();
					valid = true;
				}
				catch (Exception e) {
					System.out.println("That is not a valid option.");
					input.nextLine();
				}
			}

			switch (userInput) {
			case 1:
				addGraduate(graduateService);
				break;
			case 2:
				getAllGraduates(graduateService);
				break;
			case 3:
				searchGraduates(graduateService);
				break;
			case 4:
				updateGraduate(graduateService);
				break;
			case 5:
				deleteGraduate(graduateService);
				break;
			case 6:
				running = false;
				break;

			default:
				System.out.println("That is not a valid option.");
				break;
			}
		}
	}
	public void handleAssignment() {

		int userInput = 0;
		boolean valid;
		boolean running = true;
		AssignmentService assignmentService = new AssignmentService();

		while (running) {

			valid = false;
			
			while (!valid) {
				showAssignmentMenu();
				try {
					userInput = input.nextInt();
					valid = true;
				}
				catch (Exception e) {
					System.out.println("That is not a valid option.");
					input.nextLine();
				}
			}

			switch (userInput) {
			case 1:
				addAssignment(assignmentService);
				break;
			case 2:
				getAllAssignments(assignmentService);
				break;
			case 3:
				searchAssignments(assignmentService);
				break;
			case 4:
				updateAssignment(assignmentService);
				break;
			case 5:
				deleteAssignment(assignmentService);
				break;
			case 6:
				running = false;
				break;
			default:
				System.out.println("That is not a valid option.");
				break;
			}
		}
	}
	public void handleCourse() {

		int userInput = 0;
		boolean valid;
		boolean running = true;
		CourseService courseService = new CourseService();
		InstructorService instructorService = new InstructorService();

		while (running) {

			valid = false;
			
			while (!valid) {
				showCourseMenu();
				try {
					userInput = input.nextInt();
					valid = true;
				}
				catch (Exception e) {
					System.out.println("That is not a valid option.");
					input.nextLine();
				}
			}

			switch (userInput) {
			case 1:
				addCourse(courseService, instructorService);
				break;
			case 2:
				getAllCourses(courseService);
				break;
			case 3:
				searchCourses(courseService);
				break;
			case 4:
				updateCourse(courseService, instructorService);
				break;
			case 5:
				deleteCourse(courseService);
				break;
			case 6:
				running = false;
				break;
			default:
				System.out.println("That is not a valid option.");
				break;
			}
		}
	}

	// ENTITY HANDLERS
	public void addInstructor(InstructorService service) {
		input.nextLine();
		String name;
		Instructor instructor = new Instructor();

		System.out.println("\nPlease enter Instructor Details\n");
		System.out.print("Instructor's First Name: ");
		name = input.nextLine();
		while (!validateName(name)) {
			System.out.print("Please add a valid First Name: ");
			name = input.nextLine();
		}
		instructor.setFirstName(name);
		
		System.out.print("Instructor's Last Name: ");
		name = input.nextLine();
		while (!validateName(name)) {
			System.out.print("Please add a valid Last Name: ");
			name = input.nextLine();
		}
		instructor.setLastName(name);

		System.out.print("Instructor's Skill: ");
		instructor.setSkill(input.nextLine());

		service.addInstructorDetails(instructor);
	}
	public void getAllInstructors(InstructorService service) {
		System.out.println();
		List<Instructor> instructorList = service.getAllInstructorDetails();
		if (instructorList.size() > 0) {
			for (Instructor i : instructorList) {
				System.out.println("> Instructor ID " + i.getInstructorId() + ": " + i.getFirstName() + " " + i.getLastName());
			}
		}
		else {
			System.out.println("Currently there are 0 instructors");
		}
	}
	public void searchInstructors(InstructorService service) {
		input.nextLine();
		System.out.print("\nPlease enter the instructor's last name: ");
		String name = input.nextLine();
		
		while (!validateName(name)) {
			System.out.print("Please add a valid Last Name: ");
			name = input.nextLine();
		}
		
		Instructor instructor = service.getInstructorDetails(name);
		if (instructor != null) {
			System.out.println("\n" + instructor);
		} else {
			System.out.println("Sorry, that instructor doesn't exist.");
		}
	}
	public void updateInstructor(InstructorService service) {
		input.nextLine();
		
		List<Instructor> instructorList = service.getAllInstructorDetails();
		
		if (instructorList.size() > 0) {
			System.out.println("\n--- Possible Instructors ---");
			for (Instructor i : instructorList) {
				System.out.println("> Instructor ID " + i.getInstructorId() + ": " + i.getFirstName() + " " + i.getLastName());
			}
			
			boolean isFound = false;
			String name;
			Instructor instructor2 = new Instructor();
			
			do {
				System.out.print("\nInstructor's Last Name: ");
				name = input.nextLine();
				
				for (Instructor i : instructorList) {
					if (i.getLastName().equals(name)) {
						isFound = true;
					}
				}
				
				if (isFound) {
					System.out.print("Instructor's New First Name: ");
					name = input.nextLine();
					while (!validateName(name)) {
						System.out.print("Please add a valid First Name: ");
						name = input.nextLine();
					}
					instructor2.setFirstName(name);
					
					System.out.print("Instructor's New Last Name: ");
					name = input.nextLine();
					while (!validateName(name)) {
						System.out.print("Please add a valid Last Name: ");
						name = input.nextLine();
					}
					instructor2.setLastName(name);

					System.out.print("Instructor's New Skill: ");
					instructor2.setSkill(input.nextLine());

					service.addInstructorDetails(instructor2);
					
				}
				else {
					System.out.println("Invalid Last Name");
				}
			} while (!isFound);
		}
		else {
			System.out.println("There are currently 0 instructors");
		}
	}
	public void deleteInstructor(InstructorService service) {
		input.nextLine();
		
		boolean isFound = false;
		List<Instructor> instructorList = service.getAllInstructorDetails();
				
		if (instructorList.size() > 0) {
			System.out.println("---  Possible Instructors ---");
			for (Instructor i : instructorList) {
				System.out.println(i);
			}
			
			do {
				System.out.print("\nInstructor's Id: ");
				int instructorId = Integer.parseInt(input.nextLine());
				
				for (Instructor i : instructorList) {
					if (i.getInstructorId() == instructorId) {
						isFound = true;
					}
				}
				
				if (isFound) {
					try {
						service.deleteInstructor(instructorId);
					}
					catch (MySQLIntegrityConstraintViolationException e) {
						System.out.println("Sorry, but that instructor is currently assignmed to at least one course and cannot be deleted.");
					}
				}
				else {
					System.out.println("Invalid Instructor Id");
				}
			} while (!isFound);
		}
		else {
			System.out.println("There are currently 0 instructors.");
		}

	}
		
	public void addCourse(CourseService cService, InstructorService iService) {
		input.nextLine();

		boolean isFound = false;
		int year, month, day;
		String startDate, endDate;
		Course create = new Course();
		Calendar cal = GregorianCalendar.getInstance();
		InstructorService instructorService = new InstructorService();
		List<Instructor> instructorList = instructorService.getAllInstructorDetails();

		if (instructorList.size() > 0) {
			System.out.println("Please enter course details:\n");
	
			System.out.print("Start Date (YYYY-MM-DD): ");
			startDate = input.nextLine();
			
			while (!validateDate(startDate)) {
				System.out.println("Invalid Date");
				System.out.print("Please enter a valid date (YYYY-MM-DD): ");
				startDate = input.nextLine();
			}
			
			year = Integer.parseInt(startDate.substring(0, 4));
			month = Integer.parseInt(startDate.substring(5, 7));
			day = Integer.parseInt(startDate.substring(8, 10));
			cal.set(year, month - 1, day);
			create.setStartDate(cal.getTime());
	
			System.out.print("End Date (YYYY-MM-DD): ");
			endDate = input.nextLine();
			
			while (!validateDate(endDate) || !validateDateDifference(startDate, endDate)) {
				System.out.println("Invalid Date: Incorrect format or End Date not later than Start Date");
				System.out.print("Please enter a valid date (YYYY-MM-DD): ");
				endDate = input.nextLine();
			}
			
			year = Integer.parseInt(endDate.substring(0, 4));
			month = Integer.parseInt(endDate.substring(5, 7));
			day = Integer.parseInt(endDate.substring(8, 10));
			cal.set(year, month - 1, day);
			create.setEndDate(cal.getTime());
	
			System.out.print("Location: ");
			create.setLocation(input.nextLine());
			System.out.print("Type: ");
			create.setType(input.nextLine());
			System.out.print("Description: ");
			create.setDescription(input.nextLine());

			System.out.println("\n--- Possible Instructors ---");
			for (Instructor i : instructorList) {
				System.out.println(i);
			}
			
			do {
				System.out.print("Instructor Id: ");
				int instructorId = Integer.parseInt(input.nextLine());
				
				for (Instructor i : instructorList) {
					if (i.getInstructorId() == instructorId) {
						isFound = true;
					}
				}
				
				if (isFound) {
					create.setInstructorId(instructorId);
				}
				else {
					System.out.println("Invalid Instructor Id");
				}

			} while (!isFound);
			
			cService.createCourse(create);
		}
		else {
			System.out.println("There must be at least 1 instructor to create a course.");
			System.out.println("Currently there are 0 instructors found.");
		}
	}
	public void getAllCourses(CourseService service) {
		System.out.println();
		List<Course> courseList = service.getAllCourseDetails();
		if (courseList.size() > 0) {
			for (Course c : courseList) {
				System.out.println(c);
			}
		}
		else {
			System.out.println("Currently there are 0 courses");
		}
	}
	public void searchCourses(CourseService service) {
		input.nextLine();
		System.out.print("\nEnter enter the course type that you want to search for: ");
		Course course = service.getCourseDetails(input.nextLine());
		if (course != null) {
			System.out.println("\n" + course);
		} else {
			System.out.println("Sorry, that course doesn't exist.");
		}
	}
	public void updateCourse(CourseService cService, InstructorService iService) {
		input.nextLine();

		boolean isFound = false;
		boolean instructorFound = false;
		int instructorId;
		int day, month, year;
		String startDate, endDate;
		List<Instructor> instructorList;
		Calendar cal = GregorianCalendar.getInstance();
		List<Course> courseList = cService.getAllCourseDetails();
		
		if (courseList.size() > 0) {
			System.out.println("---  Possible Courses ---");
			for (Course c : courseList) {
				System.out.println(c);
			}
			
			do {
				System.out.print("\nCourse's Id: ");
				int courseId = Integer.parseInt(input.nextLine());
				
				for (Course c : courseList) {
					if (c.getCourseId() == courseId) {
						isFound = true;
					}
				}
				
				if (isFound) {
					Course update = new Course();
					update.setCourseId(courseId);

					System.out.print("Start Date (YYYY-MM-DD): ");
					startDate = input.nextLine();
					
					while (!validateDate(startDate)) {
						System.out.println("Invalid Date");
						System.out.print("Please enter a valid date (YYYY-MM-DD): ");
						startDate = input.nextLine();
					}
					
					year = Integer.parseInt(startDate.substring(0, 4));
					month = Integer.parseInt(startDate.substring(5, 7));
					day = Integer.parseInt(startDate.substring(8, 10));
					cal.set(year, month - 1, day);
					update.setStartDate(cal.getTime());

					System.out.print("End Date (YYYY-MM-DD): ");
					endDate = input.nextLine();
					
					while (!validateDate(endDate) || !validateDateDifference(startDate, endDate)) {
						System.out.println("Invalid Date: Incorrect format or End Date not later than Start Date");
						System.out.print("Please enter a valid date (YYYY-MM-DD): ");
						endDate = input.nextLine();
					}
					
					year = Integer.parseInt(endDate.substring(0, 4));
					month = Integer.parseInt(endDate.substring(5, 7));
					day = Integer.parseInt(endDate.substring(8, 10));
					cal.set(year, month - 1, day);
					update.setEndDate(cal.getTime());

					System.out.print("Location: ");
					update.setLocation(input.nextLine());
					System.out.print("Type: ");
					update.setType(input.nextLine());
					System.out.print("Description: ");
					update.setDescription(input.nextLine());
					
					instructorList = iService.getAllInstructorDetails();
					System.out.println("\n--- Possible Instructors ---");
					for (Instructor i : instructorList) {
						System.out.println("> Instructor ID " + i.getInstructorId() + ": " + i.getFirstName() + " " + i.getLastName());
					}
					
					instructorFound = false;
					do {
						System.out.print("\nInstructor's Id: ");
						instructorId = Integer.parseInt(input.nextLine());
						
						for (Instructor i : instructorList) {
							if (i.getInstructorId() == instructorId) {
								instructorFound = true;
							}
						}
						
						if (instructorFound) {
							update.setInstructorId(instructorId);
						}
						else {
							System.out.println("Invalid Instructor Id");
						}
					} while (!instructorFound);
					
					cService.updateCourse(update);

				}
				else {
					System.out.println("Invalid Course Id");
				}
			} while (!isFound);
		}
		else {
			System.out.println("There are currently 0 courses.");
		}
	}
	public void deleteCourse(CourseService service) {
		input.nextLine();

		boolean isFound = false;
		List<Course> courseList = service.getAllCourseDetails();
		
		if (courseList.size() > 0) {
			System.out.println("---  Possible Courses ---");
			for (Course c : courseList) {
				System.out.println(c);
			}
			
			do {
				System.out.print("\nCourse's Id: ");
				int courseId = Integer.parseInt(input.nextLine());
				
				for (Course c : courseList) {
					if (c.getCourseId() == courseId) {
						isFound = true;
					}
				}
				
				if (isFound) {
					try {
						service.deleteCourse(courseId);
					}
					catch (MySQLIntegrityConstraintViolationException e) {
						System.out.println("Sorry, but that course currently has at least one graduate enrolled and cannot be deleted.");
					}
				}
				else {
					System.out.println("Invalid Course Id");
				}
			} while (!isFound);
		}
		else {
			System.out.println("There are currently 0 courses.");
		}
	}

	public void addGraduate(GraduateService service) {
		input.nextLine();
		
		boolean isFound = false;
		Graduate grad = new Graduate();
		Calendar cal = GregorianCalendar.getInstance();
		CourseService courseService = new CourseService();
		List<Course> courseList = courseService.getAllCourseDetails();
		
		if (courseList.size() > 0) {
			System.out.println("\nPlease Enter Graduate Details\n");
			
			System.out.print("First name: ");
			String name = input.nextLine();
			while (!validateName(name)) {
				System.out.print("Please Enter A Valid First Name: ");
				name = input.nextLine();
			}
			grad.setFirstName(name);
			
			System.out.print("Last name: ");
			name = input.nextLine();
			while (!validateName(name)) {
				System.out.print("Please Enter A Valid Last Name: ");
				name = input.nextLine();
			}
			grad.setLastName(name);
			
			System.out.print("Address 1: ");
			grad.setAddress1(input.nextLine());
			
			System.out.print("Address 2: ");
			grad.setAddress2(input.nextLine());
			
			System.out.print("Date of birth (YYYY-MM-DD): ");
			String date = input.nextLine();
			
			while (!validateDate(date)) {
				System.out.println("Invalid Date");
				System.out.print("Please enter a valid date (YYYY-MM-DD): ");
				date = input.nextLine();
			}
			
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(5, 7));
			int day = Integer.parseInt(date.substring(8, 10));
			cal.set(year, month - 1, day);
			grad.setDob(cal.getTime());
	
			System.out.println("\n--- Possible Courses ---");
			for (Course c : courseList) {
				System.out.println("> ID: " + c.getCourseId() + 
									"\n> Type: " + c.getType() + 
									"\n> Location: " + c.getLocation() + 
									"\n> Dates: " + c.getStartDate() + " to " + c.getEndDate() + "\n");
			}
			
			do {
				System.out.print("Course's Id: ");
				int courseId = Integer.parseInt(input.nextLine());
				
				for (Course c : courseList) {
					if (c.getCourseId() == courseId) {
						isFound = true;
					}
				}
				
				if (isFound) {
					grad.setCourseId(courseId);
				}
				else {
					System.out.println("Invalid Course Id");
				}
			} while (!isFound);
			
			service.addGraduateDetails(grad);
		}
		else {
			System.out.println("There must be at least 1 course to create a graduate.");
			System.out.println("Currently there are 0 courses found.");
		}
	}
	public void getAllGraduates(GraduateService service) {
		System.out.println();
		List<Graduate> graduateList = service.getAllGraduateDetails();
		if (graduateList.size() > 0) {
			for (Graduate g : graduateList) {
				System.out.println("> Graduate ID: " + g.getGraduateId() + 
									"\n> Name: " + g.getFirstName() + " " + g.getLastName() + 
									"\n> Course: " + g.getCourseId() + "\n");
			}
		}
		else {
			System.out.println("Currently there are 0 graduates");
		}
	}
	public void searchGraduates(GraduateService service) {
		input.nextLine();
		System.out.print("\nPlease enter the graduate's last name: ");
		String name = input.nextLine();
		while (!validateName(name)) {
			System.out.print("Please add a valid Last Name: ");
			name = input.nextLine();
		}
		Graduate graduate = service.getGraduateDetails(name);
		
		if (graduate != null) {
			System.out.println("\n" + graduate);
		} else {
			System.out.println("Sorry, that graduate doesn't exist.");
		}
	}
	public void updateGraduate(GraduateService service) {
		input.nextLine();
		
		boolean isFound = false;
		boolean isCourseFound = false;
		CourseService courseService = new CourseService();
		List<Course> courseList = courseService.getAllCourseDetails();
		Calendar cal = GregorianCalendar.getInstance();
		List<Graduate> graduateList = service.getAllGraduateDetails();
		
		System.out.println("\n--- Possible Graduates ---");
		for (Graduate g : graduateList) {
			System.out.println("Id: " + g.getGraduateId() + " " + g.getFirstName() + " " + g.getLastName());
		}
		
		do {
			System.out.print("Graduate's Id: ");
			int graduateId = Integer.parseInt(input.nextLine());
			
			for (Graduate g : graduateList) {
				if (g.getGraduateId() == graduateId) {
					isFound = true;
				}
			}
			
			if (isFound) {
				Graduate graduate2 = new Graduate();
				graduate2.setGraduateId(graduateId);
				
				System.out.print("New First Name: ");
				String name = input.nextLine();
				while (!validateName(name)) {
					System.out.print("Please enter a valid First Name: ");
					name = input.nextLine();
				}
				graduate2.setFirstName(name);
				
				System.out.print("New Last Name: ");
				name = input.nextLine();
				while (!validateName(name)) {
					System.out.print("Please enter a valid Last Name: ");
					name = input.nextLine();
				}
				graduate2.setLastName(name);
				
				System.out.print("Address 1: ");
				graduate2.setAddress1(input.next());
				
				System.out.print("Address 2: ");
				graduate2.setAddress2(input.next());
				
				System.out.print("Date of birth (YYY-MM-DD): ");
				String date = input.nextLine();
				
				while (!InputValidationService.validateDate(date)) {
					System.out.println("Invalid Date");
					System.out.print("Please enter a valid date (YYYY-MM-DD): ");
					date = input.nextLine();
				}
				
				int year = Integer.parseInt(date.substring(0, 4));
				int month = Integer.parseInt(date.substring(5, 7));
				int day = Integer.parseInt(date.substring(8, 10));
				cal.set(year, month - 1, day);
				graduate2.setDob(cal.getTime());
				
				System.out.println("\n--- Possible Courses ---");
				for (Course c : courseList) {
					System.out.println("> ID: " + c.getCourseId() + 
										"\n> Type: " + c.getType() + 
										"\n> Location: " + c.getLocation() + 
										"\n> Dates: " + c.getStartDate() + " to " + c.getEndDate() + "\n");
				}
				
				do {
					System.out.print("Course's Id: ");
					int courseId = Integer.parseInt(input.nextLine());
					
					for (Course c : courseList) {
						if (c.getCourseId() == courseId) {
							isCourseFound = true;
						}
					}
					
					if (isFound) {
						graduate2.setCourseId(courseId);
					}
					else {
						System.out.println("Invalid Course Id");
					}
				} while (!isCourseFound);
				
				service.updateGraduate(graduate2);
			}
			else {
				System.out.println("Invalid Graduate Id");
			}
		} while (!isFound);
	}
	public void deleteGraduate(GraduateService service) {
		input.nextLine();
		
		boolean isFound = false;
		List<Graduate> graduateList = service.getAllGraduateDetails();
				
		if (graduateList.size() > 0) {
			System.out.println("---  Possible Graduates ---");
			for (Graduate g : graduateList) {
				System.out.println(g);
			}
			
			do {
				System.out.print("\nGraduate's Id: ");
				int graduateId = Integer.parseInt(input.nextLine());
				
				for (Graduate g : graduateList) {
					if (g.getGraduateId() == graduateId) {
						isFound = true;
					}
				}
				
				if (isFound) {
					try {
						service.deleteGraduate(graduateId);
					}
					catch (MySQLIntegrityConstraintViolationException e) {
						System.out.println("Sorry, but that gradute has at least one assignment entered and cannot be deleted.");
					}
				}
				else {
					System.out.println("Invalid Graduate Id");
				}
			} while (!isFound);
		}
		else {
			System.out.println("There are currently 0 graduates.");
		}

	}
	
	public void addAssignment(AssignmentService service) {
		input.nextLine();
		
		boolean isFound = false;
		GraduateService graduateService = new GraduateService();
		List<Graduate> graduateList = graduateService.getAllGraduateDetails();
		
		if (graduateList.size() > 0) {	
			Assignment assignment = new Assignment();
			System.out.println("Please enter Assignment Details\n");
			
			System.out.print("Assignment's Type: ");
			assignment.setType(input.nextLine());

			System.out.println("--- Possible Graduates ---");
			for (Graduate g : graduateList) {
				System.out.println(g);
			}
			
			do {
				System.out.print("Graduate's Id: ");
				int graduateId = Integer.parseInt(input.nextLine());
				
				for (Graduate g : graduateList) {
					if (g.getGraduateId() == graduateId) {
						isFound = true;
					}
				}
				
				if (isFound) {
					assignment.setGraduateId(graduateId);
				}
				else {
					System.out.println("Invalid Graduate Id");
				}
			} while (!isFound);
	
			System.out.print("Assignment Score: ");
			assignment.setScore(Integer.parseInt(input.nextLine()));
			
			service.addAssignment(assignment);
		}
		else {
			System.out.println("There must be at least 1 graduate to create an assignment.");
			System.out.println("Currently there are 0 graduates found.");
		}
	}
	public void getAllAssignments(AssignmentService service) {
		System.out.println();	
		List<Assignment> assignmentList = service.getAllAssignments();
		if (assignmentList.size() == 0) {
			System.out.println("Currently there are 0 assignments");
		}
		else {
			for (Assignment a : service.getAllAssignments()) {
				System.out.println(a);
			}
		}
	}	
	public void searchAssignments(AssignmentService service) {
		input.nextLine();
		System.out.println("\nPlease enter the assignment's id:");
		Assignment assignment = service.getAssignmentDetails(input.nextInt());
		if (assignment != null) {
			System.out.println("\n" + assignment);
		} else {
			System.out.println("Sorry, that assignment doesn't exist.");
		}
	}
	public void updateAssignment(AssignmentService service) {
		input.nextLine();
		
		boolean isFound = false;
		boolean isGraduateFound = false;
		Assignment assignment2 = new Assignment();
		GraduateService gService = new GraduateService();
		List<Assignment> assignmentList = service.getAllAssignments();
		List<Graduate> graduateList = gService.getAllGraduateDetails();
		
		System.out.println("\n--- Possible Assignments ---");
		for (Assignment a : assignmentList) {
			System.out.println("Id: " + a.getAssignmentId() + " " + a.getType() + " " + gService.getGraduateDetails(a.getGraduateId()).getFirstName() + " " + gService.getGraduateDetails(a.getGraduateId()).getLastName() + " " + a.getScore() + "%");
		}
		
		do {
			System.out.print("Assignment's Id: ");
			int assignmentId = Integer.parseInt(input.nextLine());
			
			for (Assignment a : assignmentList) {
				if (a.getAssignmentId() == assignmentId) {
					isFound = true;
				}
			}
		
			if (isFound) {
				System.out.println("Assignment's Type: ");
				assignment2.setType(input.nextLine());
	
				System.out.println("\n--- Possible Graduates ---");
				for (Graduate g : graduateList) {
					System.out.println("Id: " + g.getGraduateId() + " " + g.getFirstName() + " " + g.getLastName());
				}
	
				do {
					System.out.print("Graduate's Id: ");
					int graduateId = Integer.parseInt(input.nextLine());
					
					for (Graduate g : graduateList) {
						if (g.getGraduateId() == graduateId) {
							isGraduateFound = true;
						}
					}
					
					if (isGraduateFound) {
						assignment2.setGraduateId(graduateId);
					}
					else {
						System.out.println("Invalid Graduate Id");
					}
				} while (!isGraduateFound);
	
				System.out.println("Assignment Score: ");
				assignment2.setScore(Integer.parseInt(input.nextLine()));
	
				service.updateAssignment(assignment2);
			}
		} while (!isFound);
	}
	public void deleteAssignment(AssignmentService service) {
		input.nextLine();
		
		boolean isFound = false;
		List<Assignment> assignmentList = service.getAllAssignments();
		
		if (assignmentList.size() > 0) {
			System.out.println("---  Possible Assignments ---");
			for (Assignment a : assignmentList) {
				System.out.println(a);
			}
			
			do {
				System.out.print("\nAssignment's Id: ");
				int assignmentId = Integer.parseInt(input.nextLine());
				
				for (Assignment a : assignmentList) {
					if (a.getAssignmentId() == assignmentId) {
						isFound = true;
					}
				}
				
				if (isFound) {
					service.deleteAssignment(assignmentId);
				}
				else {
					System.out.println("Invalid Assignment Id");
				}
			} while (!isFound);
		}
		else {
			System.out.println("There are currently 0 assignments.");
		}
	}

}