import java.util.Scanner;

//×Ö·û´®·½·¨trim(),É¾³ı×Ö·û´®Ç°ºóµÄ¿Õ¸ñ
public class Main8{
    public static void main(String[]  args) {
    	Main8 m = new Main8();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	String s = in.nextLine();
        	System.out.println(m.reverse(s));
        }
        in.close();
    }
    
    public String reverse(String sentence) {
    	String[] r = sentence.split(" ");
    	String res = "";
    	for (int i = r.length-1; i>=0 ; i--) {
			res = res + r[i]+" ";
		}
    	return res.trim();
    }
}