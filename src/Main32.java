import java.util.Scanner;
import java.util.regex.Pattern;

public class Main32{
	
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String mask = in.nextLine();
        	String ip1 = in.nextLine();
        	String ip2 = in.nextLine();
        	System.out.println(checkNetSegment(mask , ip1 , ip2));
        }
        in.close();
//    	System.out.println(checkNetSegment("255.255.255.0" , "192.168.224.256" , "192.168.10.4"));
    }
    
    public static int checkNetSegment(String mask, String ip1, String ip2) {
    	if(isLeagal(mask) && isLeagal(ip1) && isLeagal(ip2)) {
        	String bin1 =  ipToBinary(ip1);
        	String bin2 =  ipToBinary(ip2);
        	String binM =  ipToBinary(mask);
        	int i1 = Integer.parseInt(bin1);
        	int i2 = Integer.parseInt(bin2);
        	int m = Integer.parseInt(binM);
        	if((i1^m) == (i2^m)) return 0;
        	else return 2;
    	}else {
    		return 1;
    	}
    }
    
    public static String ipToBinary(String ip) {
    	String[]  ips = ip.split("\\.");
    	String tmp = "";
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < ips.length; i++) {
			tmp = Integer.toBinaryString(Integer.parseInt(ips[i]));
			while(tmp.length() <8) {
				tmp = "0" + tmp;
			} 
			sb.append(tmp);
		} 
    	return sb.toString();
    }
    
    public static String binToNum(String ip) {
    	StringBuilder sb = new StringBuilder();
    	StringBuilder sbip = new StringBuilder(ip);
    	String x = "";
    	int ipi = 0;
    	for (int i = 0; i < sbip.length(); i++) {
			x = sbip.substring(0 , 8);
			ipi = Integer.parseInt(x, 2);
			sb.append(ipi + ".");
			sbip.delete(0, 8);
			
		}
    	return sb.substring(0 , sb.length() - 1);
    }

    public static boolean isLeagal(String address) {
    	if(address != null && Pattern.matches("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$", address)) {
    		String[] ads = address.split("\\.");
    		for (int i = 0; i < ads.length; i++) {
				int x = Integer.parseInt(ads[i]);
				if(x<0 || x>255) return false;
			}
    		return true;
    	}else{
    		return false;
    	}
    	
    }

}