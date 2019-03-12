package controller;

import model.Operations;
import model.Polynomial;
import view.View;

public class Controller {
	// public static int[] a = new int[1000000];
	// public static int[] a1 = new int[1000000];
	Polynomial a = new Polynomial();
	Polynomial a1 = new Polynomial();

	public Controller() {
		View view = new View();

		// String s=new String();
		Operations op = new Operations();

		view.plus(e -> {;
			String s = view.getP1();//get the strings from the polynomials text fields
			String s1 = view.getP2();
			int ok = 0;
			try {
				a = op.convertP(s);//convert into Polynomial class
				op.k=1;
				a1 = op.convertP(s1);//convert into Polynomial class

			} catch (Exception k) {//verify if the format is correct
				ok = 1;
			}
			if (ok == 1)//if the format is incorrect we print the correct format
				view.setResult("Bad Format-> the format is a+bx+...+mx^n");
			else {
				int[] result = op.adunare(a, a1);//compute the corresponding operation
				op.afisare(view, result);//print the result
			}
		});// at all button's action listeners we follow the same steps
		view.minus(e -> {

			String s = view.getP1();//get the strings from the polynomials text fields
			String s1 = view.getP2();
			int ok = 0;
			try {
				a = op.convertP(s);
				op.k=1;
				a1 = op.convertP(s1);
			} catch (Exception k) {
				ok = 1;
			}
			if (ok == 1)
				view.setResult("Bad Format-> the format is a+bx+...+mx^n");
			else {
				int[] result = op.scadere(a, a1);
				op.afisare(view, result);
			}
		});
		view.ori(e -> {

			String s = view.getP1();//get the strings from the polynomials text fields
			String s1 = view.getP2();
			int ok = 0;
			try {
				a = op.convertP(s);
				op.k=1;
				a1 = op.convertP(s1);
			} catch (Exception k) {
				ok = 1;
			}
			if (ok == 1)
				view.setResult("Bad Format-> the format is a+bx+...+mx^n");
			else {
				int[] result = op.inmultire(a, a1);
				op.afisare(view, result);
			}
		});
		view.impartit(e -> {

			String s = view.getP1();//get the strings from the polynomials text fields
			String s1 = view.getP2();
			int ok = 0;
			try {
				a = op.convertP(s);
				op.k=1;
				a1 = op.convertP(s1);
			} catch (Exception k) {
				ok = 1;
			}

			if (ok == 1)
				view.setResult("Bad Format-> the format is a+bx+...+mx^n");
			else {
				float[] result = op.impartire(a, a1);
				op.afisareIntegral(view, result);
			}
		});
		view.differential(e -> {

			String s = view.getP1();//get the strings from the polynomials text fields
			// String s1 = view.p2.getText();
			int ok = 0;
			try {
				a = op.convertP(s);
			} catch (Exception k) {
				ok = 1;
			}
			if (ok == 1)
				view.setResult("Bad Format-> the format is a+bx+...+mx^n");
			else {
				int[] result = op.derivare(a);
				op.afisare(view, result);
			}
		});

		view.integral(e -> {

			String s = view.getP1();//get the strings from the polynomials text fields
			String s1 = view.getP2();
			int ok = 0;
			try {
				a = op.convertP(s);
			} catch (Exception k) {
				ok = 1;
			}
			if (ok == 1)
				view.setResult("Bad Format-> the format is a+bx+...+mx^n");
			else {
				float[] result = op.integrare(a);
				op.afisareIntegral(view, result);
			}
		});
	}

}
