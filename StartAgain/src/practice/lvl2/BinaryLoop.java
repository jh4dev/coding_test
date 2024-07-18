package practice.lvl2;

import java.util.Arrays;

/*
 * 이진 변환 반복하기
 * 
 * 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.

	x의 모든 0을 제거합니다.
	x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
	예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
	
	0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 
	이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * */
public class BinaryLoop {

	
	public static void main(String[] args) {
		
		String s = "111111111111111111111111111111111111";
		
		System.out.println(Arrays.toString(solution(s)));
		System.out.println(Arrays.toString(resolution(s)));
	}
	
	public static int[] solution(String s) {
        int[] answer = new int[2];
        
        StringBuffer sbf = new StringBuffer();
        
        while(!"1".equals(sbf.toString())) {
        	sbf.setLength(0);

        	// 0 제거
        	for(char c : s.toCharArray()) {
        		if(c == '0') {
        			answer[1]++;
        		} else {
        			sbf.append(c);
        		}
        	}
        	System.out.println(sbf.toString().length());
        	s = changeNumberFormat(sbf.toString().length(), 2);
        	answer[0]++;
        }
        
        return answer;
    }
	
	public static String changeNumberFormat(long num, int format) {
		StringBuffer sbf = new StringBuffer();
		//몫이 format 보다 작아질 때까지 나눈다
		//나머지 칸 0 처리
		while(true) {
			
			sbf.insert(0, (num%format));
			if(num / format == 1) {
				sbf.insert(0, 1);
				num = 0;
			} else {
				num /= format;
			}
			
			if(num == 0) break;
		}
		return sbf.toString();
	}

	public static int[] resolution(String s) {
		
		int zeroCnt = 0;
		int changeCnt = 0;
		
		//1. 0 제거
		//2. 제거된 문자열의 길이를 2진법으로 변환 
		String temp = s;
		while(!temp.equals("1")) {
			
			while(temp.indexOf("0") >= 0) {
				temp = temp.replaceFirst("0", "");
				zeroCnt++;
			}
			
			temp = changeNumberFormat(temp.length(), 2);
			changeCnt++;
		}
		return new int[]{changeCnt, zeroCnt};
	}
}
