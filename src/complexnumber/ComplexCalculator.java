package complexnumber;

import java.util.ArrayList;

public class ComplexCalculator {

	//private Complex c1[];
	private ArrayList<Complex> cNumberList1;
	private ArrayList cNumberList2;

	/*
	public ComplexCalculator (Complex c){  //Constructor-Injection
		
		c1 = new Complex[4];
		
		//c1 = new Complex();
	}
	*/
	
	public ComplexCalculator(){
		//super();
		//c1 = new Complex[4];
		cNumberList1 = new ArrayList<>();
		cNumberList2 = new ArrayList();
		
	}
	
	
	public static void main(String args[]) {
		Complex c1 = new Complex(1.0,1.0);
		Complex c2 = new Complex(2.0,2.0 );
		ComplexCalculator calc = new ComplexCalculator();

		calc.addComplexNumber(c1); //Setter-Injection
		calc.addComplexNumber(c2); //Setter-Injection
		c1.setCalc(calc);
		c2.setCalc(calc);
		// calc.c1=c;

	}

	public void addComplexNumber(Complex cn) {
		//c1[index] = cn;
		cNumberList1.add(cn);
		cNumberList2.add(cn);
	}
	
	public Complex getComplex(int index){
		if (index >= cNumberList1.size()) return null;
		
		return cNumberList1.get(index);
		//return (Complex) cNumberList2.get(index);
		
		
		
	}
		
}