import java.util.Scanner;

public class Main5{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.nextLine();
        	StringBuilder sb = new StringBuilder();
        	
			sb.append(String.valueOf(s.charAt(s.length()-1)));
			
			for (int j = s.length()-1; j >= 0; j--) {
	            while(sb.indexOf(String.valueOf(s.charAt(j))) == -1) {
	                sb.append(s.charAt(j));
	            }
			}
			int res = Integer.parseInt(sb.toString());
			System.out.println(res);
        }
        in.close();
    }
}