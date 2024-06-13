package practice.lvl2;

import java.util.Arrays;

import sample.MyUtil;

/**
 * 124 나라
 * 
 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

	124 나라에는 자연수만 존재합니다.
	124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
	예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
	
	10진법	124 나라	10진법	124 나라
	1		1		6		14
	2		2		7		21
	3		4		8		22
	4		11		9		24
	5		12		10		41
	자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 * */
public class OneTwoFour {

	public static void main(String[] args) {
		
		int n = 6716;
		System.out.println(solution(n));
		System.out.println(solution2(n));
	}
	
	public static String solution2(int n) {
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            int num = n%3;
            if (num == 0) {
                answer.insert(0, "4"); 
                n = n/3 - 1;
            }
            else {
                answer.insert(0, Integer.toString(num));
                n = n/3;
            }

        }

        return answer.toString();
    }
	public static String solution(int n) {
        
        //3진법 변환 후, 뒤에서부터 0 -> 4 로 변환하며, 바로 앞자리 수 -1 반복
        String temp = changeNumberFormat(n, 3);
        StringBuffer sbf = new StringBuffer();
        
        String[] tempArr = temp.split("");
        int	 iNum;
        for(int i = tempArr.length - 1; i>= 0; i--) {
        	iNum = Integer.parseInt(tempArr[i]);
        	if(iNum <= 0 && i > 0) {
        		if(iNum == 0) sbf.insert(0, 4);
        		else {
        			sbf.insert(0, 3 + iNum);
        		}
        		tempArr[i-1] = String.valueOf(Integer.parseInt(tempArr[i-1]) -1);
        		
        	} else {
        		sbf.insert(0, iNum);
        	}
        	
        	System.out.println(Arrays.toString(tempArr));
        	System.out.println(sbf.toString());
        }
        if(sbf.toString().charAt(0) == '0') {
        	return sbf.substring(1);
        }
        
        return sbf.toString();
    }
	
	public static String changeNumberFormat(long num, int format) {
		StringBuffer sbf = new StringBuffer();

        while(num >= format) {
            sbf.append(num % format);
            num /= format;
        }
        sbf.append(num);

        return sbf.reverse().toString();
	}
}
