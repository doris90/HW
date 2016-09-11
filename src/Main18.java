import java.util.*;

public class Main18{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String s = in.nextLine();
        	Map<Character , Integer> map = new TreeMap<Character , Integer>();
        	StringBuilder sb = new StringBuilder();
        	for (int i = 0; i < s.length(); i++) {
        		if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i))+1);
        		else map.put(s.charAt(i), 1);
			}

        	Collection<Integer> c =  map.values();
        	int id = Collections.min(c);   //Collections.max¡¢min£¬reverser¹¦ÄÜ
        	
        	for (int i = 0; i < s.length(); i++) {
				if(map.get(s.charAt(i))!= id) sb.append(s.charAt(i));
			}
        	System.out.println(sb.toString());
        }
        in.close();
    }
}