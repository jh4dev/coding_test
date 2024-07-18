package retry;

import java.util.ArrayList;
import java.util.List;

public class MinMax {

	public static void main(String[] args) {
		
	}
	
	public static String solution(String s) {
		
		StringBuffer sbf = new StringBuffer();
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(String si : s.split(" ")) {
			list.add(Integer.parseInt(si));
		}
		
		list.sort((o1, o2) -> o1 - o2);
		
		sbf.append(list.get(0)).append(" ").append(list.get(list.size() - 1));
		
		return sbf.toString();
	}
}
