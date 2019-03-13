package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonEdit {
	private JTextField name = new JTextField();
	private JTextField email = new JTextField();
	private JTextField age = new JTextField();
	private JTextField address = new JTextField();

	private JLabel l1 = new JLabel("Name:");
	private JLabel l2 = new JLabel("Email:");
	private JLabel l3 = new JLabel("Age:");
	private JLabel l4 = new JLabel("Address:");
	
	private JButton edit=new JButton("Finish");
	
	private JFrame frame = new JFrame("Edit");


	
	public  PersonEdit() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		panel.add(name);
		panel.add(email);
		panel.add(age);
		panel.add(address);
	 
		
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(edit);
		
		edit.setBounds(250, 200, 100, 30);
		
		l1.setBounds(50, 50, 100, 30);
		name.setBounds(100, 50, 100, 30);

		l2.setBounds(50, 100, 50, 30);
		email.setBounds(100, 100, 100, 30);

		l3.setBounds(50, 150, 60, 30);
		age.setBounds(100, 150, 100, 30);

		l4.setBounds(50, 200, 70, 30);
		address.setBounds(100, 200, 100, 30);
		
		frame.add(panel);
		frame.setVisible(false);
		
		
		
		
	}
	
	public void visiblePE(boolean ok) {
		this.frame.setVisible(ok);
	}
	
	public void finishButton(ActionListener e) {
		edit.addActionListener(e);
	}
	
	public String getName() {
		return name.getText();
	}
	public String getEmail() {
		return email.getText();
	}
	public int getAge() {
		return Integer.parseInt(age.getText());
	}
	public String getAddress() {
		return address.getText();
	}
}
