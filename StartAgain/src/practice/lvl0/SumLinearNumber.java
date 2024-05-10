package practice.lvl0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumLinearNumber {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solution(5, 5)));
	}
	
	public static int[] solution(int num, int total) {
		
		List<Integer> answerList = new ArrayList<Integer>();
		
		//num이 홀수인 경우, 몫이 중앙 값
		//num이 짝수인 경우, 몫 기준 우측 +1
		
		//중앙값 
		int centralNum = Math.floorDiv(total, num);
		
		//원사이드 사이즈 
		int halfSize = (num - 1) / 2;
		
		if(num % 2 == 1) {
			for(int i = centralNum - halfSize; i <= centralNum + halfSize; i++) {
				answerList.add(i);
			}
		} else {
			
			for(int i = centralNum - halfSize; i <= centralNum + halfSize + 1; i++) {
				answerList.add(i);
			}
		}
		
		return answerList.stream().mapToInt(Integer::intValue).toArray();
		
	}
}
