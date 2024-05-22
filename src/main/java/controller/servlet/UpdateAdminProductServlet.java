package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.ProductModel;
import util.StringUtil;


@WebServlet("/UpdateAdminProductServlet")
public class UpdateAdminProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        // Retrieve parameters from the request
	        int productID = Integer.parseInt(request.getParameter("productID"));
	        String productName = request.getParameter("productName");
	        String productDescription = request.getParameter("productDescription");
	        double productPrice = Double.parseDouble(request.getParameter("productPrice")); // Parse price as double
	        int productStock = Integer.parseInt(request.getParameter("productStock"));
	        String productCompany = request.getParameter("productCompany");
	        String productImage = request.getParameter("productImage");
	        String productColor = request.getParameter("productColor");
	        String productType = request.getParameter("productType");
	        String productCapacity = request.getParameter("productCapacity");
	        System.out.println(productID);
	        System.out.println(productDescription);
	        // Check for null values before parsing integers
	        if (productName != null && productDescription != null && productCompany != null
	                && productImage != null && productColor != null && productType != null && productCapacity != null) {
	            // Create ProductModel object with the provided details
	            ProductModel updateProduct = new ProductModel(productID, productName, productDescription, (float) productPrice,
	                    productCompany, productStock, productImage, productColor, productType,
	                    productCapacity);

	            // Call updateProduct method to update the product in the database
	            boolean updateSuccess = DatabaseController.updateProduct(updateProduct);

	            if (updateSuccess) {
	                // Product update successful
	                // Redirect the user to a success page or display a success message
//	                response.sendRedirect("/pages/adminProduct.jsp");
	            	 request.getRequestDispatcher(StringUtil.ADMIN_PRODUCT_LIST_PAGE).forward(request, response);
	            } else {
	                // Product update failed
	                // Redirect the user to an error page or display an error message
	                response.sendRedirect(StringUtil.ERROR_PRODUCT_MESSAGE);
	            }
	        } else {
	            // Handle the case where any required parameter is null
	            // Redirect the user to an error page or display an error message
	            response.sendRedirect(StringUtil.ERROR_PRODUCT_MESSAGE);
	        }
	    } catch (NumberFormatException e) {
	        // Handle the case where parseInt or parseDouble fails due to null or invalid input
	        // Redirect the user to an error page or display an error message
	        response.sendRedirect(StringUtil.ERROR_PRODUCT_MESSAGE);
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
