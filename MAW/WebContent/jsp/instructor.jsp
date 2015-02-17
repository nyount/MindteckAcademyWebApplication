<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--ADD--> <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 
<!--ADD-&-specify correct .js file--><script type="text/javascript" src="js/instructorValidations.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instructor Management</title>
 
 
 


</head>
<body
	background="http://cdn.designrfix.com/wp-content/uploads/2013/01/Patterns-free-2013-jan-17.jpg">

	<center>

		<c:if test='${requestScope["add"] == "success"}'>
			<p style="color: #00DD00;">Successfully Added New Instructor</p>
		</c:if>
		<c:if test='${requestScope["add"] == "failure"}'>
			<p style="color: #FF0000;">Failed To Add New Instructor</p>
		</c:if>
		<c:if test='${requestScope["update"] == "success"}'>
			<p style="color: #00DD00;">Successfully Updated Instructor</p>
		</c:if>
		<c:if test='${requestScope["update"] == "failure"}'>
			<p style="color: #FF0000;">Failed To Update Instructor</p>
		</c:if>
		<c:if test='${requestScope["delete"] == "success"}'>
			<p style="color: #00DD00;">Successfully Deleted Instructor</p>
		</c:if>
		<c:if test='${requestScope["delete"] == "failure"}'>
			<p style="color: #FF0000;">Failed To Delete Instructor: You must first edit/delete the Courses associated with this Instructor.</p>
		</c:if>

		<h2>Instructors</h2>

		<table style="text-align: center;" border="1">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Skill</th>
			</tr>
			<c:forEach var='instructor' items='${requestScope["instructorList"]}'>
				<tr>
					<td>${instructor["firstName"]}</td>
					<td>${instructor["lastName"]}</td>
					<td>${instructor["skill"]}</td>
					<td>
						<form method="post" action="action.do?action=editinstructor"
							style="display: inline-block;">
							<input type="submit" value="Edit" /> <input type="hidden"
								name="id" value="${instructor.instructorId}">
						</form>
<!--ADD class="deleteForm"--><form method="post" class="deleteForm" action="action.do?action=deleteinstructor"
							style="display: inline-block;">

							
							<input type="submit" value="Delete" class="delete" /> <input
								type="hidden" name="id" value="${instructor.instructorId}">
								
							
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		
		
		<br />
		<form method="post" action="action.do?action=addinstructor">
			<input type="submit" value="Add Instructor" />
		</form>

	</center>

</body>
</html>