package model;
//SELECT c.product_Id, c.user_Id, p.product_Name, p.product_Image,
//c.quantity, c.price FROM carts c JOIN product p ON c.product_Id = p.product_Id
//WHERE c.user_Id = ?"
public class CartofUserModel {
	int cartId;
	int product_Id;
	int user_Id;
	String product_Name;
	String product_Image;
	int quantity;
	Double price;
	Double total_Price;
	/**
	 * @param product_Id
	 * @param user_Id
	 * @param product_Name
	 * @param product_Image
	 * @param quantity
	 * @param price
	 * @param total_Price
	 */
	public CartofUserModel(int cartId, int product_Id, int user_Id, String product_Name, String product_Image, int quantity,
			Double price, Double total_Price) {
		super();
		this.cartId = cartId;
		this.product_Id = product_Id;
		this.user_Id = user_Id;
		this.product_Name = product_Name;
		this.product_Image = product_Image;
		this.quantity = quantity;
		this.price = price;
		this.total_Price = total_Price;
	}
	
	/**
	 * @return the cart_Id
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cart_Id the cart_Id to set
	 */
	public void setCart_Id(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the product_Id
	 */
	public int getProduct_Id() {
		return product_Id;
	}
	/**
	 * @param product_Id the product_Id to set
	 */
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}
	/**
	 * @return the user_Id
	 */
	public int getUser_Id() {
		return user_Id;
	}
	/**
	 * @param user_Id the user_Id to set
	 */
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	/**
	 * @return the product_Name
	 */
	public String getProduct_Name() {
		return product_Name;
	}
	/**
	 * @param product_Name the product_Name to set
	 */
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	/**
	 * @return the product_Image
	 */
	public String getProduct_Image() {
		return product_Image;
	}
	/**
	 * @param product_Image the product_Image to set
	 */
	public void setProduct_Image(String product_Image) {
		this.product_Image = product_Image;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the total_Price
	 */
	public Double getTotal_Price() {
		return total_Price;
	}
	/**
	 * @param total_Price the total_Price to set
	 */
	public void setTotal_Price(Double total_Price) {
		this.total_Price = total_Price;
	}
	
}
