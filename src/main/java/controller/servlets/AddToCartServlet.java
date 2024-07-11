package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import model.Cart;
import model.ProductModel;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    DatabaseController dbController = new DatabaseController();
       
    public AddToCartServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("product_id");
        String product_quantity = request.getParameter("quantity");
        // Update parameter name to match form input name

        System.out.println("Product ID: " + productId);
        System.out.println("Product Quantity: " + product_quantity);
        // Use the existing DatabaseController instance to fetch the product from the database
        ArrayList<ProductModel> products = dbController.getAllProductInfo(); 
        
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        if (products != null && !products.isEmpty()) {
            for (ProductModel product : products) {
                // Assuming product_quantity is defined somewhere
                cart.addItem(product.getProduct_id(), product_quantity);
            }
            session.setAttribute("credential", "Products added to cart!!");
        } else {
            // Handle the case where the products do not exist
            session.setAttribute("credential", "No products found!!");
        }

        // Redirect to cart.jsp
        response.sendRedirect(request.getContextPath() + "/pages/cart.jsp");
    }
}
