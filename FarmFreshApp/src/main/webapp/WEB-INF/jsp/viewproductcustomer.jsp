<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

body {
	background-image: url("resources/images/background.jpg");
	height: 900px; 
  background-position: center;
  background-repeat: no-repeat; 
  background-size: cover;
}
table {
margin-left:150px;
  width:80%;
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
  padding: 8px 32px;  /*15px 32px*/
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {
margin-left:680px;
background-color: black;}

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
<h2>PRODUCTS   LIST</h2>
</div>

<table id="t01" border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Category</th><th>Product Name</th><th>Product Price</th><th>Quantity</th></tr>
   <c:forEach var="prod" items="${list}">
   <tr>
   <td>${prod.productId}</td>
   <td>${prod.category}</td>
   <td>${prod.productName}</td>
   <td>${prod.productPrice}</td>
   <td>${prod.quantity}</td> 
   </tr>
   </c:forEach>
   </table>
   <br>
   <a href="addtocart" class="button button1" role="button">Add to Cart</a>
   <br><br>
      <a href="/" class="button button1" role="button">Log Out</a>
   
  <!-- <a href="/">Logout</a>-->

</body>
</html>