<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner Academy</title>
</head>
<body>
<h1>Administrator Login</h1>
<form action="j_security_check" method="POST">
<input type="email" placeholder="Enter email" name="j_username">
<input type="password" placeholder="Enter password" name="j_password">
<input type="submit" value="Submit" name="submit">
</form>
</body>
</html>