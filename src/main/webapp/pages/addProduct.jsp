
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Form</title>
   <!-- <link rel="stylesheet" href="../Stylesheets/addproduct.css"> --> 
   <link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/addproduct.css"> 
</head>
<body>

    <div class="sidebar">
        <h1>Frostymart</h1><br>
        <ul>
             <li><a href="${pageContext.request.contextPath}/pages/adminDashboard.jsp">Dashboard</a></li><br>
             <li><a class="active" href="${pageContext.request.contextPath}/pages/addProduct.jsp">Add Product</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/adminOrder.jsp">Order list</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/adminProduct.jsp">Product list</a></li><br>
            <li><a href="${pageContext.request.contextPath}/pages/AdminFeedBackView.jsp">Feedback list</a></li><br>
            <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li><br>
        </ul>
    </div>
    <!-- Navbar -->
    <div class="navbar">
        <h2>Admin Dashboard</h2>
    </div>
    

    <div class="div7">
        <form action="${pageContext.request.contextPath}/AddProductServlet" method="post" enctype="multipart/form-data">
            <div class="one">
            <h2 style="color: white; text-align: center;">Add new product</h2><br>
            <label for="productImage">Product Image:</label><br>
            <input type="file" id="productImage" name="productImage"><br>
            <div style="display: flex;">
                <div>
                    <label for="product Brand Name">Product Name:</label><br>
                    <input type="text" id="productName" name="productName" required><br>                   
                    
                    <label for="productPrice">Price:</label><br>
                    <input type="number" id="productPrice" name="productPrice" required><br>

                    <label for="productColor">Product Colour:</label><br>
                    <input type="text" id="productColor" name="productColor" required><br>
                    
                    <label for="productDescription">Description:</label><br>
                    <textarea style="position: fixed; width: 200px; height: 40px;" id="productDescription" name="productDescription"  required></textarea><br>
                </div>
                <div style="margin: 0px 50px;">
                    <label for="CompanyName">Company Name:</label><br>
                    <input type="text" id="CompanyName" name="productCompany " required><br>

                    <label for="ProductStock">Product Stock:</label><br>
                    <input type="text" id="productStock" name="productStock" required><br>

                    <label for="productType">Product Type:</label><br>
                    <input type="text" id="productType" name="productType" required><br>

                    <label for="productCapacity">Product Capacity:</label><br>
                    <input type="text" id="productCapacity" name="productCapacity" required><br>
                </div>
            </div>
            </div>
            <input type="submit" value="Add product">
        </form>
    
</div>
</div>
</body>
</html>