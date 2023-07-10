package lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleSnail {

	public static void main(String[] args) {
		

		System.out.println(Arrays.toString(solution(4)));
	}
	
	public static int[] solution(int n) {
		
		int[][] triangle = new int[n][n];
		
		//아래로 이동이 첫
		int x = -1;
		int y = 0;
		
		int number = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				
				//아래이동 
				if(i % 3 == 0) {
					x++;
				}
				
				if(i % 3 == 1) {
					y++;
				}
				
				if(i % 3 == 2) {
					x--;
					y--;
				}
				triangle[x][y] = number++;
			}
		}
		
		List<Integer> answer = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(triangle[i][j] != 0) {
					answer.add(triangle[i][j]);
				}
			}
		}
		
		return answer.stream().mapToInt(i -> i).toArray();
	}
	
	public static int[] solution2(int n) {
		
		int[][] triangle = new int[n][n]; // 삼각형 모양의 2차원 배열 생성

        int maxNum = n * (n + 1) / 2; // 배열에 채워질 수의 최댓값
        int[] answer = new int[maxNum];

        int x = -1, y = 0; // 현재 위치 (x, y)
        int num = 1; // 채워질 수

        // 삼각형 내부를 시계방향으로 순서대로 채우기
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 아래로 이동
                if (i % 3 == 0)
                    x++;
                // 오른쪽으로 이동
                else if (i % 3 == 1)
                    y++;
                // 위로 이동
                else if (i % 3 == 2) {
                    x--;
                    y--;
                }

                triangle[x][y] = num++; 
            }
        }

        // 삼각형 배열을 1차원 배열로 변환
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
	}
	
}
