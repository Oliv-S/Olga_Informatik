public class EuklidModern {
    
    public static void main( String[] args ){ 
	int x = Integer.parseInt(args[0]); // Wertuebernahme von ...
	int y = Integer.parseInt(args[1]); // ... der Kommandozeile
	System.out.println("EuklidModern\n| " + "linie" + "\t| " + "x" + "\t| " + "y" + "\t| " + "r" + "\t| " + "comment");
	if ( x <= 0 || y <= 0)  { // '||' steht fuer 'oder'
	    System.out.println("nur positive Argumente!!");
	    return; // Ende
	}
	
	// ggT(x,y)                                    // M1
	int r=-1;
	System.out.println("| " + "K1" + "\t| " + x + "\t| " + y + "\t| " + "-" + "\t| " + "ggT(x,y)");
	while ( y != 0 ) {                             // M2
		System.out.print("| " + "K4" + "\t| " + x + "\t| " + y + "\t| ");
		if (r==-1)
			System.out.print("-");
		else 
			System.out.print(r);
		System.out.println("\t| " + " while(" + y + " != " + 0 + ")");
	    r = x % y;                                 // M3
		System.out.println("| " + "K4" + "\t| " + x + "\t| " + y + "\t| " + r + "\t| " + "  r = " + x + " % " + y);
	    x = y;                                     // M4
		System.out.println("| " + "K4" + "\t| " + x + "\t| " + y + "\t| " + r + "\t| " + "  x = " + y);
	    y = r;                                     // M5
		System.out.println("| " + "K4" + "\t| " + x + "\t| " + y + "\t| " + r + "\t| " + "  y = " + r);
	}
	System.out.println("| " + "K4" + "\t| " + x + "\t| " + y + "\t| " + "-" + "\t| " + " = " + x);// M6
	return;
    } 
}
