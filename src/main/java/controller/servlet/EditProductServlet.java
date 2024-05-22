package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.DatabaseController;
import model.ProductModel;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve the updated product information from the form
	    int productID = Integer.parseInt(request.getParameter("productID"));
	    String productName = request.getParameter("productName");
	    String description = request.getParameter("productDescription"); // Corrected parameter name
	    int price = Integer.parseInt(request.getParameter("productPrice")); // Corrected parameter name
	    String company = request.getParameter("productCompany"); // Corrected parameter name
	    int stock = Integer.parseInt(request.getParameter("productStock")); // Corrected parameter name
	    String color = request.getParameter("productColor"); // Corrected parameter name
	    String type = request.getParameter("productType"); // Corrected parameter name
	    String capacity = request.getParameter("productCapacity"); // Corrected parameter name
	    String image = request.getParameter("productImage"); // Corrected parameter name

	    // Create a ProductModel object with the updated information
	    ProductModel product = new ProductModel();
	    product.setProductID(productID);
	    product.setProductName(productName);
	    product.setProductDescription(description);
	    product.setProductPrice(price);
	    product.setProductCompany(company);
	    product.setProductStock(stock);
	    product.setProductColor(color);
	    product.setProductType(type);
	    product.setProductCapacity(capacity);
	    product.setProductImage(image);

	    // Instantiate the DatabaseController
	    DatabaseController db = new DatabaseController();

	    // Update the product in the database
	    boolean success = false;
	    try {
	        success = db.updateProduct(product);
	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	    // Redirect back to the product list page
	    if (success) {
	        response.sendRedirect("adminProduct.jsp");
	    } else {
	        // Handle failure
	        response.getWriter().println("Failed to update product.");
	    }
	}

}
