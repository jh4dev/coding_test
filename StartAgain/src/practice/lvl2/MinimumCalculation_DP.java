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
public class MinimumCalculation_DP {

	static int minCnt = -1;
	
	public static void main(String[] args) {
		
//		int x = 3;
//		int y = 8;
//		int n = 2;
		int x = 1;
		int y = 99999999;
		int n = 2;
		System.out.println(solution(x, y, n));
	}
	
	public static int solution(int x, int y, int n) {
		
		Queue<NowNumber> q = new LinkedList<>();
		NowNumber nn = new NowNumber(0, y);
		q.add(nn);
		
		NowNumber nowNum = null;
		while(!q.isEmpty()) {
			nowNum = q.poll();
			
			if(nowNum.now == x) {
				if(nowNum.cnt > 0) {
					minCnt = nowNum.cnt;
				}
				break;
			} else if (nowNum.now < x) {
				continue;
			} else {
				q.add(new NowNumber(nowNum.cnt + 1, nowNum.now / 3));
				q.add(new NowNumber(nowNum.cnt + 1, nowNum.now / 2));
				q.add(new NowNumber(nowNum.cnt + 1, nowNum.now - n));
			}
			
		}
        
        return minCnt;
    }
	
	public static class NowNumber {
		int cnt;
		double now;
		
		public NowNumber(int cnt, double now) {
			this.cnt = cnt;
			this.now = now;
		}

		@Override
		public String toString() {
			return "NowNumber [cnt=" + cnt + ", now=" + now + "]";
		}
	}
}
