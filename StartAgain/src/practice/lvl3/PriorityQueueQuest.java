package practice.lvl3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 
 * 우선순위 큐
 * 
 * 이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

	명령어	수신 탑(높이)
	I 숫자	큐에 주어진 숫자를 삽입합니다.
	D 1		큐에서 최댓값을 삭제합니다.
	D -1	큐에서 최솟값을 삭제합니다.
	이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
	
	제한사항
	operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
	operations의 원소는 큐가 수행할 연산을 나타냅니다.
	원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
	빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.

 * */
public class PriorityQueueQuest {

	public static void main(String[] args) {
		
		/*
		 * ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
			["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
		 * */
		String[] operations = {"I 1", "I 3", "I 2"};
		
		System.out.println(Arrays.toString(solution(operations)));
	}
	
	public static int[] solution(String[] operations) {
        
		//PQ 사용
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        //최대값 관리 스택
        Stack<Integer> mst = new Stack<Integer>();
        
        String[] o;
        int number;
        for(String oper : operations) {
        	o = oper.split(" ");
        	number = Integer.parseInt(o[1]);
        	
        	if("I".equals(o[0])) {
        		if(mst.isEmpty()) {
        			mst.push(number);
        		} else if(number >= mst.peek()) {
        			mst.push(number);
        		}
        		//insert
        		pq.add(number);
        		
        	} else if("D".equals(o[0])) {
        		//delete
        		// 1 -> delete maximum value
        		if(number == 1 && !pq.isEmpty()) {
        			pq.remove(mst.pop());
        		}
        		// -1 -> delete minimum value
        		if(number == -1 && !pq.isEmpty()) {
        			pq.poll();
        		}
        	}
        }
        
        if(pq.isEmpty()) {
        	return new int[] {0,0};
        } else {
        	List<Integer> list = new ArrayList<>(pq);
        	//insert 만 진행하는 경우 대비하여 정렬이 필요함
        	list.sort((o1, o2) -> o1 - o2);
        	return new int[] {list.get(list.size()-1), list.get(0)};
        }
    }
}
