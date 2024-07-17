package practice.lvl3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 숫자 게임
 * */
public class NumberGame {

	public static void main(String[] args) {
		
		int[] A = {1,3,5,7};
		int[] B = {2,2,6,8};
		
		System.out.println(solution(A, B));
	}
	
	public static int solution(int[] A, int[] B) {
        int answer = 0;
        
        // 순서가 크게 상관없어보임
        // A B 를 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        Queue<Integer> bq= new LinkedList<Integer>();
        Queue<Integer> tq= new LinkedList<Integer>();
        for(int b : B) bq.add(b);
        
        int bVal;
        int idx = 0;
        while(!bq.isEmpty()) {
        	
        	bVal = bq.poll();
        	
        	if(A[idx] < bVal) {
        		answer++;
        		idx++;
        	} else {
        		tq.add(bVal);
        	}
        }
        
        return answer;
    }
}
