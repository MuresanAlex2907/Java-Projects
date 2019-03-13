package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class PersonView extends javax.swing.JFrame{
	private JButton add = new JButton("ADD");
	private JButton delete = new JButton("DELETE");
	private JButton edit = new JButton("EDIT");
	private JButton viewAll = new JButton("VIEW ALL");
	private JButton accounts = new JButton("Accounts");

	private JTextField name = new JTextField();
	private JTextField email = new JTextField();
	private JTextField age = new JTextField();
	private JTextField address = new JTextField();

	private JLabel l1 = new JLabel("Name:");
	private JLabel l2 = new JLabel("Email:");
	private JLabel l3 = new JLabel("Age:");
	private JLabel l4 = new JLabel("Address:");


	



	public JTable show = new JTable();
	public JFrame frame = new JFrame("Person");

	
	public PersonView() {
//		initComponent();
//	}
//	private void initComponent() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JScrollPane sp = new JScrollPane(show);
       
//		show.addMouseListener(new java.awt.event.MouseAdapter() {
//			@SuppressWarnings("unused")
//			public void mouseCliked(java.awt.event.MouseEvent evt) {
//				tableMouseClick(evt);
//			}
//		});
		panel.add(add);
		panel.add(delete);
		panel.add(edit);
		panel.add(viewAll);
		panel.add(accounts);
		panel.add(sp);

		panel.add(name);
		panel.add(email);
		panel.add(age);
		panel.add(address);
     
		
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);

		show.setVisible(true);
		show.getAutoResizeMode();
		add.setBounds(50, 50, 100, 50);
		delete.setBounds(250, 50, 100, 50);
		edit.setBounds(450, 50, 100, 50);
		viewAll.setBounds(650, 50, 100, 50);
		accounts.setBounds(650, 650, 100, 30);
	
		show.addMouseListener(new java.awt.event.MouseAdapter(){
			
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int index=show.getSelectedRow();
				TableModel model=show.getModel();
				name.setText(model.getValueAt(index, 0).toString());
			    age.setText(model.getValueAt(index, 1).toString());
				email.setText(model.getValueAt(index, 2).toString());
				address.setText(model.getValueAt(index, 3).toString());
				//System.out.println(value1);
			}
		});
		
		
		l1.setBounds(50, 200, 100, 30);
		name.setBounds(100, 200, 100, 30);

		l2.setBounds(220, 200, 50, 30);
		email.setBounds(270, 200, 100, 30);

		l3.setBounds(390, 200, 60, 30);
		age.setBounds(430, 200, 100, 30);

		l4.setBounds(540, 200, 70, 30);
		address.setBounds(600, 200, 100, 30);
  
		sp.setBounds(50, 300, 400, 400);
		
		frame.add(panel);
		
		
		
		frame.setVisible(true);

	}

	public void visibleP(boolean ok) {
		this.frame.setVisible(ok);
	}

	public void accounts(ActionListener e) {
		accounts.addActionListener(e);
	}

	public void addPerson(ActionListener e) {
		add.addActionListener(e);
	}

	public void deletePerson(ActionListener e) {
		delete.addActionListener(e);
	}

	public void editPerson(ActionListener e) {
		edit.addActionListener(e);
	}
	
	public void showPerson(ActionListener e) {
		viewAll.addActionListener(e);
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
	
//	public void tableMouseClick(java.awt.event.MouseEvent evt) {
//     
//		int index=show.getSelectedRow();
//		TableModel model=show.getModel();
//		String value1=(model.getValueAt(index, 0).toString());
//		int value2=Integer.parseInt(model.getValueAt(index, 1).toString());
//		String value3=model.getValueAt(index, 2).toString();
//		String value4=model.getValueAt(index, 3).toString();
//		System.out.println(value1);
//	
//	}
	
	
   
	
	
	
}

