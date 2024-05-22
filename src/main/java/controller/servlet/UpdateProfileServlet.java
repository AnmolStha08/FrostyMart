package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.UserModel;
import util.StringUtil;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve parameters from the request
            String userName = request.getParameter("userName");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            System.out.println(userName);
            System.out.println(phoneNumber);
            // Create a CartModel object with the retrieved values
            UserModel updatedprofile = new UserModel(userName, email, address, phoneNumber );
            
            // Update the cart details in the database
            boolean updateSuccess = DatabaseController.updateProfile(updatedprofile);
            
            if (updateSuccess) {
                // Redirect the user to a success page
            	 response.sendRedirect(request.getContextPath()+ "/pages/profile.jsp");
            } else {
                // Redirect the user to an error page
                response.sendRedirect("error.jsp");
            }
        } catch (NumberFormatException e) {
            // Handle the case where parseInt fails due to null or invalid input
            // Redirect the user to an error page or display an error message
            response.sendRedirect(StringUtil.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            // Handle the case where the database controller class is not found
            e.printStackTrace(); // You might want to log this error
            response.sendRedirect("error.jsp"); // Redirect the user to an error page
        }
    }
}
