<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject</title>
</head>
<body>
<h1> Add Subject</h1>
<form action="../SaveSubject" method="POST">
<label>Enter Subject Name: </label><input type="text" name="subjectName" required="required">
<br/><br/>
<input type="submit" name="add" value="Add">
</form>

</body>
</html>