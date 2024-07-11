package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.ProductModel;

/**
 * Servlet implementation class findProduct
 */
@WebServlet("/findProductServlet")
public class findProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DatabaseController dbController = new DatabaseController();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Add functionality to handle GET requests
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String product_name = request.getParameter("search");
				//System.out.print("Hellooo!!!");

			        // perform the search operation
				    ProductModel DatabaseController = new ProductModel();
			        List<ProductModel> productList = dbController.searchProductByName(product_name);

			        // set the search results as an attribute in the request
			        request.setAttribute("productList", productList);

			        // forward the request to the JSP page to display the search results
			        request.getRequestDispatcher("/pages/product.jsp").forward(request, response);
					/*
					 * if (Dispatcher != null) { dispatcher.forward(request, response); } else { //
					 * Handle the case where the dispatcher is null (e.g., log an error, show a
					 * custom error page) response.getWriter().
					 * println("Error: Unable to dispatch request to the JSP page."); }
					 */
	}

}
