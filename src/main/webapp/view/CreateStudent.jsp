<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<h2> Create A Student</h2>
<form action="SaveStudent" method="POST">
<label>First Name</label><input type="text" name="name" required="required"><br/>
<label> Last Name</label><input type="text" name="last_name"><br/>
<label> Email</label><input type="email" name="email" required="required"><br/>
<label>Select Class</label>
<select name="myClasses">
<option>Select option</option>
<%List<String> str = 
            (List<String>)request.getAttribute("classes");
        for(String s:str){%>
        <%-- Arranging data in tabular form
        --%>
            
               <option value=<%=s%>><%=s%></option>
              
            <%}%>

</select>
<br/>
<input type="submit" name="add" value="Add">
</form>
</body>
</html>