package last.dance.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class DoublePq {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
	}
	
	static class Solution {
		
		public int[] solution(String[] operations) {
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			Stack<Integer> maxStack = new Stack<Integer>();
			
			String oper;
			int number;
			
			for(int i = 0; i < operations.length; i++) {
				
				oper = operations[i].split(" ")[0];
				number = Integer.parseInt(operations[i].split(" ")[1]);
				
				if("I".equals(oper)) {
					//숫자 삽입
					if(maxStack.isEmpty() || maxStack.peek() <= number) {
						maxStack.push(number);
					}
					pq.add(number);
					
				} else if("D".equals(oper) && number == -1) {
					//최소값 삭제
					if(!pq.isEmpty()) {
						pq.poll();
					}
				} else if("D".equals(oper) && number == 1) {
					//최대값 삭제
					if(!pq.isEmpty()) {
						pq.remove(maxStack.pop());
					}
				}
			}

			if(pq.isEmpty()) return new int[] {0,0};
			
			List<Integer> list = new ArrayList<>(pq);
			list.sort((o1, o2) -> o1 - o2);
			
			return new int[] {list.get(list.size()-1), list.get(0)};
		}
	}
}
