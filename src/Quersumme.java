
public class Quersumme {

	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]); // Wertuebernahme von ...

		System.out.println("Quersumme von " + x + " = " + qsumme(x));
	}
	
	public static int qsumme(int a)
	{
		if (a<10)
		{
			return a;
		}
		String A = String.valueOf(a);

		int sum=0;
		for (int i = 0;i<A.length();i=i+1)
		{
			sum = sum + Integer.parseInt(String.valueOf(A.charAt(i)));
		}
		
		return qsumme(sum);
	}

}

