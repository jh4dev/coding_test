package last.dance.heap;

import java.util.PriorityQueue;

public class MoreSpicy {

	public static void main(String[] args) {
		
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		System.out.println(new Solution().solution(scoville, K));
	}
	
	static class Solution {
	    public int solution(int[] scoville, int K) {
	    	
	    	int answer = 0;
	    	
	    	//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	    	PriorityQueue<Integer> pq = new PriorityQueue<>();

	    	for(int i = 0; i < scoville.length; i++) {
	    		pq.add(scoville[i]);
	    	}
	    	
	    	int min1, min2;
	    	while(pq.peek() < K) {
	    		
	    		if(pq.size() == 1) {
    				return -1;
    			}

    			min1 = pq.poll();
    			min2 = pq.poll();
    			
    			pq.add(min1 + (min2 * 2));
    			
    			answer++;
	    	}
	    	
	    	return answer;
	    }
	}
}
