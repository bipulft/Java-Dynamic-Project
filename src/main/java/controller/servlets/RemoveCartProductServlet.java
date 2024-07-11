package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

/**
 * Servlet implementation class RemoveCartProductServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RemoveCartProductServlet" })
public class RemoveCartProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCartProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("cart_id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        
        HttpSession hs = request.getSession();
        if (cart != null) {
            cart.removeItem(productId);
            hs.setAttribute("credential", "Product Removed from cart!!");
            response.sendRedirect(request.getContextPath() + "/pages/cart.jsp");
        }
		
	}	



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

}
}
