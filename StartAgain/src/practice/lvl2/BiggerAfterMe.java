package practice.lvl2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 뒤에 있는 큰 수 찾기
 * 
 * 정수로 이루어진 배열 numbers가 있습니다. 
 * 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
	정수 배열 numbers가 매개변수로 주어질 때, 
	모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 
	단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
	
	[9, 1, 5, 3, 6, 2]	[-1, 5, 6, 6, -1, -1]
 * 
 * */
public class BiggerAfterMe {

	
	public static void main(String[] args) {
		
		int[] numbers = {9, 1, 5, 3, 6, 2};
		
		System.out.println(Arrays.toString(solution(numbers)));
		System.out.println(Arrays.toString(resolution(numbers)));
	}
	
	public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<Integer>();
        Arrays.fill(answer, -1); 
        
        for (int i = 0; i < numbers.length; i++) {
        	System.out.println(numbers[i]);
        	System.out.println(stack);
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
	
	public static int[] resolution(int[] numbers) {
		
		int[] answer = new int[numbers.length];
		Arrays.fill(answer, -1);

		//스택으로 인덱스 관리
		Stack<Integer> idxStack = new Stack<>();
		
		for(int i = 0; i < numbers.length; i++) {
			
			while(!idxStack.isEmpty()) {
				if(numbers[idxStack.peek()] < numbers[i]) {
					answer[idxStack.pop()] = numbers[i];
				} else {
					break;
				}
			}
			
			idxStack.push(i);
		}
		
		return answer;
	}
}
