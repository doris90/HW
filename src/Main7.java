import java.util.Scanner;

public class Main7{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String s = in.nextLine();
        	
        	StringBuilder sb = new StringBuilder(s);
        	sb.reverse();
        	System.out.println(sb);
        }
        in.close();
    }
}