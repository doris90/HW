/*
 * ���󣺱�дһ�����򣬽������ַ����е��ַ������¹�������

����1��Ӣ����ĸ��A��Z���У������ִ�Сд��  �磬���룺Type �����epTy

����2��ͬһ��Ӣ����ĸ�Ĵ�Сдͬʱ����ʱ����������˳�����С��磬���룺BabA �����aABb

����3����Ӣ����ĸ�������ַ�����ԭ����λ�á�  �磬���룺By?e �����Be?y
    ˼·��1����˳��ȡ���ַ������ַ�
     2��//����ĸ���֣���ĸλ�ð�˳������*/

import java.util.*;

public class Main20{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String s = in.nextLine();        	
        	StringBuilder sb = new StringBuilder();
        	char[] res = new char[s.length()];
        	
        	//��˳��ȡ���ַ������ַ�
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