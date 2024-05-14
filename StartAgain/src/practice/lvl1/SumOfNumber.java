package practice.lvl1;

public class SumOfNumber {

	public static void main(String[] args) {
		
		System.out.println(solution(324));
	}
	
	public static int solution(int n) {
		
		int answer = 0;
		
		for(char c : String.valueOf(n).toCharArray()) {
			answer+= Character.getNumericValue(c);
		}
		return answer;
	}
}
