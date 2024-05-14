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
}
