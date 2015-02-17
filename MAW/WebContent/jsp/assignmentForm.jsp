<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="js/assignmentValidations.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Assignment</title>
</head>
<body background="http://cdn.designrfix.com/wp-content/uploads/2013/01/Patterns-free-2013-jan-17.jpg">
<center>
	<form method="POST" class="form" action="action.do?action=insertassignment" onsubmit="validateForm()">
		<input type="hidden" name="id" />
		<table style="text-align: center">
			<tr>
				<th colspan="2">New Assignment</th>
			</tr>
			<tr>
				<td>Type</td>
				<td><input type="text" id="type" name="type" /></td>
			</tr>
			<tr>
				<td>Graduate</td>
				<td><select id="graduate_id" name="grad_id">
						<c:forEach var='graduate' items='${requestScope["graduateList"]}'>
 						<option value="${graduate.graduateId}">${graduate["firstName"]} ${graduate["lastName"]}</option>
 						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Score</td>
				<td><input type="text" id="score" name="score" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<a href="action.do?action=assignment"><button>Cancel</button></a>
</center>
</body>
</html>