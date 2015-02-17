<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="js/instructorValidations.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Instructor</title>
</head>
<body background="http://cdn.designrfix.com/wp-content/uploads/2013/01/Patterns-free-2013-jan-17.jpg">
<center>
	<form method="POST" class="form" action="action.do?action=insertinstructor" onsubmit="validateForm()">
		<input type="hidden" name="id" />
		<table style="text-align: center">
			<tr>
				<th colspan="2">New Instructor</th>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" id="firstName" name="first_name" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" id="lastName" name="last_name" /></td>
			</tr>
			<tr>
				<td>Skill</td>
				<td><input type="text" id="skill" name="skill" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<a href="action.do?action=instructor"><button>Cancel</button></a>
</center>
</body>
</html>