import java.util.*;

public class Main{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder(s);
            
            //����8�ı���
            
        	while(sb.length()%8 != 0) {
        		sb.append("0");
        	}
//System.out.println(sb);
          
            //����8�ָ�
            while(sb.length() != 0) {
            	String res = sb.substring(0, 8);
            	System.out.println(res);
            	sb.delete(0, 8);
            }
        }
        in.close();
    }
}