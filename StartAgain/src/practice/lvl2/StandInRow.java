package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 줄 세우기
 * 
 * n명의 사람이 일렬로 줄을 서고 있습니다. n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다. n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다. 예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.

	[1, 2, 3]
	[1, 3, 2]
	[2, 1, 3]
	[2, 3, 1]
	[3, 1, 2]
	[3, 2, 1]
	사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, k번째 방법을 return하는 solution 함수를 완성해주세요.
	
	제한사항
	n은 20이하의 자연수 입니다.
	k는 n! 이하의 자연수 입니다.
 * */
public class StandInRow {

	public static void main(String[] args) {
		
		int n = 20;
		long k = getFactorialValue(20)-1;
		System.out.println(Arrays.toString(solution(n, k)));
//		for(int i = 1; i <= getFactorialValue(n); i++) {
//		}
	}
	
	public static int[] solution(int n, long k) {
		int[] answer = new int[n];
		
		List<Integer> numList = new ArrayList<Integer>();
		
		for(int i = 1; i <= n; i++) {
			numList.add(i);
		}
		
        //n이 최대값인 경우, 가능한 모든 경우의 수 = 20!...
        //최대 19자리 -> long 사용
        //맨 앞 숫자부터 처리
		//i 번쨰 자리 숫자는, n - i 팩토리얼의 몫 (나머지가 0보다 큰 경우 + 1)
        int answerIdx = 0;
        int numIdx = 0;
        long div = 0, mod = 0;
        long ft;
        while(numList.size() > 0) {
        	
        	if(k == 0) {
        		answer[answerIdx] = numList.remove(numList.size() - 1);
        		answerIdx++;
        		continue;
        	}
        	
        	ft = getFactorialValue(n - (answerIdx + 1));
        	div = k / ft;
        	mod = k % ft;
        	
        	if(mod == 0) {
        		numIdx = (int) div - 1;
        	} else {
        		numIdx = (int) div;
        	}
        	answer[answerIdx] = numList.get(numIdx);
        	numList.remove(numIdx);
        	
        	answerIdx++;
        	k = mod;
        	
        	if(numList.size() == 1) {
        		answer[answerIdx] = numList.get(0);
        		break;
        	}
        }
        
        return answer;
    }
	
	public static long getFactorialValue(int f) {
		//n이 최대값인 경우, 가능한 모든 경우의 수 = 20!...
		long ft = 1;
        for (int i = 1; i <= f; i++) {
        	ft = ft * i;
        }
        
        return ft;
	}
}
