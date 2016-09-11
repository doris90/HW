import java.util.Scanner;

public class Main10{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int i = Integer.parseInt(in.nextLine());
        	String s = Integer.toBinaryString(i);
        	s = s.replaceAll("0", "");
        	System.out.println(s.length());
        }
        in.close();
    }
}