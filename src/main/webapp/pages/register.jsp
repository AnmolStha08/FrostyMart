<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/login.css">
<meta charset="UTF-8">

<title>Rigister</title>
</head>
<body>
<div class = "container">
<h1>Register</h1>
<form action="${pageContext.request.contextPath}/RegisterServlet" method = "post">
		<label for ="Username">Username</label>
		<input type ="text" id ="UserName" name = "UserName" required ><br>
		
		<label for ="firstName">First Name</label>
		<input type ="text" id ="firstName" name = "firstName" required ><br>
		
		<label for ="lastName">Last Name</label>
		<input type ="text" id ="lastName" name = "lastName" required ><br>
		
		<label for ="Email">Email</label>
		<input type ="email" id ="email" name = "email" required ><br>
		
		<label for ="gender">Gender</label>
		<select type="text" id="gender" name="gender" >
        <option value="Male">Male</option>
        <option value="Female">Female</option>
    </select><br>
		
		<label for ="Contact">Contact</label>
		<input type ="text" id ="phoneNumber" name = "phoneNumber" required ><br>
		
		<label for ="Address">Address</label>
		<input type ="text" id ="address" name = "address" required ><br>
		
		
		<label for ="password">Password</label>
		<input type ="password" id ="password" name = "password" required ><br>
		
		<button type ="submit">Register</button>
</form>
		<a href = "${pageContext.request.contextPath}/pages/home.jsp">Back to Home</a>
</div>


</body>
</html>