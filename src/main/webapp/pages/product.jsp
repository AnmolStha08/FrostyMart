<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.DatabaseController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProductModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Information</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/product.css">

</head>
<body>
  <!-- Navigation bar -->
    <nav class="navbar">
        <div class="navbar_logo">
            <img src="${pageContext.request.contextPath}/Uploads/Products/logo.png"  style="height:40px; width:auto;" alt="Logo">
        </div>

        <div class="navbar_link">
            <a href="${pageContext.request.contextPath}/pages/home.jsp"  >Home</a>
            <a class="active" href="${pageContext.request.contextPath}/pages/product.jsp">Products</a>
            <a href="${pageContext.request.contextPath}/pages/feedback.jsp">About Us</a>
            <input type="text" placeholder="Search...">
        </div>

        <div class="navbar_button">
         <button>
                 <a href="${pageContext.request.contextPath}/CartPathValidationServlet" method="post">
                 <%-- <a href="${pageContext.request.contextPath}/pages/cart.jsp" > --%> 
				        <lord-icon
				            src="https://cdn.lordicon.com/pbrgppbb.json"
				            trigger="hover"
				            colors="primary:#ffffff"
				            style="width:25px;height:25px">
				        </lord-icon>
				    </a>
            </button>
            <% 
            String username = (String) session.getAttribute("userName");
            if (username != null) { %>
           
            <span class="text-light mr-2">
                <a href="${pageContext.request.contextPath}/pages/profile.jsp" class="btn-outline-danger">Welcome, <%= username %></a>
            </span>
            <a href="${pageContext.request.contextPath}/LogoutServlet" class="btn-outline-danger">Logout</a>
            <% } else { %>
            <button style="color:white;">
                <a href="login.jsp" class="btn-outline-danger">Login</a>
            </button>
            <% } %>
        </div>
    </nav>
`	<!-- nav bar code end here -->

<div class="container">
<%
  // Instantiate the DatabaseController
  DatabaseController db = new DatabaseController();
  
  // Retrieve the list of products
  ArrayList<ProductModel> products = db.getProducts();

  // Check if the products list is not null or empty
  if (products != null && !products.isEmpty()) {
      for (ProductModel product : products) {
%>
<div class="product_card">
    <img src="${pageContext.request.contextPath}/Uploads/Products/<%= product.getProductImage() %>" alt="Product Image">
    
    <div class="product_info">
        <h3><%= product.getProductName() %></h3>
        <p ><%= product.getProductDescription() %></p>
        <div class="row">
        <div class="left">
         <p> <%= product.getProductType() %></p>
        <p >RS <%= product.getProductPrice()%></p>
         <p> <%= product.getProductCompany() %></p>
                </div>
                <div class="right">
                <p> <%= product.getProductStock() %> units</p>
                <p> <%= product.getProductColor() %></p>
                <p> <%= product.getProductCapacity() %></p>
                </div>
       </div>
        <form action="${pageContext.request.contextPath}/AddToCartServlet" method="post">
            <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>">
            <input type="hidden" name="productId" value="<%= product.getProductID() %>">
            <input type="hidden" name="quantity" value="1" min="1">
            <input type="hidden" name="price" value="<%= product.getProductPrice() %>">
            <div class="buttons">
                <button type="submit">Add To Cart</button>
                </form>
                </div>
                <div class="buttons">
                <form action="${pageContext.request.contextPath}/OrderServlet" method="post">
            <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>">
            <input type="hidden" name="productId" value="<%= product.getProductID() %>">
            <input type="hidden" name="orderQuantity" value="1" min="1">
            <input type="hidden" name="orderStatus" value="pending">
            <input type="hidden" name="orderTotal" value="<%= product.getProductPrice() %>">
            
                <button class="buy">Buy Now</button>
                </form>
            </div>
        
    </div>
</div>
<%
      }
  } else {
%>
<p>No products found.</p>
<%
  }
%>

</div>
 <!-- Footer -->
    <footer class="footer">
        <div class="left_footer">
            <ul>
                <li><lord-icon
                    src="https://cdn.lordicon.com/nzixoeyk.json"
                    trigger="hover"
                    colors="primary:#ffffff"
                    style="width:20px;height:20px">
                </lord-icon>
                frostymart@gmail.com</li>
                <li><lord-icon
                    src="https://cdn.lordicon.com/rsvfayfn.json"
                    trigger="hover"
                    colors="primary:#ffffff"
                    style="width:20px;height:20px">
                </lord-icon>+977 9800000001</li>
                <li><lord-icon
                    src="https://cdn.lordicon.com/iikoxwld.json"
                    trigger="hover"
                    colors="primary:#ffffff"
                    style="width:20px;height:20px">
                </lord-icon>itahari,sunsari, morang</li>
            </ul>
        </div>
        <div class="mid_footer">
                        <img src="${pageContext.request.contextPath}/Uploads/Products/logo.png"  style="height:40px; width:auto;" alt="Logo">
        </div>
        <div class="right_footer">
            <ul>
                <li>Copyright @ forstymart 2024</li>
                <li>Developed by group 2</li>
            </ul>
        </div>
    </footer>
<script src="https://cdn.lordicon.com/lordicon.js"></script>
</body>
</html>
