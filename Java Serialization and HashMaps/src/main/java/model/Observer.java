package model;

import javax.swing.JFrame;

public abstract class Observer {
	protected Subject subject;

	public abstract void update(JFrame frame);
}
