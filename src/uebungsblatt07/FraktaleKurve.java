package uebungsblatt07;

/**
 * Uebungsblatt 07
 * 
 * Aufgabeteil 1.
 * Schreiben Sie eine Applikation, die eine Zeichenkette ausgibt, 
 * die zufaellig aus Buchstaben F, L und R zusammengesetzt wurde.
 * 
 * @author Olga Stuckert
 * @tutor Leon Alexander Suttmeyer
 * @uebungsgruppe 22
 * @place Universitaet Goettingen
 *
 */
public class FraktaleKurve {

	public static void main(String[] args) {
		//Die Laenge der Zeichenkette k 
		//wird auf der Kommandozeile uebergeben
		int k = Integer.parseInt(args[0]);
		
		//Negative oder zu grosse Laengen (> 100000) werden zurueckgewiesen.
		if (k<0 ||k>100000)
		{
			return;
		}
		
		//Die Laenge  wird an eine Methode uebergeben 
		methodeRandomZeichenkette(k);
	}

	//Die Methode
	public static void methodeRandomZeichenkette(int k) {
		//die k in einer Zeile ausgibt
		System.out.println(k);
		
		//In der naechsten Zeile gibt die Methode 
		//eine zufaellige Anordnung der Buchstaben
		//F, L und R aus, wobei die noetigen Zufallszahlen 
		//mit Hilfe der Funktion StdRandom.uniform, 
		//aus der in der Vorlesung eingefuehrten Bibliothek
		//stdlib.jar, erzeugt werden.
		for (int i=0; i<k; i++)
		{
			//StdRandom.uniform Returns a random integer uniformly in [0, 1, 2].
			int randomIntNumber = StdRandom.uniform(3);
			
			//gibt F, L oder R aus, abhaengig vom randomIntNumber
			switch (randomIntNumber) {
			case 0:
				System.out.print('F');
				break;
			case 1:
				System.out.print('L');
				break;
			default:
				System.out.print('R');
				break;
			}
		}
	}
}
