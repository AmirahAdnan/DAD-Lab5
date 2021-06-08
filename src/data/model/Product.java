package data.model;

import java.io.Serializable;

public class Product implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	private int productId;
	private String name;
	private float price;
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}
	
}
