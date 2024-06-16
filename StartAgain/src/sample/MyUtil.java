package sample;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {

	
	//최대공약수 (재귀)
	public int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return getGCD(b, a%b);
    }
	
	//모든 약수
	public static List<Integer> getDivisor(int number) {
		
		List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divisors.add(i);
                if (i != number / i) {
                    divisors.add(number / i);
                }
            }
        }
        divisors.sort((o1, o2) -> o2 - o1);
        return divisors;
	}
	
	//진수 변환
	public String changeNumberFormat(long num, int format) {
		StringBuffer sbf = new StringBuffer();
		//몫이 2보다 작아질 때까지 나눈다
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
	
	//진수 변환2
	public String chageNumberFormat2(long num, int format) {
		StringBuffer sbf = new StringBuffer();

        while(num >= format) {
            sbf.append(num % format);
            num /= format;
        }
        sbf.append(num);

        return sbf.reverse().toString();
	}
	
	//진수 변환
	//Integer.toString(숫자, 진수);
	
	
	//소수 판단
	public boolean isPrimeNumber(long number) {
		
		if(number < 2) {
			return false;
		}
		for(int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * format 진수를 10진수로 변환
	 * */
	public static int toDecimal(String numStr, int format) {
		
		int result = 0;
		int pow = 0;
		for(int i = numStr.length() - 1; i >= 0; i--) {
			if(Character.getNumericValue(numStr.charAt(i)) > 0) {
				result += Character.getNumericValue(numStr.charAt(i)) * Math.pow(format, pow);
			}
			pow++;
		}
		
		return result;
	}
	
	//부분수열 체크 
	public static boolean isSubsequence(String longStr, String shortStr) {
        int originalIndex = 0;
        int subsequenceIndex = 0;

        // 원래 문자열과 부분 문자열을 모두 순회할 때까지 루프
        while (originalIndex < longStr.length() && subsequenceIndex < shortStr.length()) {
            // 현재 문자가 일치하면 부분 문자열의 다음 문자로 이동
            if (longStr.charAt(originalIndex) == shortStr.charAt(subsequenceIndex)) {
                subsequenceIndex++;
            }
            // 원래 문자열의 다음 문자로 이동
            originalIndex++;
        }

        // 부분 문자열의 모든 문자를 찾았다면 true를 반환
        return subsequenceIndex == shortStr.length();
    }
}
