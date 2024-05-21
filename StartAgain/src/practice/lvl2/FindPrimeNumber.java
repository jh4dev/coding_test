package practice.lvl2;

/*
 * 소수 찾기
 * 
 * 양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.

0P0처럼 소수 양쪽에 0이 있는 경우
P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
P처럼 소수 양쪽에 아무것도 없는 경우
단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.

예를 들어, 101은 P가 될 수 없습니다.

예를 들어, 437674을 3진수로 바꾸면 211020101011입니다. 
여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다. 
(211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.) 
211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.

정수 n과 k가 매개변수로 주어집니다. 
n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.
 * */
public class FindPrimeNumber {

	
	public static void main(String[] args) {
		
		int n = 999999;
		int k = 3;
		
		System.out.println(solution(n, k));
	}
	
	public static int solution(int n, int k) {
        int answer = 0;
        
        String nStr = changeNumberFormat(n, k);
        
        // 0이 없는 경우 (P처럼 소수 양쪽에 아무것도 없는 경우)
        if(nStr.indexOf("0") < 0) {
        	if(isPrimeNumber(Long.parseLong(nStr))) {
        		return 1;
        	} else {
        		return 0;
        	}
        }
        
        StringBuffer sbf = new StringBuffer();
        for(int i = 0; i < nStr.length(); i++) {
        	/*
        	 * 0P0처럼 소수 양쪽에 0이 있는 경우
				P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
				0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
        	 * */
        	if(nStr.charAt(i) == '0') {
        		if(sbf.length() > 0 && isPrimeNumber(Long.parseLong(sbf.toString()))) {
            		answer++;
            	}
        		sbf.setLength(0);
        		
        	} else if(i == nStr.length() - 1) {
        		sbf.append(nStr.charAt(i));
        		if(sbf.length() > 0 && isPrimeNumber(Long.parseLong(sbf.toString()))) {
            		answer++;
            	}
        	} else {
        		sbf.append(nStr.charAt(i));
        	}
        }
        
        return answer;
    }
	
	public static String changeNumberFormat(long num, int format) {
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
	
	/*
	 * 소수 확인
	 * */
	public static boolean isPrimeNumber(long number) {
        if (number <= 1) {
            return false; // 1 이하는 소수가 아님
        }
        if (number == 2) {
            return true; // 2는 소수
        }
        if (number % 2 == 0) {
            return false; // 짝수는 소수가 아님
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false; // 나누어 떨어지면 소수가 아님
            }
        }
        return true; // 나누어 떨어지지 않으면 소수
    }
}
