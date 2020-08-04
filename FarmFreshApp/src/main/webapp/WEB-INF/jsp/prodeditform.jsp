<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Edit</title>
</head>
<body>
         <h1>Edit The Details about the Product</h1>  
           <form:form method="POST" action="editsave" >    
            <table >    
            <tr>  
            <td>Product Id:</td>    
             <td><form:input  path="productId" /></td>  
             </tr>   
             <tr>
                <td>Select Category</td>
                <td><form:radiobutton path="category" value="vegetable"/> Vegetable
                 <form:radiobutton path="category" value="beverages"/> Beverages </td>
            </tr>   
             <tr>    
              <td>Product Name :</td>    
              <td><form:input path="productName" /></td>  
             </tr> 
             <tr>    
              <td>Product Price :</td>    
              <td><form:input path="productPrice" /></td>  
             </tr> 
             <tr>    
              <td>Product Quantity :</td>    
              <td><form:input path="quantity" /></td>  
             </tr>     
               
             <tr>    
              <td> </td>    
              <td><input onclick="location.href='viewproductfarmer'" type="submit" value="Save" /></td>    
             </tr>    
            </table>    
           </form:form>    
</body>
</html>
