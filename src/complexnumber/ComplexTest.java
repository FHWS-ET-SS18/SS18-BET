package complexnumber;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import firstpackage.NTupel;

public class ComplexTest {
	
	Complex c1,c2,c3;
	Complex cm1,cm2,cm3,cm4;
	NTupel nt;
	
	@Before
	public void setup(){
		c1=new Complex(4.0, 5.0);
		c2=new Complex(6.0, 7.0);
	    c3 = Complex.add(c1, c2);
	    nt = new NTupel(2);
	    
	    cm1 = new Complex(1.0,2.0);
	    cm2 = new Complex(1.0,2.0);
	    cm3 = cm1;
	    cm4 = new Complex (2.0,3.0);
	    
	    
	}

	@Test
	public void test1() {
		
		assertEquals(4.0, c1.getReal(), 1.E-10);
		assertEquals(5.0, c1.getImag(), 1.E-10);
		assertEquals(c1.getReal()+c2.getReal(),c3.getReal(),1.E-10);
		assertEquals(c1.getImag()+c2.getImag(),c3.getImag(),1.E-10);
		
	}
	
	@Test
	public void test2(){
		//System.out.println(c3.display());
		//System.out.println(c3.toString());
		//System.out.println(c1.toString());
		System.out.println(c2);
		System.out.println(nt);
	}
	
	@Test
	public void test3(){
		assertTrue(cm1.equals(cm2));
		assertTrue (cm1.equals(cm3));
		assertFalse(cm1.equals(cm4));
		
		assertTrue("String1".equals("String1 "));
	}

}
