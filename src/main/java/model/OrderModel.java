package model;

public class OrderModel {
	private int orderId;
	private int orderQuantity;
	private String orderStatus;
	private double orderTotal;
	private int userId;
	private int productId;
	public OrderModel() {
		super();
	}
	

	public OrderModel(int orderQuantity, String orderStatus, double orderTotal, int userId, int productId) {
		super();
		this.orderQuantity = orderQuantity;
		this.orderStatus = orderStatus;
		this.orderTotal = orderTotal;
		this.userId = userId;
		this.productId = productId;
	}


	public OrderModel(int orderId, int orderQuantity, String orderStatus, double orderTotal, int userId, int productId) {
		super();
		this.orderId = orderId;
		this.orderQuantity = orderQuantity;
		this.orderStatus = orderStatus;
		this.orderTotal = orderTotal;
		this.userId = userId;
		this.productId = productId;
	}

	public OrderModel(int orderQuantity, String orderStatus, int orderTotal) {
		super();
		this.orderQuantity = orderQuantity;
		this.orderStatus = orderStatus;
		this.orderTotal = orderTotal;
	}



	public OrderModel(int orderQuantity, String orderStatus, int orderTotal, int productId) {
		super();
		this.orderQuantity = orderQuantity;
		this.orderStatus = orderStatus;
		this.orderTotal = orderTotal;
		this.productId = productId;
	}


	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getOrderQuantity() {
		return orderQuantity;
	}



	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}



	public String getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}



	public double getOrderTotal() {
		return orderTotal;
	}



	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}
	
}
