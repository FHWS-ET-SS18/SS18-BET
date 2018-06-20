package firstpackage;


import java.lang.*;
import java.util.*;

public class My1Class {

	private static int createdObjects = 0;
	
	private double dynValue;
	
	//Konstruktor
	public My1Class(double startValue){
		dynValue = startValue;
		createdObjects++;
	}
	

	public static void main(String [] arg){
		My1Class mfClass1 = new My1Class(3.0);
		My1Class mfClass2 = new My1Class(4.0);
		System.out.println("so kann man sich eine Referenz vorstellen: "+ mfClass1);
		System.out.println(mfClass1.dynValue +";" + mfClass2.dynValue);
		mfClass1.dynValue=7.0;
		System.out.println(mfClass1.dynValue+";" + mfClass2.dynValue);
		mfClass2 = mfClass1; 
		System.out.println(mfClass1.dynValue+";" + mfClass2.dynValue);
		mfClass1.dynValue=5.0;
		System.out.println(mfClass1.dynValue+";" + mfClass2.dynValue);
	}
	
	
}
