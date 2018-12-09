package uebungsblatt06;

public class ILIAS_06_1 {

	public static void main(String[] args) {
		
		int a=0, b=1, c=2, d=3, tmp=9;
		
		tmp = b;
		d = a;
		b = d;
		a = c;
		c = tmp;
		System.out.println(a+ "" + b+c+d);
		
	}


}
