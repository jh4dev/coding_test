package practice.lvl3;

import java.util.Arrays;

/**
 * 정수 삼각형
 * 
 * DP
 * 
 * */
public class TriangleDP {

	public static void main(String[] args) {
		
		int[][] triangle = {
				{7}, 				
				{3, 8}, 			
				{8, 1, 0}, 			
				{2, 7, 4, 4}, 		
				{4, 5, 2, 6, 5}		
			};
		
		System.out.println(solution(triangle));
	}
	
    public static int solution(int[][] triangle) {
    	
    	int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
    	
    	dp[0] = triangle[0];
    	
    	int nextLine = 0;
    	
    	// 0 과 마지막 인덱스는 방식 고정
    	// 나머지는 윗라인 -1, 0 중 큰 값 ++
    	for(int i = 0; i < triangle.length - 1; i++) {
    		nextLine = i + 1;
    		for(int j = 0; j < triangle[nextLine].length; j++) {
    			if(j == 0) {
    				dp[nextLine][j] = dp[i][j] + triangle[nextLine][j];
    				
    			} else if(j == triangle[nextLine].length - 1) {
    				dp[nextLine][j] = dp[i][j-1] + triangle[nextLine][j];
    				
    			} else {
    				dp[nextLine][j] = Math.max(dp[i][j-1], dp[i][j]) + triangle[nextLine][j]; 
    			}
    		}
    		
    	}
    	
    	int[] temp = dp[dp.length - 1].clone();
    	Arrays.sort(temp);
    	
    	return temp[temp.length - 1];
    }

}
