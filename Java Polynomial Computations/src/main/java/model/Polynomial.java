package model;


import java.util.ArrayList;
import java.util.List;

public class Polynomial {
	public List<Monom> polynom=new ArrayList<Monom>();
	
	public Polynomial() {
	}
	
	public Polynomial(Monom monom) {
		polynom.add(monom);// we add a monom to the Polynomial list
	}
	public void addMonom(Monom monom) {
		polynom.add(monom);
	}
	public int getMonomPow(int i) {//we get the power of the monom at index i of the list
		Monom m=new Monom();
		m=this.polynom.get(i);
		return m.getP();
	}
	
	public int getMonomCoeff(int i) {//we get the coeff of the monom at index i of the list
		Monom m=new Monom();
		m=this.polynom.get(i);
		return  m.getC();
	}
	
//	public float getMonomReal(int i) {
//		Monom m=new Monom();
//		m=this.polynom.get(i);
//		return m.c1;
//	}
//	public void sumP(Monom a) {
//		int ok=0;
//		this.polynom.forEach((c)->{ if(a.p==c.p)
//			                          c.c=c.c+a.c;});
//	}
    public void makeArray(int[] a,Polynomial p) {//make an array from a polynomial list
    	for(int i=0;i<p.polynom.size();i++)
    		 a[p.getMonomPow(i)]=p.getMonomCoeff(i);
    }
    public void makePolynomial(int[] a,Polynomial p) {//make a polynomial from an array
    	Monom m=new Monom();
    	for(int i=0;i<a.length;i++)
    		 if(a[i]!=0) {
    			 m.setC(a[i]);
    			 m.setP(i);
    			p.addMonom(m); 
    		 }
    }
    
}

