import java.util.Arrays;

/**
 * Basiskomplement
 * Ubertragen Sie die Idee zur Darstellung negativer Zahlen 
 * mit dem Zweierkomplement in das Dezimalsystem.
 * 
 * Das Zweikomplement wird auch als Basiskomplement zur Basis 2 bezeichnet. 
 * Definieren Sie einen Datentyp Gdec (=Goeottinger decimal) mit 8 Dezimalstellen, 
 * der zur Darstellung negativer Zahlen das Basiskomplement zur Basis 10 verwendet.
 * Der Datentyp soll folgende Eingeschaften haben.
 * - Die Anzahl negativer und nicht-negativer Zahlen sollte ungefaehr gleich sein.
 * - Die Addition soll wie gewohnt (ziffernweise Addition mit Uebertrag) 
 * durchfueuhrbar sein.
 * - Die Subtraktion kann auf Vorzeichenwechsel und Addition zurueckgefuehrt werden.
 * Geben Sie genau an wie man fuer eine beliebige darstellbare ganze Zahl die 8 Dezimalstellen
 * des Datentyps Gdec berechnet.
 *
 * @author Olga Stuckert
 * @tutor Leon Alexander Suttmeyer
 * @uebungsgruppe 22
 * @place Universitaet Goettingen
 */
public class Gdec {

	int[] zahl = new int[8];

	public Gdec(int[] zahl) {
		this.zahl = zahl.clone();
	}

	public Gdec(int val) {
		//Wenn Die Zahl > 4999999 ist, ist Die Zahl negative
		if (val < 0)
		{
			zahl[0] = 5;
			val = val * -1;
		}
		if (val > 49999999) {
			val = 49999999;
		}
		for (int i = 7; i >= 0; i--) {
			if (zahl[0] == 5)
				//Zahl ist negative
				zahl[i] = 9 - val % 10;
			else
				//Zahl ist positive
				zahl[i] = val % 10;
			val = val / 10;
		}
		if (zahl[0] > 4)
			zahl=plus(new Gdec(1)).getZahl();

	}

	public int[] getZahl() {
		return zahl;
	}

	public Gdec plus(Gdec zuAdd)
	{
		Gdec ret = new Gdec(this.getZahl());
		int[] newZahl = ret.getZahl();
		int[] zuAddZahl = zuAdd.getZahl();
		for (int i=7; i>=0;i--)
		{
			newZahl[i] = newZahl[i]+zuAddZahl[i];
			if (newZahl[i]>9)
			{
				newZahl[i]=newZahl[i]-10;
				if (i>0) 
					newZahl[i-1] = newZahl[i-1]+1;
			}
		}
		return ret;
	}
	
	public int toInt() {
		int val=0;
		
		for (int i = 0; i < 8; i++) {
			val=val*10;
			if (zahl[0] > 4)
				val+=9-zahl[i];
			else
				val+=zahl[i];
		}
		if (zahl[0] > 4)
			val = (val * -1) -1;
		return val;
	}
	
	public String toString() {
		String result="" + toInt();
		if (toInt()<10 && toInt()>-10)
			result += "\t\t";
		else
			result += "      \t";
		return result + Arrays.toString(zahl).replace(" ", "").replace(",", "");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gdec a = new Gdec(new int[] { 0, 0, 0, 0, 1, 7, 8, 9 });
		Gdec minusA = new Gdec(-1789);
		Gdec b = new Gdec(new int[] { 0, 0, 0, 0, 1, 4, 9, 2 });
		Gdec minusB = new Gdec(-1492);
		
		System.out.println("a\t" + a);
		System.out.println("b\t" +b);
		System.out.println("-b\t" +minusB);
		System.out.println("-a\t" +minusA);
		System.out.println("a+b\t " +a.plus(b));
		System.out.println("a-b\t" +a.plus(minusB));
		System.out.println("b-a\t" +b.plus(minusA));
		
		System.out.println("***********");
		Gdec c = new Gdec(49999999);
		System.out.println("c\t" + c);
		Gdec d = new Gdec(-49999999);
		System.out.println("d\t" + d);
		System.out.println("c+d\t" + c.plus(d));
		
		Gdec g = new Gdec(new int[] { 5, 0, 0, 0, 0, 0, 0, 0 });
		System.out.println("g\t" + g);
		Gdec h = new Gdec(-1);
		System.out.println("g\t" + h);
	}
}