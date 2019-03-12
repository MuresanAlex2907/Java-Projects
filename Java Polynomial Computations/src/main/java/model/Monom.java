package model;



public class Monom {
	public int getC() {
		return this.c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getP() {
		return this.p;
	}

	public void setP(int p) {
		this.p = p;
	}

	private int c;
	private int p;
	//public float c1;
	
	public Monom() {
		
	}
	
	public Monom(int c,int p) {
		this.c=c;//initialize the monom power
		this.p=p;//initialize the monom coefficient
	}
}
