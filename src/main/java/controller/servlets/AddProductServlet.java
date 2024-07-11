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
import util.StringUtils;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String product_id = request.getParameter(StringUtils.PRODUCT_ID);
		String product_name = request.getParameter(StringUtils.PRODUCT_NAME);
		String unit_price = request.getParameter(StringUtils.UNIT_PRICE);
		String product_quantity = request.getParameter(StringUtils.PRODUCT_QUANTITY);
		String product_availability = request.getParameter(StringUtils.PRODUCT_AVAILABILITY);
		String vendor_id = request.getParameter(StringUtils.VENDOR_ID);
		Part imagePart = request.getPart("image");

	
	    // If all validations pass, proceed with registration
		ProductModel productModel = new ProductModel(product_id, product_name, unit_price, product_quantity, product_availability, vendor_id, imagePart);
		
		String savePath = StringUtils.IMAGE_DIR_SAVE_PATH;
	    String fileName = productModel.getImageUrlFromPart();
	    if(!fileName.isEmpty() && fileName != null)
    		imagePart.write(savePath + fileName);
		
		int result = dbController.addProduct(productModel);
	    
	    if (result > 0) {
	    	response.sendRedirect(request.getContextPath() + "/pages/admin.jsp");
	    } else {
	    	response.sendRedirect(request.getContextPath() + "/pages/product_addition.jsp");
	    }
	}
}
