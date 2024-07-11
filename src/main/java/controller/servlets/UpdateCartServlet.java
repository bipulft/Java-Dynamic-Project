package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.CartModel;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/UpdateCartServlet" })
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
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
	    // get the product ID and new quantity from the request
	    String productId = request.getParameter("cart_id");
	    String product_quantity = request.getParameter("quantity"); // Use "quantity" instead of "product_quantity" for update
	    System.out.println("New Product Quantity: " + product_quantity);
	    
	    HttpSession hs = request.getSession();
	    // get the cart from the session
	    Cart cart = (Cart) request.getSession().getAttribute("cart");

	    // update the quantity of the cart item
	    for (CartModel cartItem : cart.getItems()) {
	        if (cartItem.getProduct().getProduct_id().equals(productId)) {
	            cartItem.setProduct_quantity(product_quantity);
	            break;
	        }
	    }

	    // update the cart in the session
	    request.getSession().setAttribute("cart", cart);
	    hs.setAttribute("credential", "Cart Product updated!!");

	    // redirect back to the cart page
	    response.sendRedirect(request.getContextPath() + "/pages/cart.jsp");
	}
}