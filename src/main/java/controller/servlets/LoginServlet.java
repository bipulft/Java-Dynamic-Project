package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import util.StringUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.LOGIN_SERVLET})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	DatabaseController dbController = new DatabaseController();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
		this.dbController = new DatabaseController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    
	    // Check if the username exists in the database
	    boolean userExists = dbController.isExistingUser(username);

	    if (!userExists) {
	        // Username doesn't exist
	        response.sendRedirect(request.getContextPath() + "/pages/login.jsp?error=AccountDoesNotExist");
	        return; // stop further processing
	    }

	    // Username exists, check password
	    int result = dbController.getUserLoginInfo(username, password);

	    if (result == 1) {
	        // Customer login successful
	        HttpSession userSession = request.getSession();
	        userSession.setAttribute("username", username);
	        userSession.setMaxInactiveInterval(30*30);
	        
	        Cookie userCookie= new Cookie("user", username);
	        userCookie.setMaxAge(30*60);
	        response.addCookie(userCookie);
	        
	        response.sendRedirect(request.getContextPath() + "/pages/index.jsp");
	        
	    } else if (result == 2) {
	        // Admin login successful
	        HttpSession userSession = request.getSession();
	        userSession.setAttribute("username", username);
	        userSession.setMaxInactiveInterval(30*30);
	        
	        Cookie userCookie= new Cookie("user", username);
	        userCookie.setMaxAge(30*60);
	        response.addCookie(userCookie);
	        
	        response.sendRedirect(request.getContextPath() + "/pages/admin.jsp");
	        
	    } else {
	        // Incorrect password
	        response.sendRedirect(request.getContextPath() + "/pages/login.jsp?error=IncorrectPassword");
	        return; // stop further processing
	    }
	}

}
