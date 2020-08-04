<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
<style>

body {
	background-image: url("resources/images/background.jpg");
	height: 900px; 
  background-position: center;
  background-repeat: no-repeat; 
  background-size: cover;
}
table {
margin-left:120px;
  width:80%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 10px;
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
  padding: 5px 23px;  /*15px 32px*/
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {margin-left:60px;
background-color: black;;
}

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
  <h2>ORDER LIST</h2>
</div>

	<!-- <h3>Cart Page</h3>-->
	<table id="t01" border="2" width="70%" cellpadding="2">
		<tr>
			<th>Option</th>
			<th>Product Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Price per Item</th>
			<th>Total Amount</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.cart }">
			<c:set var="total"
				value="${total + item.p.productPrice * item.quantitypurchase }"></c:set>
			<tr>
				<td align="center"><a
					href="remove?prodid=${item.p.productId}"
					onclick="return confirm('Are you sure?')" class="button button1" role="button">Remove</a></td>
				<td>${item.p.productId }</td>
				<td>${item.p.productName }</td>
				<td>${item.p.productPrice }</td>
				<td>${item.quantitypurchase }</td>
				<td>${item.p.productPrice * item.quantitypurchase }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right"><h2>Sum</h2></td>
			<td>${total }</td>
		</tr>
	</table>
	<br>
	<a href="addtocart" class="button button1" role="button">Continue
		Shopping</a>
		<br><br>
		<a href="viewproductcustomer" class="button button1" role="button">Homepage</a>
		<br><br>
		<a href="confirmorder?sum=${total }" class="button button1" role="button">Confirm Order</a>
		
		
		


</body>
</html>