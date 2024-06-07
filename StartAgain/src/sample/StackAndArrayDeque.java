package sample;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class StackAndArrayDeque {

	
	public static void main(String[] args) {
		
		
		String[] array = {"A", "B", "C"};
		
		Stack<String> stack = new Stack<String>();
		Deque<String> deque = new ArrayDeque<String>();
		
		stack.addAll(Arrays.asList(array));
		deque.addAll(Arrays.asList(array));
		
		while(!stack.isEmpty() && !deque.isEmpty()) {
			
			System.out.println("stack pop : " + stack.pop());
			System.out.println("deque pop : " + deque.pop());
			System.out.println("=====================");
		}
	}
}
