package model;

@SuppressWarnings("serial")
public class SavingAccount extends Account{
	private final float rate=(float) 0.10;
	public SavingAccount(int sumOfMoney, String accountID, String pin,String type) {
		//sumOfMoney=(int) (sumOfMoney-rate*sumOfMoney);
		super(sumOfMoney, accountID, pin,type);
		this.setSumOfMoney((int) (sumOfMoney+rate*sumOfMoney));
	
		//System.out.println(this.getSumOfMoney());
		// TODO Auto-generated constructor stub
	}
	
	

}
