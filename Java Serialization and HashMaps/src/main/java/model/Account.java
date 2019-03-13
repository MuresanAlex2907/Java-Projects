package model;

public class Account implements java.io.Serializable{
  private int sumOfMoney;
  private String accountID;
  private String pin;
  private String type;
  private int initialSum;

  
  public Account() {
	  
  }
  public Account(int sumOfMoney,String accountID,String pin,String type) {
	  this.sumOfMoney=sumOfMoney;
	  this.accountID=accountID;
	  this.pin=pin;
	  this.type=type;
	  this.initialSum=sumOfMoney;
  }

public String getType() {
	return type;
}

/**
 * @param type
 */
public void setType(String type) {
	this.type = type;
}

public int getInitialSum() {
	return initialSum;
}
public void setInitialSum(int initialSum) {
	this.initialSum = initialSum;
}
public int getSumOfMoney() {
	return sumOfMoney;
}

public void setSumOfMoney(int sumOfMoney) {
	this.sumOfMoney = sumOfMoney;
}

public String getAccountID() {
	return accountID;
}

public void setAccountID(String accountID) {
	this.accountID = accountID;
}

public String getPin() {
	return pin;
}

public void setPin(String pin) {
	this.pin = pin;
}
  
  
	
	
}
