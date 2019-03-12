package Testing;

import org.junit.Test;

import junit.framework.TestCase;
import model.Monom;
import model.Polynomial;
import model.Operations;

public class TestinOperations extends TestCase {
	@Test
	public void test() {
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial p3 = new Polynomial();
		Operations op = new Operations();

		Monom m1 = new Monom(3, 1);
		p1.addMonom(m1);
		m1 = new Monom(2, 4);
		p1.addMonom(m1);
		m1 = new Monom(3, 6);
		p1.addMonom(m1);

		m1 = new Monom(2, 0);
		p2.addMonom(m1);
		m1 = new Monom(3, 4);
		p2.addMonom(m1);
		m1 = new Monom(1, 5);
		p2.addMonom(m1);

		m1 = new Monom(2, 1);
		p3.addMonom(m1);

		Polynomial p4 = new Polynomial();
		m1 = new Monom(2, 4);
		p4.addMonom(m1);
		m1 = new Monom(6, 5);
		p4.addMonom(m1);
		
		int[] resultsum = new int[] { 2, 3, 0, 0, 5, 1, 3 };
		int[] result1 = op.adunare(p1, p2);
		for (int i = 0; i < 7; i++)
			assertEquals(resultsum[i], result1[i]);

		int[] resultminus = new int[] { -2, 3, 0, 0, -1, -1, 3 };
		result1 = op.scadere(p1, p2);
		for (int i = 0; i < 7; i++)
			assertEquals(resultminus[i], result1[i]);

		int[] resultori = new int[] { 0, 0, 6, 0, 0, 4, 0, 6 };
		result1 = op.inmultire(p1, p3);
		for (int i = 0; i < 8; i++)
			assertEquals(resultori[i], result1[i]);

		int[] resultdiff = new int[] {3,0,0,8,0,18};
		result1=op.derivare(p1);
		for(int i=0;i<6;i++)
		   assertEquals(result1[i],resultdiff[i]);

	    float[] resultdiv=new float[] {0,0,0,1,3};
	    float[] resultf=op.impartire(p4, p3);
	    for(int i=0;i<5;i++) 
	    	assertTrue(resultdiv[i]==resultf[i]);
	
	    float[] resulti=new float[] {0,0,1};
	    resultf=op.integrare(p3);
	    for(int i=0;i<3;i++) 
	    	assertTrue(resulti[i]==resultf[i]);
	    
	}
	

}
