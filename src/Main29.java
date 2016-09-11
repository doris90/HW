import java.util.*;

public class Main29{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String s1 =in.nextLine();
        	String s2 = in.nextLine();
        	char[] key = s1.toCharArray();
        	char[] data = s2.toCharArray();
        	encrypt(key , data);
        }
        in.close();
    }
    
    public static void encrypt(char[] key , char[] data) {
    	Map<Character , String> map = new HashMap<Character , String>();
    	
    	//Æ¥Åä¶Ô×é½¨
    	int k = 0;
    	for (int i = 0; i < key.length; i++) {
    		String x= String.valueOf(key[i]).toUpperCase();
    		if(!map.containsValue(x)) {
    			map.put((char) ('A' + k), String.valueOf(key[i]).toUpperCase());
    			k++;
    		}
		}
    	int j = map.size();
    	for (int i = 0; i < 26 && j < 26; i++) {    		
			if(!map.containsValue(String.valueOf((char) ('A' + i)))) {
				map.put((char) ('A' + j), String.valueOf((char) ('A' + i)).toUpperCase());		
				j++;
			}
		}
    	
    	String s = String.valueOf(data).toUpperCase();
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < data.length; i++) {
    		if(data[i] == ' ') {
    			sb.append(' ');
    			continue;
    		}
			if(data[i] >= 97 && data[i] <= 122) {
				sb.append(map.get((char) (s.charAt(i))).toLowerCase());
				continue;
			}
			sb.append(map.get((char) s.charAt(i)));
		}
    	System.out.println(sb.toString());
    }
}
