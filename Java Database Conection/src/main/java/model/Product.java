package model;

public class Product {
	//private int id;
	private String description;
	private String size;
	private int quantity;
	private int price;
	/**
	 * product constructor
	 * @param des product description
	 * @param size product size
	 * @param quantity available quantity
	 * @param price product price
	 */
	public Product( String des, String size, int quantity, int price) {
		this.description = des;
		this.size = size;
		this.quantity = quantity;
		this.price = price;

	}

	public Product() {

	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
