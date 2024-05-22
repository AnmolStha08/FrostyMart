package model;

public class CartModel {
	private int cartId;
    private int productID;
    private int userId;
    private int quantity;
    private int price;

    public CartModel() {
        super();
    }
    
    public CartModel(int cartId, int productID, int userId, int quantity, int price) {
		super();
		this.cartId = cartId;
		this.productID = productID;
		this.userId = userId;
		this.quantity = quantity;
		this.price = price;
	}

	public CartModel(int productID, int userId, int quantity, int price) {
        this.productID = productID;
        this.userId = userId;
        this.quantity = quantity;
        this.price= price;
    }
	public CartModel(int productID, int quantity, int price) {
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }
//    public CartModel(int productID, int quantity) {
//        this.productID = productID;
//        this.quantity = quantity;
//    }
    
    public CartModel(int cartId, int quantity) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
	}

	// Getters and setters
    public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
    
    public int getProductID() {
        return productID;
    }

	public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "CartModel [productID=" + productID + ", userId=" + userId + ", quantity=" + quantity + ", price=" + price+ "]";
    }
}
