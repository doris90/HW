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
    	//�жϳ���
    	if(p == null || p.length() <= 8) return "NG";
    	
    	//�ж�����
    	int count = 0;
    	String[] rex = {"[a-z]" , "[A-Z]" , "[0-9]" , "[^a-zA-Z0-9]"};
    	for (int i = 0; i < rex.length; i++) {
    		Pattern pa = Pattern.compile(rex[i]);
    		Matcher m = pa.matcher(p);
			if(m.find()) count++;   //find() ����ƥ�䣻matches()ƥ���������봮
		}
    	if(count<3) return "NG";
    	
    	//�ж��Ƿ��г��ȴ���2���ظ��Ӵ�
    	for (int i = 0; i <= p.length()-4; i++) {
			if(p.substring(i+3).contains(p.substring(i, i+3))) return "NG";
		}
    	
    	return "OK";
    	
    }
}