package uebungsblatt06;

import uebungsblatt05.StdIn;

public class Binaercode {

	public static void main(String[] args) {
		// Lese die Anzahl der Zeichen
		int n = StdIn.readInt();

		// Lese die Zeichen nacheinander von der Standardeingabe
		StdIn.readLine();
		byte[] a = new byte[n];

		for (int j = 0; j < n; j++) {
			char currentChar = StdIn.readChar();
			switch (currentChar) {
			case '0':
				a[j] = 0;
				break;
			default:
				a[j] = 1;
				break;
			}
		}

		// Gebe die Zeichen aus
		for (int i = 0; i < n; i++)
			System.out.print(a[i]);
		System.out.println();

		// Rufe einer rekursiven void-Methode auf
		voidMethode(a, a.length - 1);

		// Gebe die Ableitung aus
		for (int i = 0; i < n; i++)
			System.out.print(a[i]);
		System.out.println();

		// Rufe einer rekursiven void-Methode auf, die die Umkehrung einer
		// Ableitung bestimmt
		umkehrungVoidMethode(a, 0);

		// Gebe die Umkehrung aus
		for (int i = 0; i < n; i++)
			System.out.print(a[i]);
		System.out.println();
	}

	public static void voidMethode(byte[] arrayOfByte, int currentPosition) {
		if (currentPosition > 0) {
			if (arrayOfByte[currentPosition] == arrayOfByte[currentPosition - 1])
				arrayOfByte[currentPosition] = 0;
			else
				arrayOfByte[currentPosition] = 1;
			voidMethode(arrayOfByte, currentPosition - 1);
		}
	}

	public static void umkehrungVoidMethode(byte[] arrayOfByte, int currentPosition) {
		// In der ersten Position machen wir nichts
		if (currentPosition > 0) {
			if (arrayOfByte[currentPosition] == 1)
				if (arrayOfByte[currentPosition - 1] == 1)
					arrayOfByte[currentPosition] = 0;
				else
					arrayOfByte[currentPosition] = 1;
			else
				arrayOfByte[currentPosition] = arrayOfByte[currentPosition - 1];
		}
		if (currentPosition < arrayOfByte.length - 1)
			umkehrungVoidMethode(arrayOfByte, currentPosition + 1);
	}
}
