package controller.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import controller.database.DatabaseController;
import model.UserProfile;

@WebServlet(asyncSupported = true, urlPatterns = { "/UserProfileServlet" })
public class UserProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController();

    public UserProfileServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    	 // Retrieve username from cookies
    	String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        // Retrieve user profile based on username from the database
        UserProfile user = dbController.getUserByUsername(username);

        // Set user profile as an attribute in the request
        request.setAttribute("user", user);
        // Forward the request to the user profile page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/user-profile.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
