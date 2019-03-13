package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccountsEdit {
	private JTextField sum = new JTextField();
	private JTextField id = new JTextField();
	private JTextField pin = new JTextField();
	
	private JLabel l1 = new JLabel("Sum:");
	private JLabel l2 = new JLabel("AccountId:");
	private JLabel l3 = new JLabel("Pin:");
	
	private JButton edit=new JButton("Finish");
	
	private JFrame frame = new JFrame("Edit");


	
	public  AccountsEdit() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		panel.add(sum);
		panel.add(id);
		panel.add(pin);
		
		
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
	
		panel.add(edit);
		
		edit.setBounds(250, 200, 100, 30);
		
		l1.setBounds(50, 50, 100, 30);
		sum.setBounds(100, 50, 100, 30);

		l2.setBounds(50, 100, 50, 30);
		id.setBounds(100, 100, 100, 30);

		l3.setBounds(50, 150, 60, 30);
		pin.setBounds(100, 150, 100, 30);

		
		frame.add(panel);
		frame.setVisible(false);
		
		
		
		
	}
	
	public void visibleAE(boolean ok) {
		this.frame.setVisible(ok);
	}
	
	public void finishButton(ActionListener e) {
		edit.addActionListener(e);
	}
	
	public int getSum() {
		return Integer.parseInt(sum.getText());
	}
	public String getPin() {
		return pin.getText();
	}
	
	public String getId() {
		return id.getText();
	}
}
