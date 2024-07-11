package util;

import java.io.File;

public class StringUtils {
	
	// Start SQL Queries
	// User Registration Queries
	public static final String INSERT_USER = "INSERT INTO user_info "
			+ "(first_name, last_name, username, dob, gender, phone_number, email_address, address, password, role, image)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 'customer', ?)";
	
	public static final String GET_LOGIN_USER_INFO = "SELECT username, password, role FROM user_info WHERE username = ?";
	
	public static final String GET_ALL_USER_INFO = "SELECT * FROM user_info";
	//added by bipul
	public static final String GET_ALL_USER_LIST = "SELECT first_name, last_name, username, dob, gender, address FROM user_info";
//	public static final String QUERY_GET_ALL_USERS = "SELECT * FROM user_info";//for image
	
	// Add Product Queries
	public static final String ADD_PRODUCT = "INSERT INTO product"
			+ "(product_id, product_name, unit_price, product_quantity, product_availability, vendor_id, image)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	// End SQL Queries
	
	public static final String INSERT_ORDER = "INSERT INTO orders"
			+ "(customerName, orderDate, customerAddress, phone, deliveryStatus, payableAmount, paymentMethod)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
	// Start User Info Parameter Names
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String USER_NAME = "username";
	public static final String BIRTHDAY = "birthday";
	public static final String GENDER = "gender";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String EMAIL = "email";
	public static final String ADDRESS = "address";
	public static final String PASSWORD = "password";
	public static final String RETYPE_PASSWORD = "retypePassword";
	// End Parameter Names
	
	// Start Adding Product Parameter Names
	public static final String PRODUCT_ID = "product_id";
	public static final String PRODUCT_NAME = "product_name";
	public static final String UNIT_PRICE = "unit_price";
	public static final String PRODUCT_QUANTITY = "product_quantity";
	public static final String PRODUCT_AVAILABILITY = "product_availability";
	public static final String VENDOR_ID = "vendor_id";
	// End Paramenter Names
	//order parameter names
	public static final String ORDER_ID = "orderId";
	public static final String CUSTOMER_NAME = "customerName";
	public static final String ORDER_DATE = "orderDate";
	public static final String CUS_ADDRESS = "customerAddress";
	public static final String PHONE = "phone";
	public static final String DELIVERY = "deliveryStatus";
	public static final String PAYABLE_AMT = "payableAmount";
	public static final String PAYMENT_METHOD = "paymentMethod";
	
	// Start Messages
	public static final String SUCCESS_REGISTER_MESSAGE = "Successfully Registered!";
	public static final String REGISTER_ERROR_MESSAGE = "Please correct the form data.";
	public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occured.";
	public static final String SUCCESS_MESSAGE = "successMessage";
	public static final String ERROR_MESSAGE = "errorMessage";
	public static final String USERNAME_ERROR_MESSAGE = "Username is already registered.";
	public static final String EMAIL_ERROR_MESSAGE = "Email is already registered";
	public static final String PHONE_NUMBER_ERROR_MESSAGE = "Phone number is already registered";
	public static final String PASSWORD_UNMATCHED_ERROR_MESSAGE = "Password is not matched";
	public static final String MESSAGE_SUCCESS_LOGIN = "Login in successful";
	public static final String LOGIN_ERROR_MESSAGE = "Login error";
	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Create an account";
	// End Messages
	
	// Start JSP Route
	public static final String LOGIN_PAGE = "/pages/login.jsp";
	public static final String REGISTER_PAGE = "/pages/registration.jsp";
	public static final String WELCOME_PAGE = "/pages/welcome.jsp";
//	public static final String IMAGE_DIR_USER = "Users/abinashyadav/eclipse-workspace/TimeKeepers/src/main/webapp/resources/images/user/";
//	public static final String IMAGE_DIR_SAVE_PATH = "" + File.separator + IMAGE_DIR_USER;
	
	//utils for product_image (bipul0
	public static final String IMAGE_DIR_PRODUCT = "C:\\Users\\acer\\timekeepers\\TimeKeepers\\src\\main\\webapp\\resources\\images\\product\\";
	public static final String IMAGE_DIR_SAVE_PATH = "" + File.separator + IMAGE_DIR_PRODUCT;
	
	public static final String IMAGE_DIR_USER = "C:\\Users\\acer\\timekeepers\\TimeKeepers\\src\\main\\webapp\\resources\\images\\user\\";
	public static final String IMAGE_DIR_SAVE_PATH_USER = "" + File.separator + IMAGE_DIR_USER;

	// End JSP Route
	
	// Start Servlet Route
	public static final String REGISTER_SERVLET = "/RegisterServlet";
	public static final String LOGIN_SERVLET = "/LoginServlet";
	public static final String ADD_PRODUCT_SERVLET = "/AddProductServlet";
	// End Servlet Route
	
	//added by bipul
	public static final String QUERY_DELETE_PRODUCT = "DELETE FROM product WHERE product_id = ?";
	public static final String UPDATE_USER_INFO = "UPDATE register SET name=?, "
            + "username=?, conatct_number=?, role=? WHERE username=?";
	
	//update product info
	public static final String UPDATE_PRODUCT_INFO = "UPDATE product SET product_name=?, unit_price=?, product_quantity=?, product_availability=?, vendor_id=? WHERE product_id=?";
	// User Profile Update Query
    public static final String UPDATE_USER_PROFILE = "UPDATE user_info SET first_name = ?, last_name = ?, dob = ?, gender = ?, phone_number = ?, email_address = ?, address = ? WHERE username = ?";
    // End SQL Queries
    
	public static final String DELETE_ID= "deleteId";
	public static final String UPDATE_ID= "updateId";

	public static final String GET_ALL_ORDER_LIST = "SELECT * FROM orders";

	public static final String SERVLET_URL_USER_DISPLAY = "/UserListServlet";

	public static final String SERVLET_PRODUCT = "/pages/productServlet";

	public static final String PRODUCT_LIST_PAGE = "/pages/productServlet";
	public static final String URL_INDEX =  "/index.jsp";
	public static final String SERVLET_URL_HOME = "/HomeServlet";
	public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
	public static final String SERVLET_URL_LOGIN = "/LoginServlet";
	public static final String SERVLET_URL_LOGOUT = "/LogoutServlet";
	public static final String PAGE_URL_REGISTER = "/pages/registration.jsp";
	public static final String SERVLET_URL_REGISTER = "/RegisterServlet";
	public static final String USERNAME = "username";
}