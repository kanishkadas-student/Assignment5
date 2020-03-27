<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="create"> Insert</a>
	<a href="delete">Delete</a>
	<a href="update"> Update</a>
	<a href="findByName"> FindByName</a>
	<a href="count"> Count Total Students</a>
	<h1>Student Report</h1>
	<table>
	<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Course</td>
			</tr>
		<c:forEach var="s" items="${list }">
			<tr>
				<td>${s.id }</td>
				<td>${s.name }</td>
				<td>${s.course }</td>
			</tr>
		</c:forEach>


	</table>

</body>
</html>