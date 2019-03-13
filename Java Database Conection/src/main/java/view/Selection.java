package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Selection {
	private JButton client_button = new JButton("CLIENT");
	private JButton product_button = new JButton("PRODUCT");
	private JFrame frame = new JFrame("Select");
	/**
	 * creates the UI where the client can choose between product and client
	 */
	public Selection() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.add(client_button);
		panel.add(product_button);

		client_button.setBounds(100, 250, 150, 100);
		product_button.setBounds(300, 250, 150, 100);

		frame.setVisible(true);
		frame.add(panel);

	}

	public void productButton(ActionListener e) {
		product_button.addActionListener(e);
	}

	public void clientButton(ActionListener e) {
		client_button.addActionListener(e);
	}
	
	public void visibleS(Boolean ok) {
		this.frame.setVisible(ok);
	}
}
