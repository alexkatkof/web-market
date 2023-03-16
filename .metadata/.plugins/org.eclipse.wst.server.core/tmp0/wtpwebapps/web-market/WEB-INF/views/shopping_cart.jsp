<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<link href="resources/static/css/pagination.css" rel="stylesheet" type="text/css"/>

<script src="resources/static/js/stickyNavbar.js"></script>
<style type="text/css">
* {box-sizing: border-box;}

/* Style the navbar */
.topnav {
  overflow: hidden;
  background-color: #e9e9e9;
  position: -webkit-sticky; /* Safari */
  position: sticky;
}

/* Navbar links */
.topnav a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;

}

/* Navbar links on mouse-over */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Active/current link */
.topnav a.active {
  background-color: #2196F3;
  color: white;
}

/* Style the input container */
.topnav .search-container {
  float: right;
}

/* Style the input field inside the navbar */
.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

/* Style the button inside the input container */
.topnav .search-container button {
  float: right;
  padding: 6px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}

/* Add responsiveness - On small screens, display the navbar vertically instead of horizontally */
@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  .topnav input[type=text] {
    border: 1px solid #ccc;
  }
}
</style>
<style type="text/css">
#products {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#products td, #products th {
  border: 1px solid #ddd;
  padding: 8px;
}

#products tr:nth-child(even){background-color: #f2f2f2;}

#products tr:hover {background-color: #ddd;}

#products th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

@font-face {
   font-family: myFirstFont;
   src: url(sansation_light.woff);
}

* {
   font-family: myFirstFont;
}

</style>
<style type="text/css">
.notification {
  background-color: #e9e9e9;
  color: white;
  text-decoration: none;
  padding: 15px 26px;
  position: relative;
  display: inline-block;
  border-radius: 2px;
}

.notification:hover {
  background: red;
}

.notification .badge {
  position: absolute;
  top: -10px;
  right: -10px;
  padding: 5px 10px;
  border-radius: 50%;
  background: red;
  color: white;
}
</style>

</head>
<body>
<div class="topnav">
  <a href="http://localhost:8080/web-market/products?size=10&page=1">Home</a>
  <a href="http://localhost:8080/web-market/about">About</a>
  <a href="http://localhost:8080/web-market/contact">Contact</a>
  <a href="http://localhost:8080/web-market/userCabinet">Cabinet</a>
  <a href="http://localhost:8080/web-market/logout">Logout</a>
  <div class="search-container">
    <form action="searchProduct" method="post">
      <input type="text" placeholder="Search.." name="searchEntity">
      <button type="submit">Submit</button>
    </form>
  </div>
    <a href="http://localhost:8080/web-market/shopping_cart" class="notification">
  <span>Cart</span>
  <span class="badge">${cartQuantity}</span>
</a>
</div>

<br/>

<table id="products">
  <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Price</th>
    <th>Quantity</th>
  </tr>
   <c:set var="total" value="0"></c:set>
  <c:forEach var="product" items="${cart}">
  <c:set var="total"
				value="${total + product.product.price * product.quantity}"></c:set>
  <tr>
    <td>
    <c:out value="${product.product.id}" />
    </td>
    <td>
    <c:out value="${product.product.title}" />
    </td>
    <td>
     <c:out value="${product.product.price}" />
    </td>
    <td>
         <c:out value="${product.quantity}" />
    </td>
  </tr>
  </c:forEach>
  <tr>
			<td colspan="3" align="right">Sum</td>
			<td>${total}</td>
		</tr>
</table>

<br>

	<div align="center">
		<a href="purchase">Buy Now!</a>
	</div>


	<div align="center">
		<a href="http://localhost:8080/web-market/products?size=10&page=1">Back to main</a>
	</div>

</body>
</html>
