<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--ADD--> <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 
<!--ADD-&-specify correct .js file--><script type="text/javascript" src="js/graduateValidations.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Graduate Management</title>
</head>
<body background="http://cdn.designrfix.com/wp-content/uploads/2013/01/Patterns-free-2013-jan-17.jpg">

<center>

	<c:if test='${requestScope["add"] == "success"}'>
	<p style="color: #00DD00;">Successfully Added New Graduate</p>
	</c:if>
	<c:if test='${requestScope["add"] == "failure"}'>
	<p style="color: #FF0000;">Failed To Add New Graduate</p>
	</c:if>
	<c:if test='${requestScope["update"] == "success"}'>
	<p style="color: #00DD00;">Successfully Updated Graduate</p>
	</c:if>
	<c:if test='${requestScope["update"] == "failure"}'>
	<p style="color: #FF0000;">Failed To Update Graduate</p>
	</c:if>
	<c:if test='${requestScope["delete"] == "success"}'>
	<p style="color: #00DD00;">Successfully Deleted Graduate</p>
	</c:if>
	<c:if test='${requestScope["delete"] == "failure"}'>
	<p style="color: #FF0000;">Failed To Delete Graduate: You must first edit/delete the Assignments associated with this Graduate.</p>
	</c:if>
	
	<h2>Graduates</h2>
	
	<table style="text-align: center;" border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Address</th>
			<th>DOB</th>
			<th>Course</th>
		</tr>
	 	<c:forEach var='graduate' items='${requestScope["graduateList"]}'>
	 	<tr>
	 		<td>${graduate["firstName"]}</td>
	 		<td>${graduate["lastName"]}</td>
	 		<td>${graduate["address1"]}</td>
	 		<td>${graduate["dob"]}</td>
	 		<td>${convertMap[graduate.graduateId]}</td>
	 		<td>
	 			<form method="post" action="action.do?action=editgraduate" style="display:inline-block;">
	 			<input type="submit" value="Edit" />
	 			<input type="hidden" name="id" value="${graduate.graduateId}">
	 			</form>
	 			<form method="post" class="deleteForm" action="action.do?action=deletegraduate" style="display:inline-block;">
	 			<input type="submit" value="Delete" />
	 			<input type="hidden" name="id" value="${graduate.graduateId}">
	 			</form>
	 		</td>
	 	</tr>
	 	</c:forEach>
	</table>
	
	<br />
	<form method="post" action="action.do?action=addgraduate">
	<input type="submit" value="Add Graduate" />
	</form>
	
</center>

</body>
</html>