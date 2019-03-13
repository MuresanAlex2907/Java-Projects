package model;

public class Client {
   
	private int id;
	private String name;
	private String email;
	
	private int age;
	private String address;
	
	/**
	 * client constructor
	 * @param id client id
	 * @param name client name
	 * @param email client email
	 * @param age client age
	 * @param address client address
	 */
	public Client(int id, String name, String email, int age, String address) {
	     
		this.age = age;
		this.address = address;
		this.name = name;
		this.email = email;
	}

	public Client() {

	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
