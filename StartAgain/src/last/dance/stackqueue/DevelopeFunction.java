package last.dance.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DevelopeFunction {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1,1,1,1,1,1};
		
		System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
	}

	static class Solution {
		
	    public int[] solution(int[] progresses, int[] speeds) {
	     
	    	List<Integer> answerList = new ArrayList<>();
	    	
	    	Stack<Process> stack = new Stack<Process>();
	    	for(int i = progresses.length - 1; i >= 0; i--) {
	    		stack.push(new Process(i, speeds[i], progresses[i]));
	    	}
	    	
	    	int dayCnt = 1;
	    	int deployCnt = 0;
	    	Process p;
	    	while(!stack.isEmpty()) {
	    		
	    		p = stack.peek();
	    		
	    		if(p.getProgress() + (p.getSpeed() * dayCnt) >= 100) {
	    			//배포
	    			deployCnt++;
	    			stack.pop();
	    		} else {
	    			if(deployCnt > 0) {
	    				answerList.add(deployCnt);
	    				deployCnt = 0;
	    			}
	    			dayCnt += 1;
	    		}
	    	}
	    	
	    	if(deployCnt > 0) {
	    		answerList.add(deployCnt);
	    	}
	    	
	    	return answerList.stream().mapToInt(Integer::intValue).toArray();
	    }
	    
	    public class Process {
			
			private int idx;
			private int speed;
			private int progress;
			
			public Process(int idx, int speed, int progress) {
				super();
				this.idx = idx;
				this.speed = speed;
				this.progress = progress;
			}
			public int getIdx() {
				return idx;
			}
			public void setIdx(int idx) {
				this.idx = idx;
			}
			public int getSpeed() {
				return speed;
			}
			public void setSpeed(int speed) {
				this.speed = speed;
			}
			public int getProgress() {
				return progress;
			}
			public void setProgress(int progress) {
				this.progress = progress;
			}
			@Override
			public String toString() {
				return "Process [idx=" + idx + ", speed=" + speed + ", progress=" + progress + "]";
			}
		}
	}
}
