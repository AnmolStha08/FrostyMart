package controller.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import controller.DatabaseController;
import util.StringUtil;

import java.io.*;
import java.util.*;

@WebServlet(urlPatterns = "/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the cart item ID from the request parameter
        String cartId = request.getParameter("cartId");
        System.out.println(cartId);        // Call a method to delete the cart item from the database
        boolean deletionSuccessful = true;
		try {
			deletionSuccessful = DatabaseController.deleteCartItem(cartId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Send response indicating success or failure
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Write the JavaScript code to display the alert
        out.println("<script type=\"text/javascript\">");
        if (deletionSuccessful) {
            out.println("alert('Product item with ID " + cartId + " deleted successfully');");
        } else {
            out.println("alert('Failed to delete product item with ID " + cartId + "');");
        }
        out.println("window.location.href='" + request.getContextPath() + "/pages/cart.jsp';");
        out.println("</script>");
    }
}
