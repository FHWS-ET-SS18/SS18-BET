package firstpackage;


public class MyCalculator {
	
	public static void main (String args[]){
		// Verschiedene Tests, nicht besonders strukturiert, während der 
		// Vorlesung entwickelt, nicht weiter komentiert.
		// Die "richtigen Tests werden dann mit JUnit gemacht
		NTupel tupel1, tupel2;
		tupel1 = new NTupel(3);
		tupel2 = new NTupel(3);
		for (int i=0; i<tupel1.getTupDim();i++){
			tupel2.setValueAt(i, i);
		}
		
		//tupel1.setValueAt(0, 0);
		tupel1.setValueAt(1, 1);
		tupel1.setValueAt(2, 2);
		
		NTupel addResult = NTupel.add(tupel1, tupel2);
		
		if (addResult !=null) {
			System.out.println("habe null erwartet");
			for (int i=0; i< tupel1.getTupDim(); i++){
				System.out.println("Value: " + tupel1.getValueAt(i) 
						+ " + Value: " + tupel2.getValueAt(i)
						+" = " + addResult.getValueAt(i));
			}
		}
		
		System.out.println(tupel1.equals(tupel2));
		
		NTupel myTupel = new NTupel(4);
		if (myTupel.getTupDim()!= 3) System.out.println("TubDim falsch;");
				else System.out.println("TupDim korrekt");
		
		
		NTupel t1 = new NTupel(3);
		NTupel t2 = new NTupel(3);
		for (int i=0; i<3; i++){
			t1.setValueAt(i, i);
			t2.setValueAt(i, i);
		}
		NTupel result = NTupel.add(t1, t2);
		
		for (int i=0; i<3; i++){
			if (result.getValueAt(i) != t1.getValueAt(i)+ t2.getValueAt(i)) {
				System.out.println("add-Methode falsch");
				return;
			}
			
		}
		System.out.println("Add-Methode korrekt");
	}

}
