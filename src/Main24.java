//一定注意，Integer.toBinary,to...函数只保留有限位结果，例如1转化为二进制为1，而不是0001

import java.util.Arrays;
import java.util.Scanner;

public class Main24{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String[] org = in.nextLine().split(" ");
        	String s1 = org[0];
        	String s2 = org[1];
        	String combineSort = sortSpecial(s1+s2);
        	StringBuilder res  = new StringBuilder();
        	for (int i = 0; i < combineSort.length(); i++) {
        		int x = (int)combineSort.charAt(i);
        		if((x>='0' && x<='9') || (x>='a' && x<='f') || (x>='A' && x<='F')) {
					res.append(reverseBits(combineSort.charAt(i)));
				}else {
					res.append(combineSort.charAt(i));
				}
			}
        	System.out.println(res.toString());
        }
        in.close();
  
    }
    
    public static String reverseBits(char a) {
    	
    	String b = Integer.toBinaryString(Integer.parseInt(String.valueOf(a) , 16));
    	while(b.length() < 4) {b = "0" + b;}
    	StringBuilder sb = new StringBuilder(b);
    	String res = sb.reverse().toString();
    	res = Integer.toHexString(Integer.parseInt(res , 2)).toUpperCase();
    	return res;
    }
    
    public static String sortSpecial(String s) {
    	int N = s.length();
    	StringBuilder sb1 = new StringBuilder();
    	StringBuilder sb2 = new StringBuilder();
    	StringBuilder res = new StringBuilder();
    	
    	for (int i = 0; i < N; i += 2) {
			sb1.append(s.charAt(i));
		}
    	for (int j = 1; j < N; j += 2) {
			sb2.append(s.charAt(j));
		}
    	char[] s1 = sb1.toString().toCharArray();
    	char[] s2 = sb2.toString().toCharArray();   	
    	Arrays.sort(s1);
    	Arrays.sort(s2);
    	int k=0;
    	int l=0;
    	for (int i = 0; i < N; i++) {
			if(i%2 == 0) {
				res.append(s1[k]);
				k++;
			}else {
				res.append(s2[l]);
				l++;
			}
		}
    	return res.toString();
    }
}