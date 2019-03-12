package view;



import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class View {
	
	private JLabel l1 = new JLabel("First Polynomial");
    private JLabel l2 = new JLabel("Second Polynomial");
	
	private JButton b1 = new JButton("+");
	private JButton b2 = new JButton("-");
	private JButton b3 = new JButton("*");
	private JButton b4 = new JButton("/");
	private JButton b5 = new JButton("Integral");
	private JButton b6 = new JButton("Differential");
	private JLabel result=new JLabel("");

	
	private JTextField p1=new JTextField("");
	private JTextField p2=new JTextField("");
	
	public View(){
		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
	     
		
		panel.add(l1);
		panel.add(l2);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(result);
		
		panel.add(p1);
		panel.add(p2);
		
		l1.setBounds(50, 100, 100, 30);
		l2.setBounds(300, 100, 120, 30);
		p1.setBounds(50, 150, 200, 30);
		p2.setBounds(300, 150, 200, 30);
		b1.setBounds(50, 250, 160, 60);
		b2.setBounds(300, 250, 160, 60);
		b3.setBounds(50, 350, 160, 60);
		b4.setBounds(300, 350, 160, 60);
		b5.setBounds(50, 450, 160, 60);
		b6.setBounds(300, 450, 160, 60);
		result.setBounds(100,500,300,60);

		frame.setVisible(true);
		frame.add(panel);
		

	}
	public void plus(ActionListener e) {
		b1.addActionListener(e);
	}
	public void minus(ActionListener e) {
		b2.addActionListener(e);
	}
	public void ori(ActionListener e) {
		b3.addActionListener(e);
	}
	public void impartit(ActionListener e) {
		b4.addActionListener(e);
	}
	public void integral(ActionListener e) {
		b5.addActionListener(e);
	}
	public void differential(ActionListener e) {
		b6.addActionListener(e);
	}
	public void setResult(String s) {
		this.result.setText(s);
	}
	public String getP1() {
		return this.p1.getText();
	}
	public String getP2() {
		return this.p2.getText();
	}
}

