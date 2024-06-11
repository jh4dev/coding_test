package practice.lvl2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [숫자 변환하기]
 * 최소 연산 횟수 구하기 > BFS 시간초과
 * 
 * 자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.

		x에 n을 더합니다
		x에 2를 곱합니다.
		x에 3을 곱합니다.
	자연수 x, y, n이 매개변수로 주어질 때, 
	x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 
	이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
 * */
public class MinimumCalculation_BFS {

	static int minCnt = -1;
	
	public static void main(String[] args) {
//		
//		int x = 10;
//		int y = 40;
//		int n = 5;
		int x = 1;
		int y = 99999999;
		int n = 2;
		System.out.println(solution(x, y, n));
	}
	
	public static int solution(int x, int y, int n) {
		
		int[] countArr = new int[y+1];
		
		if(x == y) return 0;
		
		// i 로 연산하여 -1이 아닌 수를 만들 수 있는지 체크
		for(int i = x+1; i <= y; i++) {
			if(i % 3 == 0 && i / 3 >= x && countArr[i/3] >= 0) {
				if(countArr[i] == 0) {
					countArr[i] = countArr[i/3] + 1;
				} else {
					countArr[i] = Math.min(countArr[i/3] + 1, countArr[i]);
				}
			}
			
			if(i % 2 == 0 && i / 2 >= x && countArr[i/2] >= 0) {
				if(countArr[i] == 0) {
					countArr[i] = countArr[i/2] + 1;
				} else {
					countArr[i] = Math.min(countArr[i/2] + 1, countArr[i]);
				}
			}
			
			if(i-n >= x && countArr[i-n] >= 0) {
				if(countArr[i] == 0) {
					countArr[i] = countArr[i-n] + 1;
				} else {
					countArr[i] = Math.min(countArr[i-n] + 1, countArr[i]);
				}
			}
			
			if(countArr[i] == 0) countArr[i] = -1;
		}
		
		return countArr[y] == 0 ? -1 : countArr[y];
    }
	
}
