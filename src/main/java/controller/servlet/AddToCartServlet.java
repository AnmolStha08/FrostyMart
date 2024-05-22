//package controller.servlet;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import controller.DatabaseController;
//import model.CartModel;
//import util.StringUtil;
//
//@WebServlet("/AddToCartServlet")
//public class AddToCartServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Retrieve parameters from the request
//        String userIdParam = request.getParameter("userId");
//        String productIdParam = request.getParameter("productId");
//        String quantityParam = request.getParameter("quantity");
//        String priceParam = request.getParameter("price");
//
//        // Check if any parameter is null or empty
//        if (userIdParam == null || userIdParam.isEmpty() ||
//            productIdParam == null || productIdParam.isEmpty() ||
//            quantityParam == null || quantityParam.isEmpty() ||
//            priceParam == null || priceParam.isEmpty()) {
//            // Handle missing or empty parameters
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid parameters");
//            return;
//        }
//
//        try {
//            // Parse parameters to appropriate types
//            int userId = Integer.parseInt(userIdParam);
//            int productId = Integer.parseInt(productIdParam);
//            int quantity = Integer.parseInt(quantityParam);
//            double price = Double.parseDouble(priceParam);
//
//            // Create CartModel object
//            CartModel cartObj = new CartModel(productId, userId, quantity, (int) price);
//
//            // Call AddToCart method with CartModel object
//            DatabaseController.AddToCart(cartObj);
//            
//            // Redirect the user to the product page
//            response.sendRedirect(request.getContextPath() + StringUtil.PRODUCT_PAGE);
//        } catch (NumberFormatException e) {
//            // Handle invalid parameter format
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameter format");
//        }
//    }
//}

package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.CartModel;
import util.StringUtil;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userIdParam = request.getParameter("userId");
	    if (userIdParam == null || userIdParam.isEmpty()) {
	        // User is not logged in, show pop-up alert and redirect to login page
	        String redirectUrl = request.getContextPath() + "/login.jsp";
	        String alertScript = "<script type=\"text/javascript\">alert('Please log in to add items to your cart');window.location.href='" + redirectUrl + "';</script>";
	        
	        response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().println(alertScript);
	        return; // Stop further processing
	    }

	    // Proceed with adding item to cart
	    int userId = Integer.parseInt(userIdParam);
	    int productId = Integer.parseInt(request.getParameter("productId"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    double price = Double.parseDouble(request.getParameter("price"));

	    CartModel cartObj = new CartModel(productId, userId, quantity, (int) price);

	    // Assuming AddToCart returns a boolean indicating success
	    boolean itemAdded = DatabaseController.AddToCart(cartObj);

	    if (itemAdded) {
	        // Send JavaScript code to display the pop-up
	        String successRedirectUrl = request.getContextPath() + "/pages/cart.jsp";
	        String successAlertScript = "<script type=\"text/javascript\">alert('Item added to cart successfully!');window.location.href='" + successRedirectUrl + "';</script>";

	        response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().println(successAlertScript);
	    } else {
	        // Handle the case where adding to cart fails
	        // You can redirect to an error page or display an error message
	        response.sendRedirect("error adding cart");
	    }
	}

}


//@WebServlet("/AddToCartServlet")
//public class AddToCartServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Retrieve parameters from the request
//        int productId = Integer.parseInt(request.getParameter("productId"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        double price = Double.parseDouble(request.getParameter("price")); // Parse price as double
//
//        // Check the number of existing carts for the cart ID
//        int cartId = Integer.parseInt(request.getParameter("cartId")); // Assuming cartId is passed from the request
//        int cartCount = DatabaseController.getCartCountForCart(cartId);
//
//        if (cartCount >= 5) {
//            // If the cart already has 5 items, show a message
//            request.setAttribute("errorMessage", "You cannot insert more than 5 items for this cart.");
////            request.getRequestDispatcher("/error.jsp").forward(request, response);
//            return;
//        }
//
//        // Create CartModel object with price
//        CartModel cartObj = new CartModel(productId, quantity, (int) price);
//
//        // Call AddToCart method with CartModel object
//        DatabaseController.AddToCart(cartObj);
//        
//        // Redirect the user to the cart page or any other page
//        response.sendRedirect("/pages/cart.jsp");
//    }
//}

//@WebServlet("/AddToCartServlet")
//public class AddToCartServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Retrieve parameters from the request
//        int productId = Integer.parseInt(request.getParameter("productId"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        double price = Double.parseDouble(request.getParameter("price")); // Parse price as double
//
//        // Check the number of existing carts for the user
//        int userId = getUserIdFromSession(request); // Assuming you have a method to get user ID from session
//        int cartCount = DatabaseController.getCartCountForUser(userId);
//
//        if (cartCount >= 5) {
//            // If the user already has 5 carts, show a message
//            request.setAttribute("errorMessage", "You cannot insert more than 5 carts.");
//            request.getRequestDispatcher("/error.jsp").forward(request, response);
//            return;
//        }
//
//        // Create CartModel object with price
//        CartModel cartObj = new CartModel(productId, quantity, (int) price);
//
//        // Call AddToCart method with CartModel object
//        DatabaseController.AddToCart(cartObj);
//        
//        // Redirect the user to the cart page or any other page
//        response.sendRedirect("/pages/cart.jsp");
//    }
//
//    // Method to get user ID from session (Sample implementation)
// // Method to get user ID from session (Updated implementation)
//    private int getUserIdFromSession(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            Integer userIdObj = (Integer) session.getAttribute("productId");
//            if (userIdObj != null) {
//                return userIdObj.intValue(); // Return user ID if not null
//            }
//        }
//        return -1; // Return -1 if session or userId is null
//    }
//
//}

//public class AddToCartServlet extends HttpServlet {
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	   
//	        // Retrieve parameters from the request
//	        int productId = Integer.parseInt(request.getParameter("productId"));
//	        int quantity = Integer.parseInt(request.getParameter("quantity"));
//	        
//	        // Add the item to the cart
//	        CartModel cartObj = new CartModel(productId, quantity);
//	        DatabaseController.AddToCart(cartObj);
//	        
//	        // Redirect the user to the cart page or any other page
//	        response.sendRedirect("cart.jsp");
//	    
//	}
//
//}
