package model;

import view.View;


public class Operations {
	public int k = 1;

	public Operations() {

	}

	public Polynomial convertP(String s) {
		int i = s.length();
		Monom monom = new Monom();
		Polynomial p = new Polynomial();
		int j = 0;
		String s1 = new String();
		s1 = "";
		String s2 = new String();
		String[] c = new String[i];
		c = s.split("");
		//int k1 = 0;
		if (c[0].equals("-")) {
			// k1 = -1;
			k = -1;   //here i verify if the first element is negative
			j++;
		} // else
			// k1 = 1;
		int r = j;
		while (j < i && !c[j].equals("x") && !c[j].equals("+") && !c[j].equals("-")) {
			s1 = s1 + c[j]; //verify if the first element is just a number( we do not have to write ax^0 jus a)
			j++;
		}
		if (i == j || c[j].equals("+") || c[j].equals("-")) {
			monom = new Monom(Integer.parseInt(s1) * k, 0);//add x^0 with its coefficient
			p.addMonom(monom);
			if (j < i) {
				if (c[j].equals("-"))
					k = -1;// see if the next number has the sign - (k keeps evidence of the next elements sign)
				else
					k = 1;
			}
			j++;
		} else
			j = r;
		while (j < i) {
			s1 = "";
			s2 = "";
			int aux = 1, aux1 = 1;
			while (j < i && !c[j].equals("x")) {
				s1 = s1 + c[j];
				j++;//we go thorugh the string until we find x, in s1 we save the coefficient
			}
			if (s1 != "")
				aux = Integer.parseInt(s1);//we convert the coefficient into an integer
			aux = aux * k;//we decide the sign of the coefficient
			if ((j + 1) < i && c[j + 1].equals("^"))
				j += 2;//we jump over x^ because is invalid to convert it into an integer
			else
				j++;
			while (j < i && !c[j].equals("+") && !c[j].equals("-")) {
				s2 = s2 + c[j];
				j++;//now we search for the power of x
			}
			k = 1;
			if (j < i && c[j].equals("-"))
				k = -1;// keep the sign of the next coefficient
			if (!s2.equals(""))
				aux1 = Integer.parseInt(s2);//convert the power into an array
			j++;
			monom = new Monom(aux, aux1);
			p.addMonom(monom);//add the monom to the polynomial list
		}
		return p;
	}

	public int[] adunare(Polynomial nr1, Polynomial nr2) {
		int ok = 0;
		int ok1 = 0;
		for (int i = 0; i < nr1.polynom.size(); i++) {
			ok = nr1.getMonomPow(i);//search for the maximum power of p1
		}
		for (int i = 0; i < nr2.polynom.size(); i++) {
			ok1 = nr2.getMonomPow(i);//search for the maximum power of p2
		}
		if (ok1 > ok) {
			ok = ok1;
		}
		int[] a = new int[ok + 1];//declare an array of length equal with maximum power

		nr1.polynom.forEach(p1->{ 
		    a[p1.getP()]=p1.getC();//at index i we add the coefficient corresponding with i th power in p1
		});
		nr2.polynom.forEach(p2->{ 
		    a[p2.getP()]=p2.getC()+a[p2.getP()];// we add to the i th index the coefficient corresponding with i th power in p2
		});
		
		//		for (int i = 0; i < nr1.polynom.size(); i++) {
//			a[nr1.getMonomPow(i)] = nr1.getMonomCoeff(i);
//		}
//		for (int i = 0; i < nr2.polynom.size(); i++) {
//			a[nr2.getMonomPow(i)] = a[nr2.getMonomPow(i)] + nr2.getMonomCoeff(i);
//		}
      k=1;
		return a;
	}

	public int[] scadere(Polynomial nr1, Polynomial nr2) {
		int ok = 0;
		int ok1 = 0;
		for (int i = 0; i < nr1.polynom.size(); i++) {
			ok = nr1.getMonomPow(i);
		}//same as sum we search for the maximum power
		for (int i = 0; i < nr2.polynom.size(); i++) {
			ok1 = nr2.getMonomPow(i);
		}
		if (ok1 > ok) {
			ok = ok1;
		}
		int[] a = new int[ok + 1];//make an array of the maximum power length
		for (int i = 0; i < nr1.polynom.size(); i++) {
			a[nr1.getMonomPow(i)] = nr1.getMonomCoeff(i);
		}
		for (int i = 0; i < nr2.polynom.size(); i++) {
			a[nr2.getMonomPow(i)] = a[nr2.getMonomPow(i)] - nr2.getMonomCoeff(i);
		}//here is same as summing but instead of adding in the array we subtract
        k=1;
		return a;
	}

	public int[] inmultire(Polynomial nr1, Polynomial nr2) {
		int ok = 0;
		int ok1 = 0;
		for (int i = 0; i < nr1.polynom.size(); i++) {
			ok = nr1.getMonomPow(i);
		}//same we search for the maximum power
		for (int i = 0; i < nr2.polynom.size(); i++) {
			ok1 = nr2.getMonomPow(i);
		}
		if (ok1 > ok) {
			ok = ok1;
		}
		int[] a = new int[ok + ok1 + 1]; //initialize an array with length equal with the sum of the maximum powers form both polynomials
		for (int i = 0; i < nr1.polynom.size(); i++)
			for (int j = 0; j < nr2.polynom.size(); j++) {
				a[nr2.getMonomPow(j) + nr1.getMonomPow(i)] = a[nr2.getMonomPow(j) + nr1.getMonomPow(i)]
						+ nr2.getMonomCoeff(j) * nr1.getMonomCoeff(i);//we make the product
				//at index pow(p1)+pow(p2) we add the product of the coefficients corresponding to the polynomials at that powers
			}
    k=1;
		return a;
	}

