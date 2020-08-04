<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Placed</title>
<style>
.button {

  border: none;
  color: white;
  padding: 8px 32px;  
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {background-color: black;}

.content {
  margin-left: 290px;
  padding-left: 20px;
 font-size:200%;
 align-content:center;
 color:black;
}

img
{
margin-left:300px;
}
</style>
</head>
<body>
<div class="content">
<h3>YOUR ORDER HAS BEEN PLACED SUCCESSFULLY</h3>
<% 
int id =(Integer)session.getAttribute("out"); 
out.print("Your Order Id is "+id); 
%>
</div>
<a href="viewproductcustomer" class="button button1" role="button">Go Back to Homepage</a>
<a href="/" class="button button1" role="button">LogOut</a>

<img src="/resources/images/fresh.jpg"/>
</body>
</html>