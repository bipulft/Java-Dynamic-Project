package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DatabaseController;
import model.ProductModel;
import model.UserModel;
import util.StringUtils;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final DatabaseController dbController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        this.dbController = new DatabaseController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		
		String productId = request.getParameter("product_id");
	    System.out.println("UpdateProductServlet product_id: " + productId);
	    ProductModel product = dbController.getProductById(productId);

	    request.setAttribute("product", product);
	    request.getRequestDispatcher("/pages/productUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("update-product-name");
		String price = request.getParameter("update-product-price");
		String quantity = request.getParameter("update-product-quantity");
		String availability = request.getParameter("update-product-availability");
		String vendorId = request.getParameter("update-product-vendor");
		String id = request.getParameter("update-product-id");
//		String imagePart = request.getParameter("image");
//		
		ProductModel product = new ProductModel();
//		product.setProduct_id(id);
		product.setProduct_name(name);
		product.setUnit_price(price);
		product.setProduct_quantity(quantity);
		product.setProduct_availability(availability);
		product.setVendor_id(vendorId);
		product.setProduct_id(id);
//		product.setImageUrlFromPart(imagePart);
		
		int result = dbController.updateProductInfo(product);
		response.sendRedirect(request.getContextPath() + "/ProductListServlet");
	}

}
