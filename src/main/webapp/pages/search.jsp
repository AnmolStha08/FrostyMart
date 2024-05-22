

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/product.css">
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/search.css">
<style>
.container {
    width: 80%;
    margin: 0 auto;
}

h1 {
    text-align: center;
}

ul {
    list-style-type: none;
    padding: 0;
}

li {
    margin-bottom: 20px;
    border: 1px solid #ccc;
    padding: 10px;
}

h2 {
    margin-top: 0;
}

p {
    margin: 5px 0;
}

p:first-child {
    font-weight: bold;
}
</style>
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
		<h1>Search Results</h1>
		<c:if test="${not empty searchResults}">
			<ul>
				<c:forEach var="product" items="${searchResults}">
					<li>
						<h2>${product.getProductName()}</h2>
						<p>Code: ${product.getProductID()}</p>
						<p>Company: ${product.getProductCompany()}</p>
						<p>Price: Rs.${product.getProductPrice()}</p>
						
						<p>Description: ${product.getProductDescription()}</p>
						<p>Stock: ${product.getProductStock()}</p>
						<p>Type: ${product.getProductType()}</p></li>
				</c:forEach>
			</ul>
		</c:if>

		<c:if test="${empty searchResults}">
			<p>No search results found.</p>
		</c:if>
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


