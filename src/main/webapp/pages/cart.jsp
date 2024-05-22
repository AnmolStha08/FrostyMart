
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controller.DatabaseController" %>
<%@ page import="java.util.List" %>
<%@ page import="model.CartofUserModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/cart.css">
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
                <a href="cart.jsp">
                    <lord-icon
                        src="https://cdn.lordicon.com/pbrgppbb.json"
                        trigger="hover"
                         colors="primary:#16c72e"
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
                <a href="login.jsp" class="btn btn-outline-primary">Login</a>
            </button>
            <% } %>
        </div>
    </nav>
`	<!-- nav bar code end here -->
`	<!-- nav bar code end here -->
    <!-- Content -->
    <div class="content">
        <!-- Cart code -->
        <div class="cart">
            <!-- Cart List heading -->
            <div class="cart-list-heading">Cart List</div>
            <% 
            double totalAmount = 0; // Initialize total amount
            try {
                // Retrieve the list of cart items
                int userId = (int) session.getAttribute("userId");
                DatabaseController dbController = new DatabaseController();
                List<CartofUserModel> cartDetails = dbController.getUserCartInfo(userId);

                // Check if the cart details are not empty
                if (cartDetails != null && !cartDetails.isEmpty()) {
                    for (CartofUserModel cart : cartDetails) {
                        totalAmount += cart.getTotal_Price(); // Update total amount

                        // Display cart item
            %>
                        <!-- Cart item -->
                        <div class="cart-item">
                            <img src="${pageContext.request.contextPath}/Uploads/Products/<%= cart.getProduct_Image() %>" alt="Product Image">
                            <div class="cart-item-details">
                                <h3><%= cart.getProduct_Name() %></h3>
                                <p class="price">Price: <%= cart.getPrice() %></p>
                                <form action="${pageContext.request.contextPath}/UpdateCartServlet" method="post">
                                 <input type="hidden" name="cartId" value="<%= cart.getCartId() %>">
                                 <input type="number"  name="quantity" value="<%= cart.getQuantity() %>" style="color:black;" class="quantity-input">
                                
                                </form>
                                <div class="sameRow">
                                <!-- Add delete button here -->
                                <form action="${pageContext.request.contextPath}/DeleteCartServlet" method="post">
                                    <input type="hidden" name="cartId" value="<%= cart.getCartId() %>">
                                    <button type="submit" class="delete">Delete</button>
                                </form>
                                    <form action="${pageContext.request.contextPath}/OrderServlet" method="post">
            <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>">
            <input type="hidden" name="productId" value="<%= cart.getProduct_Id() %>">
            <input type="hidden" name="orderQuantity" value="1" min="1">
            <input type="hidden" name="orderStatus" value="pending">
            <input type="hidden" name="orderTotal" value="<%= cart.getPrice() %>">
            
                <button class="buy">Buy Now</button></form></div>
                            </div>
                        </div>
            <% 
                    } // end for loop
                } else {
            %>
                    <div class="cart-item">No items in the cart.</div>
            <% 
                } // end if
            } catch (Exception e) {
                out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
            %>
            <!-- Total amount -->
            <div class="total-amount-container">
                <div class="total-line"></div>
                <div class="total-amount">
                    Total: <span class="amount-value"><%= totalAmount %></span>
                </div>
                <%-- <div class="total-line"></div>
                
                <a href="${pageContext.request.contextPath}/pages/checkout.jsp" class="checkout-button">Checkout</a>--%>
            </div>
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
    <!-- Footer -->
    <%-- --<%@ include file="footer.jsp" %>--> --%>
    <script src="https://cdn.lordicon.com/lordicon.js"></script>
</body>
</html>
