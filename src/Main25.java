import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main25{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        String res = "";
        while(in.hasNext()) {
        	Pattern p = Pattern.compile("[a-zA-Z]+");
        	Matcher m = p.matcher(in.nextLine());
        	StringBuilder sb = new StringBuilder();
        	while(m.find()) {
        		sb.append(m.group() + " ");
        	}
        	
        	String[] s = sb.toString().split("\\s+");
        	for (int i = s.length-1; i >= 0; i--) {
				res += s[i] + " ";
			}
        	System.out.println(res.trim());
        }
        in.close();
    }
}