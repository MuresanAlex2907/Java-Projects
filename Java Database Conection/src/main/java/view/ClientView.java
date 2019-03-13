package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ClientView {

	private JButton add = new JButton("ADD");
	private JButton delete = new JButton("DELETE");
	private JButton edit = new JButton("EDIT");
	private JButton viewAll = new JButton("VIEW ALL");
	private JButton back = new JButton("Back");
	private JButton order=new JButton("Order");

	private JTextField name = new JTextField();
	private JTextField email = new JTextField();
	private JTextField age = new JTextField();
	private JTextField address = new JTextField();

	private JLabel l1 = new JLabel("Name:");
	private JLabel l2 = new JLabel("Email:");
	private JLabel l3 = new JLabel("Age:");
	private JLabel l4 = new JLabel("Address:");
	private JLabel l5 = new JLabel("Which field:");

	private String[] s = { "Address", "Email", "Age" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox comboBox = new JComboBox(s);

	public JTable show = new JTable();
	private JFrame frame = new JFrame("Client");
/**
 * creates the UI where the user can work with client database
 */
	public ClientView() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JScrollPane sp = new JScrollPane(show);

		panel.add(add);
		panel.add(delete);
		panel.add(edit);
		panel.add(viewAll);
		panel.add(back);
		panel.add(order);
		panel.add(sp);

		panel.add(name);
		panel.add(email);
		panel.add(age);
		panel.add(address);
        panel.add(comboBox);
		
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(l5);

		show.setVisible(false);
		show.getAutoResizeMode();
		add.setBounds(50, 50, 100, 50);
		delete.setBounds(250, 50, 100, 50);
		edit.setBounds(450, 50, 100, 50);
		viewAll.setBounds(650, 50, 100, 50);
		back.setBounds(650, 650, 100, 30);
		order.setBounds(550, 650, 100, 30);
		
		l1.setBounds(50, 200, 100, 30);
		name.setBounds(100, 200, 100, 30);

		l2.setBounds(220, 200, 50, 30);
		email.setBounds(270, 200, 100, 30);

		l3.setBounds(390, 200, 60, 30);
		age.setBounds(430, 200, 100, 30);

		l4.setBounds(540, 200, 70, 30);
		address.setBounds(600, 200, 100, 30);
  
		sp.setBounds(50, 300, 400, 400);

		l5.setBounds(460, 100, 100, 50);
		comboBox.setBounds(450, 150, 100, 30);
		frame.setVisible(false);
		frame.add(panel);
	}

	public void visibleC(boolean ok) {
		this.frame.setVisible(ok);
	}

	public void back(ActionListener e) {
		back.addActionListener(e);
	}

	public void addClient(ActionListener e) {
		add.addActionListener(e);
	}

	public void delete(ActionListener e) {
		delete.addActionListener(e);
	}

	public void editClient(ActionListener e) {
		edit.addActionListener(e);
	}
	
	public void showClient(ActionListener e) {
		viewAll.addActionListener(e);
	}
	public String getEdit() {
		if(this.comboBox.getSelectedItem().equals("Age"))
			  return "age";
		if(this.comboBox.getSelectedItem().equals("Address"))
			  return "address";
		if(this.comboBox.getSelectedItem().equals("Email"))
			  return "email";
	return null;	
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
	
	public void orderButton(ActionListener e) {
		order.addActionListener(e);
	}
}
