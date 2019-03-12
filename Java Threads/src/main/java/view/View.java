package view;

import java.awt.event.ActionListener;

import javax.swing.*;



public class View {
	private JLabel arMin=new JLabel("ArrivalMin");
	  private JLabel arMax=new JLabel("ArrivalMax");
	  private JLabel prMin=new JLabel("ProcessingMin");
	  private JLabel prMax=new JLabel("ProcessingMax");
	  private JLabel nrTasks=new JLabel("NrTasks");
	  private JLabel nrServers=new JLabel("Servers");
	  private JLabel timeLimit=new JLabel("TimeLimit");
	 
	  
	  private JTextField tArMin=new JTextField();
	  private JTextField tArMax=new JTextField();
	  private JTextField tPrMin=new JTextField();
	  private JTextField tPrMax=new JTextField();
	  private JTextField tNrTasks=new JTextField();
	  private JTextField tNrServers=new JTextField();
	  private JTextField tLimit=new JTextField();
	
	  private JFrame frame=new JFrame("Queue");
	  private JButton start=new JButton("Start");
	  
	 public View() {
		 
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(700, 700);
			frame.setLocationRelativeTo(null);
			JPanel panel = new JPanel();
			panel.setLayout(null);
		 
		panel.add(arMax);
		panel.add(arMin);
		panel.add(nrServers);
		panel.add(nrTasks);
		panel.add(prMax);
		panel.add(prMin);
		panel.add(start);	
		panel.add(timeLimit);
	
		
		panel.add(tArMax);
		panel.add(tArMin);
		panel.add(tLimit);
		panel.add(tNrServers);
		panel.add(tNrTasks);
		panel.add(tPrMax);
		panel.add(tPrMin);
		
		panel.add(start);
		 
		arMin.setBounds(50, 50, 100, 30);
		arMax.setBounds(300,50,100,30);
		tArMin.setBounds(160,50,100,30);
		tArMax.setBounds(460,50,100,30);
		
		prMin.setBounds(50, 150, 100, 30);
		prMax.setBounds(300,150,100,30);
		tPrMin.setBounds(160,150,100,30);
		tPrMax.setBounds(460,150,100,30);
		
		nrTasks.setBounds(50,250,100,30);
		tNrTasks.setBounds(160,250,100,30);
		
		timeLimit.setBounds(50,450,100,30);
		tLimit.setBounds(160,450,100,30);
		
		nrServers.setBounds(50,350,100,30);
		tNrServers.setBounds(160,350,100,30);
		
		
		
		start.setBounds(400, 500, 200, 70);
	
		frame.add(panel);
		frame.setVisible(true);
		
	 
	 }

	public int gettArMin() {
		return Integer.parseInt(tArMin.getText());
	}

	public int gettArMax() {
		return Integer.parseInt(tArMax.getText());
	}

	public int gettPrMin() {
		return Integer.parseInt(tPrMin.getText());
	}

	public int gettPrMax() {
		return Integer.parseInt(tPrMax.getText());
	}

	public int gettNrTasks() {
		return Integer.parseInt(tNrTasks.getText());
	}

	public int gettNrServers() {
		return Integer.parseInt(tNrServers.getText());
	}

	public int gettLimit() {
		return Integer.parseInt(tLimit.getText());
	}

	
   
	public void addStart(ActionListener e) {
		start.addActionListener(e);
	}
	
	public void visibleFalse() {
		frame.setVisible(false);
	}


}
