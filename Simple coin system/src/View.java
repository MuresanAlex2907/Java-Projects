import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class View extends JFrame {
	public JTextField textField;
	private String[] s = { "BITCOIN", "RIPPLE", "ETHEREUM" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox comboBox = new JComboBox(s);
	public JLabel bitcoin = new JLabel("-");
	public JLabel ripple = new JLabel("-");
	public JLabel ethereum = new JLabel("-");
	private JButton addPrice = new JButton("Add price");
	private JButton showBitcoin = new JButton("Show");
	private JButton showRipple = new JButton("Show");
	private JButton showEthereum = new JButton("Show");

	public View() {
		getContentPane().setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);

		comboBox.setBounds(26, 11, 98, 20);
		getContentPane().add(comboBox);

		textField = new JTextField();
		textField.setBounds(157, 11, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("$");
		label.setBounds(249, 14, 46, 14);
		getContentPane().add(label);

		addPrice.setBounds(317, 10, 89, 23);
		getContentPane().add(addPrice);

		JLabel lblCoinName = new JLabel("Coin name");
		lblCoinName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCoinName.setBounds(26, 67, 71, 14);
		getContentPane().add(lblCoinName);

		JLabel lblCurrentPrice = new JLabel("Current price($)");
		lblCurrentPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCurrentPrice.setBounds(135, 67, 98, 14);
		getContentPane().add(lblCurrentPrice);

		JLabel lblHistory = new JLabel("History");
		lblHistory.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHistory.setBounds(336, 67, 46, 14);
		getContentPane().add(lblHistory);

		JLabel lblBitcoin = new JLabel("Bitcoin");
		lblBitcoin.setBounds(26, 106, 54, 14);
		getContentPane().add(lblBitcoin);

		JLabel lblRipple = new JLabel("Ripple");
		lblRipple.setBounds(26, 146, 46, 14);
		getContentPane().add(lblRipple);

		JLabel lblEthereum = new JLabel("Ethereum");
		lblEthereum.setBounds(26, 188, 72, 14);
		getContentPane().add(lblEthereum);

		bitcoin.setBounds(135, 106, 46, 14);
		getContentPane().add(bitcoin);

		ripple.setBounds(135, 146, 46, 14);
		getContentPane().add(ripple);

		ethereum.setBounds(135, 188, 46, 14);
		getContentPane().add(ethereum);

		showBitcoin.setBounds(317, 97, 89, 23);
		getContentPane().add(showBitcoin);

		showRipple.setBounds(317, 142, 89, 23);
		getContentPane().add(showRipple);

		showEthereum.setBounds(317, 188, 89, 23);
		getContentPane().add(showEthereum);
	}

	public void addPriceBtn(ActionListener e) {
		addPrice.addActionListener(e);
	}

	public void bitcoinShow(ActionListener e) {
		showBitcoin.addActionListener(e);
	}

	public void rippleShow(ActionListener e) {
		showRipple.addActionListener(e);
	}

	public void ethereumShow(ActionListener e) {
		showEthereum.addActionListener(e);
	}
}
