package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.UserProfile;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/UpdateProfileServlet" })
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DatabaseController dbController = new DatabaseController();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String dobString = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // Parse Date of Birth string to LocalDate
        LocalDate dob = null;
        try {
            dob = LocalDate.parse(dobString);
        } catch (DateTimeParseException e) {
            // Handle parsing error
            e.printStackTrace();
        }

        // Create a new UserProfile object with updated data
        UserProfile updatedProfile = new UserProfile();
        updatedProfile.setFirstName(firstName);
        updatedProfile.setLastName(lastName);
        updatedProfile.setUsername(username);
        updatedProfile.setDob(dob); // Set parsed Date of Birth
        updatedProfile.setGender(gender);
        updatedProfile.setPhoneNumber(phoneNumber);
        updatedProfile.setEmail(email);
        updatedProfile.setAddress(address);

        // Update user profile in the database
        boolean success = dbController.updateUserProfile(updatedProfile);

        // Redirect to user profile page
        if (success) {
            try {
                response.sendRedirect(request.getContextPath() + "/UserProfileServlet");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
