package controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.CartofUserModel;

/**
 * Servlet implementation class DisplayCartServlet
 */
@WebServlet("/DisplayCartServlet")
public class DisplayCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user_Name = (String) request.getSession().getAttribute("username");
        if (user_Name != null) {
        	int userId = (int) session.getAttribute("userId");
    		List<CartofUserModel> CartDetails = dbController.getUserCartInfo(userId);
    		request.setAttribute("CartDetails", CartDetails);
    		request.getRequestDispatcher("/pages/cart.jsp").forward(request, response);
        }
        else {
        	System.out.println("user is not logged in");
            // Redirect to the login page
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
