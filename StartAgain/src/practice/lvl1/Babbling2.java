package practice.lvl1;

public class Babbling2 {

	public static void main(String[] args) {
		
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		
		System.out.println(solution(babbling));
	}
	
	public static int solution(String[] babbling) {
		
		//복잡하게 접근하였음
		//단 하나라도 중복된 문자가 포함되는 경우 발음할 수 없는 단어 
		int answer = 0;
		
		String[] canBab = {"aya", "ye", "woo", "ma"};

		for(String b : babbling) {
			
		}
		
		return answer;
	}

	public static int solution_complex(String[] babbling) {
		
		int answer = 0;
		
		String[] canBab = {"aya", "ye", "woo", "ma"};
		int babIndex = 0;
		int contCnt = 0;
		int contIdx = 0;
		
		for(String b : babbling) {
			babIndex = 0;
			
			while(babIndex < canBab.length) {
				if(b.indexOf(canBab[babIndex]) > -1) {
					//연속체크
					contCnt = 0;
					contIdx = 0;
					for(int i = 1; i <= b.length() / canBab[babIndex].length(); i++) {
						if(b.indexOf(canBab[babIndex]) == b.indexOf(canBab[babIndex].repeat(i))) {
							contCnt++;
							contIdx = i;
						}
					}
					
					if(contCnt > 1) {
						b = b.replaceFirst(
								b.substring(b.indexOf(canBab[babIndex].repeat(contIdx))
											, b.indexOf(canBab[babIndex].repeat(contIdx)) + canBab[babIndex].repeat(contIdx).length())
								, "z");
					} else {
						b = b.replaceFirst(
								b.substring(b.indexOf(canBab[babIndex])
											, b.indexOf(canBab[babIndex]) + canBab[babIndex].length())
								, " ");
					}
					
				} else {
					babIndex++;
				}
			}
			
			if(b.isBlank()) {
				answer++;
			}
		}
		
		return answer;
	}
}
