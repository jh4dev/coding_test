package last.dance.stackqueue;

import java.util.Stack;

public class CorrectBracket {

	public static void main(String[] args) {
	
		String s = "(()(";
		System.out.println(new Solution().solution(s));
	}
	
	static class Solution {
	    boolean solution(String s) {
	 
	    	Stack<Character> stack = new Stack<Character>();
	    	
	    	for(char c : s.toCharArray()) {
	    		
	    		if(c == '(') stack.push(c);
	    		else {
	    			
	    			if(stack.isEmpty()) {
	    				return false;
	    			}
	    			
	    			if(stack.peek() == '(') {
	    				stack.pop();
	    			} else {
	    				return false;
	    			}
	    		}
	    	}
	    	return stack.isEmpty() ? true : false;
	    }
	}
}
