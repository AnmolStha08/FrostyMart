package controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/CartPathValidationServlet")
public class CartPathValidationServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(CartPathValidationServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userName") == null) {
            LOGGER.log(Level.INFO, "Session is null or username is not found. Redirecting to login page.");
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
            return;
        }

        String userName = (String) session.getAttribute("userName");
        LOGGER.log(Level.INFO, "User {0} is logged in. Redirecting to cart page.", userName);
        response.sendRedirect(request.getContextPath() + "/pages/cart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
