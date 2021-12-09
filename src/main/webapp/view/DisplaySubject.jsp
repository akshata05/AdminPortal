<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject</title>
</head>
<body>
<h1>List of Subject</h1>
<ul>
<%List<String> str = 
            (List<String>)request.getAttribute("subjects");
        for(String s:str){%>
        <%-- Arranging data in tabular form
        --%>
            
               <li value=<%=s%>><%=s%></li>
              
            <%}%>
            </ul>
            <a href="./view/Options.jsp" >Go To main menu</a>
</body>
</html>