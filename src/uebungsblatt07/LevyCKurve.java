package uebungsblatt07;

import java.util.Arrays;

/**
 * Uebungsblatt 07
 * 
 * Aufgabeteil 3. Erweitern Sie die Applikation aus Aufgabeteil 2, so dass auch
 * eine Zeichenkette fuer die Levy-C-Kurve der Ordnung k konstruiert und
 * ausgegeben werden kann.
 * 
 * @author Olga Stuckert
 * @tutor Leon Alexander Suttmeyer
 * @uebungsgruppe 22
 * @place Universitaet Goettingen
 *
 */
public class LevyCKurve {

	public static void main(String[] args) {

		// Auf der Kommandozeile wird ein Buchstaben
		// und eine ganze Zahl erwartet.

		String buchstaben = args[0];

		// Die Laenge der Zeichenkette k
		// wird auf der Kommandozeile uebergeben
		int k = Integer.parseInt(args[1]);

		// Ungueltige Buchstaben, sowie negative oder zu grosse Ordnungen der
		// Drachenkurve
		// (> 20) und ungueltige Laengen werden zurueckgewiesen.
		// Negative oder zu grosse Laengen (> 100000) werden zurueckgewiesen.
{
		char[] feld = methodeLeyCKurve(0);
		System.out.println(feld);
		System.out.println(ersetzeZeichen(feld));
		System.out.println(feld);
		feld = methodeLeyCKurve(1);
		System.out.println(feld);
		System.out.println(ersetzeZeichen(feld));
		System.out.println(feld);
		feld = methodeLeyCKurve(2);
		System.out.println(feld);
		System.out.println(ersetzeZeichen(feld));
		System.out.println(feld);
		feld = methodeLeyCKurve(3);
		System.out.println(feld);
		System.out.println(ersetzeZeichen(feld));
		System.out.println(feld);
}

		// die Ordnung der Levy-C-Kurve
		if (buchstaben.equals("L") && (k >= 0 || k <= 20)) {
			// Eine Levy-C-Kurve der Ordnung k wird durch ein Zeichenkette
			// der Laenge 2k+1repräsentiert.
			int laengeDerZeichenkette = (int) Math.pow(2, k + 1) - 1;

			// Die Laenge der Zeichenkette und die Zeichenkette selbst
			// werden ausgegeben, jeweils in einer Zeile.
			System.out.println(laengeDerZeichenkette);

			char[] feld = methodeLeyCKurve(k);
			System.out.println(feld);
			System.out.println(ersetzeZeichen(feld));
			System.out.println(feld);
			
			return;
		}

		// die Ordnung der Drachenkurve
		if (buchstaben.equals("D") && (k >= 0 || k <= 20)) {
			// Eine Drachenkurve der Ordnung k wird durch ein Zeichenkette
			// der Laenge 2k+1repräsentiert.
			int laengeDerZeichenkette = (int) Math.pow(2, k + 1) - 1;

			// Die Laenge der Zeichenkette und die Zeichenkette selbst
			// werden ausgegeben, jeweils in einer Zeile.
			System.out.println(laengeDerZeichenkette);

			// Es wird ein Feld von char der passenden Laenge erzeugt
			char[] feld = new char[laengeDerZeichenkette];
			// und an eine Methode uebergeben,
			methodeDrachenkurve(feld, k);

			System.out.println(feld);
			return;
		}

		// Random Zeichenkette
		if (buchstaben.equals("R") && (k >= 0 || k <= 100000)) {
			System.out.println("Random-Zeichenkette");
			methodeRandomZeichenkette(k);
			return;
		}

		// Ander
		System.out.println("Input Error! Ungueltige Buchstaben, oder negative oder zu grosse"
				+ " Ordnungen der Drachenkurve, oder ungueltige Laengen der Random-Zeichenkette.");

		// Die Laenge wird an eine Methode uebergeben

	}

	// Die Methode konstruiert eine Zeichenkette fuer die Levy-C-Kurve
	// der Ordnung k
	private static char[] methodeLeyCKurve(int k) {

		char[] result = null;
		for (int i = 0; i <= k; i++) {
			result = methodeLeyCKurvePlusEins(result);
		}
		return result;
	}

