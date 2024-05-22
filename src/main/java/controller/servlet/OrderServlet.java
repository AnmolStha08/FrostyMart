package controller.servlet;

//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import controller.DatabaseController;
//import model.OrderModel;
//import util.StringUtil;
//
//@WebServlet("/OrderServlet")
//public class OrderServlet extends HttpServlet {
////    private static final long serialVersionUID = 1L;
////    private static final String USER_ID_PARAM = "userId";
////    private static final String PRODUCT_ID_PARAM = "productId";
////    private static final String ORDER_QUANTITY_PARAM = "orderQuantity";
////    private static final String ORDER_STATUS_PARAM = "orderStatus";
////    private static final String ORDER_TOTAL_PARAM = "orderTotal";
////    System.out.println(ORDER_QUANTITY_PARAM);
////    
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String userIdParam = request.getParameter("userId");
//        if (userIdParam != null && !userIdParam.isEmpty()) {
//            int userId = Integer.parseInt(userIdParam);
//            int productId = Integer.parseInt(request.getParameter("productId"));
//            int orderQuantity = Integer.parseInt(request.getParameter("orderQuantity"));
//            String orderStatus = request.getParameter("orderStatus");
//            double orderTotal = Double.parseDouble(request.getParameter("orderTotal"));
//            System.out.println(productId);
//            System.out.println(orderQuantity);
//            OrderModel orderObj = new OrderModel(orderQuantity, orderStatus,(int) orderTotal, userId, productId );
//
//            DatabaseController.AddToOrder(orderObj); // Method name changed to follow conventions
//        } else {
//            response.sendRedirect(StringUtil.LOGIN_PAGE);
//        }
//    }
//}

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.OrderModel;
import util.StringUtil;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
    	int userId = Integer.parseInt(request.getParameter("userId"));    	
    	int productId = Integer.parseInt(request.getParameter("productId"));
        int orderQuantity = Integer.parseInt(request.getParameter("orderQuantity"));
        String orderStatus = request.getParameter("orderStatus");
        double orderTotal =  Double.parseDouble(request.getParameter("orderTotal"));
       System.out.println(userId);

                // Create OrderModel object
                OrderModel orderObj = new OrderModel(orderQuantity, orderStatus, orderTotal, userId, productId);

                // Call AddToOrder method with OrderModel object
                DatabaseController.AddToOrder(orderObj);
                request.getRequestDispatcher(StringUtil.PRODUCT_PAGE).forward(request, response);
            }

}
