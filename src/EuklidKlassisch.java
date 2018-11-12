public class EuklidKlassisch {

	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]); // Wertuebernahme von ...
		int y = Integer.parseInt(args[1]); // ... der Kommandozeile
		System.out.println("EuklidKlassisch\n| " + "linie" + "\t| " + "x" + "\t| " + "y" + "\t| " + "comment");
		if (x <= 0 || y <= 0) { // '||' steht fuer 'oder'
			System.out.println("nur positive Argumente!!");
			return; // Ende
		}

		// ggT(x,y) // K1
		System.out.println("| " + "K1" + "\t| " + x + "\t| " + y + "\t| " + "ggT(x,y)");
		while (y != 0) { // K2
			System.out.println("| " + "K2" + "\t| " + x + "\t| " + y + "\t| " + " while (" + y + "!=0)");
			System.out.println("| " + "K3" + "\t| " + x + "\t| " + y + "\t| " + "  if  (" + x + " > " + y +")");
			if (x > y) // K3
			{
				System.out.println("| " + "K4" + "\t| " + x + "\t| " + y + "\t| " + "   x = " + x + " - " + y +"");
				x = x - y; // K4
			}
			else {
				System.out.println("| " + "K5" + "\t| " + x + "\t| " + y + "\t| " + "   y = " + y + " - " + x +"");
				y = y - x; // K5
			}
		}
		System.out.println("| " + "K6" + "\t| " + x + "\t| " + y + "\t| = " + x);// K6
		return;
	}
}
