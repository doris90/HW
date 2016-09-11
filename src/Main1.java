import java.util.Scanner;

public class Main1{
    public static void main(String[]  args) {
    	String basic = "0123456789ABCDEF";
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String s = in.nextLine();
        	s = s.replaceAll("0x", "");
        	int res = 0;
        	int j = 0;
        	for (int i = s.length()-1; i >= 0; i--) {
				res = (int) (res + basic.indexOf(String.valueOf(s.charAt(i))) * Math.pow(16, j));
				j++;
			}
        	System.out.println(res);
        }
        in.close();
    }
}