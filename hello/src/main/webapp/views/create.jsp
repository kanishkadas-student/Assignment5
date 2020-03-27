
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Enter Information of Student to be updated</h1>
	<a href="findAll">Find All</a>
	<a href="update"> Update</a>
	<a href="delete"> Delete</a>
	<a href="findByName"> FindByName</a>
	<a href="count"> Count Total Students</a>
	
	<br />
	<br />
	<br /> ${msg }

	<form:form action="create" method="post" modelAttribute="student">

		<form:label path="id">Id</form:label>
		<form:input path="id" />

		<form:label path="name">Name</form:label>
		<form:input path="name" />
		
		<form:label path="course">Course</form:label>
		<form:input path="course" />
		<input type="submit" name="submit" value="submit" />
		<br />
		<input type="reset" value="Reset">
	</form:form>
</body>
</html>
