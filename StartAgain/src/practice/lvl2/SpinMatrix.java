package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 행렬 회전
 * 
 * rows x columns 크기인 행렬이 있습니다. 
 * 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다. 
 * 이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 합니다. 
 * 각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며, 그 의미는 다음과 같습니다.

	x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전합니다.
	이 행렬에 (2, 2, 5, 4) 회전을 적용하면, 아래 그림과 같이 2행 2열부터 5행 4열까지 영역의 테두리가 시계방향으로 회전합니다. 
	이때, 중앙의 15와 21이 있는 영역은 회전하지 않는 것을 주의하세요.
	행렬의 세로 길이(행 개수) rows, 가로 길이(열 개수) columns, 그리고 회전들의 목록 queries가 주어질 때, 
	각 회전들을 배열에 적용한 뒤, 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * 제한사항
		rows는 2 이상 100 이하인 자연수입니다.
		columns는 2 이상 100 이하인 자연수입니다.
		처음에 행렬에는 가로 방향으로 숫자가 1부터 하나씩 증가하면서 적혀있습니다.
		즉, 아무 회전도 하지 않았을 때, i 행 j 열에 있는 숫자는 ((i-1) x columns + j)입니다.
		queries의 행의 개수(회전의 개수)는 1 이상 10,000 이하입니다.
		queries의 각 행은 4개의 정수 [x1, y1, x2, y2]입니다.
		x1 행 y1 열부터 x2 행 y2 열까지 영역의 테두리를 시계방향으로 회전한다는 뜻입니다.
		1 ≤ x1 < x2 ≤ rows, 1 ≤ y1 < y2 ≤ columns입니다.
		모든 회전은 순서대로 이루어집니다.
		예를 들어, 두 번째 회전에 대한 답은 첫 번째 회전을 실행한 다음, 그 상태에서 두 번째 회전을 실행했을 때 이동한 숫자 중 최솟값을 구하면 됩니다.
 * */
public class SpinMatrix {

	
	public static void main(String[] args) {
		
		int rows = 100;
		int colums = 97;
		int[][] queries = {{1,1,100,97}};
		
		System.out.println(Arrays.toString(solution(rows, colums, queries)));
	}
	
	static int[][] board;
	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        board = new int[rows][columns];
        
        int value = 1;
        for(int r = 0; r < rows; r++) {
        	for(int c = 0; c < columns; c++) {
        		board[r][c] = value++;
        	}
        }
        
        for(int i = 0; i < queries.length; i++) {
        	answer[i] = spin(queries[i]);
        }
        
        return answer;
    }
	
	public static int spin(int[] query) {
		int x1, y1, x2, y2;
		x1 = query[0] - 1;
		y1 = query[1] - 1;
		x2 = query[2] - 1;
		y2 = query[3] - 1;

		//현위치, 방향
		int row = x1;
		int col = y1;
		char dir = 'E';
		
		//숫자 교체용
		int temp, before;
		before = board[row][col];
		
		//최소값 (리턴용)
		int min = before;
		Loop1:
		while(true) {
			
			switch(dir) {
			case 'E':
				//오른쪽 진행
				if(col + 1 > y2) {
					//아래쪽 변경
					dir = 'S';
				} else {
					temp = board[row][col+1];
					board[row][col+1] = before;
					before = temp;
					col += 1;
				}
				break;
			case 'S':
				//아래쪽 진행
				if(row + 1 > x2) {
					//왼쪽 변경
					dir = 'W';
				} else {
					temp = board[row+1][col];
					board[row+1][col] = before;
					before = temp;
					row += 1;
				}
				break;
			case 'W':
				//왼 진행
				if(col - 1 < y1) {
					//위쪽 변경
					dir = 'N';
				} else {
					temp = board[row][col-1];
					board[row][col-1] = before;
					before = temp;
					col -= 1;
				}
				break;
			case 'N':
				//위쪽 진행
				if(row - 1 < x1) {
					break Loop1;
				} else {
					temp = board[row-1][col];
					board[row-1][col] = before;
					before = temp;
					row -= 1;
				}
				break;
			default: break;
			}
			if(before < min) min = before;
		}
		
		return min;
	}
	
	public static void print() {
		System.out.println("--------------------------------------");
		for(int i = 0; i < board.length; i++) {
        	System.out.println(Arrays.toString(board[i]));
        }
	}
}
