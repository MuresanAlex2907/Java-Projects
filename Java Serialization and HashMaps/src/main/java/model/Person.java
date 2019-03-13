package model;

import java.util.*;

public class Person implements java.io.Serializable {

	private String name;
	

	private int age;
	private String email;
	private String address;
	private HashSet<Account> accounts=new HashSet<Account>();
	
	public Person() {
		
	}
	
	public Person(String name,int age,String email, String address) {
		//accounts=null;
		this.name=name;
		this.age=age;
		this.email=email;
		this.address=address;
	}
    public void addAcc(Account account) {
    	accounts.add(account);
    }
    
    public HashSet<Account> getAccount() {
    	return accounts;
    }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	
}
