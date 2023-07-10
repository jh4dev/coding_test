package lvl2;

//큰 수 만들기, 그리디
public class MakeBiggestNumber {

	public static void main(String[] args) {
		
		String number = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
		int k = 33;
		
//		"87654321", 3, "87654"
//		"18765432", 3, "87654"
//		"77413258", 2, "774358"
//		"12345678901234567890", 19, "9"
//		"01010", 3, "11"
//		"559913", 1, "59913"
//		"9191919", 1, "991919"

		System.out.println(solution(number, k));
	}
	
	public static String solution(String number, int k) {
        
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		
		// 앞에서 부터 (전체길이 - k) 수 중 가장 큰 수 선택
		// 선택한 수 다음 인덱스 부터 탐색 범위를 한칸씩 늘려가며 반복 탐색
		for(int i = 0; i < number.length() - k; i++) {
			char max = 0;
			for(int j = idx; j <= i + k; j++) {
				if(max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j + 1;
				}
			}
			sb.append(max);
		}
        
        return sb.toString();
	}
	
	public static String solution2(String number, int k) {
		
		
		int maxIdx = 0;
		String maxNum = "";
		
		int length = number.length();
		
		if(k == number.length()) {
			return number;
		}
		
		//1. 시작점 찾기
		for(int i= 0; i <= length -(length-k); i++) {
			maxNum = getBigger(maxNum, number.substring(length-(length-k)-i, length - i));
		}
		//주의 
		maxIdx = number.indexOf(maxNum);
		number = number.substring(maxIdx);
		
		k -= maxIdx;
		String maxVal = "";
		for(int i = 0; i < k; i++) {
			
			for(int j = 0; j < number.length(); j++) {

				maxVal = getBigger(maxVal, number.substring(0, j) + number.substring(j + 1));
			}
			
			number = maxVal;
		}
		
		return number;
	}
	
	private static String getBigger(String max, String n) {
		if(max.equals("")) {
			return n;
		}


		//자릿수는 항상 같음 
		for(int i = 0; i < max.length()-1; i++) {
			if(Integer.parseInt(max.substring(i, i+1)) == Integer.parseInt(n.substring(i, i+1))) {
				continue;
			} else if(Integer.parseInt(max.substring(i, i+1)) >= Integer.parseInt(n.substring(i, i+1))) {
				return max;
			} else {
				return n;
			}
		}
	

		return max;
	}

}
