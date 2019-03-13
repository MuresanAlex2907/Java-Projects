package model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ObserverAccounts extends Observer {
	
	 public ObserverAccounts(Subject subject){
	      this.subject = subject;
	      this.subject.attach(this);
	   }

	@Override
	public void update(JFrame frame) {
		
		JOptionPane.showMessageDialog(frame, subject.getName()+" from your account "+subject.getId()+" were extracted "+
													subject.getWithdraw()+" euros");

		
		
	}

}
