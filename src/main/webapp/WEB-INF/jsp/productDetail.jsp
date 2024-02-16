<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
<h2>Product Detail</h2>
<c:if test="${not empty product}">
    <div>
        <strong>ID:</strong> ${product.id}<br>
        <strong>Name:</strong> ${product.name}<br>
    </div>
</c:if>
<c:if test="${empty product}">
    <p>Product not found.</p>
</c:if>
<a href="http://localhost:8888/api.predic8.de/mvc/shop/v2/products">Back to Product List</a>
</body>
</html>
