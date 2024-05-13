package practice.lvl1;

public class GiveMeCoke {

	public static void main(String[] args) {
		
		int a = 2;
		int b = 1;
		
		int n = 20;
		
		
		System.out.println(solution(a, b, n));
	}
	
	public static int solution(int a, int b, int n) {
		
		int answer = 0;
		int coke = 0;
		while(n > a) {
			
			coke = (n / a * b);
			n = coke + n % a;
			answer += coke;
		}
		
		return answer;
	}
}
