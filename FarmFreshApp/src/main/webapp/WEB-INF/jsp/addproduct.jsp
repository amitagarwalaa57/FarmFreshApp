<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link rel="stylesheet" type="text/css" href="/resources/css/addproductstyle.css">
<style>
.container {
  display: block;
  position: relative;
  padding-left: 50px;
  margin-bottom: 12px;
  cursor: pointer;
  font-size: 17px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default radio button */
.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
}

/* Create a custom radio button */
.checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 12px;
  width: 12px;
  background-color: #eee;
  border-radius: 50%;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.container input:checked ~ .checkmark {
  background-color: #2196F3;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the indicator (dot/circle) when checked */
.container input:checked ~ .checkmark:after {
  display: block;
}

/* Style the indicator (dot/circle) */
/*.container .checkmark:after {
 	top: 9px;
	left: 9px;
	width: 8px;
	height: 8px;
	border-radius: 50%;
	background: white;
}*/
</style>
</head>
<body>   

<div class="loginbox">
<img src="/resources/images/cm.jpg" class="avatar">


 <h1>Add New Product</h1>  
           <form:form method="post" action="saveprod" onSubmit="return checklimit();">    
            <table >    
               
            
               <tr> <td><p>Select Category</p></td>
              
              
                <td><label class="container">Vegetable<form:radiobutton path="Category" value="Vegetable" name="radio"/><span class="checkmark"></span></label>
                 <label class="container">Beverages<form:radiobutton path="Category" value="Beverages"/><span class="checkmark"></span></label>
                 </td>
              </tr>
             <tr>    
              <td><p>Product Name :</p></td>    
              <td><form:input path="productName" /></td>  
             </tr> 
             <tr>    
              <td><p>Product Price :</p></td>    
              <td><form:input path="productPrice" /></td>  
             </tr> 
             <tr>    
              <td><p>Product Quantity:</p></td>    
              <td><form:input path="quantity" /></td>  
             </tr>     
             <tr></tr> 
                         
             <tr>    
       		             
              <td> </td>    
              <td><input type="submit" value="save" /></td>    
             </tr>    
             
             <tr>
             <td></td>
             <td><a href="firstpage"><h3>Go back</h3></a>
             </tr>
            </table>    
            
            
           </form:form>    
           
          
          </div>
          
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
