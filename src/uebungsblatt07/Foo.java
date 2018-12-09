package uebungsblatt07;

public class Foo {
	public static String ba(int n) {
		String s = "";
		int p=0;
		System.out.println("public static String ba(int n) \t" + n +  "\t" + (p==0?"-":p)+"\t" + (s.isEmpty()?"\"\"":s));
		for (p = 2; p * p <= n; p++) {
			System.out.println("for (p = 2; p * p <= n; p++)  \t" + n +  "\t" + (p==0?"-":p) + "\t" + (s.isEmpty()?"\"\"":s));
			System.out.println("if (n % p == 0)\t\t\t" + n +  "\t" + (p==0?"-":p) + "\t" + (s.isEmpty()?"\"\"":s) );			
			if (n % p == 0) {
				s = p + "*" + ba(n / p);
				System.out.println("s = p + \"*\" + ba(n / p);   \t" + n +  "\t" + (p==0?"-":p) + "\t" + (s.isEmpty()?"\"\"":s));
				break; // verlassen der for - Schleife
			}
		}
		System.out.println("if (p * p > n)\t\t\t" + n +  "\t" + (p==0?"-":p) + "\t" + (s.isEmpty()?"\"\"":s) );
		if (p * p > n)
		{
			s = s + n;
			System.out.println("s = s + n;\t\t\t" + n +  "\t" + (p==0?"-":p) + "\t" + (s.isEmpty()?"\"\"":s) );
		}
		System.out.println("return s;\t\t\t" + n +  "\t" + (p==0?"-":p) + "\t" + (s.isEmpty()?"\"\"":s) );
		return s;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println("Zeile\t\t\t\tn\tp\ts");
		System.out.println(ba(n));
		System.out.println(ba2(n));
	}

	public static String ba2(int n) {
		String s = "";
		int p;
		for (p = 2; p * p <= n; p++) {
			if (n % p == 0) {
				s = p + "*" + ba2(n / p);
				break; // verlassen der for - Schleife
			}
		}
		if (p * p > n)
			s = s + n;
		
		return s;
	}
}
