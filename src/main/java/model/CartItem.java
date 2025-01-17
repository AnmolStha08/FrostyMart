package model;

public class CartItem {
    private String productId;
    private String userId;
    private int quantity;

    public CartItem(String productId, String userId, int quantity) {
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
