package practice.lvl2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *	두 큐의 원소 합 같게 만들기
 *
 * 길이가 같은 두 개의 큐가 주어집니다. 
 * 하나의 큐를 골라 원소를 추출(pop)하고, 추출된 원소를 다른 큐에 집어넣는(insert) 작업을 통해 각 큐의 원소 합이 같도록 만들려고 합니다. 
 * 이때 필요한 작업의 최소 횟수를 구하고자 합니다. 한 번의 pop과 한 번의 insert를 합쳐서 작업을 1회 수행한 것으로 간주합니다.

큐는 먼저 집어넣은 원소가 먼저 나오는 구조입니다. 
이 문제에서는 큐를 배열로 표현하며, 원소가 배열 앞쪽에 있을수록 먼저 집어넣은 원소임을 의미합니다.
즉, pop을 하면 배열의 첫 번째 원소가 추출되며, insert를 하면 배열의 끝에 원소가 추가됩니다. 
예를 들어 큐 [1, 2, 3, 4]가 주어졌을 때, pop을 하면 맨 앞에 있는 원소 1이 추출되어 [2, 3, 4]가 되며, 
이어서 5를 insert하면 [2, 3, 4, 5]가 됩니다.

다음은 두 큐를 나타내는 예시입니다.

	queue1 = [3, 2, 7, 2]
	queue2 = [4, 6, 5, 1]
	두 큐에 담긴 모든 원소의 합은 30입니다. 따라서, 각 큐의 합을 15로 만들어야 합니다. 예를 들어, 다음과 같이 2가지 방법이 있습니다.
	
	queue2의 4, 6, 5를 순서대로 추출하여 queue1에 추가한 뒤, queue1의 3, 2, 7, 2를 순서대로 추출하여 queue2에 추가합니다. 그 결과 queue1은 [4, 6, 5], queue2는 [1, 3, 2, 7, 2]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 7번 수행합니다.
	queue1에서 3을 추출하여 queue2에 추가합니다. 그리고 queue2에서 4를 추출하여 queue1에 추가합니다. 그 결과 queue1은 [2, 7, 2, 4], queue2는 [6, 5, 1, 3]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 2번만 수행하며, 이보다 적은 횟수로 목표를 달성할 수 없습니다.
	따라서 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수는 2입니다.
	
	길이가 같은 두 개의 큐를 나타내는 정수 배열 queue1, queue2가 매개변수로 주어집니다. 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return 하도록 solution 함수를 완성해주세요. 단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return 해주세요.
	
제한사항
	1 ≤ queue1의 길이 = queue2의 길이 ≤ 300,000
	1 ≤ queue1의 원소, queue2의 원소 ≤ 109
	주의: 언어에 따라 합 계산 과정 중 산술 오버플로우 발생 가능성이 있으므로 long type 고려가 필요합니다.
 * */
public class MakeSameSumQueue {

	public static void main(String[] args) {
		
		int[] queue1 = {1,5};
		int[] queue2 = {1,1};
		
		System.out.println(solution(queue1, queue2));
	}
	
	
	public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sumQ1 = 0;
        long sumQ2 = 0;
        
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        int t1,t2;
        for(int i = 0; i < queue1.length; i++) {
        	t1 = queue1[i];
        	t2 = queue2[i];
        	
        	q1.add(t1);
        	q2.add(t2);
        	
        	sumQ1 += t1;
        	sumQ2 += t2;
        }
        
        //홀수 컷트!
        if((sumQ1 + sumQ2) % 2 ==1) {
        	return -1;
        }
        
        int moveNumber;
        while(true) {
        	
        	//루프 탈출 조건
        	//한 큐가 비어있단 얘기는, 두 큐의 최대값이 나머지 값들의 합보다 크다는 것으로, 절반에 해당하는 값을 만들 수 없는 구조임
        	if(q1.isEmpty() || q2.isEmpty()) return -1;
        	
        	//최대 순회 > max 순회에 대한 고찰 필요
        	if(answer >= 3*queue1.length) return -1;
        	
        	
        	if(sumQ1 == sumQ2) {
        		break;
        		
        	} else if(sumQ1 < sumQ2) {
        		// Q2 -> Q1
        		moveNumber = q2.poll();
        		sumQ2 -= moveNumber;
        		sumQ1 += moveNumber;
        		q1.add(moveNumber);
        	} else {
        		// Q1 -> Q2
        		moveNumber = q1.poll();
        		sumQ1 -= moveNumber;
        		sumQ2 += moveNumber;
        		q2.add(moveNumber);
        	}
        	answer++;
        }
        
        return answer;
    }
}
