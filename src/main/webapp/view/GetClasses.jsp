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

<form action="GetReport" method="GET">
<label>Select Class</label>
<select name="myClasses" required="required">
<option value="">Select option</option>
<%List<String> str = 
            (List<String>)request.getAttribute("classes");
        for(String s:str){%>
        <%-- Arranging data in tabular form
        --%>
            
               <option value=<%=s%>><%=s%></option>
              
            <%}%>

</select>
<br/>

<input type="submit" name="Next" value="Get Report">
</form>

</body>
</html>