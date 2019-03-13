package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Bank implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1567263102345436765L;

	public static HashMap<Person, HashSet<Account>> accounts = new HashMap<Person, HashSet<Account>>();

	// private static HashSet<Person> persons = new HashSet<Person>();
	// private static HashSet<Account> allAccounts = new HashSet<Account>();

	@SuppressWarnings("unchecked")
	public void loadData() {
		try {
			FileInputStream fileIn = new FileInputStream("accounts.ser");
			ObjectInputStream inputStream = new ObjectInputStream(fileIn);
			accounts = (HashMap<Person, HashSet<Account>>) inputStream.readObject();
			System.out.println(accounts.size() + "load");
			fileIn.close();
			inputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			e.getMessage();
		}
	}

	public void storeData() {
		try {
			FileOutputStream fileOut = new FileOutputStream("accounts.ser");
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
			outputStream.writeObject(accounts);
			outputStream.close();
			fileOut.close();
			System.out.println(accounts.size() + "store");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Bank() {

	}

	/**
	 * 
	 * @pre accounts!=null
	 * 
	 */
	public Person getPerson(String name) {
		for (Person p : accounts.keySet()) {
			// System.out.println(p.getName());
			if (p.getName().equals(name))
				return p;
		}
		return null;

	}

	public Account getAccount(Person p, String id) {
		for (Account ac : p.getAccount()) {
			if (ac.getAccountID().equals(id))
				return ac;
		}
		return null;
	}

	/**
	 * @pre person!=null
	 * @pre account!=null
	 */
	public static void addAccount(Person person, Account account) {
		int ok = 1;
		for (Account a : person.getAccount()) {
			if (a.getAccountID().equals(account.getAccountID()))
				ok = 0;
		}
		if (ok == 1) {
			if (account.getType().equals("saving")) {
				SavingAccount toInsert = new SavingAccount(account.getSumOfMoney(), account.getAccountID(),
						account.getPin(), account.getType());
				person.addAcc(toInsert);
				// allAccounts.add(toInsert);
			} else {
				SpendingAccount toInsert = new SpendingAccount(account.getSumOfMoney(), account.getAccountID(),
						account.getPin(), account.getType());
				person.addAcc(toInsert);
				// allAccounts.add(toInsert);
			}

			Bank.addNewPerson(person);
			accounts.put(person, person.getAccount());
		} else
			System.out.println("Acount already inserted");
	}

	public static HashSet<Account> getAccount(Person person) {
		if (accounts.containsKey(person))
			return accounts.get(person);
		else {
			System.out.println("person inexistent");
			return null;
		}
	}

	/**
	 * @throw IllegalArgumentException if person is not valid
	 */
	public static void addNewPerson(Person person) {
		int ok = 0;
		if (person.getAge() < 18)
			throw new IllegalArgumentException("Too small");
		for (Person p : accounts.keySet()) {
			if (p.getName().equals(person.getName()))
				ok = 1;
		}
		if (ok == 0) {
			accounts.put(person, new HashSet<Account>());
			// persons.add(person);
		} else
			System.out.println("person already in bank");
		// System.out.println(accounts.hashCode());
	}

	/**
	 * 
	 * @throw IllegalArgumentException if person is not valid
	 */
	public static void deletePerson(Person person) {

		if (accounts.containsKey(person)) {
			// persons.remove(person);
			accounts.remove(person);

		} else
			throw new IllegalArgumentException("Inexistent person");
		System.out.println("person inexistent");
	}

	/**
	 * 
	 * @throw IllegalArgumentException if person is not valid
	 */

	public static void deleteAccount(Person person, Account account) {

		int ok = 0;
		System.out.println(person.getName());
		// HashSet<Account> aux = new HashSet<Account>();
		Account aux1 = new Account();
		for (Account ac : person.getAccount()) {
			if (ac.getAccountID().equals(account.getAccountID())) {

				ok = 1;
				aux1 = ac;
			}
		}
		if (ok == 1) {
			System.out.println("asasa");
			// aux=person.getAccount();
			// allAccounts.remove(aux1);
			person.getAccount().remove(aux1);

			accounts.put(person, person.getAccount());
		} else
			throw new IllegalArgumentException("Account not find");
	}

	/**
	 * 
	 * @throw IllegalArgumentException if person is not valid
	 */
	public static void editPerson(Person person, Person newPerson) {
		if (accounts.containsKey(person)) {
			Bank.addNewPerson(newPerson);
			HashSet<Account> aux = accounts.get(person);
			for (Account a : aux) {
				if (a.getType().equals("saving"))
					a.setSumOfMoney(a.getInitialSum());
				Bank.addAccount(newPerson, a);
			}
			// persons.remove(person);
			// persons.add(newPerson);
			Bank.deletePerson(person);
			// accounts.put(newPerson,aux);
		} else
			throw new IllegalArgumentException("Person to edit not find");
	}

	/**
	 * 
	 * @throw IllegalArgumentException if person is not valid
	 */

	public static void editAccount(Person person, Account account, Account newAccount) {

		if (account != null) {
			person.addAcc(newAccount);
			// allAccounts.add(newAccount);
			// allAccounts.remove(account);
			person.getAccount().remove(account);
			accounts.put(person, person.getAccount());
		} else
			System.out.println("Account inexistent");
		throw new IllegalArgumentException("Account not found");
	}

	// public static HashSet<Account> getAllAccounts() {
	// return allAccounts;
	// }
	//
	// public static HashSet<Person> getAllPersons() {
	// return persons;
	// }

	public static void showPersons(JTable show) {
		DefaultTableModel tableModel = (DefaultTableModel) show.getModel();
		String[] columnsNames = { "Name", "Age", "Email", "Address" };
		tableModel.setColumnIdentifiers(columnsNames);
		tableModel.setRowCount(0);
		String[] data = new String[4];
		for (Person p : accounts.keySet()) {
			data[0] = p.getName();
			data[1] = Integer.toString(p.getAge());
			data[2] = p.getEmail();
			data[3] = p.getAddress();
			tableModel.addRow(data);

		}
		show.setModel(tableModel);
		show.setVisible(true);
	}

	public static void showAccount(JTable show) {
		DefaultTableModel tableModel = (DefaultTableModel) show.getModel();
		String[] columnsNames = { "Sum", "Id", "Pin", "Type" };
		tableModel.setColumnIdentifiers(columnsNames);
		tableModel.setRowCount(0);
		String[] data = new String[4];
		for (Person p : accounts.keySet())
			for (Account a : p.getAccount()) {
				data[0] = Integer.toString(a.getSumOfMoney());
				data[1] = a.getAccountID();
				data[2] = a.getPin();
				data[3] = a.getType();
				tableModel.addRow(data);

			}
		show.setModel(tableModel);
		show.setVisible(true);
	}

	public static void extractMoney(Person person, Account account, int withdraw, JFrame frame) {
		int sum = account.getSumOfMoney();
		Subject subject = new Subject();
		if (account.getType().equals("spending")) {
			if (withdraw > sum)
				JOptionPane.showMessageDialog(frame, "Not enought money");
			else {
				sum = sum - withdraw - (int) (0.10 * withdraw);
				account.setSumOfMoney(sum);
				new ObserverAccounts(subject);
				subject.setState(person.getName(), withdraw, account.getAccountID(), frame);
			}
		} else
			JOptionPane.showMessageDialog(frame, "This is a saving account");

	}

	public static void addMoney(Person person, Account account, int withdraw, JFrame frame) {
		int sum = account.getSumOfMoney();
		//Subject subject = new Subject();
		if (account.getType().equals("spending")) {
				sum = sum +withdraw ;
				account.setSumOfMoney(sum);
				//new ObserverAccounts(subject);
				//subject.setState(person.getName(), withdraw, account.getAccountID(), frame);
				JOptionPane.showMessageDialog(frame, withdraw+" euros were added to account "+account.getAccountID());
			
		} else
			JOptionPane.showMessageDialog(frame, "This is a saving account");

	}
}
