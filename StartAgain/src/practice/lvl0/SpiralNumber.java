package practice.lvl0;

import java.util.Arrays;
//나선 배열
public class SpiralNumber {

	public static void main(String[] args) {
		int size = 5;
		for(int[] arr : solution(size)) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static int[][] solution(int n) {
		
		int[][] answer = new int[n][n];
		
		int num = 0;
		int rowNum = 0;
		int colNum = 0;
		
		int dir = 1;
		
		while(num < n*n) { 
			num++;
			answer[rowNum][colNum] = num;
			if(dir == 1) {
				//동
				if(colNum + 1 < n && answer[rowNum][colNum + 1] == 0) {
					colNum++;
				} else {
					rowNum++;
					dir = 2;
				}
			} else if(dir == 2) {
				//남 
				if(rowNum + 1 < n && answer[rowNum + 1][colNum] == 0) {
					rowNum++;
				} else {
					colNum--;
					dir = 3;
				}
			} else if(dir == 3) {
				//서 
				if(colNum - 1 >= 0 && answer[rowNum][colNum - 1] == 0) {
					colNum--;
				} else {
					rowNum--;
					dir = 4;
				}
			} else if(dir == 4) {
				//북 
				if(rowNum - 1 >= 0 && answer[rowNum - 1][colNum] == 0) {
					rowNum--;
				} else {
					colNum++;
					dir = 1;
				}
			}
		}
				
		return answer;
		
	}
}
