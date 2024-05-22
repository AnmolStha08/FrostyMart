<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controller.DatabaseController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProductModel"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product Display</title>
</head>
<body>
    <h1>Products</h1>
  
    <table border="1">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Add to Cart</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over product list and display each product --%>
            <c:forEach items="${products}" var="product">
            
                <tr>
                    <td>${product.productName}</td>
                    <td>${product.productDescription}</td>
                    <td>${product.productPrice}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/AddToCartServlet" method="post">
                            <input type="hidden" name="productId" value="${product.productID}">
                            <input type="number" name="quantity" value="1" min="1">
                            <input type="submit" value="Add to Cart">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <%-- Close if condition --%>
    
</body>
</html>
