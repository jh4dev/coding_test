package practice.lvl2;

import java.util.Arrays;

/**
 * 
 * 양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.

x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
예를 들어,

	f(2) = 3 입니다. 다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
	수	비트	다른 비트의 개수
	2	000...0010	
	3	000...0011	1
	f(7) = 11 입니다. 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.
	수	비트	다른 비트의 개수
	7	000...0111	
	8	000...1000	4
	9	000...1001	3
	10	000...1010	3
	11	000...1011	2
	정수들이 담긴 배열 numbers가 매개변수로 주어집니다.
	numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.
	
 * */
public class FindMinValue {

	public static void main(String[] args) {
		
		long[] numbers = {Long.parseLong("372036854775807")};
		
		System.out.println(Arrays.toString(solution(numbers)));
	}
	
	public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        String bitStr = "";
        String target = "";
        int maxIdx;
        StringBuffer sbf = new StringBuffer();
        
        for(int i = 0; i < numbers.length; i++) {
        	bitStr = chageNumberFormat(numbers[i], 2);
        	System.out.println(bitStr);
        	bitStr = "0" + bitStr;
        	
        	maxIdx = getMaxIndex(bitStr.lastIndexOf("00"), bitStr.lastIndexOf("10"), bitStr.lastIndexOf("01"));
        	target = bitStr.substring(maxIdx, maxIdx + 2);
        	
        	System.out.println(bitStr);
        	System.out.println(bitStr.lastIndexOf("00"));
        	System.out.println(bitStr.lastIndexOf("10"));
        	System.out.println(bitStr.lastIndexOf("01"));
        	System.out.println(maxIdx);
        	System.out.println(bitStr.indexOf(maxIdx));
        	System.out.println(target);
        	
        	switch(target) {
        	case "00":
        		target = "01";
        		break;
        	case "10":
        		target = "11";
        		break;
        	case "01":
        		target = "10";
        		break;
        	default: 
        		break;
        	}
        	sbf.setLength(0);
        	System.out.println(bitStr.substring(0, (int) maxIdx));
        	System.out.println(target);
        	System.out.println(bitStr.substring(maxIdx+2));
        	sbf.append(bitStr.substring(0, (int) maxIdx));
        	sbf.append(target);
        	sbf.append(bitStr.substring(maxIdx+2));
        	
        	
        	answer[i] = toDecimal(sbf.toString(), 2);
        }
        
        return answer;
    }
	
	public static int getMaxIndex(int...idxs) {
		
		int max = 0;
		
		for(int i : idxs) {
			if(i > max && i > -1) {
				max = i;
			}
		}
		return max;
	}
	
	public static String chageNumberFormat(long num, int format) {
		StringBuffer sbf = new StringBuffer();

        while(num >= format) {
            sbf.append(num % format);
            num /= format;
        }
        sbf.append(num);

        return sbf.reverse().toString();
	}
	
	public static long toDecimal(String numStr, int format) {
		
		long result = 0;
		int pow = 0;
		for(int i = numStr.length() - 1; i >= 0; i--) {
			if(Character.getNumericValue(numStr.charAt(i)) > 0) {
				result += Character.getNumericValue(numStr.charAt(i)) * Math.pow(format, pow);
			}
			pow++;
		}
		
		return result;
	}
}
