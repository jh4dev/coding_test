package practice.lvl1;

import java.util.Arrays;

public class SecretMap {

	public static void main(String[] args) {
	
//		System.out.println(numberToBinaryString(9, 5));
		
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		
		System.out.println(Arrays.toString(solution(6, arr1, arr2)));
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        String arr1Str = "";
        String arr2Str = "";

        StringBuffer sbf = new StringBuffer();
        
        for(int i = 0; i < arr1.length; i++) {
        
        	sbf.setLength(0);
        	
        	arr1Str = numberToBinaryString(arr1[i], n);
        	System.out.println(arr1Str);
        	arr2Str = numberToBinaryString(arr2[i], n);
        	System.out.println(arr2Str);

        	for(int j = 0; j < n; j++) {
        		
        		if(arr1Str.charAt(j) == '1' || arr2Str.charAt(j) == '1' ) {
        			sbf.append("#");
        		} else {
        			sbf.append(" ");
        		}
        	}
        	answer[i] = sbf.toString();
        }
        
        return answer;
    }
	
	public static String numberToBinaryString(int num, int size) {
		StringBuffer sbf = new StringBuffer();
		//몫이 2보다 작아질 때까지 나눈다
		//나머지 칸 0 처리
		while(sbf.length() < size) {
			
			sbf.insert(0, (num%2));
			if(num / 2 == 1) {
				sbf.insert(0, 1);
				num = 0;
			} else {
				num /= 2;
			}
		}
		return sbf.toString();
	}
}
