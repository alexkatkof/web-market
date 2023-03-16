<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/static/css/productTable.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/navbar.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/pagination.css" rel="stylesheet" type="text/css"/>
<link href="resources/static/css/cartNotification.css" rel="stylesheet" type="text/css"/>
<script src="resources/static/js/stickyNavbar.js"></script>
<title>Please Add Your New Address</title>
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
<h2 align="center">Please add address!</h2>

<div align="center">
		<form action="http://localhost:8080/web-market/successeful_added_address" method="post">
			<input type="text" name="country">Country: <br> 
			<input type="text" name="city">City: <br> 
			<input type="text" name="street">Street: <br> 
			<input type="text" name="zipCode">Zip Code: <br> 
			<input type="submit" value="Submit">
		</form>
	</div>

</body>
</html>