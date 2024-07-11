package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import util.StringUtils;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final DatabaseController dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        this.dbController = new DatabaseController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete triggered");
		if (dbController.deleteProductInfo(req.getParameter(StringUtils.DELETE_ID)) == 1) {
			/*
			 * req.setAttribute(StringUtils.MESSAGE_SUCCESS,
			 * StringUtils.MESSAGE_SUCCESS_DELETE);	
			 */
			resp.sendRedirect(req.getContextPath() + "/pages/admin.jsp");
		} else {
			req.setAttribute(StringUtils.ERROR_MESSAGE, "cannot delete the Product");
			resp.sendRedirect(req.getContextPath() + "/ProductListServlet");
		}
	}

}
