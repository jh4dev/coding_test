package last.dance.bf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DontGiveUp {

	public static void main(String[] args) {
		
		int[] answers = {1,3,2,4,2};
		
		System.out.println(Arrays.toString(new Solution().solution(answers)));
	}

	static class Solution {
		
		int[] pt1 = {1,2,3,4,5};
		int[] pt2 = {2,1,2,3,2,4,2,5};
		int[] pt3 = {3,3,1,1,2,2,4,4,5,5};
		
	    public int[] solution(int[] answers) {
	    	List<Integer> answerList = new ArrayList<>();
	        
	        Map<Integer, Integer> correctMap = new HashMap<>();
	        
	        for(int i = 0; i < answers.length; i++) {
	        	
	        	if(answers[i] == pt1[i % pt1.length]) correctMap.put(1, correctMap.getOrDefault(1, 0) + 1);
	        	if(answers[i] == pt2[i % pt2.length]) correctMap.put(2, correctMap.getOrDefault(2, 0) + 1);
	        	if(answers[i] == pt3[i % pt3.length]) correctMap.put(3, correctMap.getOrDefault(3, 0) + 1);
	        	
	        }
	        
	        List<Map.Entry<Integer, Integer>> entList = new ArrayList<>(correctMap.entrySet());
	        entList.sort((o1, o2) -> o2.getValue() - o1.getValue());

	        int max = entList.get(0).getValue();
	        
	        for(Entry<Integer, Integer> entry : entList) {
	        	if(entry.getValue() == max) {
	        		answerList.add(entry.getKey());
	        	}
	        }
	        
	        answerList.sort((o1, o2) -> o1 - o2);
	        return answerList.stream().mapToInt(Integer::intValue).toArray();
	    }
	    
	}
}
