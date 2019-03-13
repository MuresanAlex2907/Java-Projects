package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	private String name;
	private int withdraw;
	private String id;

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setState(String name,int withdraw,String id,JFrame frame) {
		this.name = name;
		this.id=id;
		this.withdraw=withdraw;
		notifyAllObservers(frame);
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers(JFrame frame) {
		for (Observer observer : observers) {
			observer.update(frame);
		}
	}
}
