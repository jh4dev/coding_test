package practice.lvl0;

public class NextNumber {

	public static void main(String[] args) {
		
		int[] common = {0, 0, 0};
		System.out.println(solution(common));
	}
	
	public static int solution(int[] common) {
		
		int answer = 0;
		
		int gap1 = 0;
		int gap2 = 0;
		
		int gap1Sum = 0;
		int gap2Sum = 0;
		
		boolean isArith = false;
		
		for(int i = 1; i < common.length; i++) {
			
			gap1 = common[i] - common[i-1];
			if(common[i-1] != 0) {
				gap2 = common[i] / common[i-1];
			} else {
				gap2 = 0;
			}
			
			
			gap1Sum += gap1;
			gap2Sum += gap2;
			
			if(i == common.length - 1) {
				if(gap1 == gap1Sum / (common.length - 1)) {
					isArith = true;
				}
				
				if(isArith) {
					answer = common[i] + gap1;
				} else {
					answer = common[i] * gap2;
				}
			}
		}
		
		
		return answer;
	}
}
