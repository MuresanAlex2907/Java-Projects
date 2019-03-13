package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class AccountView {

	private JButton add = new JButton("ADD");
	private JButton delete = new JButton("DELETE");
	private JButton edit = new JButton("EDIT");
	private JButton viewAll = new JButton("VIEW ALL");
	private JButton back = new JButton("BACK");
	private JButton extract = new JButton("Extract");
	private JButton addMoney=new JButton("Add Money");

	private JTextField sum = new JTextField();
	private JTextField id = new JTextField();
	private JTextField pin = new JTextField();
	private JTextField withdraw = new JTextField();

	private JLabel l1 = new JLabel("Sum:");
	private JLabel l2 = new JLabel("AcountId:");
	private JLabel l3 = new JLabel("Pin:");
	private JLabel l4 = new JLabel("Type:");
	private JLabel l5 = new JLabel("Extraction: ");

	private String[] s = { "Saving", "Spending" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox comboBox = new JComboBox(s);

	public JTable show = new JTable();
	public JFrame frame = new JFrame("Accounts");

	public AccountView() {

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
		panel.add(sp);
		panel.add(addMoney);

		panel.add(sum);
		panel.add(id);
		panel.add(pin);
		panel.add(extract);

		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(l5);
		panel.add(withdraw);

		panel.add(comboBox);

		show.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent e) {
				int index = show.getSelectedRow();
				TableModel model = show.getModel();
				sum.setText(model.getValueAt(index, 0).toString());
				id.setText(model.getValueAt(index, 1).toString());
				pin.setText(model.getValueAt(index, 2).toString());
				String value=(model.getValueAt(index, 3).toString());
				  if(value.equals("spending"))
					  comboBox.setSelectedIndex(1);
				  else
					  comboBox.setSelectedIndex(0);
				// System.out.println(value1);
			}
		});

		show.setVisible(false);
		show.getAutoResizeMode();
		add.setBounds(50, 50, 100, 50);
		delete.setBounds(250, 50, 100, 50);
		edit.setBounds(450, 50, 100, 50);
		viewAll.setBounds(650, 50, 100, 50);
		back.setBounds(650, 650, 100, 30);
		extract.setBounds(550, 650, 100, 30);
		addMoney.setBounds(600, 620, 100, 30);

		l5.setBounds(600, 550, 100, 30);
		withdraw.setBounds(600, 580, 100, 30);

		l1.setBounds(50, 200, 100, 30);
		sum.setBounds(100, 200, 100, 30);

		l2.setBounds(220, 200, 70, 30);
		id.setBounds(280, 200, 100, 30);

		l3.setBounds(390, 200, 60, 30);
		pin.setBounds(430, 200, 100, 30);

		l4.setBounds(540, 200, 100, 30);
		comboBox.setBounds(600, 200, 100, 30);

		sp.setBounds(50, 300, 400, 400);

		frame.add(panel);
		frame.setVisible(false);

	}

	public void visibleA(boolean ok) {
		this.frame.setVisible(ok);
	}

	public void back(ActionListener e) {
		back.addActionListener(e);
	}

	public void addAccount(ActionListener e) {
		add.addActionListener(e);
	}

	public void deleteAccount(ActionListener e) {
		delete.addActionListener(e);
	}

	public void editAccount(ActionListener e) {
		edit.addActionListener(e);
	}

	public void showAccount(ActionListener e) {
		viewAll.addActionListener(e);
	}

	public String getId() {
		return id.getText();
	}

	public int getWithdraw() {
		return Integer.parseInt(withdraw.getText());
	}

	public String getpin() {
		return pin.getText();
	}

	public int getSum() {
		return Integer.parseInt(sum.getText());
	}

	public String getType() {
		if (comboBox.getSelectedItem().equals("Saving"))
			return "saving";
		else
			return "spending";
	}

	public void addExtract(ActionListener e) {
		extract.addActionListener(e);
	}
	
	public void addMoney(ActionListener e) {
		addMoney.addActionListener(e);
	}

}
