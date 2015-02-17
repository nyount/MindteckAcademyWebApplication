<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="js/graduateValidations.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Graduate</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css"> 
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
	    $(".datepicker").datepicker({
	    	altFormat: "yy-mm-dd",
	    	changeMonth: true,
	    	changeYear: true,
	    	yearRange: "1900:2015"
	    });
	  });
  </script>
</head>
<body background="http://cdn.designrfix.com/wp-content/uploads/2013/01/Patterns-free-2013-jan-17.jpg">
<center>
	<form method="POST" class="form" action="action.do?action=updategraduate" onsubmit="validateForm()">
		<input type="hidden" name="id" value='${param["id"]}'/>
		<table style="text-align: center">
			<tr>
				<th colspan="2">Edit Graduate</th>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" id="first_name" name="first_name" value='${requestScope["first_name"]}'/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" id="last_name" name="last_name" value='${requestScope["last_name"]}'/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" id="address1" name="address1" value='${requestScope["address1"]}'/></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><input type="text" id="dob" name="dob" class="datepicker" value='${requestScope["dob"]}' readonly/></td>
			</tr>
			<tr>
				<td>Course</td>
				<td><select id="course_id" name="course_id" value='${requestScope["course_id"]}'>
						<c:forEach var='course' items='${requestScope["courseList"]}'>
 						<option value="${course.courseId}">${course["type"]}</option>
 						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<a href="action.do?action=graduate"><button>Cancel</button></a>
</center>
</body>
</html>