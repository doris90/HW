import java.util.Scanner;

public class Main30{
    public static void main(String[]  args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	System.out.println(amount(Integer.parseInt(in.nextLine())));
        }
        in.close();
    }
    
    public static int amount(int n) {
    	if(n <= 2) return 1;
    	else return amount(n-1)+amount(n-2);
    }
}