package last.dance.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Pokemon {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6};
		
		System.out.println(solution(nums));
	}
	
	public static int solution(int[] nums) {
		Map<Integer, Integer> answerMap = new HashMap<>();
		
		Map<Integer, Integer> pMap = new HashMap<>();
		
		for(int mon : nums) {
			pMap.put(mon, pMap.getOrDefault(mon, 0) + 1);
		}

		List<Entry<Integer, Integer>> entryList = new ArrayList<>(pMap.entrySet());
		entryList.sort((o1, o2) -> o1.getValue() - o2.getValue());
		
		int take = 0;
		Loop1:
		while(true) {
			
			for(Integer key : pMap.keySet()) {
				
				answerMap.put(key, answerMap.getOrDefault(key, 0) + 1);
				take++;
				if(take >= nums.length/2) {
					break Loop1;
				}
			}
		}
		
		return answerMap.size();
	}
}
