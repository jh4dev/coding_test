package practice.lvl0;

import java.util.Arrays;

public class SafetyZone {

	public static void main(String[] args) {
		
		int[][] board = {
				 {1,0,0,0,0}
				,{0,0,0,0,0}
				,{0,0,1,0,0}
				,{0,0,0,0,0}
				,{0,0,0,0,1}
		};
		
		solution(board);
	}
	
	public static int solution(int[][] board) {
		
		int answer = 0;
		
		for(int i = 0; i < board.length; i++) {
			
			for(int j = 0; j < board[0].length; j++) {
				
				//지뢰인 경우, 주변 8칸 중 0인 칸을 위험지역으로 변경 (-1 처리)
				if(board[i][j] == 1) {
					
					//좌상
					if(i >= 1 && j >= 1 ) {
						if(board[i-1][j-1] == 0)
						board[i-1][j-1] = 9;
					}
					
					//상
					if(i >= 1) {
						if(board[i-1][j] == 0)
						board[i-1][j] = 9;
					}
					
					//우상
					if(i >= 1 && j < board.length - 1) {
						if(board[i-1][j+1] == 0)
							board[i-1][j+1] = 9;
					}
					
					//좌 
					if(j >= 1) {
						if(board[i][j-1] == 0)
							board[i][j-1] = 9;
					}
					
					//우
					if(j < board.length - 1 ) {
						if(board[i][j+1] == 0) {
							board[i][j+1] = 9;
						}
					}
					
					//좌하
					if(i < board.length - 1 && j >= 1) {
						if(board[i+1][j-1] == 0)
							board[i+1][j-1] = 9;
					}
					
					//하
					if(i < board.length - 1) {
						if(board[i+1][j] == 0) {
							board[i+1][j] = 9;
						}
					}
					
					//우하
					if(i < board.length - 1 && j < board.length - 1) {
						if(board[i+1][j+1] == 0) {
							board[i+1][j+1] = 9;
						}
					}
					
				}
			}
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 0) {
					answer++;
				}
			}
		}
		
		return answer;
	}
}
