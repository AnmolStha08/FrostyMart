package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Feedback;
import util.StringUtil;
import controller.DatabaseController;

//@WebServlet("/feedbackServlet")
@WebServlet(asyncSupported = true, urlPatterns = StringUtil.FEEDBACK_SERVLET)
public class feedbackServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String feedbackDescription = request.getParameter("feedbackDescription");
		Feedback feedbackObj = new Feedback(userName, email, subject, feedbackDescription);
////		System.out.print(request.getParameter("feedback_Description"));
//		DatabaseController.saveFeedback(feedbackObj);
//		// Redirect back to the same page after submission
////		response.sendRedirect(request.getContextPath() + "/aboutus.html");
//		
		 boolean feedbackStored = DatabaseController.saveFeedback(feedbackObj);

		    response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();

		    // Write the JavaScript code to display the alert only if feedback was stored successfully
		    if (feedbackStored) {
		        out.println("<script type=\"text/javascript\">");
		        out.println("alert('Feedback submitted successfully!');");
		        out.println("window.location.href='" + request.getContextPath() + "${pageContext.request.contextPath}/pages/feedback.jsp");
		        out.println("</script>");
		    } else {
		        // If feedback storage failed, you can handle it here
		        // For example, you can display an error message or redirect to an error page
		        out.println("<script type=\"text/javascript\">");
		        out.println("alert('Failed to store feedback. Please try again later.');");
		        out.println("window.location.href='" + request.getContextPath() + "${pageContext.request.contextPath}/pages/feedback.jsp");
		        out.println("</script>");
		    }
	}
}