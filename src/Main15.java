import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main15{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        Main15 m = new Main15();
        while(in.hasNext()) {
        	
        	String s = in.nextLine();
        	
        	System.out.println(m.isValidPassWord(s));
        }
        in.close();
    }
    
    public String isValidPassWord(String p) {
    	//判断长度
    	if(p == null || p.length() <= 8) return "NG";
    	
    	//判断种类
    	int count = 0;
    	String[] rex = {"[a-z]" , "[A-Z]" , "[0-9]" , "[^a-zA-Z0-9]"};
    	for (int i = 0; i < rex.length; i++) {
    		Pattern pa = Pattern.compile(rex[i]);
    		Matcher m = pa.matcher(p);
			if(m.find()) count++;   //find() 部分匹配；matches()匹配整个输入串
		}
    	if(count<3) return "NG";
    	
    	//判断是否含有长度大于2的重复子串
    	for (int i = 0; i <= p.length()-4; i++) {
			if(p.substring(i+3).contains(p.substring(i, i+3))) return "NG";
		}
    	
    	return "OK";
    	
    }
}