	public float[] impartire(Polynomial nr1, Polynomial nr2) {
		int max = 0, max1 = 0, c = 0, c1 = 0;
		float[] q = new float[1];
		int[] r = new int[1];
		Polynomial p = new Polynomial();
		Monom m = new Monom();
		for (int i = 0; i < nr1.polynom.size(); i++) {
			max = nr1.getMonomPow(i);
			c = nr1.getMonomCoeff(i);
		}//search for the biggest power in p1
		for (int i = 0; i < nr2.polynom.size(); i++) {
			max1 = nr2.getMonomPow(i);
			c1 = nr2.getMonomCoeff(i);
		}//search for the biggest power in p2
		int[] a = new int[max1 + 1];
		if (max > max1)
			q = new float[max - max1 + 1];
		while (max > max1) {
			r = new int[max + 2];
			q[max - max1] = c / c1;//in array q we keep the result of the division
			m.setC( c / c1);
			m.setP( max - max1);
			p.polynom.clear();
			p.addMonom(m);
			r = this.inmultire(p, nr2);//part of horner algorithm (here we have the multiplying step)
			p.polynom.clear();
			p.makePolynomial(r, p);//because my operations are on polynomials with array result we must convert each result
			r = new int[max + 1];
			r = this.scadere(nr1, p);//make the substraction
			r[max] = 0;
			nr1.polynom.clear();
			nr1.makePolynomial(r, nr1);
			max = 0;
			for (int i = 0; i < nr1.polynom.size(); i++) {
				if (nr1.getMonomCoeff(i) != 0) {
					max = nr1.getMonomPow(i);
					c = nr1.getMonomCoeff(i);
				}//see the maximum remained power
			}
		}
		k=1;
		if (max == max1)
			q[0] = c / c1;
		return q;
	}

	public int[] derivare(Polynomial nr1) {
		int ok = 0;
		for (int i = 0; i < nr1.polynom.size(); i++) {
			ok = nr1.getMonomPow(i);
		}//search for maximum power

		int[] result = new int[ok + 1];
		if (ok > 0)
			for (int i = 0; i < nr1.polynom.size(); i++) {
				if (nr1.getMonomPow(i) >= 1)
					result[nr1.getMonomPow(i) - 1] = nr1.getMonomCoeff(i) * nr1.getMonomPow(i);
			}//make the derivative with normal formula
		k=1;
		return result;
	}

	public float[] integrare(Polynomial nr1) {
		int ok = 0;
		for (int i = 0; i < nr1.polynom.size(); i++) {
			ok = nr1.getMonomPow(i);
		}//search for maximu power
		float[] result = new float[ok + 2];

		for (int i = nr1.polynom.size() - 1; i >= 0; i--) {
			result[nr1.getMonomPow(i) + 1] = (float) nr1.getMonomCoeff(i) / (nr1.getMonomPow(i) + 1);

		}//compute the integral using normal formula 
		k=1;
		return result;
	}

	public void afisare(View view, int[] result) {
		String s = new String();
		int i = 0;
		int ok = 0;
		for (int j = 0; j < result.length; j++)
			if (result[j] != 0)
				ok = 1;//see if the polynomial is not null
		if (ok == 1) {
			while (i < result.length && result[i] == 0)
				i++;
			if (i == 0)
				s = Integer.toString(result[i]);//keep the coefficient of x^0
			else {
				if (result[i] != 1)//if the coefficient is 1 we want to print just x not 1x
					s = Integer.toString(result[i]) + "x^" + Integer.toString(i);
				else
					s = "x^" + Integer.toString(i);
			}
			for (int j = i + 1; j < result.length; j++) {
				if (result[j] != 0) {
					if (result[j] > 0) {//positive coefficients
						if (result[j] != 1)//here we print all the other powers and coefficients not 0 or 1
							s = s + "+" + Integer.toString(result[j]) + "x^" + Integer.toString(j);
						else
							s = s + "+" + "x^" + Integer.toString(j);
					} else {
						if (result[j] != 1)//negative coefficients
							s = s + Integer.toString(result[j]) + "x^" + Integer.toString(j);
						else
							s = s + "x^" + Integer.toString(j);
					}
				}
			}
		} else
			s = "0";
		view.setResult(s);//set the result label
	}

	public void afisareIntegral(View view, float[] result) {//at this method we follow the same as the before printing method 
		//but here we don't print integer coefficients but float coefficients
		String s = new String();
		int i = 0;
		int ok = 0;
		for (int j = 0; j < result.length; j++)
			if (result[j] > 0)
				ok = 1;
		if (ok == 1) {
			while (i < result.length && result[i] == 0)
				i++;
			if (i == 0)
				s = Float.toString(result[i]);
			else
				s = Float.toString(result[i]) + "x^" + Integer.toString(i);
			for (int j = i + 1; j < result.length; j++) {
				if (result[j] != 0) {
					if (result[j] > 0)
						s = s + "+" + Float.toString(result[j]) + "x^" + Integer.toString(j);
					else
						s = s + Float.toString(result[j]) + "x^" + Integer.toString(j);
				}
			}
		} else
			s = "0";
		view.setResult(s);
	}

}