package uebungsblatt05;

public class DrawCurve {
	public static void main(String[] args) {
		// Lese die Anzahl der Zeichen
		int n = StdIn.readInt();

		// Lese die Zeichen nacheinander von der Standardeingabe
		StdIn.readLine();
		char[] arrayOfChar = new char[n];

		for (int j = 0; j < n; j++) {
			arrayOfChar[j] = StdIn.readChar();
		}

		int xMin = 0, xMax = 0, yMin = 0, yMax = 0;

		// 1. Step - berechne min und max von X und Y
		// 2. Step - zeichne eine Linie
		for (int step = 0; step < 2; step++) {
			// Erste mal - verpassen
			// Zveite mal - stelle die Skalierung des
			// angezeigten Koordinatensystems fest
			if (step == 1) {
				StdDraw.setXscale(xMin, xMax);
				StdDraw.setYscale(yMin, yMax);
			}

			// Current Position
			int xCurrent = 0;
			int yCurrent = 0;

			// Erste Schritt - nach Ost
			int xDelta = 1;
			int yDelta = 0;

			// Gehe durch Die eingelesene Zeichenkette
			for (int i = 0; i < n; i++) {
				if (arrayOfChar[i] == 'F' || arrayOfChar[i] == 'f') {
					// Gehe vorwaerts
					// zeichne eine Linie aber nur wenn wir 2. mal es machen
					if (step == 1) {
						StdDraw.line(xCurrent, yCurrent, xCurrent + xDelta, yCurrent + yDelta);
					}
					xCurrent += xDelta;
					yCurrent += yDelta;

					// Kalkuliere min und max fuer X und Y aber nur wenn wir 1. mal es machen
					if (step == 0) {
						if (xCurrent < xMin) {
							xMin = xCurrent;
						}
						if (xCurrent > xMax) {
							xMax = xCurrent;
						}
						if (yCurrent < yMin) {
							yMin = yCurrent;
						}
						if (yCurrent > yMax) {
							yMax = yCurrent;
						}
					}
				}
				// biege nach Links ab
				else if (arrayOfChar[i] == 'L' || arrayOfChar[i] == 'l') {
					if (xDelta == 0) {
						xDelta = -yDelta;
						yDelta = 0;
					} else {
						yDelta = xDelta;
						xDelta = 0;
					}
				}
				// biege nach Rechts ab
				else if (arrayOfChar[i] == 'R' || arrayOfChar[i] == 'r') {
					if (xDelta == 0) {
						xDelta = yDelta;
						yDelta = 0;
					} else {
						yDelta = -xDelta;
						xDelta = 0;
					}
				}

				// Bei einem anderen Wert als F, L, R melden wir einen Fehler
				else {
					System.out.println("Input error.");
					return;
				}
			}
		}
	}
}
