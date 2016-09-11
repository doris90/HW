import java.util.Arrays;
import java.util.Scanner;
//Arrays.sort()¿ÉÒÔÅÅ×Ö·û´®£»
public class Main9{
    public static void main(String[]  args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int N = Integer.parseInt(in.nextLine());
        	String[] s = new String[N];
        	for (int i = 0; i < s.length; i++) {
				s[i] = in.nextLine();
			}
        	Arrays.sort(s);
        	for (int i = 0; i < s.length; i++) {
				System.out.println(s[i]);
			}
        }
        in.close();
    }
}