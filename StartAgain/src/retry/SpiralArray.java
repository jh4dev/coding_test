package retry;

import java.util.Arrays;

public class SpiralArray {

	public static void main(String[] args) {
		
		int n = 5;
		
		System.out.println(Arrays.deepToString(solution(n)));
		
	}
	
	public static int[][] solution(int n) {
		
		int[][] answer = new int[n][n];
		
		int cnt = 0;
		int dir = 1;
		
		int row = 0;
		int col = 0;
		while(cnt < n*n) {
			
			cnt++;
			answer[row][col] = cnt;
			
			if(dir == 1) {
				//동쪽 진행 확인 
				if(col + 1 < n && answer[row][col+1] == 0) {
					col += 1;
				} else {
					//남쪽으로 진행 
					row += 1;
					dir = 2;
				}
			} else if (dir == 2) {
				//남쪽 진행 확인 
				if(row + 1 < n && answer[row+1][col] == 0) {
					row += 1;
				} else {
					//서쪽으로 진행
					col -= 1;
					dir = 3;
				}
			} else if (dir == 3) {
				//서쪽 진행 확인 
				if(col - 1 >= 0 && answer[row][col-1] == 0) {
					col -= 1;
				} else {
					//북쪽으로 진행 
					row -= 1;
					dir = 4;
				}
				
			} else if (dir == 4) {
				//북쪽 진행 확인 
				if(row - 1 >= 0 && answer[row - 1][col] == 0) {
					row -= 1;
				} else {
					//동쪽으로 진행 
					col += 1;
					dir = 1;
				}
				
			}
			
		}   
	
		return answer;
		
	}
} 
