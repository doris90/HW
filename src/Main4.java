/*
 * TreeMap:
 * 插入元素按自然排列
 * put()方法，若键已存在，值被覆盖*/
import java.util.*;

public class Main4{
    public static void main(String[]  args) {
    	//Main2 m2 = new Main2();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
        	int N = in.nextInt();
        	in.nextLine();
        	Map<Integer , Integer> map = new TreeMap<Integer , Integer>(); 
        	String[] ss = in.nextLine().split(" ");
        	map.put(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
        	
        	for (int i = 1; i < N; i++) {
        		String[] s = in.nextLine().split(" ");
				if(map.containsKey(Integer.parseInt(s[0]))) {
					map.put(Integer.parseInt(s[0]), map.get(Integer.parseInt(s[0]))+Integer.parseInt(s[1]));
				}else{
					map.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				}
			}
        	
        	for (Integer key : map.keySet()) {
        		System.out.println(key + " " + map.get(key));
			}       	
        }
        in.close();
    }

}