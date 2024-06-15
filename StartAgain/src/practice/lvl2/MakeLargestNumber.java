package practice.lvl2;

/**
 * 큰 수 만들기 또있네
 * 
 * 
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

	예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 
	이 중 가장 큰 숫자는 94 입니다.
	
	문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
	number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
	
	제한 조건
	number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
	k는 1 이상 number의 자릿수 미만인 자연수입니다.
 * */
public class MakeLargestNumber {

	public static void main(String[] args) {
		
		String number = "111222333";
		int k = 5;
		//775841
		System.out.println(solution(number, k));
	}

	public static String solution(String number, int k) {
		
        int nextMax = 9;
        int nowMaxIdx 	= 0;
        int tempIdx = 0;
        
        int numLen = number.length();
<<<<<<< Updated upstream
=======
        int initK  = k;
>>>>>>> Stashed changes
        
        StringBuffer sbf = new StringBuffer();
        Loop1:
        while(k > 0) {
        	
<<<<<<< Updated upstream
        	if(sbf.length() == numLen - k) {
=======
        	if(sbf.length() == numLen - initK) {
>>>>>>> Stashed changes
        		number = "";
        		break;
        	}
        	
        	nowMaxIdx = number.indexOf(String.valueOf(nextMax));
        	
        	if(nowMaxIdx > -1 && nowMaxIdx <= k) {
 
        		if(nextMax == 0) {
        			number = number.substring(1);
        			k--;
        			nextMax = 9;
        			continue;
        		}
        		
    			k -= nowMaxIdx;
    			tempIdx = nowMaxIdx;
    			while(true) {
    				if(!String.valueOf(number.charAt(tempIdx)).equals(String.valueOf(nextMax))) {
    					break;
    				} else if(sbf.length() == numLen - initK) {
    	        		number = "";
    	        		break Loop1;
    	        	}
    				sbf.append(number.charAt(nowMaxIdx));
    				tempIdx++;
    				if(tempIdx >= number.length()) {
    					break;
    				}
    			}
    			number = number.substring(tempIdx);
    			nextMax = 9;
        			
        	} else {
        		nextMax--;
        		
        	}
        }
        sbf.append(number);
        
        return sbf.toString();
    }
}

