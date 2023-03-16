<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link href="resources/static/css/productTable.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/navbar.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/pagination.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/cartNotification.css" rel="stylesheet" type="text/css"/>
<script src="resources/static/js/stickyNavbar.js"></script>
</head>
<body>

<div class="topnav">
  <a class="active" href="products?size=10&page=1">Home</a>
  <a href="about">About</a>
  <a href="contact">Contact</a>
  <a href="userCabinet">Cabinet</a>
  <a href="logout">Logout</a>
  <div class="search-container">
    <form action="searchProduct" method="post">
      <input type="text" placeholder="Search.." name="searchEntity">
      <button type="submit">Submit</button>
    </form>
  </div>
    <a href="shopping_cart" class="notification">
  <span>Cart</span>
  <span class="badge">${cartQuantity}</span>
</a>
</div>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</p>

	<form action="user" method="post">
		<input type="text" name="userName"><br> <input
			type="submit" value="Login">
	</form>
</body>
</html>