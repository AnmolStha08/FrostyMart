<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About us</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/feedback.css">
<link rel="stylesheet" href="../Stylesheets/feedback.css">
<style>

</style>
</head>
<body>
  <!-- Navigation bar -->
    <nav class="navbar">
        <div class="navbar_logo">
                       <img src="${pageContext.request.contextPath}/Uploads/Products/logo.png"  style="height:40px; width:auto;" alt="Logo">
        </div>

        <div class="navbar_link">
            <a href="home.jsp" >Home</a>
            <a href="${pageContext.request.contextPath}/pages/product.jsp">Products</a>
            <a class="active"  href="${pageContext.request.contextPath}/pages/feedback.jsp">About Us</a>
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
            <a href="${pageContext.request.contextPath}/pages/logout.jsp" class="btn-outline-danger">Logout</a>
            <% } else { %>
            <button style="color:white;">
                <a href="login.jsp" class="btn-outline-danger">Login</a>
            </button>
            <% } %>
        </div>
    </nav>
`	<!-- nav bar code end here -->

	<!-- Box for content -->
	<div class="box">
		<h2>About Us</h2>
		<p>Welcome to FrostyMart, where innovation meets
			convenience in the realm of refrigeration solutions. We are not just
			another online store; we are your partners in keeping things fresh,
			both in your kitchen and in your life.</p>

		<p>Our journey began with a simple vision: to revolutionize how
			people experience refrigeration. We observed the evolving needs of
			modern households and recognized the importance of having reliable,
			efficient, and stylish refrigerators that seamlessly blend into any
			space.</p>

		<p>At FrostyMart, we curate a meticulously
			selected range of refrigerators, each chosen for its quality
			craftsmanship, cutting-edge technology, and elegant design. Whether
			you're a culinary enthusiast, a busy parent, or a professional chef,
			we have the perfect fridge to suit your lifestyle and elevate your
			kitchen experience.</p>

		<p>But we're more than just a place to buy appliances. We're a
			community of like-minded individuals who share a passion for
			innovation and excellence. Our team is dedicated to providing
			unparalleled customer service, offering expert advice, and ensuring
			that your shopping experience with us is nothing short of
			exceptional.</p>

		<p>We understand that purchasing a refrigerator is an investment,
			and we take that responsibility seriously. That's why we go above and
			beyond to ensure that each product we offer meets our rigorous
			standards of quality and reliability. With us, you can shop with
			confidence, knowing that you're getting the best of the best.</p>
		<div class="container">
			<h2>Feedback Form</h2>
			<form id="feedbackForm" method="post"
				action="${pageContext.request.contextPath}/feedbackServlet">

				<label for="user_Name">User Name:</label> 
				<input type="text" id="userName" name="userName" > 
				<label for="email">Email:</label>
				<input type="email" id="email" name="email"> 
				<label for="subject"> Subject</label> 
				<input type="text" id="subject"	name="subject" required>
				<label for="feedbackDescription">Feedback:</label>
				<textarea id="feedbackDescription" name="feedbackDescription"	rows="5" required></textarea>

				<button type="submit">Submit Feedback</button>
			</form>
		</div>
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