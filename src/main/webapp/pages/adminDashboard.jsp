<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/adminDashboard.css">
    <style>
       

    </style>
</head>
<body>
    <!-- Sidebar -->
    <div class="sidebar">
        <h1>Frostymart</h1><br>
        <ul>
            <li><a class="active"href="${pageContext.request.contextPath}/pages/adminDashboard.jsp">Dashboard</a></li><br>
            <li><a  href="${pageContext.request.contextPath}/pages/addProduct.jsp">Add Product</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/adminOrder.jsp">Order list</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/adminProduct.jsp">Product list</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/AdminFeedBackView.jsp">Feedback list</a></li><br>
            <li><a href="#">Logout</a></li><br>
        </ul>
    </div>

    <!-- Navbar -->
    <div class="navbar">
        <h2>Admin Dashboard</h2>
    </div>

    <!-- Content area -->
    
   <div class="content">
         <br>
        <br>
        <h2>Welcome to the Admin Panel</h2>
        
    </div> 
</body>
</html>
