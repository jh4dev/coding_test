package retry;

import java.util.Stack;

public class Sample {

	public static void main(String[] args) {
		
		String s = "()(()";
		
		System.out.println(rightBracket2(s));
	}
	
	public static boolean rightBracket(String s) {
		
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		
		int idx = 1;
		while(idx < s.split("").length) {
			
			if(stack.isEmpty()) {
				stack.push(s.charAt(idx));
			} else {
				if(stack.peek() == '(' && s.charAt(idx) == ')') {
					stack.pop();
				} else {
					stack.push(s.charAt(idx));
				}
			}
			idx++;
		}
		
		return stack.isEmpty() ? true : false;
	}
	
	public static boolean rightBracket2(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : s.toCharArray()) {
			
			if(c == '(' || stack.isEmpty()) {
				stack.push(c);
			} else if(c == ')' && stack.peek() == '(') {
				stack.pop();
			}
		}
		
		return stack.isEmpty() ? true : false;
	}
}
