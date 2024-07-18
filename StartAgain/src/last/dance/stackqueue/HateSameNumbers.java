package last.dance.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class HateSameNumbers {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] arr = {1,1,3,3,0,1,1};
		
		System.out.println(Arrays.toString(sol.solution(arr)));
	}
	
	public static class Solution {
		
	    public int[] solution(int []arr) {
	    	
	    	List<Integer> answerList = new ArrayList<>();
	        
	        Stack<Integer> stack = new Stack<Integer>();
	        stack.push(arr[0]);
	        
	        for(int i = 1; i < arr.length; i++) {
	        	if(stack.peek() == arr[i]) {
	        		continue;
	        	} else {
	        		stack.push(arr[i]);
	        	}
	        }
	        
	        while(!stack.isEmpty()) {
	        	answerList.add(stack.pop());
	        }

	        Collections.reverse(answerList);
	        return answerList.stream().mapToInt(Integer::intValue).toArray();
	    }
	}
}
