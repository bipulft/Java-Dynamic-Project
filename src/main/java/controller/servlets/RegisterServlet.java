package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DatabaseController;
import model.UserModel;
import util.StringUtils;

/**
 * Servlet implementation class RegisterServlet
 * 
 * @author Abinash Yadav (22067491)
 * 
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.REGISTER_SERVLET})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DatabaseController dbController = new DatabaseController();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		// doGet(request, response);
		String firstName = request.getParameter(StringUtils.FIRST_NAME);
		String lastName = request.getParameter(StringUtils.LAST_NAME);
		String username = request.getParameter(StringUtils.USER_NAME);
		String dobString = request.getParameter(StringUtils.BIRTHDAY);
		LocalDate dob = LocalDate.parse(dobString);
		String gender = request.getParameter(StringUtils.GENDER);
		String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
		String email = request.getParameter(StringUtils.EMAIL);
		String address = request.getParameter(StringUtils.ADDRESS);
		String password = request.getParameter(StringUtils.PASSWORD);
		String retypePassword = request.getParameter(StringUtils.RETYPE_PASSWORD);
		Part imagePart = request.getPart("image");

	    // Validation 1: Name Format Validation
	    if (!firstName.matches("[a-z A-Z]+") || !lastName.matches("[a-z A-Z]+")) {
	        // Handle invalid name format
	        // Example: return an error response or redirect to registration page with an error message
	        response.sendRedirect(request.getContextPath() + "/pages/registration.jsp?error=invalidNameFormat");
	        return;
	    }

	    // Validation 2: Minimum Username Length Requirement
	    if (username.length() < 6 || !username.matches("[a-zA-Z0-9]+")) {
	        // Handle invalid username
	        // Example: return an error response or redirect to registration page with an error message
	        response.sendRedirect(request.getContextPath() + "/pages/registration.jsp?error=invalidUsername");
	        return;
	    }

	    // Validation 3: Birthday Date Restriction
	    LocalDate currentDate = LocalDate.now();
	    if (dob.isAfter(currentDate)) {
	        // Handle invalid birthday
	        // Example: return an error response or redirect to registration page with an error message
	        response.sendRedirect(request.getContextPath() + "/pages/registration.jsp?error=futureBirthDate");
	        return;
	    }

	    // Validation 4: Phone Number Format Requirement
	    if (!phoneNumber.matches("\\+[0-9]{13}")) {
	        // Handle invalid phone number format
	        // Example: return an error response or redirect to registration page with an error message
	        response.sendRedirect(request.getContextPath() + "/pages/registration.jsp?error=invalidPhoneNumberFormat");
	        return;
	    }

	    // Validation 5: Password Complexity Requirement
	    if (!password.matches("^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z]).{6,}$")) {
	        // Handle invalid password
	        // Example: return an error response or redirect to registration page with an error message
	        response.sendRedirect(request.getContextPath() + "/pages/registration.jsp?error=invalidPasswordFormat");
	        return;
	    }

	    // Ensure password and retype password match
	    if (!password.equals(retypePassword)) {
	        // Handle password mismatch
	        // Example: return an error response or redirect to registration page with an error message
	        response.sendRedirect(request.getContextPath() + "/pages/registration.jsp?error=passwordMismatch");
	        return;
	    }

	    // Validation 6: Data Duplication identification Requirement
	    // Check if username already exists in the database
	    if (dbController.isExistingUser(username)) {
	        // Handle data duplication
	        // Example: return an error response or redirect to registration page with an error message
	        response.sendRedirect(request.getContextPath() + "/pages/registration.jsp?error=userName_notAvailable");
	        return;
	    }
	    
	    // Check if email already exists in the database
	    if (dbController.isExistingEmail(email)) {
	        // Handle data duplication
	        // Example: return an error response or redirect to registration page with an error message
	        response.sendRedirect(request.getContextPath() + "/pages/registration.jsp?error=emailAlreadyUsed");
	        return;
	    }

	    // Check if phone number already exists in the database
	    if (dbController.isExistingNumber(phoneNumber)) {
	        // Handle data duplication
	        // Example: return an error response or redirect to registration page with an error message
	        response.sendRedirect(request.getContextPath() + "/pages/registration.jsp?error=phoneNumberAlreadyUsed");
	        return;
	    }


	    // If all validations pass, proceed with registration
	    UserModel userModel = new UserModel(firstName, lastName, username, dob, gender, phoneNumber, email, address, password, imagePart);
	    String savePath = StringUtils.IMAGE_DIR_SAVE_PATH_USER;
        String fileName = userModel.getImageUrlFromPart();
        if(!fileName.isEmpty() && fileName != null) {
            imagePart.write(savePath + fileName);
        }
	    
	    int result = dbController.addUser(userModel);
	    
	    if (result == 1) {
	    	request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_REGISTER_MESSAGE);
	        response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
	    } else if (result == 0) {
	        // Redirect to the same register page with form data mistake
	    	request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.REGISTER_ERROR_MESSAGE);
	        request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
	    } else {
	        // Redirect to the same register page with server error
	    	request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
	        request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
	    }
	}
}
