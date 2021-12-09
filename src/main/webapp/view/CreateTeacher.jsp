<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>
</head>
<body>

<h2> Create A Teacher</h2>
<form action="../SaveTeacher" method="POST">
<label> First Name</label><input type="text" name="first_name" required="required"><br/>
<label> Last Name</label><input type="text" name="last_name" required="required"><br/>
<label> Email</label><input type="email" name="email" required="required"><br/>
<br/>
<input type="submit" name="add" value="Add">

</form>
</body>
</html>