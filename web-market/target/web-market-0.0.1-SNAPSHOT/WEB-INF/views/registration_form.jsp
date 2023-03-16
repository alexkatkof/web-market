<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Sign Up | By Code Info</title>
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
    <link href="resources/static/css/login_form.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <div class="signup-box">
      <h1>Sign Up</h1>
      <h4>It's free and only takes a minute</h4>
     <form:form modelAttribute="user" action="registration" method="post">
        <label>First Name</label>
        <form:input path="firstName" />
        <label>Last Name</label>
        <form:input path="lastName" />
        <label>Email</label>
        <form:input path="email" />
        <h4>Address</h4>
        <label>Country</label>
        <form:input path="address.country" />
        <label>City</label>
        <form:input path="address.city" />
        <label>The street</label>
        <form:input path="address.street" />
        <label>Zip code</label>
        <form:input path="address.zipCode" />
        <br/>
        <label>Login</label>
        <form:input path="login" />
        <label>Password</label>
        <form:password path="pass" class="pass" onkeyup="doAjax()" />
        <button type="submit">Submit</button>
    	</form:form>
      <p>
        By clicking the Sign Up button,you agree to our <br />
        <a href="#">Terms and Condition</a> and <a href="#">Policy Privacy</a>
      </p>
    </div>
    <p class="para-2">
      Already have an account? <a href="index">Login here</a>
    </p>
  </body>
</html>

