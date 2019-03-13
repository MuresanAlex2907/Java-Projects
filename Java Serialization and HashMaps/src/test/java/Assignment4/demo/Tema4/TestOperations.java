package Assignment4.demo.Tema4;

import java.util.HashSet;

import javax.swing.JFrame;

import junit.framework.TestCase;
import model.Account;
import model.Bank;
import model.Person;

public class TestOperations extends TestCase {
	
	@SuppressWarnings("static-access")
	public void test() {
	Bank bank=new Bank();
	Person person = new Person("Alex", 20, "ABC", "Donath");
	Person person1 = new Person("Dani", 21, "DEF", "Zalau");
	Person person2 = new Person("Ian", 21, "IAN", "Bucuresti");
	Account account = new Account(100, "ingb232", "1234", "saving");
	Account account2 = new Account(100, "ingb232424", "4234", "spending");
	JFrame frame=new JFrame();
	
	bank.addNewPerson(person);
	assertTrue(bank.accounts.containsKey(person));
	
	bank.addAccount(person, account);
	assertTrue(bank.accounts.get(person)==person.getAccount());
	
	bank.deletePerson(person);
	assertTrue(!bank.accounts.containsKey(person));
	
	
	bank.addNewPerson(person1);
	bank.addAccount(person1, account2);
	
//	bank.editAccount(person1, account2, account);
//	assertTrue(bank.accounts.get(person1).contains(account) && !bank.accounts.get(person1).contains(account2));
//	
//	bank.editPerson(person1, person);
//	assertTrue(!bank.accounts.containsKey(person1) && bank.accounts.containsKey(person));
	
	bank.deleteAccount(person, account);
	assertTrue(!bank.accounts.get(person).contains(account));
	
	bank.addAccount(person2, account);
	bank.extractMoney(person2, account, 20,frame );
	
	

}
}
