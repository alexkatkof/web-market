<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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

<br/>

<h2  align="center">Products</h2>

<br>

<p>Title : ${searchEntity.searchTitle }</p>


<table id="products">
  <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Price</th>
    <th>Photo</th>
    <th></th>
  </tr>
  <c:forEach var="product" items="${products}">
  <tr>
    <td>
    <c:out value="${product.id}" />
    </td>
    <td>
    <a href='<c:out value="/web-market/product_info?id=${product.id}" />'> <c:out value="${product.title}" /></a>
    </td>
    <td>
     <c:out value="${product.price}" />
    </td>
     <td>
    <img width="250" height="200" src="getStudentPhoto/<c:out value='${product.id}'/>">
    </td>
    <td>
    <a href='<c:out value="/web-market/shopping_cart/${product.id}" />'>Add to cart</a>
    </td>
  </tr>
  </c:forEach>
</table>

<br>

</body>
</html>