	// Die Methode ersetzt in einem Feld von char einen Levy-C-Kurve
	// mit den Zeichen F, + und - durch L, R.
	// Dabei soll kein neues Feld erzeugt und die F-L-R-Zeichenkette
	// im uebergebenen Feld zurueckgeliefert werden.
	private static int ersetzeZeichen(char[] feld) {

		// Um die Levy-C-Kurve mit F, L und R zu repraesentiert, werden
		// zuerst die Zeichen vor dem ersten und nach dem letzten F entfernt.
		int positionOfFirstF = 0;
		for (int i = 0; i < feld.length; i++) {
			if (feld[i] == 'F') {
				positionOfFirstF = i;
				break;
			}
		}

		// verpasse die Zeichen vor dem ersten F
		int readPosition = positionOfFirstF;
		int writePosition = 0;

		// verpasse auch die Zeichen nach dem letzten F
		while (readPosition < feld.length - positionOfFirstF) {
			if (feld[readPosition] == 'F') {
				feld[writePosition] = feld[readPosition];
				writePosition++;
				readPosition++;
				continue;
			}
			if (feld[readPosition] == '-') {
				if (feld[readPosition + 1] == '-') {
					// -- -> L
					feld[writePosition] = 'L';
					writePosition++;
					readPosition += 2;
					continue;
				} else if (feld[readPosition + 1] == '+') {
					// -+ -> verpassen
					readPosition += 2;
					continue;
				}
			}
			if (feld[readPosition] == '+') {
				if (feld[readPosition + 1] == '+') {
					// ++ -> R
					feld[writePosition] = 'R';
					writePosition++;
					readPosition += 2;
					continue;
				} else if (feld[readPosition + 1] == '-') {
					// +- -> verpassen
					readPosition += 2;
					continue;
				}
			}
		}
		
		//ersetzte alle andere Zeichen mit 0
		for (int i=writePosition; i<feld.length; i++)
		{
			feld[i] = 0;
		}
		
		return writePosition; 
	}

	private static char[] methodeLeyCKurvePlusEins(char[] feld) {
		// Die Zeichenkette = F repraesentiert
		// die Levy-C-Kurve der Ordnung 0.
		if (feld == null) {
			return new char[] { 'F' };
		}

		int lengthOfFeld = feld.length;

		// Wenn die Ordnung > 0 ist
		// Ordnung C(i+1) = '+' + C(i) + '-' + '-' + C(i) + '+'
		int newLengthOfFeld = feld.length * 2 + 4;

		// Erstelle ein neues Array fuer die Ordnung + 1
		char[] ordnungPlusEins = new char[newLengthOfFeld];

		ordnungPlusEins[0] = '+';
		ordnungPlusEins[lengthOfFeld + 1] = '-';
		ordnungPlusEins[lengthOfFeld + 1 + 1] = '-';
		ordnungPlusEins[newLengthOfFeld - 1] = '+';

		for (int i = 0; i < lengthOfFeld; i++) {
			ordnungPlusEins[i + 1] = feld[i];
			ordnungPlusEins[i + 1 + lengthOfFeld + 2] = feld[i];
		}

		return ordnungPlusEins;
	}

	// Die Methode aus Aufgabeteil 1.
	private static void methodeRandomZeichenkette(int k) {
		// die k in einer Zeile ausgibt
		System.out.println(k);

		// In der naechsten Zeile gibt die Methode
		// eine zufaellige Anordnung der Buchstaben
		// F, L und R aus, wobei die noetigen Zufallszahlen
		// mit Hilfe der Funktion StdRandom.uniform,
		// aus der in der Vorlesung eingefuehrten Bibliothek
		// stdlib.jar, erzeugt werden.
		for (int i = 0; i < k; i++) {
			// StdRandom.uniform Returns a random integer uniformly in [0, 1, 2].
			int randomIntNumber = StdRandom.uniform(3);

			// gibt F, L oder R aus, abhaengig vom randomIntNumber
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

	// Gib eine Zeichenkette d0 = F repraesentiert
	// die Drachenkurve der Ordnung 'ordnung' zurueck
	public static void methodeDrachenkurve(char[] feld, int k) {
		String recursieveDrachenkurveResult = methodeDrachenkurveRecursive(k);
		for (int i = 0; i < feld.length; i++) {
			feld[i] = recursieveDrachenkurveResult.charAt(i);
		}
	}

	// Gib eine Zeichenkette d0 = F repraesentiert
	// die Drachenkurve der Ordnung 'ordnung' zurueck
	public static String methodeDrachenkurveRecursive(int ordnung) {

		// Fuer eine Ordnung == 0, ein Resultat ist immer F
		if (ordnung == 0) {
			return "F";
		}

		// Bekomme ein Resultat fuer eine Ordnung-1
		String ordnungMinusEins = methodeDrachenkurveRecursive(ordnung - 1);

		// ein Resultat fuer eine Ordnung entsteht aus der Zeichenkette
		// der Drachenkurve mit Ordnung-1, dann kommt R und dann kommt umgekehrter
		// Reihenfolge der Drachenkurve mit Ordnung-1
		return ordnungMinusEins + "R" + kehrReihenfolgeUm(ordnungMinusEins);
	}

	// Gib umgekehrter Reihenfolge zurueck,
	// wobei in der Umkehrung von Di jedes L durch ein R und jedes
	// R durch ein L ersetzt wird.
	public static String kehrReihenfolgeUm(String reihenfolge) {
		// Neue variable um umgekehrter Reihenfolge zu speichern
		String umgekehrterReihenfolge = new String();

		// Pruefe alle Buchstaben
		for (int i = reihenfolge.length() - 1; i >= 0; i--) {
			switch (reihenfolge.charAt(i)) {
			// ersetze L durch R
			case 'L':
				umgekehrterReihenfolge += "R";
				break;
			// ersetze R durch L
			case 'R':
				umgekehrterReihenfolge += "L";
				break;
			// speichere alle anderen Buchstaben ohne aenderungen
			default:
				umgekehrterReihenfolge += reihenfolge.charAt(i);
				break;
			}
		}
		return umgekehrterReihenfolge;
	}
}
