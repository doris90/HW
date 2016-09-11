import java.util.Scanner;

public class Main16{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String s = in.nextLine();

        	System.out.println(convertPassWord(s));
        }
        in.close();
    }
    
    public static String convertPassWord(String s) {
    	String basic = "abcdefghijklmnopqrstuvwxyz";
    	String number ="22233344455566677778889999";
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < s.length(); i++) {
    		//to lowerCase and +1;
    		int asc = (int)s.charAt(i);
			if( asc >= 65 && asc <= 90) {
				if(asc == 90) sb.append('a');
				else sb.append((char)(s.charAt(i)+33));
				continue;
			}
			
			
			//lowerCase to number
			else if( asc >= 97 && asc <= 122) {
				int tmp = basic.indexOf(s.charAt(i));
				sb.append(number.charAt(tmp));
				continue;
			} 
			else {
				sb.append(s.charAt(i));
			}
		}
    	return sb.toString();
    }
}