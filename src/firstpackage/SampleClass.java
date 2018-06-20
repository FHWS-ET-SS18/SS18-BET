package firstpackage;

public class SampleClass {
	
	private  int createdObjects;
	
	private double dynValue;
	
	SampleClass(){
		//SampleClass.createdObjects++;
		createdObjects++;
		
	}
	
	SampleClass (double dynValue){
		createdObjects++;
		this.dynValue = dynValue;

	}
	
	public int getCreatedObjects(){
		return createdObjects;
	}
	
	public double getDynValue(){
		return this.dynValue;
	}
	
	public void setDynValue(double dynValue){
		this.dynValue=dynValue;
		
	}
	
	
	
	public static void main (String[] args){
		
		/*
		System.out.println(SampleCLass.createdObjects);
		
		System.out.println(SampleClass.getCreatedObjects());
		
		SampleClass o1 = new SampleClass();
		System.out.println(SampleClass.createdObjects);
		
		SampleClass o2 = new SampleClass(10.0);
		System.out.println(SampleClass.createdObjects);
		
		System.out.println(o1.dynValue);
		System.out.println(o2.getDynValue());
		
		o1.setDynValue(20);
		
		System.out.println(o1.getDynValue());
		
		System.out.println(o1.getCreatedObjects());
		
		SampleClass o3=null;	
		//System.out.println(o3.getDynValue());
		*/
		
		SampleClass o1 = new SampleClass();
		System.out.println(o1.createdObjects);
		SampleClass o2 = new SampleClass();
		System.out.println(o2.createdObjects);
	}

}
