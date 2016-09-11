import java.util.Scanner;
import java.util.regex.Pattern;

public class Main12{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String[] s = in.nextLine().split(";");
        	int x = 0 ;
        	int y = 0;
        	for (int i = 0; i < s.length; i++) {
        		if(Pattern.matches("[ADWS][0-9]+", s[i])) {
        			switch(String.valueOf(s[i].charAt(0))) {
        			case "A":
        				x = x - Integer.parseInt(s[i].substring(1));
        				break;
        			case "D":
        				x = x + Integer.parseInt(s[i].substring(1));
        				break;
        			case "W":
        				y = y + Integer.parseInt(s[i].substring(1));
        				break;
        			case "S":
        				y = y - Integer.parseInt(s[i].substring(1));
        				break;
        			}
        		}
				
			}
        	System.out.println(x + "," + y);
        }
        in.close();
    }
}