package skilltest.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question1_0615 {

	public static void main(String[] args) {
		
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1,1,1,1,1,1};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
       
		List<Integer> answerList = new ArrayList<Integer>();
        Queue<Progress> jobQueue = new LinkedList<Progress>();
        
        for(int i = 0; i < progresses.length; i++) {
        	
        	jobQueue.add(new Progress(progresses[i], speeds[i]));
        }
        
        Progress p;
        int days = 0;
        int nowProgress = 0;
        int deployCnt = 0;
        while(!jobQueue.isEmpty()) {
        	
        	p = jobQueue.peek();
        	nowProgress = p.develope(days);
        	
        	if(nowProgress >= 100) {
        		deployCnt++;
        		jobQueue.poll();
        	
        	} else {
        		if(deployCnt > 0) {
        			answerList.add(deployCnt);
        			deployCnt = 0;
        		}
        		days++;
        	}
        }
        if(deployCnt > 0) {
        	answerList.add(deployCnt);
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
	
	public static class Progress {
		
		int initPrgress;
		int speed;
		
		public Progress (int initPrgress, int speed){
			
			this.initPrgress = initPrgress;
			this.speed = speed;
		}
		
		public int develope(int days) {
			return initPrgress + speed * days;
		}
		
		public boolean isComplete() {
			return initPrgress >= 100 ? true : false;
		}

		@Override
		public String toString() {
			return "Progress [initPrgress=" + initPrgress + ", speed=" + speed + "]";
		}
		
		
	}
}
