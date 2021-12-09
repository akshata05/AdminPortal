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

Enter Teachers details


<form action="GetSubjectForClass" method="GET">
<label> Select Teacher</label>
<select name="myTeacher" required="required">

<option value="">Select option</option>
<%List<String> str = 
            (List<String>)request.getAttribute("teacher");
        for(String s:str){%>
        <%-- Arranging data in tabular form
        --%>
            
               <option value='<%=s%>'><%=s%></option>
              
            <%}%>

</select>
<br/>
<label> Select Class</label>
<select name="myClasses" required="required">
<option value="">Select option</option>
<%List<String> stri = 
            (List<String>)request.getAttribute("classes");
        for(String s:stri){%>
        <%-- Arranging data in tabular form
        --%>
            
               <option value='<%=s%>'><%=s%></option>
              
            <%}%>

</select>
<input type="submit" name="Next" value="Next">

</form>
</body>
</html>