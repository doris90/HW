/*
 * ���󣺴�ӡ���ξ���
 * ˼·��1�� ͨ�����εĹ��̣������������ά����
 * 		2��ͨ���ַ���ƴ�ӣ�trim()������ά�������ַ�����ʽ���*/

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
    	//�����������ά����
    	for(int  k = 0;k < x; k++) {					//���Ʋ���
        	for (int i = k; i >= 0 && i < x; i--) {		//ÿһ��б�Խ�i�������꣩�ݼ������Ǹ����Բ�����ʼ
        		int p = i;
        		for (int j = 0; i >= 0&&j <= p; j++) {	//ÿһ��б�Խ�j�������꣩������ͬʱi�ݼ�����֤�Ǹ���
					a[i][j] = t;
					t++;
					i--;					
				}   			
    		}
    	}

    	//���д�ӡ��ά����
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