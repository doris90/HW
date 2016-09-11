/*
 * 需求：编写一个程序，将输入字符串中的字符按如下规则排序。

规则1：英文字母从A到Z排列，不区分大小写。  如，输入：Type 输出：epTy

规则2：同一个英文字母的大小写同时存在时，按照输入顺序排列。如，输入：BabA 输出：aABb

规则3：非英文字母的其它字符保持原来的位置。  如，输入：By?e 输出：Be?y
    思路：1、按顺序取出字符串中字符
     2、//非字母保持，字母位置按顺序填入*/

import java.util.*;

public class Main20{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String s = in.nextLine();        	
        	StringBuilder sb = new StringBuilder();
        	char[] res = new char[s.length()];
        	
        	//按顺序取出字符串中字符
        	for (int i = 0; i < 26; i++) {
				for (int j = 0; j < s.length(); j++) {
					if(s.charAt(j)-'a' == i || s.charAt(j)-'A' == i) sb.append(s.charAt(j));
				}
			}
        	
        	
        	int j = 0;
        	
        	for (int i = 0; i < s.length(); i++) {
        		char x = s.charAt(i);
				if((x>=65 && x<=90) || (x>=97 && x<=122)) {
					res[i] = sb.charAt(j);
					j++;
					continue;
				}
				else res[i] = x;
			}
        	System.out.println(String.valueOf(res));
        }
        in.close();
    }
}