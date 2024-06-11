package practice.lvl2;

/**
 * [숫자 변환하기]
 * 최소 연산 횟수 구하기 > DFS 시간초과
 * 
 * 자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.

		x에 n을 더합니다
		x에 2를 곱합니다.
		x에 3을 곱합니다.
	자연수 x, y, n이 매개변수로 주어질 때, 
	x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 
	이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
 * */
public class MinimumCalculation_DFS {

	static int minCnt = -1;
	
	public static void main(String[] args) {
		
		int x = 1;
		int y = 99999999;
		int n = 4;
		
		System.out.println(solution(x, y, n));
	}
	
	public static int solution(int x, int y, int n) {
		dfs(y, x, n, 0);
        
        return minCnt;
    }
	
	public static void dfs(double now, double target, int n, int cnt) {
		
		if(now == target) {
			if(minCnt > cnt || minCnt == -1) minCnt = cnt;
			return;
		}
		if(now < target) {
			return;
		}
		
		dfs(now / 3, target, n, cnt+1);
		dfs(now / 2, target, n, cnt+1);
		dfs(now - n, target, n, cnt+1);
	}
}
