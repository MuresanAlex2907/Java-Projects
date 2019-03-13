package controller;


import model.Account;
import model.Bank;
import model.Person;
import view.AccountView;
import view.AccountsEdit;
import view.PersonEdit;
import view.PersonView;


public class Controller {

	private Person toEdit=new Person();
	private Account toEditA=new Account();
	private Person forAccounts=new Person();
	public static Bank bank=new Bank();
	@SuppressWarnings("static-access")
	public Controller() {
		
		//final PersonView pv = new PersonView();
		final PersonEdit pe = new PersonEdit();
		final AccountView av=new AccountView();
		final AccountsEdit ae=new AccountsEdit();
		final PersonView pv=new PersonView();
		
		new Bank().loadData();
		
		pe.finishButton(e->{
			pe.visiblePE(false);
			pv.visibleP(true);
			});
		pv.editPerson(e->{
			pe.visiblePE(true);
			//pv.visibleP(false);
		});
		
		av.back(e->{
			av.visibleA(false);
			pv.visibleP(true);
		});
		
	   pv.accounts(e->{
		   //forAccounts=null;
		   forAccounts=bank.getPerson(pv.getName());
		   av.visibleA(true);
		   pv.visibleP(false);
	   });
	   
	   pv.addPerson(e->{
		   Person p=new Person(pv.getName(),pv.getAge(),pv.getEmail(),pv.getAddress());
		  
		   bank.addNewPerson(p);
		   
	   });
	   
	   pv.showPerson(e->{
		   
		
		
		   bank.showPersons(pv.show);
	   });
	   pv.deletePerson(e->{
		   Person p=bank.getPerson(pv.getName());
		   bank.deletePerson(p);
	   });
	   
	   pv.editPerson(e->{
		  toEdit=bank.getPerson(pv.getName());
	   });
	   
	   pe.finishButton(e->{
		   Person p=new Person(pe.getName(),pe.getAge(),pe.getEmail(),pe.getAddress());
		   bank.editPerson(toEdit, p);
	   });
	   
	   av.addAccount(e->{
		  // Person p=new Person(pe.getName(),pe.getAge(),pe.getEmail(),pe.getAddress());
		   Account a=new Account(av.getSum(),av.getId(),av.getpin(),av.getType());
		   bank.addAccount(forAccounts, a);
		   
	   });
	   
	   av.showAccount(e->{
		   bank.showAccount(av.show);
	   });
	   
	   av.deleteAccount(e->{
		   Account a=new Account(av.getSum(),av.getId(),av.getpin(),av.getType());
		   bank.deleteAccount(forAccounts, a);
	   });
	   
	   av.editAccount(e->{
		   ae.visibleAE(true);
		   toEditA=bank.getAccount(forAccounts, av.getId());
		   
	   });
	   av.addExtract(e->{
		   Account a=bank.getAccount(forAccounts, av.getId());
		   int withdraw=av.getWithdraw();
		   bank.extractMoney(forAccounts, a, withdraw,av.frame);
	   });
	   
	   av.addMoney(e->{
		   Account a=bank.getAccount(forAccounts, av.getId());
		   int toAdd=av.getWithdraw();
		   bank.addMoney(forAccounts, a, toAdd, av.frame);
	   });
	   
	   ae.finishButton(e->{
		   ae.visibleAE(false);
		   Account a=new Account(ae.getSum(),ae.getId(),ae.getPin(),toEditA.getType());
		   bank.editAccount(forAccounts, toEditA, a);
	   });
		
	   pv.frame.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	        	new Bank().storeData();
	        }
	    });
	   
	   av.frame.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	        	new Bank().storeData();
	        }
	    });
	   
	   
	   
	}
}
