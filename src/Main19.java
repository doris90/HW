/*
 * ���󣺽���������м������ߵݼ�������
 * ˼·��1��������������г�������f1
 * 		 2�� ������������г�������f2
 * 		3��f1+f2-1��������ֵ��Ϊ����и����˵����еĸ���������Ҫ���и���N-max*/

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
				max = Math.max(f1[i] + f2[i] -1, max); //����+����-1�����������飩����ȡ���ֵ
			}
        	
        	System.out.println(N-max);
        	
        }
        in.close();
    }
    //�����������LIS��f[i]��ʾǰiλԪ�ص�����������У�
    /*
     * ���ڵ�i��Ԫ�أ�����j��Ԫ��С�ڵ�i��Ԫ�أ���f[j] +1>f[i],����0-i��һ������������еĳ���= f[j]+1
     * ���������а���i��ǰj��Ԫ�ص��������*/
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
    //���������������
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
