package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.ProductModel;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Getting all products");
		List<ProductModel> productList = dbController.getAllProductInfo();
		request.setAttribute("productList", productList); //request: index mah list lai pathauney kaam garcha
		
		//current role,
		//if admin
		request.getRequestDispatcher("/pages/admin.jsp").forward(request, response);
		
		//else, product
		// Check if the user is an admin
//		if (isAdmin) {
//		    // Forward to the admin page
//		    request.getRequestDispatcher("/pages/admin.jsp").forward(request, response);
//		} else {
//		    // Forward to the product page
//		    request.getRequestDispatcher("/pages/product.jsp").forward(request, response);
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
