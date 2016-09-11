import java.util.Scanner;

public class Main23{
	
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String s1 = in.nextLine();
        	String s2 = in.nextLine();
        	System.out.println(Encrypt(s1));
        	System.out.println(unEncrypt(s2));
        }
        in.close();
    }
    
    public static String Encrypt(String aucPassword) {
    	int n = aucPassword.length();
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < n; i++) {
    		int x = (int)aucPassword.charAt(i);
			if(x>64 && x<91) {
				if(x == 90) sb.append("a");
				else {
					x = x+33;
					sb.append(((char) x));
				}
			}else if(x>96 && x<123) {
				if(x == 122) sb.append("A");
				else {
					x = x-31;
					sb.append(((char) x));
				}				
			}else if(x>47 && x<58) {
				if(x == 57) sb.append("0");
				else {
					x = x+1;
					sb.append(((char) x));
				}			
			}
		}
    	
    	return sb.toString();
    }
    
    public static String unEncrypt(String s) {
    	int n = s.length();
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < n; i++) {
    		int x = (int)s.charAt(i);
    		if(x>64 && x<91) {
    			if(x == 65) sb.append("z");
    			else {
    				x = x+31;
    				sb.append(((char) x));
    			}
    		}else if(x>96 && x<123) {
    			if(x == 97) sb.append("Z");
    			else {
    				x = x-33;
    				sb.append(((char) x));
    			}				
    		}else if(x>47 && x<58) {
    			if(x == 48) sb.append("9");
    			else {
    				x = x-1;
    				sb.append(((char) x));
    			}			
    		}
    	}
    	
    	return sb.toString();
    }

}