

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.DatabaseController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.OrderModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/adminProduct.css">
  
</head>
<body>

    <!-- Sidebar -->
    <div class="sidebar">
        <h1>Frostymart</h1><br>
        <ul>
            <li><a href="${pageContext.request.contextPath}/pages/addProduct.jsp">Dashboard</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/addProduct.jsp">Add Product</a></li><br>
            <li><a class="active" href="${pageContext.request.contextPath}/pages/adminOrder.jsp">Order list</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/adminProduct.jsp">Product list</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/AdminFeedBackView.jsp">Feedback list</a></li><br>
            <li><a href="#">Logout</a></li><br>
        </ul>
    </div>

    <!-- Navbar -->
    <div class="navbar">
        <h2>Admin Dashboard</h2>
    </div>

    <!-- Table Container -->
    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>Order Id</th>
                    <th>Order Quantity</th>
                    <th>OrderStatus</th>
                    <th>Order Total</th>
                    <th>User Id</th>
                    <th>Product Id</th>

                </tr>
            </thead>
            <tbody>
            <%
                // Instantiate the DatabaseController
                DatabaseController db = new DatabaseController();
              
                // Retrieve the list of products
                ArrayList<OrderModel> orders = db.getOrders();

                // Check if the products list is not null or empty
                if (orders != null && !orders.isEmpty()) {
                    for (OrderModel order : orders) {
            %>
                    <tr>
                    	<td><%= order.getOrderId() %></td>
            <td><%= order.getOrderQuantity() %></td>
            <td><%= order.getOrderStatus() %></td>
            <td><%= order.getOrderTotal() %></td> <!-- Ensure this line is correct -->
            <td><%= order.getUserId() %></td>
            <td><%= order.getProductId() %></td>
            
                    </tr>
                    <!-- Add more rows for additional products -->
                <% } // end of for loop
                } // end of if condition
            %>
            </tbody>
        </table>
    </div>
      
</body>
</html>
