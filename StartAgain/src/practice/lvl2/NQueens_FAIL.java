package practice.lvl2;

/**
 * N Queens
 * n * n 체스판에, n 개의 Queen 이 서로 공격할 수 없게 배치하는 경우의 수
 * 
 * */
public class NQueens_FAIL {

	public static void main(String[] args) {
	
		int n = 4;
		
		System.out.println(solution(n));
	}
	
	static int answer;
	static int[] chess;
	public static int solution(int n) {
		answer = 0;
		chess = new int[n];
		
		bt(0, n);
		
		return answer;
	}
	
	public static void bt(int row, int n) {
		
		if(row == n) {
			answer++;
			return;
		}
		
		for(int c = 0; c < n; c++) {
			chess[row] = c;
			if(isPossiblePlace(row)) {
				bt(row + 1, n);
			}
		}
		
	}
	
	public static boolean isPossiblePlace(int nowRow) {
		
		for(int r = 0; r < nowRow; r++) {
			
			if(chess[nowRow] == chess[r]) return false;
			if(Math.abs(r - nowRow) == Math.abs(chess[nowRow] - chess[r])) return false;
		}
		
		return true;
	}
}
