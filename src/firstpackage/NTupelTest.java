package firstpackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;




public class NTupelTest {
	
   private NTupel firstTupel,secondTupel;

	
	@Before
    public void setup(){
    	firstTupel = new NTupel(3);
    	secondTupel = new NTupel(new Double[]{3.0,4.0,5.0});
    	
    	
    }

	@Test
	public void test1() {
		assertEquals(3,firstTupel.getTupDim());
		assertEquals(Double.NaN,firstTupel.getValueAt(4),1.E-10);
		assertEquals(3.0,secondTupel.getValueAt(0),1.E-10);
		
	}
	
	@Test
	public void test2(){
		NTupel result = secondTupel.multiplyBy(3.0);
		assertEquals(secondTupel.getTupDim(),result.getTupDim());
		
		for (int i=0; i<secondTupel.getTupDim();i++){
			double result1= secondTupel.getValueAt(i)*3.0;
			double result2 = result.getValueAt(i);
			assertEquals(result1,result2,1.E-10);
		}
		
	}

}
