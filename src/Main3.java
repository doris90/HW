import java.util.Scanner;

public class Main3{
    public static void main(String[]  args) {
    	//Main2 m2 = new Main2();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	double l = in.nextDouble();
        	int res = (int) Math.round(l);
        	System.out.println(res);
        }
        in.close();
    }

}