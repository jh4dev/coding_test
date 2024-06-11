package practice.lvl2;

/**
 * 가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다. 
 * 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다. 
 * 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.

	타일을 가로로 배치 하는 경우
	타일을 세로로 배치 하는 경우
	예를들어서 n이 7인 직사각형은 다음과 같이 채울 수 있습니다.
	
	Imgur
	
	직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.
	
	제한사항
	가로의 길이 n은 60,000이하의 자연수 입니다.
	경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.
 * */
public class Tiles_DP {

	public static void main(String[] args) {
	
		int n = 600000;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
        
		//피보나치
		/*	n 칸의 마지막을 채우는 방법에는 
				n-1 까지의 경우의 수에 세로막대 1개 추가
				n-2 까지의 경우의 수에 가로막대 2개 추가
			
			따라서, f(n) = f(n-1) + f(n-2) >> 피보나치
		 * 
		 * */ 
		
		int[] dp = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
		}
		
		return dp[n];
    }
}
