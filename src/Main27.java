//注意：int的范围[-2^32 , 2^32-1]IP地址的十进制的数,ip的十进制可能会超过这个范围

import java.util.Scanner;

public class Main27{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String ip = in.nextLine();
        	long num = Long.parseLong(in.nextLine());
        	System.out.println(ipToOc(ip));
        	System.out.println(ocToIp(num));
        }
        in.close();
//    	System.out.println(Integer.parseInt("00001010" , 2));
    }
    public static long ipToOc(String s) {
    	long[] a = new long[4];
    	String[] ss = s.split("\\.");
    	StringBuilder sb =  new StringBuilder();
    	for (int i = 0; i < a.length; i++) {
			a[i] = Long.parseLong(ss[i]);
			String bin = Long.toBinaryString(a[i]);
			while(bin.length() < 8) {
				bin = "0"+bin;
			}
			sb.append(bin);
		}
    	Long res = Long.parseLong(sb.toString() , 2);
    	return res;
    }
    
    public static String ocToIp(long a) {
    	StringBuilder ss = new StringBuilder(Long.toBinaryString(a));
    	StringBuilder sb =  new StringBuilder();
    	
    	while(ss.length() < 32) {
    		ss.insert(0, '0');
    	}
    	
    	for (int i = 0; i < ss.length(); i++) {
			sb.append(Integer.parseInt(ss.substring(0, 8) , 2) + ".");
			ss.delete(0, 8);
		}
    	
    	sb.deleteCharAt(sb.length() - 1);
    	return sb.toString();
    }
}