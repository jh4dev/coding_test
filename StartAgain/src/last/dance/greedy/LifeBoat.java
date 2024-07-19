package last.dance.greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LifeBoat {

	public static void main(String[] args) {
		
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		
		System.out.println(new Solution().solution(people, limit));
	}
	
	static class Solution {
	    public int solution(int[] people, int limit) {
	    	int answer = 0;

	    	Arrays.sort(people);
	    	Deque<Integer> adq = new ArrayDeque<Integer>();
	    	for(int i = 0; i < people.length; i++) {
	    		adq.add(people[i]);
	    	}
	    	
	    	int light, heavy;
	    	while(!adq.isEmpty()) {
	    		
	    		light = adq.peekFirst();
	    		heavy = adq.peekLast();
	    		
	    		if(light + heavy <= limit) {
	    			adq.pollFirst();
	    			adq.pollLast();
	    		} else {
	    			adq.pollLast();
	    		}
	    		answer++;
	    	}
	    	
	    	return answer;
	    }
	}
}
