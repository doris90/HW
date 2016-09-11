/*
 * 需求：打印蛇形矩阵
 * 思路：1、 通过蛇形的过程，将数据填入二维数组
 * 		2、通过字符串拼接，trim()处理将二维数据以字符串形式输出*/

import java.util.Scanner;

public class Main28{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int i = Integer.parseInt(in.nextLine());
        	zigzag(i);
        }
        in.close();
    }
    
    public static void zigzag(int x) {
    	StringBuilder sb = new StringBuilder();
    	int t = 1;
    	int[][] a = new int[x][x];
    	//将数据填入二维数组
    	for(int  k = 0;k < x; k++) {					//控制层数
        	for (int i = k; i >= 0 && i < x; i--) {		//每一条斜对角i（横坐标）递减，但非负，以层数开始
        		int p = i;
        		for (int j = 0; i >= 0&&j <= p; j++) {	//每一条斜对角j（纵坐标）递增，同时i递减（保证非负）
					a[i][j] = t;
					t++;
					i--;					
				}   			
    		}
    	}

    	//逐行打印二维数组
    	for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < x; j++) {
				sb.append(String.valueOf(a[i][j]) + " ");
			}
			x--;
			System.out.println(sb.toString().trim());
			sb.delete(0, sb.length());
		}
	

    }
}