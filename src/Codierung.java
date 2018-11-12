import java.util.Formatter;

public class Codierung {
	public static  int[] code = {252, 220,228,196,246,214,223};
	public static  String[] symbol = {"ü","Ü","ä","Ä","ö","Ö","ß"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] qpk = new String[code.length];
		for (int i=0; i<code.length; i++)
		{
			qpk[i] = getCode( code[i]);
		}
		
		String[] text = {"St=F6=DFel","verb=FC=DFen",	"d=FCrr",		"zerst=F6=DFt"};
		
		for (String string : text) {
			System.out.print(string);
			String result = string;
			for (int i=0; i<code.length; i++)
			{
				result = result.replace(qpk[i], symbol[i]);
			}
			System.out.println("\t - " + result);

		}
		System.out.println("***************");
		String[] text2 = {"ließ","überhören",	"Mäßigens",		"Lückenbüßer"};
		for (String string : text2) {
			System.out.print(string);
			String result = string;
			for (int i=0; i<code.length; i++)
			{
//				System.out.println(qpk[i] + " # " + symbol[i]);
				result = result.replace(symbol[i], qpk[i]);
			}
			System.out.println("\t - " + result);

		}
	
	}
	
	public static  String getSymbol(int input)
	{
		for (int i=0; i<code.length; i++)
		{
			if (input == code[i])
				return symbol[i];
		}
		return "";
	}
	
	public static  String getCode(int input)
	{
		for (int i=0; i<code.length; i++)
		{
			if (input == code[i])
				return "="+intToHexString(code[i]).toUpperCase();
		}
		return "";
	}
	
	public static String intToHexString(int input) {
	    StringBuilder sb = new StringBuilder();
	 
	    Formatter formatter = new Formatter(sb);
        formatter.format("%02x", input);

        formatter.close();
	    return sb.toString();
	}
	

}
