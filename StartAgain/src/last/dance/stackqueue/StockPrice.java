package last.dance.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {

	public static void main(String[] args) {
		
		int[] prices = {2,2,1,1,3,3,4,4,5};
		
		System.out.println(Arrays.toString(new Solution().solution(prices)));
	}
	
	
	static class Solution {
		
		public int[] solution(int[] prices) {
			
			int[] answer = new int[prices.length];
			
			Stack<Integer> stack = new Stack<Integer>();
			
			for(int i = 0; i < prices.length; i++) {
				if(stack.isEmpty()) {
					stack.push(i);
					continue;
				}
				
				while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
					answer[stack.peek()] = i - stack.pop();
				} 
				
				stack.push(i);
			}
			
			while(!stack.isEmpty()) {
				answer[stack.peek()] = prices.length - 1 - stack.pop();
			}
			return answer;
		}
	}
}
