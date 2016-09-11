/*
 * ����������ַ���
 * ˼·��Manacher�㷨 ��http://www.cnblogs.com/biyeymyhjob/archive/2012/10/04/2711527.html �� http://www.open-open.com/lib/view/open1419150233417.html
 * 1��ǰ���� ���ַ��������ַ�����롰#����׼��һ��p[] ��¼��iΪ��������İ뾶������������������id����ʾi֮ǰ����ĵ�����λ�ã�����mx����ʾi֮ǰ����ı߽�λ��
 *  mx = id + p[id];
 * 2�������ַ���{
 * 		if(i<mx) p[i] = Math.min(p[2*id - i] , mx-i);
 * 		else p[i] = 1;										//�ж�i��λ��
 * 
 * 		while(i>=mx && i+p[i]<s.length() && s.charAt(i-p[i]) == s.charAt(i+p[i])) p[i]++;  //i��mx���ң�i+p[i]Ϊ�µ�mxʱ���ܳ��������ȣ���i������չ��
 * 
 * 		if(i+p[i] > mx) {
 * 			mx = i+p[i]; 				//i+p[i]Ϊ�µ�mxʱ���滻mx��id
 * 			id = i;
 * 		}
 * }
 * 3������p���飬�ҵ�p�����ֵ-1����Ϊ����ĳ���*/


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