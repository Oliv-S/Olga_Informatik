package uebungsblatt06;

public class TypeCasting {
	public static void main(String[] args) {
		short a =73;
		short b =219;
		short c=(short) (a+b);
		int d=(byte) c;
		short e= -3;
		int f=(char) e;
		int g=1;
		int h=4;
		double i=g/h *4.0;
		System . out . println ("a = " + a);
		System . out . println ("b = " + b);
		System . out . println ("c = " + c);
		System . out . println ("d = " + d);
		System . out . println ("e = " + e);
		System . out . println ("f = " + f);
		System . out . println ("g = " + g);
		System . out . println ("h = " + h);
		System . out . println ("i = " + i);
	}
}
