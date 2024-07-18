package last.dance.stackqueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Processes {

	public static void main(String[] args) {
		
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		System.out.println(new Solution().solution(priorities, location));
	}
	
	static class Solution{
		
		public int solution(int[] priorities, int location) {
			
			int answer = 0;
			
			Queue<Process> processQueue = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			for(int i = 0; i < priorities.length; i++) {
				processQueue.add(new Process(i, priorities[i]));
				pq.add(priorities[i]);
			}

			Process p;
			while(!processQueue.isEmpty()) {
				
				p = processQueue.poll();
				
				if(pq.peek() <= p.getPriority()) {
					pq.poll();
					answer++;
					if(p.location == location) {
						break;
					}
				} else {
					processQueue.add(p);
				}
			}
			
			return answer;
		}
		
		public class Process {
			private int location;
			private int priority;
			
			public Process(int location, int priority) {
				super();
				this.location = location;
				this.priority = priority;
			}
			
			public int getLocation() {
				return location;
			}
			public void setLocation(int location) {
				this.location = location;
			}
			public int getPriority() {
				return priority;
			}
			public void setPriority(int priority) {
				this.priority = priority;
			}
			@Override
			public String toString() {
				return "Process [location=" + location + ", priority=" + priority + "]";
			}
		}
	}
}
