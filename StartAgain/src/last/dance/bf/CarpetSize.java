package last.dance.bf;

import java.util.Arrays;

public class CarpetSize {

	public static void main(String[] args) {
		
		int brown = 10;
		int yellow = 2;
		
		System.out.println(Arrays.toString(new Solution().solution(brown, yellow)));
	}
	
	static class Solution {
	    public int[] solution(int brown, int yellow) {
	    	int[] answer = new int[2];
	    	
	    	int total = brown + yellow;

	    	//brown이 8 이상, yellow가 1 이상 -> x/y 최소 3 이상
	    	for(int i = 3; i <= Math.sqrt(total); i++) {
	    		if(total % i == 0 && isCorrectAnswer(total / i, i, brown, yellow)) {
	    			answer[0] = total / i;
	    			answer[1] = i;
	    		}
	    	}
	    	
	    	return answer;
	    }
	    
	    public boolean isCorrectAnswer(int x, int y, int brown, int yellow) {
	    	
	    	if((x-2) * (y-2) == yellow && x * y - yellow == brown) {
	    		return true;
	    	}
	    	
	    	return false;
	    }
	}
}
