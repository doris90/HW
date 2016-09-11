/*
 * 需求：依赖背包问题（华为108购物单）
 * 思路：1、对于每一个主件用0-1背包处理：二重循环（顺，逆到c[i]）
 * 		2、附件需连带对应主件一起算*/
import java.util.Scanner;

public class Main11{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int V = in.nextInt();
        	int N = in.nextInt();
        	in.nextLine();
        	int[] v = new int[N+1];
        	int[] p = new int[N+1];
        	int[] q = new int[N+1];        	
        	for (int i = 1; i <= N; i++) {
				String[] s = in.nextLine().split(" ");
				v[i] = Integer.parseInt(s[0]);
				p[i] = Integer.parseInt(s[1])*v[i];
				q[i] = Integer.parseInt(s[2]);
			}
        	int f = depentPack(N , V , v , p , q);
        	System.out.println(f);
        }
        in.close();
    }
    
    public static int depentPack(int N , int V , int[] weight , int[] value , int[] q) {
    	int[][] f = new int[N+1][V+1];
    	for (int i = 1; i <= N; i++) {
			for (int j = weight[i]; j <= V; j++) {
				if(q[i] == 0) {
					f[i][j] = Math.max(f[i-1][j], f[i-1][j-weight[i]]+value[i]);
 				}else {
 					if((weight[i]+weight[q[i]])<=j) {
 						f[i][j] = Math.max(f[i-1][j], f[i-1][j-weight[i]-weight[q[i]]]+value[i]+q[i]);
 					}
 				}
			}
		}
    	return f[N][V];
    }
}