package model;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;

import util.StringUtil;

public class ProductModel {
	private int productID;
    private String productName;
    private String productDescription;
    private float productPrice;
    private String productCompany;
    private int productStock;
    private String productImage;
    private String productColor;
    private String productType;
    private String productCapacity;

    public ProductModel() {
        super();
    }
    
    public ProductModel(int productStock) {
		super();
		this.productStock = productStock;
	}

	public ProductModel(int productID, String productName, String productDescription, float productPrice,
			String productCompany, int productStock, String productImage, String productColor, String productType,
			String productCapacity) {
		this.productID = productID;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productCompany = productCompany;
		this.productStock = productStock;
		this.productImage = productImage;
		this.productColor = productColor;
		this.productType = productType;
		this.productCapacity = productCapacity;
	}

	public ProductModel(String productName, String productDescription, float productPrice, String productCompany,
            int productStock, Part productImage, String productColor, String productType, String productCapacity) {
        super();
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productCompany = productCompany;
        this.productStock = productStock;
        this.productImage = getImageUrl(productImage);
        this.productColor = productColor;
        this.productType = productType;
        this.productCapacity = productCapacity;
    }
	
	
    public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductImage() {
        return productImage;
    }
    
	private String getImageUrl(Part imagePart) {
		String savePath = StringUtil.PRODUCT_PIC_SAVE_DIR;
		String fileName = null;
		try {
			String contentDisp = imagePart.getHeader("content-disposition");
			String[] items = contentDisp.split(";");
			for (String s : items) {
				if (s.trim().startsWith("filename")) {
					fileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
					break;
				}
			}

			if (fileName == null || fileName.isEmpty()) {
				fileName = "default.jpg";
			}

			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdirs();
			}
			String filePath = savePath + File.separator + fileName;
			imagePart.write(filePath);

		} catch (IOException e) {
			e.printStackTrace();
			fileName = null;
		}

		return fileName;
	}
	
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductCapacity() {
        return productCapacity;
    }

    public void setProductCapacity(String productCapacity) {
        this.productCapacity = productCapacity;
    }
    
    //use this constructor for add product
    
    

    @Override
    public String toString() {
        return "ProductModel [productName=" + productName + ", productDescription=" + productDescription
                + ", productPrice=" + productPrice + ", productCompany=" + productCompany + ", productStock="
                + productStock + ", productImage=" + productImage + ", productColor=" + productColor + ", productType="
                + productType + ", productCapacity=" + productCapacity + "]";
    }
}
