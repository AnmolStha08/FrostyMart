package controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductModel;
import controller.DatabaseController;

@WebServlet("/ProductDisplayServlet")
public class ProductDisplayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Instantiate the DatabaseController
        DatabaseController dbController = new DatabaseController();
        
        // Retrieve products from the database
        ArrayList<ProductModel> products = dbController.getProducts();
        
        // Set products as request attribute with the correct name
        request.setAttribute("products", products);
        
        // Forward to product display JSP
        request.getRequestDispatcher("product_display.jsp").forward(request, response);
    }
}

