<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>

<style>


*{
margin:0;
padding:0;
}
body {
margin: 0;
    padding: 0;
	background-image: url("/resources/images/market.jpg");
 
   height: 500px; 
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}



h2
{
color:white;
text-align:center;
padding:20px;
}

.reg{
width:40%;
margin:auto;
background-color:rgb(0,0,0,0.4);
}
#reg{
width:60%;
margin-left:70px;
}

label{
margin-left:60px;
color:white;
font-size:20px;
}

#name{
margin-left:60px;
width:400px;
outline:0;
float:center;
padding:5px;
border:3px border-color:rgb(118,136,149);
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

.button1 {background-color: #932109;
margin-left:120px;
}


</style>

</head>
<body>   

<div class="reg">
             
           <form:form method="post" action="save">    
             <h2>Register Here</h2>
             
             
             <br><br>

    <label>Enter First Name:</label><br><form:input path="fname" id="name" /><br><br>
    
    <label>Enter Last Name:</label><br><form:input path="lname" id="name" /><br><br>

    <label>Enter Email:</label><br><form:input path="email" id="name"/><br><br>

    <label>Enter Password:</label><br><form:input path="pword" id="name" autocomplete="off"/><br><br>

    <label>Enter Mobile No:</label><br><form:input path="mobNo"  id="name"/><br><br>

    <label>Enter Address:</label><br><form:input path="address" id="name" /><br>

  <br><br><input type="submit" class="button button1" value="Sign Up"/><br><br>
  
  
  <input type="button" class="button button1" onclick="location.href='home'" value="Home page" />
  <br><br>


 </form:form>
 
             
           
          </div>
</body>
</html>
