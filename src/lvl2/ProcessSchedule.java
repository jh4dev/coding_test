package lvl2;

import java.util.*;

public class ProcessSchedule {

    public static void main(String[] args) {

        int[] priorities = {2,1,3,2};
        int location = 2;

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {

        //priorities : 프로세스 별 우선순위
        //location : 찾을 프로세스 인덱스

        //return : priorities[location] 이 실행되는 순서, 순서는 1부터
        //<location, priority>
        Queue<Process> queue = new LinkedList<Process>();
        for(int i = 0; i < priorities.length; i++) {
            Process pc = new Process();
            pc.setOrder(i);
            pc.setPriority(priorities[i]);
            queue.add(pc);
        }

        //우선순위 관리 스택(오름차순으로 push 설정)
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(priorities);
        Arrays.stream(priorities).boxed().forEach(stack::push);

        int nowPriority = 0;
        int cnt = 1;

        while(true) {
            Process pc = queue.poll();
            if(pc == null) {
                break;
            }

            nowPriority = stack.pop();
            if(pc.getPriority() == nowPriority) {
                if(pc.getOrder() == location) {
                    break;
                }
                //실행할 우선순위
                cnt += 1;
            } else {
                //큐에 삽입
                queue.add(pc);
                stack.push(nowPriority);
            }

        }

        return cnt;
    }

    static class Process {

        private int priority;
        private int order;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }
}
