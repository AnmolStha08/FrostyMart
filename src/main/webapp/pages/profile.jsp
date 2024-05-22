<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.DatabaseController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.UserModel"%>
<%@ page import="model.OrderModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/userProfile.css">
<style>
@charset "ISO-8859-1";
/* Styles for navigation bar */
.navbar {
    position: fixed; /* Fixed position */
    top: 0; /* Position at the top */
    left: 0; /* Position at the left */
    width: 100%; /* Full width */
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #333;
    color: white;
    padding: 10px 20px;
    z-index: 1000; /* Ensure navbar stays on top */
}

.navbar_logo {
    margin-right: auto;
}

.navbar_link {
    flex-grow: 1;
    display: flex;
    justify-content: center;
    align-items: center;
}

.navbar_link a,input {
    color: white;
    text-decoration: none;
    margin: 0 10px;
}

.navbar_link a:hover {
    color: red;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.profile-btn {
    background-color: transparent;
    border: none;
    cursor: pointer;
}

.navbar_button {
    display: flex;
    gap: 20px;
    margin-right: 30px;
}

.navbar_button button {
    background-color: transparent;
    border: none;
    color: white; /* Set text color to white */
    cursor: pointer;
    text-decoration: none; /* Remove underline */
}

/* If you want to style only the login button */
.navbar_button .login-button a {
    color: white; /* Set text color to white */
}

.navbar_link a.active {
    color: green;
}

.navbar_link a.active:hover{
    color: red;
}

 /* Table styles */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
 .content table tr td input[type="text"] {
    color: black;
}
        th {
            background-color: #f2f2f2;
        }

        /* Center align text in the first column */
        td:first-child {
            text-align: center;
        }

        /* Add some padding to the table header */
        th {
            padding-top: 12px;
            padding-bottom: 12px;
        }

        /* Highlight alternate rows */
        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }

/* Style for labels */
label {
    font-weight: bold;
}

/* Style for the update profile link */
a {
    display: block; /* Display as block element */
    margin-top: 10px; /* Add some space above the link */
    color: blue; /* Set link color */
    text-decoration: none; /* Remove default underline */
}

/* Style for link hover effect */
a:hover {
    text-decoration: underline; /* Add underline on hover */
}

.container {
    padding: 20px;
    margin: 20px;
    margin-left: 70px ;
}

.container {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(300px, 1fr)); /* Each column will have a minimum width of 300px and expand to fill available space */
    grid-gap: 20px; /* Spacing between cards */
    margin-bottom: 20px;
}

.btn-outline-primary {
    color: white;
    text-decoration: none;
}

.btn_outline_danger {
    color: white;
    text-decoration: none;
}
</style>
</head>
<body>
    <!-- Navigation bar -->
    <nav class="navbar">
        <div class="navbar_logo">
            <img src="${pageContext.request.contextPath}/Uploads/Products/logo.png" style="height:40px; width:auto;" alt="Logo">
        </div>

        <div class="navbar_link">
            <a href="${pageContext.request.contextPath}/pages/home.jsp">Home</a>
            <a href="${pageContext.request.contextPath}/pages/product.jsp">Products</a>
            <a href="${pageContext.request.contextPath}/pages/feedback.jsp">About Us</a>
            <input type="text" placeholder="Search...">
        </div>

        <div class="navbar_button">
            <button>
                  <a href="${pageContext.request.contextPath}/CartPathValidationServlet">
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
            <span class="text_light mr-2">
                <a href="profile.jsp" class="btn_outline_danger" style="color:green;">Welcome, <%= username %></a>
            </span>
            <a href="${pageContext.request.contextPath}/LogoutServlet" class="btn_outline_danger">Logout</a>
            <% } else { %>
            <button class="login-button">
                <a href="login.jsp" class="btn-outline-primary">Login</a>
            </button>
            <% } %>
        </div>
    </nav>
    <!-- Content -->
   <div class="content">
    <!-- User profile -->
    <div class="container">
        <%
        // Retrieve username from session
        String sessionUsername = (String) session.getAttribute("userName");
        if (sessionUsername != null) {
            // If username exists, fetch user details based on username
            DatabaseController dao = new DatabaseController();
            UserModel user = dao.getUserByName(sessionUsername);
            if (user != null) {
        %>
        <div class="contents">
            <div class="content">
                <h2>Account Information</h2>
                <form method="post" action="${pageContext.request.contextPath}/UpdateProfileServlet">
                <table>
                    <tr>
                        <td><label for="name">Name:</label></td>
                        <td><input type="text" name="userName" value="<%= user.getUserName() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="contact">Contact:</label></td>
                        <td><input type="text" name="phoneNumber" value="<%= user.getPhoneNumber() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="email">Email:</label></td>
                        <td><input type="text" name="email" value="<%= user.getEmail() %>"></td>
                    </tr>
                    <tr>
                        <td><label for="address">Address:</label></td>
                        <td><input type="text" name="address" value="<%= user.getAddress() %>"></td>
                    </tr>
                </table>
                <button type="submit">update</button>
                </form>
            </div>
        </div>
        <% 
            } else {
                // Handle case where user details are not found
                out.println("User details not found.");
            }
        } else {
            // Handle case where user is not logged in
            out.println("User not logged in.");
        }
        %>
    </div>
</div>


        
        <!-- Order details -->
       <!-- Order details -->
<div class="content">
    <!-- Order details heading -->
   <div class="order-details">
    <table>
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <% 
            try {
                // Retrieve the list of orders for the logged-in user
                int userId = (int) session.getAttribute("userId");
                DatabaseController dbController = new DatabaseController();
                List<OrderModel> orderDetails = dbController.getUserOrders(userId);

                // Check if the order details are not empty
                if (orderDetails != null && !orderDetails.isEmpty()) {
                    // Display order details
                    for (OrderModel order : orderDetails) {
                        // Get product name
                        String productName = dbController.getProductNameById(order.getProductId());
            %>
                        <tr class="order-item">
                            <td><%= order.getOrderId() %></td>
                            <td><%= productName %></td>
                            <td><%= order.getOrderQuantity() %></td>
                            <td><%= order.getOrderTotal() %></td>
                            <td><%= order.getOrderStatus() %></td>
                        </tr>
            <% 
                    } // end for loop
                } else {
            %>
                    <tr>
                        <td colspan="5">No orders found.</td>
                    </tr>
            <% 
                } // end if
            } catch (Exception e) {
                out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
            %>
        </tbody>
    </table>
</div>

</div>

    </div>
</body>
</html>
