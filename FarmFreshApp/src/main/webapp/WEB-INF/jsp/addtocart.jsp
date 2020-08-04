<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<style>

body {
	background-image: url("resources/images/farmpic.jpg");
	height: 900px; 
  background-position: center;
  background-repeat: no-repeat; 
  background-size: cover;
}
table {
margin-left:300px;
  width:60%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 16px;
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

.button1 {background-color: black;
margin-left:120px;}

.content {
  margin-left: 570px;
  padding-left: 20px;
 font-size:200%;
 align-content:center;
 color:black;
}

</style>
</head>
<body>

<div class="content">
  <h2>SHOPPING</h2>
</div>

	<!-- <h3>Products Page</h3>-->
	<table id="t01" border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Category</th>
			<th>Name</th>
			<th>Price</th>
			<th>Buy</th>
		</tr>
		<c:forEach var="prod" items="${list}">
   <tr>
   <td>${prod.productId}</td>
   <td>${prod.category}</td>
   <td>${prod.productName}</td>
   <td>${prod.productPrice}</td>
   <c:out value="${list[4]}" />
				<td align="center">
					<a href="buy?prodid=${prod.productId}" class="button button1" role="button">Buy Now</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<a href="viewcart" class="button button1" role="button">View Your Cart</a>
	
	 <script>

	 
           function checklimit(){
        	   var txt1 = document.getElementById("quantity").value;
        	   submit="true";
               if(txt1>200){
            	   alert("Product Quantity Cannot Exceed 200. Please check again !")
                   return false;
              }
              
       }

           </script>

</body>
</html>