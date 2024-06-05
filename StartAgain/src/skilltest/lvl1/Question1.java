package skilltest.lvl1;

public class Question1 {

	
	public static void main(String[] args) {
	
		int n = 4;
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
        int answer = 0;
        
		for(int i = 1; i <= Math.sqrt(n); i++) {
        	
			if(n % i == 0) {
				answer += i;
				
				if(n / i != i) {
					answer += (n / i);
				}
			}
        }
		
        return answer;
    }
}


