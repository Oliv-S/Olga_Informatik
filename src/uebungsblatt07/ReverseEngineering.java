package uebungsblatt07;

public class ReverseEngineering {

	public static void main(String[] args) {

		for (int i = 1; i < 50; i++) {
			System.out.println(i + "\t " + getValue(i));
		}

		
	}

	public static boolean getValue(int x) {
		boolean b = true;
		int t = 2;
		while ((t * t <= x) && b) {
			b = ((x % t) != 0);
			t++;
		}
		boolean res = (b && (x != 1));
		return res;
	}

}
