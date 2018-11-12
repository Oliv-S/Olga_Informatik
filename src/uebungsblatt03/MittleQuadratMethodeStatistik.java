package uebungsblatt03;

public class MittleQuadratMethodeStatistik {

	public static void main(String[] args) {
		
		//Überprüfe den Zyklus für jede Nummer 
//		for (int i=1; i<99;i++)
//		{
//			calcZyklus(i);
//		}	
		
		StdOut.printf("2.a. Der Eingabewert, der eine Folge erzeugt, die mit einem Zyklus beginnt"); 
		StdOut.println();
		calcZyklus(50);
		StdOut.printf("2.b. Der Eingabewert, der eine Folge erzeugt, die einen Zyklus enthaelt, aber nicht damit beginnt");
		StdOut.println();
		calcZyklus(56);
		
		StdOut.printf("3.a. Eine Folge, die mit einem Zyklus der Länge 2 beginnt"); 
		StdOut.println();
		calcZyklus(57);
		StdOut.printf("3.b. Ein Zyklus der Laenge 2 enthaelt, aber nicht damit beginnt");
		StdOut.println();
		calcZyklus(79);
		
		StdOut.printf("4. Die Folgen, welche einen Zyklus der Laenge groesser 1 enthalten"); 
		StdOut.println();
		calcZyklus(24);
		calcZyklus(57);
		calcZyklus(79);
		
		
	}
	
	//Ausgeben alle Werte der Folge bis limit
	public static int printFolge(int value, int limit) {
		for (int i=0; i<101; i++)
		{   //Ausgeben
			StdOut.printf("%d \t%02d -> %04d", i+1 , value, value*value);
			value = getNext(value);
			StdOut.println();	
			if (i>=limit) return value;
		}
		return value;
	}
	
	public static void calcZyklus(int value)
	{
		//initialisieren Hase und Igel 
		int hase = value;
		int igel = value;
		for (int i=0; i<50; i++)
		{
			//aktualisieren Hase und Igel 
			hase = getNext(getNext(hase));
			igel = getNext(igel);
			
			if (hase==igel)
			{
				//Zyklus gafunden!!!
				int lange=0;
				if (igel==getNext(igel))
					lange = 1;
				else 
					//mehr als 1
					lange = 2;
				
				//Zyklus start
				int start = 0;
				if (igel==value)
					start = 1;
				else start = i+2;				
				
				StdOut.printf("%d - cycle start: %d, lange: %d", value, start, lange);
				StdOut.println();
				
				//Ausgeben alle werte bis der Annfang des Zyklus
				printFolge(value, i+2);
				break;
			}
		}
//		StdOut.printf("***********");
		StdOut.println();		
	}
	
	public static int getNext(int value)
	{
		//Quadrieren
		value = value * value;
		
		//Aktualisieren
		//abcd -> bcd
		value = value - (value/1000)*1000;
		//bcd -> bc
		return value/10;
	}
}
