<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
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
/* table { */
/*   font-family: arial, sans-serif; */
/*   border-collapse: collapse; */
/*   width: 100%; */
/* } */

/* td, th { */
/*   border: 1px solid #dddddd; */
/*   text-align: left; */
/*   padding: 8px; */
/* } */

/* tr:nth-child(even) { */
/*   background-color: #dddddd; */
/* } */
</style>

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
  <a href="contact">Contact</a>
  <a class="active" href="userCabinet">Cabinet</a>
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

<h2  align="center">${LastName} Cabinet</h2>
<br/>
<h2  align="center">User Info:</h2>
<br/>

<div align="right">
<a href="http://localhost:8080/web-market/editUser">Edit profile</a>
</div>
<br/>

<div align="right">
<a href="http://localhost:8080/web-market/editUserAddress">Edit address</a>
</div>
<br/>

<div align="right">
<a href="http://localhost:8080/web-market/addUserAddress">Add address</a>
</div>
<br/>

<table id="customers">
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
  </tr>
  <c:forEach var="userInfo" items="${userInfo}">
  <tr>
    <td>
    <c:out value="${userInfo.firstName}" />
    </td>
    <td>
    <c:out value="${userInfo.lastName}" />
    </td>
    <td>
     <c:out value="${userInfo.email}" />
    </td>
  </tr>
  </c:forEach>
</table>

<h2  align="center">Address</h2>
<br/>

<table id="customers">
  <tr>
    <th>Country</th>
    <th>City</th>
    <th>The Street</th>
    <th>Zip Code</th>
  </tr>
  <c:forEach var="userAddress" items="${userAddress}">
  <tr>
    <td>
    <c:out value="${userAddress.country}" />
    </td>
    <td>
    <c:out value="${userAddress.city}" />
    </td>
    <td>
     <c:out value="${userAddress.street}" />
    </td>
    <td>
    <c:out value="${userAddress.zipCode}" />
    </td>
  </tr>
  </c:forEach>
</table>

<br>

</body>
</html>
