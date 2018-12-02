package uebungsblatt04;

public class StringToFloat {

	public static void main(String[] args) {
		String str = args[0];

		toFloat(str);

		/*
		toFloat("01111111100000000000000000000000"); // POSITIVE INFINITY
		toFloat("11111111100000000000000000000000"); // NEGATIVE INFINITY
		toFloat("11111111100000000000000000000001"); // NaN
		toFloat("10000000000000000000000000000000"); // -0
		toFloat("00000000000000000000000000000000"); // +0
		toFloat("00000000000000000000000000011000"); // Denormalisierter Darstellung
		toFloat("00001100000000000000000000011000"); // Normalisierter Darstellung
		toFloat("00111111100000000000000000000000"); // 1
		toFloat("10111111100000000000000000000000"); //-1
		toFloat("00111111000000000000000000000000"); // 0.5
		toFloat("10111111000000000000000000000000"); //-0.5
		toFloat("00111110100000000000000000000000"); // 0.25
		toFloat("10111110100000000000000000000000"); //-0.25
		toFloat("00111110000000000000000000000000"); // 0.125
		toFloat("10111110000000000000000000000000"); //-0.125
		toFloat("00110110101001111100010110101100"); // 5.0E-6 =  0.000005f
		toFloat("10110110101001111100010110101100"); //-5.0E-6 = -0.000005f
		*/
		
		/*
		float f= 3.4E-44F; 
		int bits = Float.floatToIntBits(f);
		System.out.println(f + " \t- \t" + Integer.toBinaryString(bits));
		f= 9.86079E-32f;
		bits = Float.floatToIntBits(f);
		System.out.println(f + " \t- \t" + Integer.toBinaryString(bits));	
		*/
	}

	public static void toFloat(String str) {
		// Pruefen die Laenge
		if (str.length() != 32) {
			System.out.println("Zeichenkette hat ein falsches Format. Length = " + str.length());
			return;
		}
		// Pruefen die Zeichen
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '0' && str.charAt(i) != '1') {
				System.out.println("Zeichenkette hat ein falsche Zeichen: " + str.charAt(i));
				return;
			}

		}

		// Gib aus
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
		}
		System.out.println();

		// das Vorzeichen
		// 0 - +
		// 1 - -
		char s = str.charAt(0);
		int S = 1;
		System.out.print("das Vorzeichen (s):\t" + s);
		if (s == '1') {
			System.out.println("\t\t\t( - )");
			S = -1;
		} else {
			System.out.println("\t\t\t( + )");
		}

		// der Exponent
		String e = str.substring(1, 9);
		int E = Integer.parseInt(e, 2);
		System.out.print("der Exponent (e):\t" + e);
		System.out.println("\t\t(" + E + ")");

		// die Mantisse
		String f = str.substring(9);
		int F = Integer.parseInt(f, 2);
		System.out.println("die Mantisse (f):\t" + f);

		float mantisse = 0;
		
		if (E == 255) {
			if (F != 0) {
				System.out.println("v = NaN");
			} else {
				if (s == '1')
					System.out.println("v = NEGATIVE INFINITY");
				else
					System.out.println("v = POSITIVE INFINITY");
			}
		} else if (E == 0) {
			if (F == 0) {
				if (s == '1')
					System.out.println("v = -0");
				else
					System.out.println("v = +0");
			} else {
				System.out.println("Denormalisierter Darstellung");
				mantisse = 0;
				E = -126;
			}
		} else {
			System.out.println("Normalisierter Darstellung");
			mantisse = 1;
			E = E-127;
		}
		
		//Kalkuliere die Mantisse
		for (int i=0; i<23; i++)
		{
			int bit=0;
			if (f.charAt(i)=='1') 
				bit=1;
			mantisse+=Math.pow(2, -1*(i+1))*bit;
		}
		System.out.println("die reduzierte Mantisse (f):\t" + mantisse);
		
		//Kalkuliere V
		float v = (float) (mantisse * Math.pow(2, E)) * S;
		System.out.println("v = " + v);
		System.out.println("***");

	}
}