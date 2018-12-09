public class CollatzVermutung {

	public static void main(String[] args) {
		// Pruefe wie viele Zahlen von der Kommandozeile uebertragen wurden
		if (args.length == 1) { // 1 Argument
								// Uebernemme die Zahl n von der Kommandozeile
			int n = Integer.parseInt(args[0]);

			if (n < 1) {
				System.out.print("Die Zahl muss > 0 sein!");
				return;
			}

			// Rufe die Methode collatzIterativOutput auf
			System.out.println("collatzIterativOutput:");
			collatzIterativOutput(n);

			System.out.println("*******");

			// Rufe die Methode collatzIterativ auf
			System.out.println("collatzIterativ:");

			// Gebe Elementen des Arrays aus
			int[] result = collatzIterativ(n);
			if (result==null)
			{
				System.out.println("A0 = " + n);
				return;
			}
			for (int i = 0; i < result.length; i++) {
				System.out.println("A" + i + " = " + result[i]);
			}
			return;
		} else if (args.length == 2) { // 2 Argumente
										// Uebernemme die Zahlen n und m von der Kommandozeile
			int n = Integer.parseInt(args[0]);
			int m = Integer.parseInt(args[1]);

			if (n < 1 || m < 1 || n > m) {
				System.out.print("Die Zahlen muss > 0 sein, und m>n sein!");
				return;
			}

			// mit der Methode collatzIterativ wird geprueft,
			// ob die Collatz-Vermutung fuer die Zahlen n bis m zutrifft
			for (int i = n; i <= m; i++) {
				
				if (collatzIterativ(i) == null) {
					System.out.println("Für die Collatz-Vermutung für die Zahlen " + n + " und " + m
							+ " keine Aussage gemacht werden kann");
					return;
				}
			}
			System.out.println("Die Collatz-Vermutung für die Zahlen " + n + " und " + m + " ist wahr");
			return;
		}
		System.out.print("Falsche Anzahl von Parametern wurden uebertragen!");
	}

	public static void collatzIterativOutput(int n) {
		// aktuelles Element des Feldes
		int aCurrent = n,
				// vorheriges Element des Feldes
				aPrev = n;

		int counter = 0;// Counter

		while (aCurrent != 1 && aCurrent != Integer.MAX_VALUE) {
			System.out.println("A" + counter + " = " + aCurrent);
			counter++;

			if (aPrev % 2 == 0) {
				// Wenn aPrev gerade ist
				aCurrent = aPrev / 2;
			} else { // wenn aPrev ungerade ist

				// Pruefe ob bei der Berechnung eines Folgenglieds ein Wert groesser
				// als Integer.MAX_VALUE wuerde
				if (aPrev > (Integer.MAX_VALUE - 1) / 3) {
					System.out.println("Nexter Wert soll groesser als Integer.MAX_VALUE wurde. Ende!");
					return;
				}
				// Ansonst
				aCurrent = aPrev * 3 + 1;
			}
			aPrev = aCurrent;
		}
		System.out.println("A" + counter + " = " + aCurrent);
	}

	public static int[] collatzIterativ(int n) {
		// Ein Array, das nur ein Element enthält.
		int[] a = { n };

		return appendInt(a, 1);
	}

	public static int[] appendInt(int[] a, int b) {
		// Ein neues Array ist 2 mal goesser als das Array a
		int[] newA = new int[a.length * 2];

		// Kopiere den Inhalt eines Arrays in ein anderes
		for (int i = 0; i < a.length; i++) {
			newA[i] = a[i];
		}

		int counter = a.length - 1;// Counter

		// Leztes Element im Array a ist fuer uns ein vorheriges Element
		// aPrev = a[counter-1],
		// aCurrent = a[counter];

		do {
			counter++;

			if (newA[counter - 1] % 2 == 0) {
				// Wenn aPrev gerade ist
				newA[counter] = newA[counter - 1] / 2;
			} else {
				// wenn aPrev ungerade ist

				// Pruefe ob bei der Berechnung eines Folgenglieds ein Wert groesser
				// als Integer.MAX_VALUE wuerde
				if (newA[counter - 1] > (Integer.MAX_VALUE - 1) / 3) {
					System.out.println("Nexter Wert soll groesser als Integer.MAX_VALUE wurde. Ende!");
					return null;
				}
				// Ansonst
				newA[counter] = newA[counter - 1] * 3 + 1;
			}

			// Prüfe, ob das Array voll ist
			if (counter == newA.length - 1) {
				// Ein neues Array ist 2 mal goesser als vorheriges Array
				int[] newB = new int[newA.length * 2];

				// Kopiere den Inhalt eines Arrays in ein anderes
				for (int i = 0; i < newA.length; i++) {
					newB[i] = newA[i];
				}
				
				//Nutze ein neues Array 
				newA = newB;
			}
		} while (newA[counter] != 1 && newA[counter] != Integer.MAX_VALUE);

		// Wenn das Array goesser als der Zahl der Elementen ist
		if (counter < newA.length - 1) {
			int newArraySize = counter + 1;

			// Ein neues Array, das genau so gross ist wie es bedarf
			int[] newB = new int[newArraySize];

			// Kopiere den Inhalt eines Arrays in ein anderes
			for (int i = 0; i < newArraySize; i++) {
				newB[i] = newA[i];
			}
			//Gebe ein neues Array zurueck
			return newB;
		}

		// Ansonst
		return newA;
	}
}