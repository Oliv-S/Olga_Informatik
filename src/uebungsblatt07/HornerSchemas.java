package uebungsblatt07;

public class HornerSchemas {

	public static void main(String[] args) {
		int z=16;
		int q=2;
		hornerUmkehrung( z,  q);
		System.out.println(hornerUmkehrungRekursiv( z,  q));
		System.out.println("****");
		System.out.println(hornerUmkehrungRekursivAblaufProtokol( 13,  2));
		

	}
	
	public static void hornerUmkehrung(int z, int q)
	{
		String s = "";
		do {
		s = (z % q) + s;
		z = z / q;
		} while (z != 0);
		System . out. println (s);		
	}	
	
	public static String hornerUmkehrungRekursiv(int z, int q)
	{
		if (z/q != 0)
			return hornerUmkehrungRekursiv(z/q, q) + z % q;	
		return String.valueOf(z % q);
	}
	
	public static String hornerUmkehrungRekursivAblaufProtokol(int z, int q)
	{
		if (z/q != 0)
		{
			String res = hornerUmkehrungRekursivAblaufProtokol(z/q, q) + z % q;
			System.out.println("hornerUmkehrungRekursiv( " + z + " , " + q + " ); Return value: " + res);
			return res;
		}
		String res =  String.valueOf(z % q);
		System.out.println("hornerUmkehrungRekursiv( " + z + " , " + q + " ); Return value: " + res);
		return res;
	}

}
