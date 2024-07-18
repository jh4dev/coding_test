package last.dance.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ListOfPhoneNumber {

	
	public static void main(String[] args) {
		
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
		
		boolean result = true;
		
		Map<String, Integer> phoneMap = new HashMap<>();
		
		Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
		
		StringBuffer sbf = new StringBuffer();
		int idx = 0;
		for(String p : phone_book) {
			
			sbf.setLength(0);
			idx = 0;
			//동일한 번호는 없음
			while(sbf.length() < p.length()) {
				sbf.append(p.charAt(idx));
				if(phoneMap.get(sbf.toString()) != null) {
					return false;
				}
				idx++;
			}
			phoneMap.put(p, 1);
		}
		
		return result;
	}
}
