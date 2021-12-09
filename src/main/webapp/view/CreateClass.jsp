<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Class</title>
</head>
<body>
<script>
let count=0;
function myFunction(id) {
	if(document.getElementById(id).checked){
		count++;
	}
	else{
		count--;
	}
	if(count>=4){
	var checks=document.getElementsByClassName("myCheck");
	for(let i=0;i<checks.length; i++){
		if(!checks[i].checked){checks[i].disabled=true;}
		
		}
	
	}
else {
	var checks=document.getElementsByClassName("myCheck");
	for(let i=0;i<checks.length; i++){
		if(!checks[i].checked){checks[i].disabled=false;}
		
		}
	}
	}
  
</script>

<h2> Create A Class</h2>
<form action="SaveClass" method="POST">
<label>Enter class name: </label><input type="text" name="name" required>
<br/><br/>
<label>Select at maximum, 4 subjects for a class</label>
<ul>

<%List<String> str = 
            (List<String>)request.getAttribute("subjects");
        for(String s:str){%>
        <%-- Arranging data in tabular form
        --%>
            
               <li value='<%=s%>'><%=s%><input type="checkbox" name="myCheck" class="myCheck" id='<%=s%>' value='<%=s%>' onclick="myFunction(this.id)"/></li>
              
            <%}%>
</ul>
<input type="submit" name="add" value="Add">
</form>


</body>
</html>