/*
 * 1、  Mask 255.255.255.255 , 0.0.0.0 为非法。
 * 2. IP和Mask必须同时正确，才能被分类到A, B, C, D, E以及私有。
* 3. IP和Mask同时错误时，只算一次错误
* 4. 注意0.*.*.*以及127.*.*.*不属于任何类别。*/



import java.util.Scanner;
import java.util.regex.Pattern;

public class Main13{
	
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        int ipA = 0;
        int ipB = 0;
        int ipC = 0;;
        int ipD = 0;;
        int ipE = 0;;
        int err = 0;
        int ipPrivate = 0;;
        while(!in.hasNext("0")) {
        	
        	String[] s = in.nextLine().split("~");
        	
        	if(!isValidIp(s[0]) || !isValidMaskCode(s[1])) err++;    		
        	if(!isValidIp(s[0]) && !isValidMaskCode(s[1])) continue;
        	
        	if(isValidIp(s[0])  && isValidMaskCode(s[1])) {
        		String[] res = s[0].split("\\.");
            	int x = Integer.parseInt(res[0]);
            	int y = Integer.parseInt(res[1]);
            	if(x >= 0 && x <=126) {
            		if(x == 10) ipPrivate++;
            		ipA++;
            		
            	}else if(x > 127 && x <=191) {
            		if(x == 172) {
            			if(x > 15 && x <= 31) ipPrivate++;
            		}
            		ipB++;
            		
            	}else if(x > 191 && x <=223) {
            		if(x == 192 && y == 168) ipPrivate++;
            		ipC++;
            	
            	}else if(x > 223 && x <=239){
            		ipD++;
           
            	}else {
            		ipE++;
            
            	}        	
        	}
        }
        System.out.println(ipA + " "+ ipB + " "+ipC + " "+ipD + " "+ipE + " "+err + " "+ipPrivate);
        in.close();
    	
    	
    }
    
    public static boolean isValidIp(String ip){
    	if(ip != null && Pattern.matches("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$", ip)) {
    		String[] s = ip.split("\\.");
    		for (int i = 0; i < s.length; i++) {
				if(Integer.parseInt(s[i])<0 || Integer.parseInt(s[i])>255) return false;
			}
    		return true;
    	}else {
    		return false;
    	}
    	
    }
    
    public static boolean isValidMaskCode(String maskCode){
    	if(maskCode != null && Pattern.matches("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$", maskCode)) {
    		String[] s  = maskCode.split("\\.");
    		String res = "";
    		
			for (int k = 0; k < s.length; k++) {
				String st = Integer.toBinaryString(Integer.parseInt(s[k]));
				
				if(st.length() < 8){					
					StringBuilder sb = new StringBuilder(st);
					while(sb.length() < 8) {
						sb.insert(0, "0");
					}
					st = sb.toString();
				}				
				res += st;
			}
			
			if(!res.contains("0") || !res.contains("1")) return false;
		    		
    		int firstZeroIndex = res.indexOf('0');
    		res = res.substring(firstZeroIndex);
    		if(res.contains("1")) return false;
    		else return true;
    	}else {
    		return false;
    	}
    }
}