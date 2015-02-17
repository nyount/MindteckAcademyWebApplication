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
<title>Assignment Management</title>
</head>
<body background="http://cdn.designrfix.com/wp-content/uploads/2013/01/Patterns-free-2013-jan-17.jpg">

<center>

	<c:if test='${requestScope["add"] == "success"}'>
	<p style="color: #00DD00;">Successfully Added New Assignment</p>
	</c:if>
	<c:if test='${requestScope["add"] == "failure"}'>
	<p style="color: #FF0000;">Failed To Add New Assignment</p>
	</c:if>
	<c:if test='${requestScope["update"] == "success"}'>
	<p style="color: #00DD00;">Successfully Updated Assignment</p>
	</c:if>
	<c:if test='${requestScope["update"] == "failure"}'>
	<p style="color: #FF0000;">Failed To Update Assignment</p>
	</c:if>
	<c:if test='${requestScope["delete"] == "success"}'>
	<p style="color: #00DD00;">Successfully Deleted Assignment</p>
	</c:if>
	<c:if test='${requestScope["delete"] == "failure"}'>
	<p style="color: #FF0000;">Failed To Delete Assignment</p>
	</c:if>
	
	<h2>Assignments</h2>
	
	<table style="text-align: center;" border="1">
		<tr>
			<th>Type</th>
			<th>Graduate</th>
			<th>Score</th>
		</tr>
	 	<c:forEach var='assignment' items='${requestScope["assignmentList"]}'>
	 	<tr>
	 		<td>${assignment["type"]}</td>
	 		<td>${convertMap[assignment.graduateId]}</td>
	 		<td>${assignment["score"]}</td>
	 		<td>
	 			<form method="post" action="action.do?action=editassignment" style="display:inline-block;">
	 			<input type="submit" value="Edit" />
	 			<input type="hidden" name="id" value="${assignment.assignmentId}">
	 			</form>
	 			<form method="post" class="deleteForm" action="action.do?action=deleteassignment" style="display:inline-block;">
	 			<input type="submit" value="Delete" />
	 			<input type="hidden" name="id" value="${assignment.assignmentId}">
	 			</form>
	 		</td>
	 	</tr>
	 	</c:forEach>
	</table>
	
	<br />
	<form method="post" action="action.do?action=addassignment">
	<input type="submit" value="Add Assignment" />
	</form>
	
</center>

</body>
</html>