package complexnumber;

import firstpackage.NTupel;

public class Complex extends NTupel {
	
	//private double absValue,phase;
	
	private ComplexCalculator calc;
	
	public Complex(){
		super(2);
	}
	
	public Complex(double real, double imag){
		super(2);
		this.setValueAt(0, real);
		this.setValueAt(1, imag);
		
	}
	
	public void setCalc(ComplexCalculator calc){
		this.calc=calc;
	}
	
	public double getReal(){
		return getValueAt(0);
	}
	
	public double getImag(){
		return this.getValueAt(1);
	}
	
	public void setReal(double real){
		this.setValueAt(0, real);
	}
	
	public void setImag(double imag){
		this.setValueAt(0, imag);
	}
	
	public static Complex add(Complex c1, Complex c2){
		NTupel  nTresult  = NTupel.add(c1,c2);
		Complex cPresult = new Complex(nTresult.getValueAt(0), nTresult.getValueAt(1));
		return cPresult;
	}
	
	public double getAbsValue(){
		//return Math.sqrt(Math.pow(getReal(), 2.) + Math.pow(getImag(), 2.));
		return Complex.getAbsValue(getReal(), getImag());
	}
	
	public static double getAbsValue(double real,double imag){
		return Math.sqrt(Math.pow(real, 2.) + Math.pow(imag, 2.));
	}
	
	public double getPhase(){
		return Math.atan2(getImag(),getReal());
	}
	
	public Complex multiply(Complex c1, Complex c2){
		double newAbsValue = c1.getAbsValue()*c2.getAbsValue();
		double newPhase = c1.getPhase()+c2.getPhase();
		
		return new Complex(newAbsValue*Math.cos(newPhase),
				newAbsValue*Math.sin(newPhase));
		
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append(super.toString()).append("\n");
		buf.append("Realteil: ").append(getReal()).append("\n");
		buf.append("Imagteil: ").append(getImag()).append("\n");
		buf.append("Betrag: ").append(getAbsValue()).append("\n");
		buf.append("Phase: ").append(getPhase()).append("\n");
		
		return buf.toString();
	
	}
	
	
	
	
	
}
