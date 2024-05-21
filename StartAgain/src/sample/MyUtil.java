package sample;

public class MyUtil {

	
	//최대공약수 (재귀)
	public int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return getGCD(b, a%b);
    }
	
	//모든 약수
	public void getDivisor(int number) {
		int x;
		int y;
		for(int i = 1; i <= Math.sqrt(number); i++) {
        	y = i;
        	x = number / y;
        }
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
	public String chageNumverFormat2(long num, int format) {
		StringBuffer sbf = new StringBuffer();

        while(num >= format) {
            sbf.append(num % format);
            num /= format;
        }
        sbf.append(num);

        return sbf.reverse().toString();
	}
	
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
}
