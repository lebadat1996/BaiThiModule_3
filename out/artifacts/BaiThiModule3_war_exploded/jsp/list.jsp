<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/product?action=create">Add New Product</a>
    </h2>
</center>
<center>
    <h3 style="color: red">${title}</h3>
    <form action="/product" method="post">
        <input type="text" name="name">
        <button value="find" name="action" type="submit">Search</button>
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category </th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td><c:out value="${product.getId()}"/></td>
                <td><c:out value="${product.getProductName() }"/></td>
                <td><c:out value="${product.getPrice()}"/></td>
                <td><c:out value="${product.getQuantity()}"/></td>
                <td><c:out value="${product.getColor()}"/></td>
                <td><c:out value="${product.getCategory()}"/></td>
                <td>
                    <a href="/product?action=edit&id=${product.getId()}">Edit</a>
                    <a href="/product?action=delete&id=${product.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>