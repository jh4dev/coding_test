package practice.lvl2;

/*
 * 숫자의 표현 (연속된 수의 합)
 * Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.

	1 + 2 + 3 + 4 + 5 = 15
	4 + 5 + 6 = 15
	7 + 8 = 15
	15 = 15
	자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
 * */

/* Effecient Solution
 * 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리
 * */
public class SumOfNumbers {

	public static void main(String[] args) {
		
		int n = 9;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
        int answer = 1;	//본인 자신 기본값
        
        int tempSum = 0;
        int startNum = 1;
        
        while(startNum <= n/2) {
        	tempSum = startNum;
        	for(int i = startNum + 1; i <= n/2 + 1; i++) {
        		
        		tempSum += i;
        		
        		if(tempSum == n) {
        			answer++;
        			startNum++;
        			break;
        		} else if(tempSum > n) {
        			startNum++;
        			break;
        		}
        	}
        }
        return answer;
    }
}
