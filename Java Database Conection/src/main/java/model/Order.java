package model;

public class Order {
	private String c_name;
	private String p_name;
	private String size;
	private int quantity;
	private int price;
	private int total;
	
	public Order() {
		
	}
	/**
	 * order constructor
	 * @param namec name of the client
	 * @param namep product description
	 * @param size product size
	 * @param quantity quantity ordered
	 * @param price price of the product
	 */
	public Order(String namec,String namep,String size,int quantity,int price) {
		this.c_name=namec;
		this.p_name=namep;
		this.size=size;
		this.quantity=quantity;
		this.price=price;
		this.total=price*quantity;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
}
