package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 삼각 달팽이
 * 
 * 정수 n이 매개변수로 주어집니다. 
 * 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 
 * 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 * */
public class TriangleSnailArray {

	public static void main(String[] args) {
	
		int n = 1;
		System.out.println(Arrays.toString(solution(n)));
	}
	
	public static int[] solution(int n) {
        
        //아래, 오른쪽, 위
        int[][] dirArr = {{1, 0}, {0, 1}, {-1, -1}};
        
        int[][] triangle = new int[n][n];
        /*
         * dir 진행 방향
         * 0 : 아래
         * 1 : 오른쪽
         * 2 : 위
         * */
        int dir = 0;
        
        //채울 숫자
        int fillNum = 1;
        //진행 방향 기준 숫자를 채운 카운트
        int fillCnt = 1;
        //진행 방향 기준 채워야 하는 길이
        int len = n;
        int row = 0, col = 0;
        triangle[row][col] = 1;
        
        if(n > 1) {
	        while(len > 0) {
	        	fillNum++;
	        	row = row + dirArr[dir][0];
	        	col = col + dirArr[dir][1];
	        	
	        	triangle[row][col] = fillNum;
	        	fillCnt++;
	        	
	        	if(fillCnt >= len) {
	        		fillCnt = 0;
	        		len--;
	        		
	        		if(dir == 0) dir = 1;
	        		else if(dir == 1) dir = 2;
	        		else if(dir == 2) dir = 0;
	        	}
	        }
        }

        return Arrays.stream(triangle)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value != 0)
                .toArray();
    }
}
