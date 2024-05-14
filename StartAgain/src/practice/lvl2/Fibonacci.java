package practice.lvl2;

/*
 * n번째 피보나치 수
 * 
 * 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

	예를들어
	
	F(2) == 1 F(0) + F(1) = 0 + 1 
	F(3) = F(1) + F(2) = 1 + 1 = 2
	F(4) = F(2) + F(3) = 1 + 2 = 3
	F(5) = F(3) + F(4) = 2 + 3 = 5
	와 같이 이어집니다.
	
	2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
	
	제한 사항
	n은 2 이상 100,000 이하인 자연수입니다.
	
 * */
public class Fibonacci {

	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(solution(n));
		
	}
	
	public static int solution(int n) {
        long nthNum = 0;
        
        long a = 0; // F(0)
        long b = 1; // F(1)
        
        for(int i = 2; i <= n; i++) {
        	
        	nthNum = a + b;
        	
        	a = b;
        	b = nthNum;
        }
        
        return (int) nthNum % 1234567;
    }
}
