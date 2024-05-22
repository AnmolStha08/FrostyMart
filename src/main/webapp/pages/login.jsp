<head>

<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/login.css">

</head>

<div class="container">
    <h1>Login</h1>
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <label for="userName">UserName</label>
        <input type="text" id="userName" name="userName" required><br>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required><br> <!-- Use type="password" for passwords -->
        <button type="submit">Login</button>
           <a href="${pageContext.request.contextPath}/pages/register.jsp">Register</a> <!-- Link to register.jsp -->
    <a href="${pageContext.request.contextPath}/pages/home.jsp">Back to Home</a>
    </form>
 
    
    <%-- Display error message if login fails --%>
    <% String error = request.getParameter("error");
        if (error != null && error.equals("1")) { %>
            <p style="color: red;">Invalid userName or password.</p>
    <% } %>
    
    <%-- Display error message if Register Successful --%>
    <% String rs = request.getParameter("registration");
        if (rs != null && rs.equals("success")) { %>
            <p style="color: green;">Your Registration is Successful. Please Login.</p>
    <% } %>
</div>
