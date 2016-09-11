import java.util.Scanner;

public class Main31{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int h = Integer.parseInt(in.nextLine());
        	double s = h;
        	double hh = 0;
        	if(h > 0) {
        		for (int i = 1; i <= 5; i++) {
					hh = h/(Math.pow(2, i));
					if(i<5) s  =  s + hh*2;
				}
 
        	}
        	System.out.println(s);
        	System.out.println(hh);
        }
        in.close();
    }
}