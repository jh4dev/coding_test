package practice.lvl1;

import java.util.HashMap;
import java.util.Map;

//숫자와 영문숫자가 혼재된 문자열을 숫자로만 변환
public class GetNumStringNumber {

	public static void main(String[] args) {
		
		System.out.println(solution("one2three4"));
		
	}
	
	public static int solution(String s) {
	
		Map<String, Integer> engNumMap = new HashMap<String, Integer>();

		engNumMap.put("one", 1);
		engNumMap.put("two", 2);
		engNumMap.put("three", 3);
		engNumMap.put("four", 4);
		engNumMap.put("five", 5);
		engNumMap.put("six", 6);
		engNumMap.put("seven", 7);
		engNumMap.put("eight", 8);
		engNumMap.put("nine", 9);
		engNumMap.put("zero", 0);

		StringBuffer tempBuffer		= new StringBuffer();
		StringBuffer answerBuffer 	= new StringBuffer();
		for(char c : s.toCharArray()) {
			if(Character.isDigit(c)) {
				answerBuffer.append(c);
			} else {
				tempBuffer.append(c);
				
				if(engNumMap.get(tempBuffer.toString()) != null) {
					answerBuffer.append(engNumMap.get(tempBuffer.toString()));
					tempBuffer.setLength(0);
				}
			}
		}
		
		return Integer.parseInt(answerBuffer.toString());
	}
}
