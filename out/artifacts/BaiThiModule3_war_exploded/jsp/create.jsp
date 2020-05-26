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
        <a href="/product?action=product">List All Product</a>
    </h2>
</center>
<center>
    <h3 style="color: red">${message}</h3>
</center>
<div align="center">
    <form method="post" action="/product">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Add product
                </h2>
            </caption>
            <tr>
                <th>ID:</th>
                <td>
                    <input type="text" name="id"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name"
                           value=""
                    />
                </td>
            </tr>
            <tr>
                <th>Price</th>
                <td>
                    <input type="text" name="price"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity </th>
                <td>
                    <input type="text" name="quantity" />
                </td>
            </tr>
            <tr>
                <th>Color </th>
                <td>
                    <input type="text" name="color" />
                </td>
            </tr>
            <tr>
                <th>Category</th>
                <td>
                    <input type="text" name="category" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" value="insert" name="action">save</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>