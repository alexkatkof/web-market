<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts</title>
<link href="resources/static/css/productTable.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/navbar.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/pagination.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/cartNotification.css" rel="stylesheet" type="text/css"/>
<script src="resources/static/js/stickyNavbar.js"></script>
</head>
<body>

<div class="topnav">
  <a href="products?size=10&page=1">Home</a>
  <a href="about">About</a>
  <a class="active" href="contact">Contact</a>
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

	<div align="center">
		<h1>Web-market's contacts</h1>
		<p>We work from Monday to Friday from 9:00 to 19:00. On Saturday
			from 10:00 to 17:00, and on Sunday we only accept orders.</p>
		<h2>Telephone:</h2>
		<p>+37368955899</p>
		<h2>Address:</h2>
		<p>2001, München, Plankenhofstraße 6C.</p>
	</div>

</body>
</html>