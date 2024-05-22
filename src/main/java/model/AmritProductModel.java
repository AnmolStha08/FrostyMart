package model;

import java.io.File;

import javax.servlet.http.Part;

public class AmritProductModel {
	private String name;
	private String description;
	private float price;
	private int quantity;
	private String brand;
	private String ram;
	private String camera;
	private String display;
	private String storage;
	private String processor;
	private String battery;
	private String operatingSystem;
	private String image;
	
	public static final String PRODUCT_PIC_DIR = "\\Users\\anmol\\eclipse-workspace\\Fridge_Shop\\src\\main\\webapp\\Uploads\\Products\\";
	public static final String PRODUCT_PIC_SAVE_DIR = "C:" + File.separator + PRODUCT_PIC_DIR;
	
	private String getProductPicName(Part part) {
		String imagePath = PRODUCT_PIC_SAVE_DIR;
		File imageSaveDir = new File(imagePath);
		String productPicUrlFromPath = null;
		if(!imageSaveDir.exists()) {
			imageSaveDir.mkdir();
		}
		String contentDisp = part.getHeader("content-disposition");
		String []items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				productPicUrlFromPath = s.substring(s.indexOf("=") + 2, s.length() -1);
			}
		}
		if(productPicUrlFromPath  == null || productPicUrlFromPath .isEmpty()) {
			productPicUrlFromPath = "defaultpp.png";
		}
		return productPicUrlFromPath;
	}

	/**
	 * @param name
	 * @param description
	 * @param price
	 * @param quantity
	 * @param brand
	 * @param ram
	 * @param camera
	 * @param display
	 * @param storage
	 * @param processor
	 * @param battery
	 * @param operatingSystem
	 * @param image
	 */
	public AmritProductModel(String name, String description, float price, int quantity, String brand, String ram,
			String camera, String display, String storage, String processor, String battery, String operatingSystem,
			Part product_image) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.ram = ram;
		this.camera = camera;
		this.display = display;
		this.storage = storage;
		this.processor = processor;
		this.battery = battery;
		this.operatingSystem = operatingSystem;
		this.image = getProductPicName(product_image);
		
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
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
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the ram
	 */
	public String getRam() {
		return ram;
	}

	/**
	 * @param ram the ram to set
	 */
	public void setRam(String ram) {
		this.ram = ram;
	}

	/**
	 * @return the camera
	 */
	public String getCamera() {
		return camera;
	}

	/**
	 * @param camera the camera to set
	 */
	public void setCamera(String camera) {
		this.camera = camera;
	}

	/**
	 * @return the display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @param display the display to set
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	/**
	 * @return the storage
	 */
	public String getStorage() {
		return storage;
	}

	/**
	 * @param storage the storage to set
	 */
	public void setStorage(String storage) {
		this.storage = storage;
	}

	/**
	 * @return the processor
	 */
	public String getProcessor() {
		return processor;
	}

	/**
	 * @param processor the processor to set
	 */
	public void setProcessor(String processor) {
		this.processor = processor;
	}

	/**
	 * @return the battery
	 */
	public String getBattery() {
		return battery;
	}

	/**
	 * @param battery the battery to set
	 */
	public void setBattery(String battery) {
		this.battery = battery;
	}

	/**
	 * @return the operatingSystem
	 */
	public String getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * @param operatingSystem the operatingSystem to set
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Part part) {
		this.image = getProductPicName(part);
	}

	/**
	 * @param name
	 * @param description
	 * @param price
	 * @param quantity
	 * @param brand
	 * @param ram
	 * @param camera
	 * @param display
	 * @param storage
	 * @param processor
	 * @param battery
	 * @param operatingSystem
	 * @param image
	 */
	public AmritProductModel(String name, String description, float price, int quantity, String brand, String ram,
			String camera, String display, String storage, String processor, String battery, String operatingSystem,
			String image) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.ram = ram;
		this.camera = camera;
		this.display = display;
		this.storage = storage;
		this.processor = processor;
		this.battery = battery;
		this.operatingSystem = operatingSystem;
		this.image = image;
	}
	
}
