package uebungsblatt03;

/**
 *  * Ein Folge mit einfachen rekursiven Bildungsgesetz ist einen Auflistung von (unendlich
 * vielen) fortlaufend nummerierten Folgengliedern (Zahlen), wobei ein Folgenglied (nur) aus
 * dem unmittelbar vorhergehenden Folgenglied berechnet wird. Das erste Folgenglied (Startwert)
 * wird explizit angegeben, somit koennen mit demselben Bildungsgesetz verschiedene
 * Folgen aus unterschiedlichen Startwerten erzeugt werden.
 * Eine Folge kann einen Zyklus, d.h. eine sich wiederholende minimale Teilfolge, enthalten.
 * Beispiel
 * Das Bildungsgesetz fi = fi-1 mod 3 + 2 (fuer i > 0) erzeugt mit Startwert f0 = 2 die
 * Folge 2; 4; 3; 2; 4; 3; 2; 4; 3; 2; .. Diese Folge beginnt mit dem Zyklus 2; 4; 3 der Laenge 3.
 * Weiterhin sind die Zyklen 4; 3; 2 und 3; 2; 4 der Lange 3 in dieser Folge enthalten.
 * Die Mittelquadratmethode (middle square method) beschreibt ein einfaches rekursives
 * Bildungsgesetz fuer Folgen. Informieren Sie sich uber die Mittelquadratmethode unter
 * https://de.wikipedia.org.
 * 1. Programmieren Sie eine Java-Applikation, die einen Middle Square Generator fur
 * zweistellige Zahlen realisiert, wie folgt.
 * Dabei sollen, ausgehend von einem Startwert (dem ersten Folgenglied), die ersten
 * 101 Folgenglieder der nach der Mittelquadratmethode gebildetet Folge fur zweistellige
 * Zahlen ausgegeben werden
 *  * Initialisiere Sie eine int-Variable a durch interaktives Einlesen einer ganzen
 * Zahl, negative Zahlen oder Zahlen mit mehr als zwei Stellen werden zuruckgewiesen.
 * Benutzen Sie zum Einlesen die Klasse StdIn von Sedgewick/Wayne, die auch
 * im Skript verwendet wird.
 * Hinweis
 * Damit Sie Ihre Applikation compilieren und starten konnen, mussen Sie
 * StdIn.java und StdOut.java von der Webseite https://introcs.cs.princeton.edu/java/stdlib/ 
 * in das Verzeichnis mit dem Quellcode Ihrer Applikation
 * kopieren.
 *  * Iterieren Sie folgende Schritte 101-mal (durch Mitzaehlen, z.B. mit einer for-
 * Schleife).
 * - a ausgeben
 * - a quadrieren
 * - a aktualisieren, der neue Wert von a ist die zweistellige Zahl, die aus der
 * Hunderter- und Zehnerstelle von a besteht
 * * Kennzeichnen Sie die Schritte ausgeben, quadrieren, aktualisieren durch Kommentare.
 *
 * @author Olga Stuckert
 * @tutor Leon Alexander Suttmeyer
 * @uebungsgruppe 22
 * @place Universitaet Goettingen
 */
public class MittleQuadratMethode {

	public static void main(String[] args) {
		StdOut.printf("%s", "Plese input positiv integer value <100: ");
		int a = 0;
		if (!StdIn.isEmpty()) {
			a = StdIn.readInt();
		}
		
		if (a<0||a>99)
		{
			StdOut.println();
			StdOut.printf("Input error.");
			return;
		}
		
		for (int i=0; i<101; i++)
		{
			//Ausgeben
			StdOut.printf("%d \t%02d -> %04d", i , a, a*a);
			
			//Quadrieren
			a = a * a;
			
			//Aktualisieren
			//abcd -> bcd
			a = a - (a/1000)*1000;
			//bcd -> bc
			a = a/10;
			StdOut.println();
		}
	}
}
