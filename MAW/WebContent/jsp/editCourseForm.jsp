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
<title>Edit Course</title>
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
	    	yearRange: "1990:2030"
	    });
	  });
  </script>
</head>
<body background="http://cdn.designrfix.com/wp-content/uploads/2013/01/Patterns-free-2013-jan-17.jpg">
<center>
	<form method="POST" class="form" action="action.do?action=updatecourse" onsubmit="validateForm()">
		<input type="hidden" name="id" value='${param["id"]}'/>
		<table style="text-align: center">
			<tr>
				<th colspan="2">Edit Course</th>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><input type="text" id="start_date" name="start_date" class="datepicker" value='${requestScope["start_date"]}' readonly/></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><input type="text" id="end_date" name="end_date" class="datepicker" value='${requestScope["end_date"]}' readonly/></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><input type="text" id="location" name="location" value='${requestScope["location"]}'/></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><input type="text" id="type" name="type" value='${requestScope["type"]}'/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" id="description" name="description" value='${requestScope["description"]}'/></td>
			</tr>
			<tr>
				<td>Instructor</td>
				<td><select id="instructor_id" name="instructor_id" value='${requestScope["instructor_id"]}'>
						<c:forEach var='instructor' items='${requestScope["instructorList"]}'>
 						<option value="${instructor.instructorId}">${instructor["firstName"]} ${instructor["lastName"]}</option>
 						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<a href="action.do?action=course"><button>Cancel</button></a>
</center>
</body>
</html>