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
        <a href="/product">List All Product</a>
    </h2>
</center>
<center>
    <h3 style="color: red">${message1}</h3>
</center>
<div align="center">
    <form method="post" action="/product">
        <table border="1" cellpadding="5">
            <tr>
                <th>ID:</th>
                <td>
                    <input type="text" name="id" size="45"
                           value="${product.getId()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${product.getProductName()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Price</th>
                <td>
                    <input type="text" name="price" size="15"
                           value="${product.getPrice()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td>
                    <input type="text" name="quantity" size="15"
                           value="${product.getQuantity()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Color</th>
                <td>
                    <input type="text" name="color" size="15"
                           value="${product.getColor() }"
                    />
                </td>
            </tr>
            <tr>
                <th>Category</th>
                <td>
                    <input type="text" name="category" size="15"
                           value="${product.getCategory()}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" value="edit" name="action">save</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>