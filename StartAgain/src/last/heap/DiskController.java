package last.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DiskController {

	
	public static void main(String[] args) {
		
		int[][] jobs ={{0, 5}, {1, 2}, {5, 5}};
;
		
		System.out.println(solution(jobs));
	}
	
	public static int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Task> pq = new PriorityQueue<Task>();
        
        for(int[] job : jobs) {
        	pq.add(new Task(job));
        }
        
        int now = 0;
        Task t;
        List<Task> tempList = new ArrayList<>();
        while(!pq.isEmpty()) {
        	
        	//시작 가능한 모든 job 중, 소요 시간이 가장짧은 것 우선 진행 
        	t = pq.poll();
        	if(now == 0 || now < t.getRequset()) {
        		now = t.getRequset();
        	}
        	t.setTotalTime(now);
        	
        	tempList.clear();
        	tempList.add(t);
        	while(!pq.isEmpty() && pq.peek().getRequset() <= now) {
        		pq.peek().setTotalTime(now);
        		tempList.add(pq.poll());
        	}
        	
        	if(tempList.size() > 1) {
        		tempList.sort((o1, o2) -> {
        			return o1.getTime() - o2.getTime();
        		});
        	}
        	System.out.println(tempList.get(0));
        	now += tempList.get(0).getTime();
        	answer += tempList.remove(0).getTotalTime();
    		pq.addAll(tempList);
        }
        
        return answer / jobs.length ;
    }
	
	public static class Task implements Comparable<Task> {
		private int requset;
		private int time;
		private int totalTime;
		
		public void setTotalTime(int nowTime) {
			this.totalTime = nowTime - this.requset + this.time;
		}
		
		public Task(int[] t) {
			super();
			this.requset = t[0];
			this.time = t[1];
		}
		public int getRequset() {
			return requset;
		}
		public void setRequset(int requset) {
			this.requset = requset;
		}
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		public int getTotalTime() {
			return totalTime;
		}
		

		@Override
		public String toString() {
			return "Task [requset=" + requset + ", time=" + time + ", totalTime=" + totalTime + "]";
		}

		@Override
		public int compareTo(Task o) {
			return Integer.compare(this.requset, o.requset);
		}
	}
}
