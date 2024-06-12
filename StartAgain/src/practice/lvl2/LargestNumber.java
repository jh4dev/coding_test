package practice.lvl2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 가장 큰 수
 * 
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

	예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
	
	0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
	
	제한 사항
	numbers의 길이는 1 이상 100,000 이하입니다.
	numbers의 원소는 0 이상 1,000 이하입니다.
	정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
	입출력 예
	numbers	return
	[6, 10, 2]	"6210"
	[3, 30, 34, 5, 9]	"9534330"
	
 * */
public class LargestNumber {

	public static void main(String[] args) {
		
//		System.out.println("123".substring(0, 2));
//		System.out.println("123".substring(1));
		
		int[] numbers = {0,0,0};
		System.out.println(solution(numbers));
	}
	
	public static String solution(int[] numbers) {
        
        String[] numStrArr = Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .toArray(String[]::new);
        
        Arrays.sort(numStrArr, new CustomComparator());
        
        StringBuffer sbf = new StringBuffer();
        for(String numStr : numStrArr) {
        	sbf.append(numStr);
        }
        
        return sbf.toString().charAt(0) == '0' ? "0" : sbf.toString();
    }
	
	static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
        	int i1 = Integer.parseInt(o1.split("")[0]);
        	int i2 = Integer.parseInt(o2.split("")[0]);
        	int len1 = o1.length();
        	int len2 = o2.length();
        	
        	if(len1 == len2){
        		//1. 길이가 같다면, 숫자 크기 비교
        		return o2.compareTo(o1);
        		
        	} else if(i1 != i2) {
        		//2. 가장 첫 숫자가 큰 값
        		return i2 - i1;
        		
        	} else {
        		
        		//3. 첫 숫작 같고, 길이가 다르다면, 길이가 짧은 숫자에, 길이가 긴 숫자의 길이와 동일하게 첫 숫자를 채워 비교
        		// 길이를 맞춘 후에도 동일하다면, 길이가 긴 숫자 먼저
        		if(len1 < len2) {
        			for(int i = len1; i < len2; i++) {
        				o1 += String.valueOf(i1);
        			}
        			
        		} else if(len2 < len1) {
        			for(int i = len2; i < len1; i++) {
        				o2 += String.valueOf(i2);
        			}
        		}
        		
        		if(Integer.parseInt(o1) == Integer.parseInt(o2)) {
        			// 주의
    				// o1,o2 <= 1000
        			if(Integer.parseInt(o1.split("")[1]) > i1) {
        				// 가운데 숫자가 첫 숫자보다 크면, 길이가 짧은 숫자가 우선
        				return len1 - len2;
        			} else if(Integer.parseInt(o1.split("")[1]) < i1 ) {
        				// 가운데 숫자가 첫 숫자보다 작으면, 길이가 긴 숫자가 우선
        				return len2 - len1;
        			} else {
        				return o1.compareTo(o2);
        			}
        			
    			}
        		return Integer.parseInt(o2) - Integer.parseInt(o1);
        	}
        }
    }
}
