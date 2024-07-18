package retry;

public class Babbling1 {

	public static void main(String[] args) {
		
		String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
		
		System.out.println(solution(babbling));
	}
	
	public static int solution(String[] babbling) {
		int answer = 0;

		for(String bab : babbling) {
			
			if(replaceWords(bab).trim().isEmpty()) {
				answer++;
			}
		}
		
		return answer;
	}
	
	static String[] canSay = {"aya", "ye", "woo", "ma"};
	
	public static String replaceWords(String word) {
		
		for(String s : canSay) {
			word = word.replace(s, " ");
		}
		
		return word;
	}
}
