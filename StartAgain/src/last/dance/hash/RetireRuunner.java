package last.dance.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RetireRuunner {

	public static void main(String[] args) {
		
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		System.out.println(solution(participant, completion));
	}
	
	public static String solution(String[] participant, String[] completion) {
		Map<String, Integer> pMap = new HashMap<>();
		
		for(String p : participant) {
			pMap.put(p, pMap.getOrDefault(p, 0) + 1);
		}

		int cp = 0;
		for(String c : completion) {
			cp = pMap.get(c);
			
			cp -= 1;
			if(cp == 0) {
				pMap.remove(c);
			} else {
				pMap.put(c, cp);
			}
		}
		
		return new ArrayList<>(pMap.keySet()).get(0);
	}
	
}
