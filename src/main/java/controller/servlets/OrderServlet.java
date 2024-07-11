package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.database.DatabaseController;
import model.OrderModel;
import util.StringUtils;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		int orderId = Integer.parseInt(request.getParameter(StringUtils.ORDER_ID));
		String customerName = request.getParameter(StringUtils.CUSTOMER_NAME);
		String orderDateString = request.getParameter(StringUtils.ORDER_DATE);
		LocalDate orderDate = LocalDate.parse(orderDateString);
		String customerAddress = request.getParameter(StringUtils.CUS_ADDRESS);
		String phone = request.getParameter(StringUtils.PHONE);
		String deliveryStatus = request.getParameter(StringUtils.DELIVERY);
		String payableAmount = request.getParameter(StringUtils.PAYABLE_AMT);
		String paymentMethod = request.getParameter(StringUtils.PAYMENT_METHOD);
		
		
		OrderModel orderModel = new OrderModel(customerName, orderDate, customerAddress, phone, deliveryStatus, payableAmount, paymentMethod);

		int result = dbController.order(orderModel);
	    
	    if (result > 0) {
	    	response.sendRedirect(request.getContextPath() + "/pages/orderSuccess.jsp");
	    } else {
	    	response.sendRedirect(request.getContextPath() + "/pages/checkout.jsp");
	    }

	}

}
