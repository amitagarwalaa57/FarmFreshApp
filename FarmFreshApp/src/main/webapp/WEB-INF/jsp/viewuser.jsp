<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Emp Details</title>

<style>

body {
	background-image: url("resources/images/far.jpg");
	height: 900px; 
  background-position: center;
  background-repeat: no-repeat; 
  background-size: cover;
}
table {
  width:90%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
#t01 tr:nth-child(even) {
  background-color: #eee;
}
#t01 tr:nth-child(odd) {
 background-color: #fff;
}
#t01 th {
  background-color: black;
  color: white;
}
.button {
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {background-color:black;}

.content {
  margin-left: 550px;
  padding-left: 20px;
 font-size:200%;
 align-content:center;
 color:white;
}

</style>

</head>
<body>
 
<div class="content">
  <h2>CUSTOMER LIST</h2>
</div> 
<table id="t01" border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Mobile number</th><th>Address</th></tr>  
   <c:forEach var="user" items="${list}">   
   <tr>  
   <td>${user.userId}</td> 
   <td>${user.fname}</td>  
   <td>${user.lname}</td>  
   <td>${user.email}</td>
   <!-- <td>${user.pword}</td>-->
   <td>${user.mobNo}</td>
   <td>${user.address}</td>  
   <!--  <td><a href="editemp/${user.userId}">Edit</a></td>-->  
   <!--  <td><a href="deleteemp/${user.userId}">Delete</a></td>-->  
   </tr>  
   </c:forEach>  
   </table>  
   <br>  
  <!--  <a href="signup">Add New Employee</a>-->
  
  <a href="farmer" class="button button1" role="button">HOMEPAGE</a>
  <!-- <a href="farmer">Go Back</a>-->  
</body>
</html>