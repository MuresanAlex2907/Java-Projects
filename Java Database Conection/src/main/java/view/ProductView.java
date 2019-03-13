package view;

import java.awt.event.ActionListener;

import javax.swing.*;

public class ProductView {

	private JButton add = new JButton("ADD");
	private JButton delete = new JButton("DELETE");
	private JButton edit = new JButton("EDIT");
	private JButton viewAll = new JButton("VIEW ALL");
	private JButton back=new JButton("Back");
	
	private JButton choose=new JButton("Choose");

	
	public JTable show=new JTable();

	private JTextField description = new JTextField();
	private JTextField size = new JTextField();
	private JTextField quantity = new JTextField();
	private JTextField price = new JTextField();
	
	
	private String[] s = { "Quantity", "Price", "Size" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox comboBox = new JComboBox(s);

	private JLabel l1 = new JLabel("Description:");
	private JLabel l2 = new JLabel("Size:");
	private JLabel l3 = new JLabel("Quantity:");
	private JLabel l4 = new JLabel("Price:");
	private JLabel l5=new JLabel("Which field:");
	
	public JFrame frame = new JFrame("Product");

	/**
	 * creates the UI where the user can work with product database
	 */
	public ProductView() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JScrollPane sp=new JScrollPane(show);
		panel.add(add);
		panel.add(delete);
		panel.add(edit);	
		panel.add(viewAll);
		panel.add(back);
		panel.add(choose);
		
		panel.add(sp);
		panel.add(description);
		panel.add(price);
		panel.add(quantity);
		panel.add(size);
		panel.add(comboBox);
		
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(l5);
		
		//panel.add(show);
		show.setVisible(false);
		show.getAutoResizeMode();
		add.setBounds(50, 50, 100, 50);
		delete.setBounds(250, 50, 100, 50);
		edit.setBounds(450, 50, 100, 50);
		viewAll.setBounds(650, 50, 100, 50);
		back.setBounds(650, 650, 100, 30);
		choose.setBounds(550, 650, 100, 30);
		
		l1.setBounds(50, 200, 100, 30);	
		description.setBounds(120, 200, 100, 30);
		
		l2.setBounds(220, 200, 50, 30);
		size.setBounds(270, 200, 100, 30);
		
		l3.setBounds(370,200,60,30);
		quantity.setBounds(430, 200, 100, 30);
		
		l4.setBounds(530, 200, 50, 30);
		price.setBounds(580, 200, 100, 30);
		sp.setBounds(50, 300, 400, 400);
		
		l5.setBounds(460, 100, 100, 50);
		comboBox.setBounds(450, 150, 100, 30);
		frame.setVisible(false);
		frame.add(panel);
	}
	
	public String getDescription() {
		return description.getText();
	}
	public String getSize() {
		return size.getText();
	}
	public int getPrice() {
		return Integer.parseInt(price.getText());
	}
	public int getQuantity() {
		return Integer.parseInt(quantity.getText());
	}
	
	public void visibleP(boolean ok) {
		this.frame.setVisible(ok);
	}
	public void back(ActionListener e) {
		back.addActionListener(e);
	}
	public void addProduct(ActionListener e) {
		add.addActionListener(e);
	}
	public void deleteProduct(ActionListener e) {
		delete.addActionListener(e);
	}
	public void editProduct(ActionListener e) {
		edit.addActionListener(e);
	}
	
	public void showProduct(ActionListener e) {
		viewAll.addActionListener(e);
	}
	public String getEdit() {
		if(this.comboBox.getSelectedItem().equals("Price"))
			  return "price";
		if(this.comboBox.getSelectedItem().equals("Quantity"))
			  return "quantity";
		if(this.comboBox.getSelectedItem().equals("Size"))
			  return "size";
	return null;	
	}
	
	public void chooseButton(ActionListener e) {
		choose.addActionListener(e);
	}

}
