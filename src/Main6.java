import java.util.Scanner;

public class Main6{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        int count = 1;
        while(in.hasNext()) {
        	String s = in.nextLine();
        	StringBuilder sb = new StringBuilder();
        	if((int)s.charAt(0)>=0 && (int)s.charAt(0) <= 127)sb.append(s.charAt(0));
        	for (int i = 1; i < s.length(); i++) {        		
        		if(((int)s.charAt(i)>=0 && (int)s.charAt(i) <= 127 && sb.indexOf(String.valueOf(s.charAt(i))) == -1)) {
        			sb.append(s.charAt(i));
        			count++;
        		}				
			}
        	System.out.println(count);
        }
        in.close();
    }
}