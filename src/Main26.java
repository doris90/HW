/*
 * 需求：最长回文字符串
 * 思路：Manacher算法 ：http://www.cnblogs.com/biyeymyhjob/archive/2012/10/04/2711527.html 和 http://www.open-open.com/lib/view/open1419150233417.html
 * 1、前处理： 将字符串所有字符间插入“#”，准备一个p[] 记录以i为中心最长回文半径（包括它本身），变量id，表示i之前最长回文的中心位置；变量mx，表示i之前最长回文边界位置
 *  mx = id + p[id];
 * 2、遍历字符串{
 * 		if(i<mx) p[i] = Math.min(p[2*id - i] , mx-i);
 * 		else p[i] = 1;										//判断i的位置
 * 
 * 		while(i>=mx && i+p[i]<s.length() && s.charAt(i-p[i]) == s.charAt(i+p[i])) p[i]++;  //i在mx外且（i+p[i]为新的mx时不能超过串长度，向i两边扩展）
 * 
 * 		if(i+p[i] > mx) {
 * 			mx = i+p[i]; 				//i+p[i]为新的mx时，替换mx和id
 * 			id = i;
 * 		}
 * }
 * 3、遍历p数组，找到p的最大值-1，即为最长回文长度*/


import java.util.Arrays;
import java.util.Scanner;

public class Main26{
	
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String s = in.nextLine();
        	StringBuilder sb = new StringBuilder();
        	for (int i = 0; i < s.length(); i++) {
				sb.append("#" + s.charAt(i));
			}
        	sb.append("#");
        	System.out.println(maxLength(sb.toString()));
        }
        in.close();
//    	System.out.println(maxLength("#5#1#2#3#3#2#1#4#"));
    }

    
    public static int maxLength(String s) {
    	int[] p = new int[s.length()+1];
    	int mx = 0;
    	int id = 0;
    	
    	for (int i = 1; i <= s.length(); i++) {
			if(i < mx) {
				p[i] = Math.min(p[2*id - i], mx - i);
			}else {
				p[i] = 1;
			}
			
			while(i >= p[i] && i+p[i]<s.length() && s.charAt(i + p[i]) == s.charAt(i - p[i])) p[i]++;
			
			if(i+p[i] > mx) {
				mx = p[i]+i;
				id = i;
			}
		}
    	
    	Arrays.sort(p);
    	return p[p.length-1]-1;
    }
    
}