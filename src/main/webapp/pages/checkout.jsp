 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.DatabaseController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.CartModel"%>
<%@ page import="model.ProductModel"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <style>
       
    </style>
</head>
<body>
    <div class="container">
        <h1>Order Confirmation</h1>
        <p>Thank you for your order! Below are the details:</p>
        <table>
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
<% 
    // Instantiate the DatabaseController
    DatabaseController db = new DatabaseController();
    
    // Retrieve the list of cart items
    ArrayList<CartModel> carts = db.getcarts();
    ArrayList<ProductModel> products = db.getProducts();
    
    double totalAmount = 0; // Initialize total amount
    
    //Check if both cart and product lists are not null
    if (carts != null && products != null && !carts.isEmpty() && !products.isEmpty()) {
        for (int i = 0; i < carts.size(); i++) {
            CartModel cart = carts.get(i);
            ProductModel product = products.get(i);                  
            totalAmount += cart.getPrice(); // Add product price to total
%>
                <!-- Replace the following rows with dynamic data from your checkout process -->
                <tr>
                    <td><%= product.getProductName() %></td>
                    <td><%= cart.getQuantity() %></td>
                    <td>Rs<%= cart.getPrice() %></td>
                </tr>
<% 
        } // end of for loop
    } // end of if condition
%>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="2" class="total">Total:</td>
                    <!-- Replace the following total with dynamic data from your checkout process -->
                    <td class="total">Rs<%= totalAmount %></td>
                    <!-- End of dynamic data -->
                </tr>
            </tfoot>
        </table>
        <!-- Form to submit order -->
        <form action="${pageContext.request.contextPath}/OrderServlet" method="post"> <!-- Change the action to your OrderServlet URL -->
            <!-- Hidden input fields to pass data to the servlet -->
            <% 
            
                // Loop through the cart items to include them as hidden input fields
                if (carts != null && products != null && !carts.isEmpty() && !products.isEmpty()) {
			        for (int i = 0; i < carts.size(); i++) {
			            CartModel cart = carts.get(i);
			            ProductModel product = products.get(i);
            %>
            
            <input type="hidden" name="orderQuantity<%= i %>" value="<%= cart.getQuantity() %>">
            <input type="hidden" name="orderStatus<%= i %>" value="in progress">
            <input type="hidden" name="orderTotal<%= i %>" value="<%= cart.getPrice() %>">
            
            <% 
                    } 
                }
            %>
            <!-- End of hidden input fields -->
            <button type="submit" class="button">Place Order</button> <!-- Change to a button to submit the form -->
        </form>
    </div>
</body>
</html>
