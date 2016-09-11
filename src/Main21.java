
import java.util.*;

public class Main21{
    public static void main(String[]  args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int N = Integer.parseInt(in.nextLine());
        	List<String> set = new ArrayList<String>();
        	int count = 0;
        	for (int i = 0; i < N; i++) {
				set.add(in.nextLine());
			}
        	
        	Collections.sort(set);
        	
        	String[] bros = brothers(in.nextLine());
        	int k = Integer.parseInt(in.nextLine());
        	String K = "";
        	for (int i = 0; i < bros.length; i++) {
				if(set.contains(bros[i])) {
					count++;
					if(count == k) K = bros[i];
				}
			}
        	System.out.println(count);
        	System.out.println(K);
        }
        in.close();
    }
    
	public static String[] brothers(String s) {
    	String basic = s+s;
    	int N = s.length();
    	String[] res = new String[N-1];
    	int j = 0;
    	for (int i = 1; i < N; i++) {
			res[j] = basic.substring(i, i+N);
			j++;
		}
    	return res;
    	
    }
}