package controller.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import controller.DatabaseController;
import util.StringUtil;

import java.io.*;
import java.util.*;

@WebServlet(urlPatterns = "/DeleteAdminProductServlet")
public class DeleteAdminProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the cart item ID from the request parameter
        String productId = request.getParameter("productID");

        // Call a method to delete the cart item from the database
        boolean deletionSuccessful = true;
		try {
			deletionSuccessful = DatabaseController.deleteProduct(productId);
		} catch (ClassNotFoundException e) {
			// Print stack trace for debugging purposes
			e.printStackTrace();
            deletionSuccessful = false;
		}

        // Set response content type
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Prepare the message
        String message;
        if (deletionSuccessful) {
            message = "Product item with ID " + productId + " deleted successfully";
        } else {
            message = "Failed to delete product item with ID " + productId;
        }

        // Write the message as the response
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('" + message + "');");
        out.println("window.location.href='" + request.getContextPath() + "/pages/adminProduct.jsp';");
        out.println("</script>");
    }
}
