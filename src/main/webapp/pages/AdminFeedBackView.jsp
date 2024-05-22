<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.DatabaseController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Feedback"%>
<%@ page import="java.util.List"%>
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
            <li><a href="${pageContext.request.contextPath}/pages/adminProduct.jsp">Product list</a></li><br>
            <li><a class="active" href="${pageContext.request.contextPath}/pages/AdminFeedBackView.jsp">Feedback list</a></li><br>
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
                    <th>Feedback Id</th>
                    <th>UserName</th>
                    <th>Subject</th>
                    <th>Email</th>
                    <th>Feedback Description</th>
                    
                </tr>
            </thead>
            <tbody>
            <%
                // Instantiate the DatabaseController
                DatabaseController db = new DatabaseController();
              
                // Retrieve the list of products
               List<Feedback> feedbacks = DatabaseController.getFeedback();
				ArrayList<Feedback> arrayListFeedback = new ArrayList<>(feedbacks);


                // Check if the products list is not null or empty
                if (feedbacks != null && !feedbacks.isEmpty()) {
                    for (Feedback feedback : feedbacks) {
            %>	
                <tr>
			        <td><%= feedback.getFeedbackId() %></td>   
			        <td><%= feedback.getUserName() %></td>
			        <td><%= feedback.getSubject() %></td>
			        <td><%= feedback.getEmail() %></td>
			        <td><%= feedback.getFeedbackDescription() %></td>
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
