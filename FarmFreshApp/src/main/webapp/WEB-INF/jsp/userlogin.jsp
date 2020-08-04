<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">


</head>
<body>

<c:if test="${not empty errorMessage}">
   <c:out value="${errorMessage}"/>
</c:if>
    <div class="loginbox">
    <img src="/resources/images/avatar.png" class="avatar">
    <h1>Welcome Customer</h1>
        <h1>Login Here</h1>
        <form method="post" action="userLogin">
        
            <p>Email</p>
            <input type="email" id="email" name="email" placeholder="Enter Email">
            <p>Password</p>
            <input type="password" id="pword" name="pword" placeholder="Enter Password">
            <input type="submit" name="" value="Login">
            <br><br>
            <a href="signup">Don't have an account?Sign Up</a><br><br>
	<a href="/"><h3>Go back</h3></a>
        </form>
        
    </div>






<!--<c:if test="${not empty errorMessage}">
   <c:out value="${errorMessage}"/>
</c:if>

<h2>Enter the Details:-</h2>
    <form method="post" action="userLogin">
        <table >
            <tr><td>Enter Email:</td><td><input id="email" type="email" name="email"/></td></tr>
           <tr><td> Enter Password:</td><td><input id="pword" name="pword" type="password" /></td></tr>
            <tr><td></td><td><input type="submit" value="Login"/></td></tr>
        </table>
    </form>
    <br><br>
    <a href="signup">New user? Sign up</a>
    <br><br><br>-->
</body>
</html>