<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About us!</title>
<link href="resources/static/css/productTable.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/navbar.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/pagination.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/cartNotification.css" rel="stylesheet" type="text/css"/>
<script src="resources/static/js/stickyNavbar.js"></script>
</head>
<body>

<div class="topnav">
  <a href="products?size=10&page=1">Home</a>
  <a class="active" href="about">About</a>
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

	<div align="center">

		<h1>About Us!</h1>
		<h2>Contact Information</h2>
		<p>On our website, in just a couple of minutes at
			home in a comfortable environment, you can easily place an order.
			Previously, on our website in an accessible form, you can familiarize
			yourself with an open link about the product: its technical
			characteristics and capabilities, main programs and functions,
			additional functions. If after this call you still have questions,
			you can order a call back or ask a question in the online chat and an
			experienced, competent consultant will answer all your questions.
			Qualified, polite staff will not help you get confused in a wide
			range and choose the product that you need.</p>
	</div>

</body>
</html>