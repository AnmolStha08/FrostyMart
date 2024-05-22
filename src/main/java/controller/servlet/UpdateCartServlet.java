package controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.CartModel;
import util.StringUtil;

@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve parameters from the request
            int cartId = Integer.parseInt(request.getParameter("cartId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            System.out.println(cartId);
            System.out.println(quantity);
            // Create a CartModel object with the retrieved values
            CartModel updatedCart = new CartModel(cartId, quantity);
            
            // Update the cart details in the database
            boolean updateSuccess = DatabaseController.updateCart(updatedCart);
            
            if (updateSuccess) {
                // Redirect the user to a success page
            	 response.sendRedirect(request.getContextPath()+ "/pages/cart.jsp");
            } else {
                // Redirect the user to an error page
                response.sendRedirect("error.jsp");
            }
        } catch (NumberFormatException e) {
            // Handle the case where parseInt fails due to null or invalid input
            // Redirect the user to an error page or display an error message
            response.sendRedirect(StringUtil.ERROR_PRODUCT_MESSAGE);
        } catch (ClassNotFoundException e) {
            // Handle the case where the database controller class is not found
            e.printStackTrace(); // You might want to log this error
            response.sendRedirect("error.jsp"); // Redirect the user to an error page
        }
    }
}
