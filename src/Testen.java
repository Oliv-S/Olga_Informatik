import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testen {   
    public static void main( String[] args){ 
    	List<String> s=new ArrayList<String>();
        for (int i1=0;i1<10;i1++)
        	for (int i2=0;i2<10;i2++)
        		for (int i3=0;i3<10;i3++)
        			for (int i4=0;i4<10;i4++)
        				for (int i5=0;i5<10;i5++)
        				{
        					
        					String arg0=String.valueOf(i1)+
        							String.valueOf(i2)+
        							String.valueOf(i3)+
        							String.valueOf(i4)+
        							String.valueOf(i5);
        					s.add(arg0);
        				}
        System.out.println(s.stream().filter(p->check(p)).count());
        System.out.println(10*9*8*7);
//        s.stream().filter(p->check(p)).forEach(System.out::println);;
        for (String string : s) {
//			System.out.println(string);
		} 					
        	

	}
    
    public static boolean check(String s)
    {
    	Map<Character, Integer> m = new HashMap<Character, Integer>();
    	for (int i=0;i<s.length();i++)
    	{
    		Character c = s.charAt(i);
    		m.put(c, m.getOrDefault(c, 0)+1);
    	}
    	Map<Integer, Integer> v = new HashMap<Integer, Integer>();
    	for (Character c : m.keySet()) {
    		Integer i=m.get(c);
    		v.put(i,v.getOrDefault(i, 0)+1);
		}
    	if (v.getOrDefault(1, 0)==1 && v.getOrDefault(2, 0)==2)
    		return true;    	
		return false;
    	
    }
}
