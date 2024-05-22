package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import controller.DatabaseController;
import model.ProductModel;
import util.StringUtil;
import controller.DatabaseController;

@WebServlet(asyncSupported = true, urlPatterns = { "/AddProductServlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
                 maxFileSize = 1024 * 1024 * 50,
                 maxRequestSize = 1024 * 1024 * 100)
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController();

    public AddProductServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("productName");
        String description = request.getParameter("productDescription");
        float price = 0.0f;
        if (request.getParameter("productPrice") != null) {
            price = Float.parseFloat(request.getParameter("productPrice"));
        }
        int quantity = 0;
        if (request.getParameter("productStock") != null) {
            quantity = Integer.parseInt(request.getParameter("productStock"));
        }
        String company = request.getParameter("productCompany");
        String color = request.getParameter("productColor");
        String type = request.getParameter("productType");
        String capacity = request.getParameter("productCapacity");
        Part uploadedImage = request.getPart("productImage");
        
        
        ProductModel product = new ProductModel(name, description, price, company, quantity, uploadedImage, color, type, capacity);
        String savePath = StringUtil.PRODUCT_PIC_SAVE_DIR;
        String fileName = product.getProductImage();
        int result = dbController.addProduct(product);
        try {
		    if (fileName != null && !fileName.isEmpty()) {
		    	uploadedImage.write(savePath + fileName);
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		    // Handle the exception appropriately (e.g., log it, return an error message, etc.)
		}
		 if (result == 1) {
		        request.setAttribute("successMessage", "Product added successfully!");
		    } else {
		        request.setAttribute("errorMessage", "Error occurred while adding product.");
		    }
		    
		    // Forward the request to your JSP
		    request.getRequestDispatcher("pages/addProduct.jsp").forward(request, response);
	}
        
    }

