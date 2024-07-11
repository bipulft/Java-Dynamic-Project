package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.ProductModel;
import util.StringUtils;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DatabaseController dbController = new DatabaseController();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyServlet() {

		this.dbController = new DatabaseController();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	  
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String updateId = request.getParameter(StringUtils.UPDATE_ID);
		String deleteId = request.getParameter(StringUtils.DELETE_ID);

		if (updateId != null && !updateId.isEmpty()) {
			doPut(request, response);
		}
		if (deleteId != null && !deleteId.isEmpty()) {
			doDelete(request, response);
		}
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("put triggered");
		String productId = req.getParameter(StringUtils.UPDATE_ID);
		ProductModel products = dbController.getProductById(productId);

		req.setAttribute("product", products);
		req.getRequestDispatcher("/pages/productUpdate.jsp").forward(req, resp);

	}

//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("delete triggered");
//		if (dbController.deleteProductInfo(req.getParameter(StringUtils.DELETE_ID)) == 1) {
//			/*
//			 * req.setAttribute(StringUtils.MESSAGE_SUCCESS,
//			 * StringUtils.MESSAGE_SUCCESS_DELETE);
//			 */
//			resp.sendRedirect(req.getContextPath() + "/pages/admin.jsp");
//		} else {
//			req.setAttribute(StringUtils.ERROR_MESSAGE, "cannot delete the Product");
//			resp.sendRedirect(req.getContextPath() + "/ProductListServlet");
//		}
//	}

}
