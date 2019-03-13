package view;

import java.awt.Color;

import javax.swing.*;

import model.SimulationManager;

public class ExecutionView {

	public JTextArea t1=new JTextArea();
	private JLabel l1=new JLabel("1:");
	private JLabel l2=new JLabel("2:");
	private JLabel l3=new JLabel("3:");
	private JLabel l4=new JLabel("4:");
	private JLabel l5=new JLabel("5:");
	private JLabel l6=new JLabel("6:");
	private JLabel l7=new JLabel("7:");
	private JLabel l8=new JLabel("8:");
	
	private JTextField tf1=new JTextField();
	public JTextField getTf1() {
		return tf1;
	}
	public void setTf1(String tf1) {
		this.tf1.setText(tf1);
	}
	public JTextField getTf2() {
		return tf2;
	}
	public void setTf2(String tf2) {
		this.tf2.setText(tf2);;
	}
	public JTextField getTf3() {
		return tf3;
	}
	public void setTf3(String tf3) {
		this.tf3.setText(tf3);
	}
	public JTextField getTf4() {
		return tf4;
	}
	public void setTf4(String tf4) {
		this.tf4.setText(tf4);
	}
	public JTextField getTf5() {
		return tf5;
	}
	public void setTf5(String tf5) {
		this.tf5.setText(tf5);
	}
	public JTextField getTf6() {
		return tf6;
	}
	public void setTf6(String tf6) {
		this.tf6.setText(tf6);
	}
	public JTextField getTf7() {
		return tf7;
	}
	public void setTf7(String tf7) {
		this.tf7.setText(tf7);
	}
	public JTextField getTf8() {
		return tf8;
	}
	public void setTf8(String tf8) {
		this.tf8.setText(tf8);
	}
	private JTextField tf2=new JTextField();
	private JTextField tf3=new JTextField();
	private JTextField tf4=new JTextField();
	private JTextField tf5=new JTextField();
	private JTextField tf6=new JTextField();
	private JTextField tf7=new JTextField();
	private JTextField tf8=new JTextField();
	private JFrame frame=new JFrame("Simulation");
	
	
	public ExecutionView() {
		

		 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 500);
		frame.setLocationRelativeTo(null);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		 panel.setBackground(Color.black);
		 t1.setBackground(Color.gray);
		JScrollPane p1=new JScrollPane(t1);
		p1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(p1);
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(l5);
		panel.add(l6);
		panel.add(l7);
		panel.add(l8);
		
		panel.add(tf1);
		panel.add(tf2);
		panel.add(tf3);
		panel.add(tf4);
		panel.add(tf5);
		panel.add(tf6);
		panel.add(tf7);
		panel.add(tf8);
		
		t1.setEditable(false);
		
		
		
		l1.setBounds(15,50,20,30);
		l2.setBounds(15,100,20,30);
		l3.setBounds(15,150,20,30);
		l4.setBounds(15,200,20,30);
		l5.setBounds(15,250,20,30);
		l6.setBounds(15,300,20,30);
		l7.setBounds(15,350,20,30);
		l8.setBounds(15,400,20,30);
		
		tf1.setBounds(50, 50, 400, 30);
		tf2.setBounds(50, 100, 400, 30);
		tf3.setBounds(50, 150, 400, 30);
		tf4.setBounds(50, 200, 400, 30);
		tf5.setBounds(50, 250, 400, 30);
		tf6.setBounds(50, 300, 400, 30);
		tf7.setBounds(50, 350, 400, 30);
		tf8.setBounds(50, 400, 400, 30);
		
		p1.setBounds(500, 40, 400, 400);
		
		frame.add(panel);
		frame.setVisible(false);
	}
	public void visibleTrue() {
		frame.setVisible(true);
	}
}
