<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="js/courseValidations.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Management</title>
</head>
<body background="http://cdn.designrfix.com/wp-content/uploads/2013/01/Patterns-free-2013-jan-17.jpg">

<center>

	<c:if test='${requestScope["add"] == "success"}'>
	<p style="color: #00DD00;">Successfully Added New Course</p>
	</c:if>
	<c:if test='${requestScope["add"] == "failure"}'>
	<p style="color: #FF0000;">Failed To Add New Course</p>
	</c:if>
	<c:if test='${requestScope["update"] == "success"}'>
	<p style="color: #00DD00;">Successfully Updated Course</p>
	</c:if>
	<c:if test='${requestScope["update"] == "failure"}'>
	<p style="color: #FF0000;">Failed To Update Course</p>
	</c:if>
	<c:if test='${requestScope["delete"] == "success"}'>
	<p style="color: #00DD00;">Successfully Deleted Course</p>
	</c:if>
	<c:if test='${requestScope["delete"] == "failure"}'>
	<p style="color: #FF0000;">Failed To Delete Course: You must first edit/delete the Graduates associated with this Course.</p>
	</c:if>
	
	<h2>Courses</h2>
	
	<table style="text-align: center;" border="1">
		<tr>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Location</th>
			<th>Type</th>
			<th>Description</th>
			<th>Instructor</th>
		</tr>
	 	<c:forEach var='course' items='${requestScope["courseList"]}'>
	 	<tr>
	 		<td>${course["startDate"]}</td>
	 		<td>${course["endDate"]}</td>
	 		<td>${course["location"]}</td>
	 		<td>${course["type"]}</td>
	 		<td>${course["description"]}</td>
	 		<td>${convertMap[course.courseId]}</td>
	 		<td>
	 			<form method="post" action="action.do?action=editcourse" style="display:inline-block;">
	 			<input type="submit" value="Edit" />
	 			<input type="hidden" name="id" value="${course.courseId}">
	 			</form>
	 			<form method="post" class="deleteForm" action="action.do?action=deletecourse" style="display:inline-block;">
	 			<input type="submit" value="Delete" />
	 			<input type="hidden" name="id" value="${course.courseId}">
	 			</form>
	 		</td>
	 	</tr>
	 	</c:forEach>
	</table>
	
	<br />
	<form method="post" action="action.do?action=addcourse">
	<input type="submit" value="Add Course" />
	</form>
	
</center>

</body>
</html>