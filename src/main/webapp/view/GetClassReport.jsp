<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Report</title>
</head>
<body>
<h1>List of Students in CLass</h1>
<table style="border: 1px solid black;border-spacing: 2px;margin-left: auto;
  margin-right: auto; border-color: gray;">
<th style="border: 1px solid black;border-color: gray;">Student Name</th>
  <%List<String> str = 
            (List<String>)request.getAttribute("student");
        for(String s:str){%>
        <%-- Arranging data in tabular form
        --%>
            <tr style="border: 1px solid black; border-color: gray;">
                <td style="border: 1px solid black; border-color: gray;"><%=s%></td>
                
            </tr>
            <%}%>
            </table>
            
            <h1>List of Teacher</h1>
<table style="border: 1px solid black;border-spacing: 2px;margin-left: auto;
  margin-right: auto; border-color: gray;">
<th style="border: 1px solid black;border-color: gray;">Teacher Name</th>
  <%List<String> str1 = 
            (List<String>)request.getAttribute("teacher");
        for(String s:str1){%>
        <%-- Arranging data in tabular form
        --%>
            <tr style="border: 1px solid black; border-color: gray;">
                <td style="border: 1px solid black; border-color: gray;"><%=s%></td>
                
            </tr>
            <%}%>
            </table>
            
            <h1>List of Subject</h1>
<table style="border: 1px solid black;border-spacing: 2px;margin-left: auto;
  margin-right: auto; border-color: gray;">
<th style="border: 1px solid black;border-color: gray;">Subjects</th>
  <%List<String> str2 = 
            (List<String>)request.getAttribute("subject");
        for(String s:str2){%>
        <%-- Arranging data in tabular form
        --%>
            <tr style="border: 1px solid black; border-color: gray;">
                <td style="border: 1px solid black; border-color: gray;"><%=s%></td>
                
            </tr>
            <%}%>
            </table>
            <a href="./view/Options.jsp" >Go To main menu</a>
</body>
</html>