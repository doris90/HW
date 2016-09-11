import java.util.Scanner;

public class Main22{
    public static void main(String[]  args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int N = Integer.parseInt(in.nextLine());
            int[] dp = new int[N+1];
            int[] a = new int[N];
            String[] s = in.nextLine().split(" ");
            
            for (int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(s[i]);
			}
            int cnt = 0;
//            if(isPrime(a[0] + a[1])) dp[1] = 1; 
            for (int i = N-2; i >= 0; i--) {            	
				for (int j = N-1; j > i; j--) {
					if(isPrime(a[i] + a[j])) {
						cnt = dp[i+1] - dp[j-1] + dp[j+1] + 1;
					}else {
						cnt = dp[i+1];
					}
					if(cnt > dp[i]) dp[i] = cnt;
						
				}
			}
            
            System.out.println(dp[0]);

            
        }
        in.close();
   }
    
    public static boolean isPrime(int n) {
    	if(n<2) return false;
    	
    	for (int i = 2; i < n; i++) {
			if(n%2 == 0) return false;
		}
    	return true;
    }
}