import java.util.Scanner;

public class Main17{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        Main17 m = new Main17(); 
        while(in.hasNext()) {
        	int i = Integer.parseInt(in.nextLine());
        	if(i != 0) {
        		System.out.println(m.canDrinlk(i));
        	}
        }
        in.close();
    }
    
    public int canDrinlk(int x) {
    	int count = 0;
    	while(x>=2) {
    		if(x == 2) {
    			count++;
    			x = 0;
    		}
    		else{
    			count += x/3;
    			x = x/3 + x%3;
    		}
    	}
    	return count;
    }
}