/*
 * 需求：将数组呈现中间向两边递减的趋势
 * 思路：1、正向递增子序列长度数组f1
 * 		 2、 逆向递增子序列长度数组f2
 * 		3、f1+f2-1数组的最大值即为组成中高两端低序列的个数，而需要出列个数N-max*/

import java.util.Scanner;

public class Main19{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int N = Integer.parseInt(in.nextLine());
        	String[] s = in.nextLine().split(" ");
        	int[] height = new int[N];
        	for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(s[i]);
			}
        	
        	int[] f1 = forward(height);
        	int[] f2 = back(height);
        	int max = 0;
        	for (int i = 0; i < N; i++) {
				max = Math.max(f1[i] + f2[i] -1, max); //正向+逆向-1（操作了两遍），求取最大值
			}
        	
        	System.out.println(N-max);
        	
        }
        in.close();
    }
    //最长递增子序列LIS（f[i]表示前i位元素的最长递增子序列）
    /*
     * 对于第i个元素，若第j个元素小于第i个元素，且f[j] +1>f[i],则在0-i这一段最长递增子序列的长度= f[j]+1
     * 即该子序列包含i和前j个元素的最长子序列*/
    public static int[] forward(int[] a) {
    	int[] f = new int[a.length];
    	for (int i = 0; i < a.length; i++) {
    		f[i] = 1;
			for (int j = 0; j < i; j++) {
				if(a[j] < a[i] && f[j] + 1>f[i]) {
					f[i] = f[j] + 1;
				}
			}
		}
    	return f;
    }
    //逆向最长递增子序列
    public static int[] back(int[] a) {
    	int n = a.length;
    	int[] f = new int[n];
    	for (int i = n-1; i >= 0; i--) {
			f[i] = 1;
			for (int j = n-1; j > i; j--) {
				if(a[j] < a[i] && f[j]+1 > f[i]){
					f[i] = f[j] + 1;
				}
			}
		}
    	return f;
    }
}
