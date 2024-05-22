<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.DatabaseController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProductModel"%>
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
            <li><a href="${pageContext.request.contextPath}/pages/adminDashboard.jsp">Dashboard</a></li><br>
             <li><a  href="${pageContext.request.contextPath}/pages/addProduct.jsp">Add Product</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/adminOrder.jsp">Order list</a></li><br>
            <li><a class="active" href="${pageContext.request.contextPath}/pages/adminProduct.jsp">Product list</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/AdminFeedBackView.jsp">Feedback list</a></li><br>
            <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li><br>
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
                    <th>Product Id</th>
                    <th>ProductName</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Company</th>
                    <th>Stock</th>
                    <th>Color</th>
                    <th>Type</th>
                    <th>Capacity</th>
                    <th>Image</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <%
                // Instantiate the DatabaseController
                DatabaseController db = new DatabaseController();
              
                // Retrieve the list of products
                ArrayList<ProductModel> products = db.getProducts();

                // Check if the products list is not null or empty
                if (products != null && !products.isEmpty()) {
                    for (ProductModel product : products) {
            %>	<form id="feedbackForm" method="post" action="${pageContext.request.contextPath}/UpdateAdminProductServlet">
                    <tr>
    <form id="ProductList" method="post" action="${pageContext.request.contextPath}/UpdateAdminProductServlet">
        <td><%= product.getProductID() %></td>
        <input type="hidden" name="productID" value="<%= product.getProductID() %>">
        <td><input type="text" name="productName" value="<%= product.getProductName() %>"></td>
        <td><input type="text" name="productDescription" value="<%= product.getProductDescription() %>"></td>
        <td><input type="text" name="productPrice" value="<%= product.getProductPrice() %>"></td>
        <td><input type="text" name="productCompany" value="<%= product.getProductCompany() %>"></td>
        <td><input type="text" name="productStock" value="<%= product.getProductStock() %>"></td>
        <td><input type="text" name="productColor" value="<%= product.getProductColor() %>"></td>
        <td><input type="text" name="productType" value="<%= product.getProductType() %>"></td>
        <td><input type="text" name="productCapacity" value="<%= product.getProductCapacity() %>"></td>
        <td><input type="text" name="productImage" value="<%= product.getProductImage() %>"></td>
        <td>
            <button type="submit">Save</button>
        </td>
    </form>
    <td>
        <form action="${pageContext.request.contextPath}/DeleteAdminProductServlet" method="post">
            <input type="hidden" name="productID" value="<%= product.getProductID() %>">
            <button type="submit" class="delete" style="color: red">
                <lord-icon
                    src="https://cdn.lordicon.com/skkahier.json"
                    trigger="hover"
                    style="width:25px;height:25px">
            </button>
        </form>
    </td>
</tr>

                  </form>
                    
                    <!-- Add more rows for additional products -->
                <% } // end of for loop
                } // end of if condition
            %>
            </tbody>
        </table>
    </div>
<script src="https://cdn.lordicon.com/lordicon.js"></script>    
</body>
</html>
