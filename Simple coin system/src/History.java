import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class History extends JFrame {
	public JLabel mesaj = new JLabel("");
	public JLabel price1 = new JLabel("");
	public JLabel price2 = new JLabel("");
	public JLabel price3 = new JLabel("");
	public JLabel price4 = new JLabel("");
	public JLabel price5 = new JLabel("");
	private JButton btnClose = new JButton("Close");

	public History() {
		getContentPane().setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);

		mesaj.setBounds(30, 11, 292, 14);
		getContentPane().add(mesaj);

		price1.setBounds(30, 60, 63, 14);
		getContentPane().add(price1);

		price2.setBounds(30, 85, 63, 14);
		getContentPane().add(price2);

		price3.setBounds(30, 107, 63, 14);
		getContentPane().add(price3);

		price4.setBounds(30, 134, 63, 14);
		getContentPane().add(price4);

		price5.setBounds(30, 170, 63, 14);
		getContentPane().add(price5);

		btnClose.setBounds(308, 193, 89, 23);
		getContentPane().add(btnClose);
	}

	public void closeBtn(ActionListener e) {
		btnClose.addActionListener(e);
	}

}
