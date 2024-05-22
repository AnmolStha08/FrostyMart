<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="controller.DatabaseController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProductModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/home.css">
</head>
<body>
  <!-- Navigation bar -->
    <nav class="navbar">
        <div class="navbar_logo">
                       <img src="${pageContext.request.contextPath}/Uploads/Products/logo.png"  style="height:40px; width:auto;" alt="Logo">
        </div>

        <div class="navbar_link">
            <a class="active" href="${pageContext.request.contextPath}/pages/home.jsp"  >Home</a>
            <a href="${pageContext.request.contextPath}/pages/product.jsp">Products</a>
            <a href="${pageContext.request.contextPath}/pages/feedback.jsp">About Us</a>
            <!-- <input type="text" placeholder="Search..."> -->
            <form action="${pageContext.request.contextPath}/SearchServlet"
						method="GET">
						<input type="text" class="search-input" name="query"
							placeholder="Search"> <!-- <select name="searchType">
							<option value="name">Name</option>
							<option value="price">Price</option>
						</select> -->
						<button type="submit">Search</button>
					</form>
        </div>

        <div class="navbar_button">
        
              <button>
				    <a href="${pageContext.request.contextPath}/CartPathValidationServlet" method="post"> 
				    <%--<a href="${pageContext.request.contextPath}/pages/cart.jsp" >--%>
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
                <a href="profile.jsp" class="btn-outline-danger">Welcome, <%= username %></a>
            </span>
            <a href="${pageContext.request.contextPath}/LogoutServlet" class="btn-outline-danger">Logout</a>
            <% } else { %>
            <button class="login-button">
    <a href="login.jsp" class="btn-outline-danger">Login</a>
</button>

            <% } %>
        </div>
    </nav>
`	<!-- nav bar code end here -->

   
 <div class="container">
        <img src="${pageContext.request.contextPath}/Uploads/Products/img1.png" alt="Product Image">
        
        
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