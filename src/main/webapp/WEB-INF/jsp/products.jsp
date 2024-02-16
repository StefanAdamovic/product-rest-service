<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products List</title>
</head>
<body>
<h2>Products List</h2>

<c:choose>
    <c:when test="${not empty productPageResponse}">
        <table border="1px solid">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
            </tr>
            <c:forEach var="product" items="${productPageResponse.products}">
                <tr>
                    <td>${product.id}</td>
                    <td>
                        <a href="http://localhost:8888/api.predic8.de/mvc/shop/v2/products/${product.id}">${product.name}</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>No products found.</p>
    </c:otherwise>
</c:choose>
</body>
</html>

