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

<form action="SaveTeacherForClass" method="GET">

<br/>
<select name="mySubjects" required="required">
<option value="">Select option</option>
<%List<String> stri = 
            (List<String>)request.getAttribute("subjects");
        for(String s:stri){%>
        <%-- Arranging data in tabular form
        --%>
            
               <option value='<%=s%>'><%=s%></option>
              
            <%}%>

</select>
<input type="hidden" name="teacher" value="<%= (String)request.getAttribute("teacher") %>" />
<input type="hidden" name="class" value="<%=(String) request.getAttribute("class") %>" />
<input type="submit" name="Next" value="Next">

</form>
</body>
</html>