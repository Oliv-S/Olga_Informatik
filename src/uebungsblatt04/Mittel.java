package uebungsblatt04;

import java.util.Random;

public class Mittel
{

	public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
		if (n<2)
		{
			System.out.println("n muss groesser als 1 sein!");
			return;
		}
		Random rand = new Random();

		//Generiere n random positive Zahlen
		//von 1 bis max
		int max = 1000;
		long[] feld = new long[n];
		for (int i=0; i<n; i++)
		{
			//+1 um die Zahl > 0 zu werden
			feld[i]=rand.nextInt(max)+1;
			System.out.println(feld[i]);
		}
		
		//Arithmetische Mittel
		double arithmetischeMittel = 0;
		for (int i=0; i<n; i++)
		{
			arithmetischeMittel += feld[i];
		}
		arithmetischeMittel /= n;
		System.out.println("Arithmetische Mittel: " + arithmetischeMittel);
		
		//Geometische Mittel
		double geometischeMittel = 1;
		for (int i=0; i<n; i++)
		{
			geometischeMittel *= feld[i];
			
		}
		geometischeMittel = Math.pow(geometischeMittel, 1.0/n);
		System.out.println("Geometische Mittel: " + geometischeMittel);
		
		if (arithmetischeMittel>=geometischeMittel)
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("WIEDERLEGT");
		}
	}
}