package model;

import java.io.File;

import javax.servlet.http.Part;

import util.StringUtils;


public class ProductModel {
	private String product_id;
	private String product_name;
	private String unit_price;
	private String product_quantity;
	private String product_availability;
	private String vendor_id;
	//added by bipul
	private String imageUrlFromPart;

	
	public ProductModel() {}

	public ProductModel(String product_id, String product_name, String unit_price, String product_quantity, String product_availability, String vendor_id, Part imagePart) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.unit_price = unit_price;
		this.product_quantity = product_quantity;
		this.product_availability = product_availability;
		this.vendor_id = vendor_id;
		//added by bipul
		this.setImageUrlFromPart(getImageUrl(imagePart));
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}

	public String getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_availability() {
		return product_availability;
	}

	public void setProduct_availability(String product_availability) {
		this.product_availability = product_availability;
	}

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}
	//added by bipul	
	public String getImageUrlFromPart() {
		return imageUrlFromPart;
	}

	public void setImageUrlFromPart(String imageUrlFromPart) {
		this.imageUrlFromPart = imageUrlFromPart;
	}
	
	// product image for database(Bipul)
	private String getImageUrl(Part part) {
		String savePath = StringUtils.IMAGE_DIR_SAVE_PATH;
		File fileSaveDir = new File(savePath);
		String imageUrlFromPart = null;
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
			imageUrlFromPart = "download.jpg";
		}
		return imageUrlFromPart;
	}
	
}
