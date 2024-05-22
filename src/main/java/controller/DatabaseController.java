package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Feedback;
import model.OrderModel;
//import model.PasswordEncryptionWIthAes;
import model.ProductModel;
import model.UserModel;
import model.CartItem;
import model.CartModel;
import model.CartofUserModel;
import util.StringUtil;


public class DatabaseController {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/frostymart";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }
public boolean addUser(UserModel user) {
		
		try(Connection con = getConnection()) {
			
			String query = "INSERT INTO user (user_Name,first_Name, last_Name, email, address, phone_Number, password) values(?,?,?,?,?,?,?)";
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1, user.getUserName());
			st.setString(2, user.getFirstName());
			st.setString(3, user.getLastName());
			st.setString(4, user.getEmail());
			st.setString(5, user.getAddress());
			st.setString(6, user.getPhoneNumber());
			st.setString(7, user.getPassword());
			
			st.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean loginUser(String userName, String password) {
	    try (Connection con = getConnection()) {
	        String query = "SELECT * FROM user WHERE user_Name = ? AND password = ?";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setString(1, userName);
	        st.setString(2, password);
	        
	        ResultSet rs = st.executeQuery();

	        if (rs.next()) {
	            return true;
	        } else {
	           
	            return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public static int AddUser(UserModel user) {
	    Connection conn = null;
	    PreparedStatement stmt = null;

	    try {
	        // Get connection
	        conn = getConnection();

	        // Prepare statement
	        String sql = StringUtil.INSERT_USER;
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, user.getUserName());
	        stmt.setString(2, user.getFirstName());
	        stmt.setString(3, user.getLastName()); 
	        stmt.setString(4, user.getGender());
	        stmt.setString(5, user.getEmail()); 
	        stmt.setString(6, user.getAddress());
	        stmt.setString(7, user.getPhoneNumber());
	        stmt.setString(8, user.getPassword()); 
	        System.out.println(user.getGender());
	        // Execute update
	        stmt.executeUpdate();
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        // Close connections
	        try {
	            if (stmt != null)
	                stmt.close();
	            if (conn != null)
	                conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return 0;
	}

    public UserModel getUserByName(String userName) {
		UserModel user = null;
		try(Connection con = getConnection()) {
			String query = "SELECT * FROM user where user_Name = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, userName);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				user = new UserModel();
				user.setUserName(rs.getString("user_Name"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setPhoneNumber(rs.getString("phone_Number"));
				user.setPassword(rs.getString("password"));
               
			}
			
			return user;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return user;
	} 
    public UserModel getUserByEmail(String userName) {
    	UserModel user = null;
    	try(Connection con = getConnection()) {
    		String query = "SELECT * FROM user where user_Name = ?";
    		PreparedStatement st = con.prepareStatement(query);
    		st.setString(1, userName);
    		ResultSet rs = st.executeQuery();
    		if(rs.next()) {
    			user = new UserModel();
    			user.setUserName(rs.getString("userName"));
    			user.setEmail(rs.getString("email"));
    			user.setAddress(rs.getString("address"));
    			user.setPhoneNumber(rs.getString("phoneNumber"));
    			user.setPassword(rs.getString("password"));
                
    		}
    		
    		return user;
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	}
    	
    	
    	
    	return user;
    }
    public static boolean updateProfile(UserModel profile) throws ClassNotFoundException {
		// TODO Auto-generated method stub
    	try (Connection conn =getConnection()) {
            String sql = StringUtil.UPDATE_PROFILE;
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, profile.getEmail());
            stmt.setString(2, profile.getAddress());
            stmt.setString(3, profile.getPhoneNumber());
            stmt.setString(4, profile.getUserName());
           
            
            
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
		
	}
    public int getUserIdSession(String userName) {
	    int userId = -1; // Default value if no user is found
	    try (Connection con = getConnection()) {
	        PreparedStatement statement = con.prepareStatement(StringUtil.GETUSERID);
	        statement.setString(1, userName); // Set the user_name parameter
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	        	userId = resultSet.getInt(1);
	            System.out.println("user_Id = " + userId);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	}
	    return userId;
    }

    public List<OrderModel> getUserOrdersByUsername(String username) {
        List<OrderModel> userOrders = new ArrayList<>();
        try (Connection con = getConnection()) {
            String query = "SELECT * FROM orders o JOIN user u ON o.user_Id = u.user_Id WHERE u.user_Name = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.setOrderId(rs.getInt("order_Id"));
                order.setOrderQuantity(rs.getInt("order_Quantity"));
                order.setOrderStatus(rs.getString("order_Status"));
                order.setOrderTotal(rs.getDouble("order_Total"));
                // Assuming you have an OrderModel with appropriate setters
                userOrders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return userOrders;
    }

    public List<OrderModel> getUserOrders(int userId) throws ClassNotFoundException {
        List<OrderModel> orders = new ArrayList<>();
        try (Connection con = getConnection()) {
            String query = "SELECT * FROM orders WHERE user_Id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.setOrderId(rs.getInt("order_Id"));
                order.setProductId(rs.getInt("product_Id"));
                order.setOrderQuantity(rs.getInt("order_Quantity"));
                order.setOrderTotal(rs.getDouble("order_Total"));
                order.setOrderStatus(rs.getString("order_Status"));
                // You may fetch other details like order date, etc., if available
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
	public ArrayList<UserModel> getUsers() {
	    ArrayList<UserModel> products = new ArrayList<>();
	    
	    try(Connection con = getConnection()) {
	        String query = StringUtil.SELECT_USER;
	        
	        try(PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
	            while(rs.next()) {
	                UserModel user = new UserModel();
	                user.setUserId(rs.getInt("user_Id"));
	                user.setUserName(rs.getString("user_Name"));
	                user.setFirstName(rs.getString("first_Name"));
	                user.setLastName(rs.getString("last_Name"));
	                user.setGender(rs.getString("gender"));
	                user.setEmail(rs.getString("email"));
	                user.setAddress(rs.getString("address"));
	                user.setPhoneNumber(rs.getString("phone_Number"));
	                user.setPassword(rs.getString("password"));
	                
	                products.add(user);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); 	   }
	    
	    return products;
	}
	public int getUserLoginInfo(String userName, String password) {
		try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(StringUtil.GET_LOGIN_USER_INFO);
            st.setString(1, userName);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
            	                String userDb = rs.getString("user_Name");
                String dbPassword = rs.getString("password");

                if (userDb.equals(userName) && dbPassword.equals(password)) {
                    return 1; // Login successful
                } else {
                    return 0; // Password mismatch
                }
            } else {
                // No matching record found
                return 0;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging
            return -1;
        }
	}
//	public int getUserLoginInfo(String userName, String password) {
//	
//	}
   

    public UserModel getUserDetails(String userName) throws ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(StringUtil.GET_LOGIN_USER_INFO)) {
//        	statement.setInt(1, userId);
        	statement.setString(1, userName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    UserModel user = new UserModel();
                    user.setFirstName(resultSet.getString("first_Name"));
                    user.setLastName(resultSet.getString("last_Name"));
                    // Set other user details as needed
                    return user;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) { 
            e.printStackTrace();
            return null;
        }
    }
    public String getProductNameById(int productId) throws ClassNotFoundException {
        String productName = null;
        try (Connection con = getConnection()) {
            String query = "SELECT product_Name FROM product WHERE product_Id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                productName = rs.getString("product_Name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productName;
    }

    public static boolean saveFeedback(Feedback feedback) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Get connection
            conn = getConnection();

            // Prepare statement
            String sql = StringUtil.INSERT_feedback;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, feedback.getUserName());
            stmt.setString(2, feedback.getEmail());
            stmt.setString(3, feedback.getSubject());
            stmt.setString(4, feedback.getFeedbackDescription());

            // Execute update
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close connections
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return true;
    }


    public static ArrayList<Feedback> getFeedback() {
        ArrayList<Feedback> feedbackList = new ArrayList<>();
        
        try (Connection con = getConnection()) {
            String query = StringUtil.SELECT_FEEDBACK;
            
            try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Feedback feedback = new Feedback();
                    
                    feedback.setFeedbackId(rs.getInt("feedback_Id"));
                    feedback.setUserName(rs.getString("user_Name"));
                    feedback.setSubject(rs.getString("subject"));
                    feedback.setEmail(rs.getString("email")); 
                    feedback.setFeedbackDescription(rs.getString("feedback_Description"));
                    
                    feedbackList.add(feedback);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return feedbackList;
    }

	public int addProduct(ProductModel product) {
	    try (Connection connection = getConnection()) {
	        String query = StringUtil.INSERT_PRODUCT;
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, product.getProductName());
	        preparedStatement.setString(2, product.getProductDescription());
	        preparedStatement.setFloat(3, product.getProductPrice());
	        preparedStatement.setString(4, product.getProductCompany());
	        preparedStatement.setInt(5, product.getProductStock());
	        preparedStatement.setString(6, product.getProductImage());
	        preparedStatement.setString(7, product.getProductColor());
	        preparedStatement.setString(8, product.getProductType());
	        preparedStatement.setString(9, product.getProductCapacity());
	        
	        int result = preparedStatement.executeUpdate();
	        return result > 0 ? 1 : 0;
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	public ArrayList<ProductModel> getProducts() {
	    ArrayList<ProductModel> products = new ArrayList<>();
	    
	    try (Connection con = getConnection()) {
	        String query = StringUtil.select_Products;
	        
	        try (PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                ProductModel product = new ProductModel();
	                
	                product.setProductID(rs.getInt("product_Id"));
	                product.setProductName(rs.getString("product_Name"));
	                product.setProductDescription(rs.getString("product_Description"));
	                product.setProductPrice(rs.getFloat("product_Price"));
	                product.setProductCompany(rs.getString("product_Company"));
	                product.setProductStock(rs.getInt("product_Stock"));
	                product.setProductColor(rs.getString("product_Color"));
	                product.setProductType(rs.getString("product_Type"));
	                product.setProductCapacity(rs.getString("product_Capacity"));
	                product.setProductImage(rs.getString("product_Image"));
//	                // Retrieve the image filename from the database
//	                String imageName = rs.getString("product_Image");
//	                System.out.println(rs.getString("product_Image"));
//	                // Construct the complete image URL
//	                String imageUrl = "/uploads/Products/" + imageName; // Adjust this path as needed
////	                System.out.println(imageUrl);
//	                // Set the product image URL
//	                product.setProductImage(imageUrl);
	                
	                products.add(product);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return products;
	}

	 public ArrayList<ProductModel> searchProduct(String query) {
	        ArrayList<ProductModel> searches = new ArrayList<>();
	        try (Connection con = getConnection()) {
	            String sql = "SELECT * FROM product WHERE LOWER(product_Name) LIKE ?";
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1, "%" + query.toLowerCase() + "%");
	            ResultSet rs = st.executeQuery();

	            while (rs.next()) {
	                ProductModel product = new ProductModel(
	                    rs.getInt("product_ID"),
	                    rs.getString("product_Name"),
	                    rs.getString("product_Description"),
	                    rs.getFloat("product_Price"),
	                    rs.getString("product_Company"),
	                    rs.getInt("product_Stock"),
	                    rs.getString("product_Image"),
	                    rs.getString("product_Color"),
	                    rs.getString("product_Type"),
	                    rs.getString("product_Capacity")
	                );

	                searches.add(product);
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return searches;
	    }
//    public ArrayList<ProductModel> searchProduct(String query, String searchType) {
//        ArrayList<ProductModel> searches = new ArrayList<>();
//        try {
//            if ("name".equals(searchType)) {
//                String sql = "SELECT * FROM Product WHERE LOWER(name) LIKE ?";
//                PreparedStatement st = this.con.prepareStatement(sql);
//                st.setString(1, "%" + query.toLowerCase() + "%");
//                ResultSet rs = st.executeQuery();
//                while (rs.next()) {
//                	ProductModel product = new ProductModel(rs.getString("code"), rs.getString("name"), rs.getFloat("price"),
//                            rs.getString("brand"), rs.getString("productImage"), rs.getInt("stock"),
//                            rs.getString("size"), rs.getString("description"), rs.getString("type"));
//                    searches.add(product);
//                }
//            } else if ("price".equals(searchType)) {
//                String sql = "SELECT * FROM Product WHERE price = ?";
//                float price = Float.parseFloat(query);
//                PreparedStatement st = this.con.prepareStatement(sql);
//                st.setFloat(1, price);
//                ResultSet rs = st.executeQuery();
//                while (rs.next()) {
//                	ProductModel product = new Product(rs.getString("code"), rs.getString("name"), rs.getFloat("price"),
//                            rs.getString("brand"), rs.getString("productImage"), rs.getInt("stock"),
//                            rs.getString("size"), rs.getString("description"), rs.getString("type"));
//                    searches.add(product);
//                }
//            }
//        } catch (NumberFormatException | SQLException e) {
//            e.printStackTrace();
//        }
//        return searches;
//    }
	   public static boolean updateProduct(ProductModel product) throws ClassNotFoundException {
	        try (Connection conn =getConnection()) {
	            String sql = StringUtil.UPDATE_PRODUCT_DETAILS;
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            
	            stmt.setString(1, product.getProductName());
	            stmt.setString(2, product.getProductDescription());
	            stmt.setDouble(3, product.getProductPrice());
	            stmt.setString(4, product.getProductCompany());
	            stmt.setInt(5, product.getProductStock());
	            stmt.setString(6, product.getProductImage());
	            stmt.setString(7, product.getProductColor());
	            stmt.setString(8, product.getProductType());
	            stmt.setString(9, product.getProductCapacity());
	            stmt.setInt(10, product.getProductID());
	            
	            
	            int rowsUpdated = stmt.executeUpdate();
	            return rowsUpdated > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	   public static boolean deleteProduct(String productID) throws ClassNotFoundException {
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(StringUtil.DELETE_PRODUCT))
	        {
	            // Set the cart_id parameter in the prepared statement
	            stmt.setInt(1, Integer.parseInt(productID));
	            
//	            System.out.println("productID");
	            // Execute the delete query
	            int rowsAffected = stmt.executeUpdate();
	            // Check if deletion was successful
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exceptions
	            return true;
	        }
	    }
	   
	   public static boolean AddToCart(CartModel cart) {
		    Connection conn = null;
		    PreparedStatement stmt = null;

		    try {
		        // Get connection
		        conn = getConnection();

		        // Prepare statement
		        String sql = StringUtil.INSERT_TO_CART;
		        stmt = conn.prepareStatement(sql);
		        stmt.setInt(1, cart.getProductID());
		        stmt.setInt(2, cart.getQuantity());
		        stmt.setInt(3, cart.getPrice()); // Set price parameter
		        stmt.setInt(4, cart.getUserId());

		        // Execute update
		        stmt.executeUpdate();
		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		    } finally {
		        // Close connections
		        try {
		            if (stmt != null)
		                stmt.close();
		            if (conn != null)
		                conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
			return true;
		}
	   
	   public static boolean updateCart(CartModel cart) throws ClassNotFoundException {
	        try (Connection conn =getConnection()) {
	            String sql = StringUtil.UPDATE_CART_DETAILS;
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            
	            
//	            stmt.setInt(1, cart.getProductId());
//	            stmt.setInt(2, cart.getUserId());
	            stmt.setInt(1, cart.getQuantity());
//	            stmt.setInt(4, cart.getPrice());
	            stmt.setInt(2, cart.getCartId());
	                       
	            
	            int rowsUpdated = stmt.executeUpdate();
	            return rowsUpdated > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	public ArrayList<CartModel> getcarts() {
	    ArrayList<CartModel> carts = new ArrayList<>();
	    
	    try(Connection con = getConnection()) {
	        String query = StringUtil.SELECT_CART;
	        
	        try(PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
	            while(rs.next()) {
	                CartModel cart = new CartModel();
	                cart.setCartId(rs.getInt("cart_Id"));
	                cart.setProductID(rs.getInt("product_Id"));
	                cart.setQuantity(rs.getInt("quantity"));
	                cart.setPrice(rs.getInt("price"));
	                cart.setUserId(rs.getInt("user_Id"));
//	                cart.setProductDescription(rs.getString("product_Description"));
	              
	                
	                carts.add(cart);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); 	   }
	    
	    return carts;
	}

	public ArrayList<CartModel> getproductId() {
	    ArrayList<CartModel> carts = new ArrayList<>();
	    
	    try(Connection con = getConnection()) {
	        String query = "select * from carts c left join product p on c.product_Id = p.product_Id";
	        
	        try(PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
	            while(rs.next()) {
	                CartModel cart = new CartModel();
	                
	                cart.setProductID(rs.getInt("product_Id"));
//	                cart.setQuantity(rs.getInt("quantity"));
//	                cart.setProductPrice(rs.getInt("price"));
//	                cart.setProductDescription(rs.getString("product_Description"));
//	                cart.setProductPrice(rs.getFloat("product_Price"));
	              
	                
	                carts.add(cart);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); 	   }
	    
	    return carts;
	}
	

	 public static boolean deleteCartItem(String cartId) throws ClassNotFoundException {
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(StringUtil.DELETE_CART)) {
	            // Set the cart_id parameter in the prepared statement
	            stmt.setInt(1, Integer.parseInt(cartId));
	            // Execute the delete query
	            int rowsAffected = stmt.executeUpdate();
	            // Check if deletion was successful
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exceptions
	            return false;
	        }
	    }
	 
	 public static void AddToOrder(OrderModel order) {
		    Connection conn = null;
		    PreparedStatement stmt = null;

		    try {
		        // Get connection
		        conn = getConnection();

		        // Prepare statement
		        String sql = StringUtil.INSERT_INTO_ORDERS;
		        stmt = conn.prepareStatement(sql);
		        stmt.setInt(1, order.getOrderQuantity());
		        stmt.setDouble(2, order.getOrderTotal()); // Assuming orderTotal is double
		        stmt.setString(3, order.getOrderStatus());
		        stmt.setInt(4, order.getUserId());
		        stmt.setInt(5, order.getProductId());
		        System.out.println(order.getOrderQuantity());
		        // Execute update
		        stmt.executeUpdate();
		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		    } finally {
		        // Close connections
		        try {
		            if (stmt != null)
		                stmt.close();
		            if (conn != null)
		                conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}

	 
	 public ArrayList<OrderModel> getOrders() {
		    ArrayList<OrderModel> orders = new ArrayList<>();
		    
		    try(Connection con = getConnection()) {
		        String query = StringUtil.select_Orders;
		        
		        try(PreparedStatement st = con.prepareStatement(query); ResultSet rs = st.executeQuery()) {
		            while(rs.next()) {
		                OrderModel order = new OrderModel();
		                order.setOrderId(rs.getInt("order_Id"));
		                order.setOrderQuantity(rs.getInt("order_Quantity"));
		                order.setOrderStatus(rs.getString("order_Status"));
		                order.setOrderTotal(rs.getDouble("order_Total"));
		                order.setUserId(rs.getInt("user_Id"));
		                order.setProductId(rs.getInt("product_Id"));
		                orders.add(order);
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace(); 	   }
		    
		    return orders;
		}
	 
	 public List<CartofUserModel> getUserCartInfo(int userId) {
		    List<CartofUserModel> cartDetails = new ArrayList<>();
		    try (Connection con = getConnection()) {
		        PreparedStatement statement = con.prepareStatement(StringUtil.GET_USER_CART_DETAILS);
		        statement.setInt(1, userId);
		        ResultSet result = statement.executeQuery();
		        while (result.next()) {
		        	int cart_Id = result.getInt("cart_Id");
		            int user_Id = result.getInt("user_Id");
		            int product_Id = result.getInt("product_Id");
		            String product_Name = result.getString("product_Name");
		            String product_Image = result.getString("product_Image");
		            int quantity = result.getInt("quantity");
		            Double price = result.getDouble("price");
		            Double total_Amount = price * quantity;
		            CartofUserModel cartofUserModel = new CartofUserModel(cart_Id, product_Id, user_Id, product_Name,
		                    product_Image, quantity, price, total_Amount);
		            cartDetails.add(cartofUserModel);
		        }
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }
		    return cartDetails;
		}
	
	

}
