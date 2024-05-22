package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import controller.DatabaseController;
import model.CartModel;

@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public cartServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve cart items from the database (you need to implement this method in your DatabaseController)
            List<CartModel> cartItems = getCartItemsFromDatabase();
            
            // Set cart items as an attribute in the request scope
            request.setAttribute("cartItems", cartItems);
            
            // Forward the request to cart.jsp
            request.getRequestDispatcher("${pageContext.request.contextPath}/pages/cart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Failed to fetch cart items");
        }
    }
    
    // Method to retrieve cart items from the database (you need to implement this method)
    private List<CartModel> getCartItemsFromDatabase() {
        // Call the appropriate method from your DatabaseController to fetch cart items from the database
        // For example:
        // return DatabaseController.getInstance().getCartItems();
        return null;
    }
}
