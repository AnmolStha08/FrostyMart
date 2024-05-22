package util;

import java.io.File;

public class StringUtil {
//	user query
	public static final String GET_LOGIN_STUDENT_INFO = "SELECT * FROM USER WHERE user_Name = ?";
	public static final String GET_USERNAME = "SELECT COUNT(*) FROM USER WHERE user_Name = ?";
	public static final String GET_PHONE = "SELECT COUNT(*) FROM USER WHERE phone_number = ?";
	public static final String GET_EMAIL = "SELECT COUNT(*) FROM USER WHERE email = ?";
	public static final String GET_ALL_STUDENTS = "SELECT * FROM USER";
	
	
	public static final String INSERT_USER = "INSERT INTO USER " 
			+ "(user_Name, first_Name, last_Name, gender, email, address, phone_Number, password) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;
	public static final String GETUSERID = "Select User_Id from user where user_Name =?";
	public static final String SELECT_USER = " SELECT * FROM USER";
	public static final String GET_LOGIN_USER_INFO = "SELECT * FROM USER WHERE user_Name = ?";
	public static final String UPDATE_PROFILE=" UPDATE user SET email=?, address=?, phone_Number=? where user_Name=?";
//	product query
	public static final String INSERT_PRODUCT = "INSERT INTO product" 
			+"(product_Name, product_Description, product_Price, product_Company, product_Stock, product_Image, product_Color, product_Type, product_Capacity)"
			+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String get_Search_Products="SELECT * FROM PRODUCT WHERE productName LIKE ? OR p.description LIKE ?";
	public static final String select_Products="SELECT * FROM product";
	
	public static final String DELETE_PRODUCT = "delete from product where product_Id =?";
	
	public static final String select_Orders="SELECT * FROM orders";
	public static final String INSERT_INTO_ORDERS="INSERT INTO orders "
			+ "(order_Quantity, order_Total, order_Status, user_Id, product_Id)"
			+ "VALUES(?, ?, ?, ?, ?) ";
//			"INSERT INTO ORDERS"
//			+"(order_Quantity, order_Status, order_Total, "
////			+ "user_Id, product_Id"
//			+"values(?,?,?)";
//	feedback query
	public static final String INSERT_feedback = "INSERT INTO feedback" 
			+ "(user_Name, email, subject, feedback_Description)"
			+ "Values(?, ?, ?, ?)" ;
	public static final String SELECT_FEEDBACK = "SELECT * FROM feedback";
	    // Add more SQL queries as needed
	//query to get the cart info of a user
	public static final String GET_USER_CART_DETAILS= "SELECT c.cart_Id, c.product_Id, c.user_Id, p.product_Name, p.product_Image, c.quantity, c.price "
			+ "FROM carts c JOIN product p "
			+ "ON c.product_Id = p.product_Id WHERE c.user_Id = ?";	
//	cart query
	public static final String ADD_TO_CART = "INSERT INTO CARTS "
			  +"(product_Id, user_Id, quantity) "
			  + "VALUES (?,?,?)";
	public static final String INSERT_TO_CART = "INSERT INTO carts "
	        + "(product_Id, quantity, price, user_Id) "
	        + "VALUES (?, ?, ?, ?)";
	public static final String UPDATE_CART_DETAILS="UPDATE carts SET quantity = ? WHERE cart_Id= ?";

//	product_Id=?, user_Id = ?, price = ?
			
	public static final String SELECT_CART = "SELECT * FROM CARTS WHERE user_Id=?";
	public static final String DELETE_CART = "delete from carts where cart_Id=?";
	public static final String get_cart_product_details = "SELECT c.cart_Id,p.product_Id,p.product_Img,p.product_Name,c.quantity,p.product_Price,p.product_Description,p.product_Company FROM cart as c left join product as p"
			+ " on c.product_Id=p.product_Id where c.cart_Id=?";
//	public static final String UPDATE_PRODUCT_DETAILS = "UPDATE product SET product_Id = ?, " 
//			+ " product_Name = ?, product_Description = ?, product_Price = ?, product_Company = ?, " 
//			+" product_Stock = ?, product_Image = ?,  product_Color = ?, product_Type = ?,  product_Capacity = ? " 
//			+"WHERE product_Id = ?";
	public static final String UPDATE_PRODUCT_DETAILS = "UPDATE product "
	        + "SET product_Name = ?, "
	        + "product_Description = ?, "
	        + "product_Price = ?, "
	        + "product_Company = ?, "
	        + "product_Stock = ?, "
	        + "product_Image = ?, "
	        + "product_Color = ?, "
	        + "product_Type = ?, "
	        + "product_Capacity = ? "
	        + "WHERE product_Id = ?";

//Start JSP Route
	public static final String Home_PAGE = "/pages/home.jsp";
	public static final String REGISTER_PAGE = "/pages/register.jsp";
	public static final String FEEDBACK_PAGE = "/pages/feedback.jsp";
	public static final String ADMIN_FEEDBACK_PAGE = "/pages/adminFeedback.jsp";
	public static final String CART_PAGE = "/pages/cart.jsp";
	public static final String LOGIN_PAGE="/pages/login.jsp";
	public static final String HOME_PAGE="/pages/home.jsp";
	public static final String PRODUCT_PAGE="/pages/product.jsp";
	public static final String ADMIN_PRODUCT_LIST_PAGE="/pages/adminProduct.jsp";
	// End JSP Route
	
	// Start Servlet Route
	public static final String REGISTER_SERVLET = "/RegisterServlet";
	public static final String LOGIN_SERVLET = "/LoginServlet";
	public static final String ADD_PRODUCT_SERVLET = "/AddProductServlet";
	public static final String FEEDBACK_SERVLET = "/feedbackServlet";
	public static final String ADD_TO_CART_SERVLET = "/AddToCartServlet";
	public static final String DELETE_CART_SERVLET = "/DeleteCartServlet	";
//	public static final String ADMIN_PRODUCT_LIST_PAGE=
//	public static final String CART_U_NL = "/cart_nl_servlet";
//	public static final String delete_cart_item = "/delete_c_i_servlet";
//	public static final String order_cart_item = "/order_c_i_servlet";
	// End Servlet Route

	// Start login page message
	public static final String SUCCESS_LOGIN_MESSAGE = "Successfully LoggedIn!";
	public static final String ERROR_LOGIN_MESSAGE = "Either username or password is not correct!";
	// End login page message
	public static final String SUCCESS_MESSAGE = "successMessage";
	public static final String ERROR_MESSAGE = "errorMessage";
	public static final String ERROR_PRODUCT_MESSAGE = "product detail didnot change";
	// End string messages 
	
	// Start register page messages
		public static final String SUCCESS_REGISTER_MESSAGE = "Successfully Registered!";
		public static final String ERROR_REGISTER_MESSAGE = "Please correct the form data.";
		public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occurred.";
		public static final String USERNAME_ERROR_MESSAGE = "Username is already registered.";
		public static final String EMAIL_ERROR_MESSAGE = "Email is already registered.";
		public static final String PHONE_NUMBER_ERROR_MESSAGE = "Phone Number is already registered.";
		public static final String PASSWORD_UNMATCHED_ERROR_MESSAGE = "Password not matched.";
		// End register page messages

		public static final String PRODUCT_PIC_DIR = "\\Users\\anmol\\eclipse-workspace\\Fridge_Shop\\src\\main\\webapp\\Uploads\\Products\\";
		public static final String PRODUCT_PIC_SAVE_DIR = "C:" + File.separator + PRODUCT_PIC_DIR;


}