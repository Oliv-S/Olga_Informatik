package uebungsblatt03;

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
