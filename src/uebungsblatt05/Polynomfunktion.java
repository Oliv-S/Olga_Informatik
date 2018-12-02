package uebungsblatt05;


/**
 * Polynome sind Ausdruecke der Gestalt
 * p(x) = An*X^n + A(n-1)*X^(n-1) + ... + A1*x + A0
 * wobei die Koeffizienten des Polynoms An; A(n-1); ... ; A1; A0 
 * beliebige Zahlen sind. Die Polynomfunktion x -> p(x) ordnet den Wert zu, 
 * der durch Einsetzen von x entsteht.
 * Sei
 * q(x) = An*X^n^2 + A(n-1)*X^(n-1)^2 + ... + A2*x^2^2 + A1*x + A0
 * ein spezielles Polynon mit quadratischen Exponenten und ganzzahligen Koeffizienten
 * An; A(n-1); ... ; A1; A0 
 * Unmittelbar aus der Definition von q ergibt sich ein Algorithmus zur Berechnung des
 * Funktionswertes der zugehoerigen Polynomfunktion an der Stelle x.
 * Eingabe: Koeffizienten a[n], a[n-1], ..., a[0], Argument x
 * 
 * @author Olga Stuckert
 * @tutor Leon Alexander Suttmeyer
 * @uebungsgruppe 22
 * @place Universitaet Goettingen
 *
 */
public class Polynomfunktion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		for (int i = 0; i<10; i++)
		{
			calc(a, 1, i);
		}

	}

	public static double calc(double[] a, double x, int n) {
		double q = a[0];
		long cnt1=0, cnt2 =0;
//		int n = a.length;
		for (int i = 1; i <= n; i++) {
			cnt1 ++;
			double potenz = 1;
			for (int j = 1; j <= i; j++)
			{
				cnt2++;
				potenz = potenz * x;
			}
			x = potenz;
			for (int j = 1; j <= i ; j++)
			{
				cnt2++;
				potenz = potenz * x;
			}
				
			q = a[i] * potenz + q;
		}
		System.out.println(n + " - " + cnt1 + " - " + cnt2 + " - " + q);
		return q;
	}
}
