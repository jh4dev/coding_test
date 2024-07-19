package last.dance.greedy;

import java.util.Stack;

public class MakeBiggest {

	 public static void main(String[] args) {
	
		 String number = "1924";
		 int k = 2;
		 
		 System.out.println(new Solution().solution(number, k));
	}
	 
	static class Solution {
	    public String solution(String number, int k) {
	        StringBuffer sbf = new StringBuffer();
			int resultLen = number.length() - k;
			
			Stack<Integer> stack = new Stack<>(); 
			for(String num : number.split("")) {
				
				while(!stack.isEmpty() 
						&& stack.peek() < Integer.parseInt(num) 
						&& k > 0) {
					
					stack.pop();
					k--;
				}
				
				stack.push(Integer.parseInt(num));
			}

			for(int s : stack) {
				if(sbf.length() >= resultLen) {
					break;
				}
				sbf.append(s);
			}
			
			return sbf.toString();
	    }
	}
}
