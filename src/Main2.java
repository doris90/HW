import java.util.Scanner;

public class Main2{
    public static void main(String[]  args) {
    	Main2 m2 = new Main2();
        Scanner in = new Scanner(System.in);
        while(in.hasNextLong()) {
        	long l = in.nextLong();
        	System.out.println(m2.getResult(l));
        }
        in.close();
    }
    
    public String getResult(long ulDataInput) {
    	StringBuilder sb = new StringBuilder();
    	long x = ulDataInput;
    	for (int i = 2; i <= ulDataInput; i++) {
			if(x % i == 0) {
				sb.append(String.valueOf(i)+ " ");
				x = x/i;
				i--;
			}
		}
    	return sb.toString();
    }
}