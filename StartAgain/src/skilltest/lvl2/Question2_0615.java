package skilltest.lvl2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Question2_0615 {

	public static void main(String[] args) {
		
		String[][] plans = {
				{"science", "12:40", "50"},
					{"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}
		};
		
		System.out.println(Arrays.toString(solution(plans)));
	}
	
	public static String[] solution(String[][] plans) {
        List<String> answerList = new ArrayList<>();
        List<WorkPlan> planList = new ArrayList<>();
        
        for(String[] plan : plans) {
        	planList.add(new WorkPlan(plan));
        }

        //시작시간 순으로 정렬
        Collections.sort(planList, (o1, o2) -> o1.getiStartTime() - o2.getiStartTime());
        
        Queue<WorkPlan> planQueue = new LinkedList<>();
        planQueue.addAll(planList);
        
        Stack<WorkPlan> ws = new Stack<WorkPlan>();
        Stack<WorkPlan> hold = new Stack<WorkPlan>();
        ws.push(planQueue.poll());
        
        WorkPlan nowPlan = null;
        WorkPlan nextPlan = null;
        LocalTime nowTime = ws.peek().ltStart;
        while(!ws.isEmpty()) {
        	nowPlan 	= ws.peek();
        	nextPlan 	= planQueue.peek();
        	
        	System.out.println(nowTime);
        	if(isComplete(nowTime.plusMinutes(nowPlan.getiPlayTime()), nextPlan.getLtStart())) {
        		answerList.add(ws.pop().getSubject());
        		nowTime = nowTime.plusMinutes(nowPlan.getiPlayTime());
        		if(hold.isEmpty()) {
        			ws.push(planQueue.poll());
        		} else {
        			ws.push(hold.pop());
        		}
        	} else {
                Duration duration = Duration.between(nowPlan.getLtStart(), nextPlan.getLtStart());
        		nowPlan.setiPlayTime(nowPlan.getiPlayTime() - (int)duration.toMinutes());
        		nowTime = nextPlan.ltStart;
        		hold.push(nowPlan);
        		ws.pop();
        		ws.push(planQueue.poll());
        	}
        	
        	System.out.println("진행 : " + ws);
        	System.out.println("대기 : " + hold);
        	System.out.println(nowTime);
        	System.out.println("-------------");
        	
        	if(planQueue.isEmpty()) {
        		while(!ws.isEmpty()) {
        			answerList.add(ws.pop().getSubject());
        		}
        		while(!hold.isEmpty()) {
        			answerList.add(hold.pop().getSubject());
        		}
        		break;
        	}
        }
        
        return answerList.toArray(new String[0]);
    }
	
	public static boolean isComplete(LocalTime now, LocalTime next){
		
		if(now.equals(next) || now.isBefore(next)) return true;
		return false;
	}
	public static class WorkPlan {
		
		String subject;
		String startTime;
		String playTime;
		
		int iStartTime;
		int iPlayTime;
		LocalTime ltStart;
		
		public WorkPlan (String[] plan) {
			
			this.subject 	= plan[0];
			this.startTime 	= plan[1];
			this.playTime 	= plan[2];
			
			this.iPlayTime 	= Integer.parseInt(playTime);
			this.ltStart 	= LocalTime.of(Integer.parseInt(startTime.split(":")[0]), Integer.parseInt(startTime.split(":")[1]));
			this.iStartTime = Integer.parseInt(startTime.split(":")[0]) * 60 + Integer.parseInt(startTime.split(":")[1]);
		}
		public LocalTime getLtStart() {
			return ltStart;
		}
		public void setLtStart(LocalTime ltStart) {
			this.ltStart = ltStart;
		}
		public int getiStartTime() {
			return iStartTime;
		}
		public void setiStartTime(int iStartTime) {
			this.iStartTime = iStartTime;
		}
		public int getiPlayTime() {
			return iPlayTime;
		}
		public void setiPlayTime(int iPlayTime) {
			this.iPlayTime = iPlayTime;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getPlayTime() {
			return playTime;
		}
		public void setPlayTime(String playTime) {
			this.playTime = playTime;
		}
		@Override
		public String toString() {
			return "WorkPlan [subject=" + subject + ", startTime=" + startTime + ", playTime=" + playTime
					+ ", iStartTime=" + iStartTime + ", iPlayTime=" + iPlayTime + ", ltStart=" + ltStart + "]";
		}
	}
}
