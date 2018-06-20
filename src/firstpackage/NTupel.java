package firstpackage;

public class NTupel {
	
	
	private Double[] values;
	
	private int tupDim;
	
	// Konstruktor, der tupDim mit einem entsprechenden Wert belegt
	// und ein entsprechend grosses Feld für die Werte anlegt
	public NTupel(int tupDim){
		//tupDim belegen
		this.tupDim=tupDim;
		// Feld anlegen. Feld ist noch leer (mit null-Referenzen gefüllt)
		this.values = new Double[tupDim];
		
	}
	
	// Konstruktor, bei dem die Werte für das feld mit übergeben werden. 
	// Die feldlänge bestimmt sich aus der Anzahl der Werte
	public NTupel(Double[] values){
		tupDim = values.length;
		/*
		//Umständliche Art, eine Kopie des Feldes anzulegen
		this.values = new Double[tupDim];
		
		for (int i=0; i<tupDim; i++){
				this.values[i] = values[i];
		}
		*/
		// Nutzen der clone-Methode der Klasse Double
		this.values=values.clone();
	}
	
	
	/** Statische Methode zur Addition zweier NTupel.
	 * Es werden zwei Objekte vom Typ NTupel übergeben, das Ergebnis steht in einem neuen Objekt.  
	 * die beiden Summanden(-Objekte) werden nicht verändert
	 * @param die beiden Summanden (bleiben unverändert)
	 * @return Das aufsummierte Ergebnisobjekt
	 */
	public static  NTupel add(NTupel oneTupel, NTupel anotherTupel){
		// Ergebnis-Objekt erzeugen
		NTupel result = new NTupel(oneTupel.tupDim);
		// Überprüfung, ob die Anzahl der Elemente gleich ist. Falls nicht, wird null
		// zurück gegeben, Der Aufrufer kann daran erkennen, dass die Methode mit einem "Fehler" 
		// beendet wurde
		if (oneTupel.getTupDim()!= anotherTupel.getTupDim()) return null;
		
		// Elementweise Addition der einzelnen Elemente in NTupel
		for (int i=0; i<result.tupDim; i++){
			// Verändert: Überprüfung, ob values[i} auch tatsächlich belegt ist
			if (oneTupel.values[i]== null || anotherTupel.values[i] == null){
				return null;
			}
			result.values[i]= oneTupel.values[i]+ anotherTupel.values[i];
		}
		return result;		
	}
	/** Methode zur Multiüplikation eines NTupels mit einen konstanten Wert. Das verwendete
	 * Objekt bleibt dabei unverändert. Fehlt in dem Array ein WEert, wird null zurück gegeben
	 * 
	 * @param factor : Wert, mit dem jedes einzelne Element multipliziert wird.
	 * @return Das Ergebnisobjekt nach der Multiplikation
 	 */
	public NTupel multiplyBy(double factor){
		NTupel result = new NTupel(this.tupDim);
		// Ergänzt: Test, ob die entsprechenden Werte überhaupt vorhanden sind
		for (int i=0; i<this.tupDim; i++){
			if (this.values[i] == null){
				return null;
			}
			result.values[i]= factor*this.values[i];
		}

		return result;
	}
	
	/** Hilfsfunktion zur bequemen Ausgabe der einzelnen Feldelemente
	 * 
	 */
	public void printValues(){
		// Anmerkung: nachträglich verändert, sodass alle Werte in einer einzigen 
		//Zeile ausgegeben werden
		System.out.println("Values: ");
		for (int i=0; i<tupDim; i++){
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}
	/** Hilfsfunktion zur bequemen Ausgabe der einzelnen Feldelemente
	 * 
	 */
	public void printValues(Double[] values){
		// Anmerkung: nachträglich verändert, sodass alle Werte in einer einzigen 
		//Zeile ausgegeben werden
		System.out.println("Values: ");
		for (int i=0; i<tupDim; i++){
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}
	
	
	/**
	 * Methode zur Ausgabe eines bestimmten Wertet des Tupels
	 * Falls der Index in einem ungültigen bBreich liegt, wird Double.NaN
	 * (NaN: Not A Number) ausgegeben. Ebenso, falls das Listenelement nicht belegt ist (null)
	 * 
	 * @param index Nummer des auszugebenden Wertes
	 * @return auzugebender Wert. 
	 * 
	 */
	public double getValueAt(int index){
		// Nachträglich eingefügt: Überprüfung, ob Index im gültigen Bereich liegt
		// und ob das Element überhaup einen Wert han (!null)
		if (index < 0 || index >= tupDim) return Double.NaN;
		if (values[index]== null) return Double.NaN;
		double wert = values[index];
		return wert;
		// oder kürzer: return values[index];
	}
	
	/**
	 * Methode zum Setzen eines  Wertes an der Stelle index
	 * 
	 * @param index Position des zu verändernden Elementes
	 * @param newValue erfolgreich: true, ansonsten false
	 * @return
	 */
	protected boolean setValueAt(int index, double newValue){
		if (index<0 || index >= tupDim) return false;
		values[index]= newValue;
		return true;
	}
	/**
	 * Überprüft, ob zwei Objekte gleich sind.
	 * Gleich bedeutet in diesem fall, dass tupDim gleich ist
	 * sowie alle Werte in values
	 * 
	 * @param tupel das andere Objekt
	 * @return Geliche Objekte: true, sonst false
	 */
	public boolean equals (NTupel tupel){
		
		// tupDim gleich?
		if (this.tupDim!= tupel.tupDim) return false;
		// alle Werte gleich
		for (int i=0; i<this.tupDim; i++){
			if (this.values[i].doubleValue() != tupel.values[i].doubleValue()){
				
				return false;
			}
			if (this.values[i].equals(values[i])){
				
				return false;
			}
			
		}
		
		return true;
	}
	/**
	 * Liefert die Dimension des Tupels
	 * @return Tupeldimension
	 */
	public int getTupDim(){
		
		return tupDim;
	}
	

	
	public String display(){
		return "not yet implemented";
	}

	// einfache "Testmethode"
	public static void main(String [] args){
		Double[] myValues= new Double[10]; 
		
		for (int i=0; i<10; i++){
			myValues[i]= i*1.0;
		}
		
		NTupel tupel1 = new NTupel(10);
		tupel1.printValues();
		
		NTupel tupel2 = new NTupel(myValues);
		tupel2.printValues();
		
		
		myValues[5] = 1000.0;
		tupel2.printValues();
		
		
	}

}
