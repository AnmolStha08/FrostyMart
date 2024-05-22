package controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println(userName);
        DatabaseController dao = new DatabaseController();

        if (dao.loginUser(userName, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userName);
            session.setMaxInactiveInterval(3 * 60); // Session expires after 30 minutes

            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(3 * 60); // Cookie expires after 30 minutes
            response.addCookie(userCookie);
            session.setAttribute("userName", userName);
            int userId = dao.getUserIdSession(userName);
            session.setAttribute("userId", userId);
            if(userName.toLowerCase().equals("admin")) {
                response.sendRedirect(request.getContextPath()+ "/pages/adminDashboard.jsp");
            } else {
                response.sendRedirect(request.getContextPath()+ "/pages/home.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp?error=1");
            System.out.println("Something is wrong");
        }
    }
}
