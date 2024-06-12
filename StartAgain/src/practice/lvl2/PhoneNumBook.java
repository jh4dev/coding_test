package practice.lvl2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
	전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
	
	구조대 : 119
	박준영 : 97 674 223
	지영석 : 11 9552 4421
	전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
	
	제한 사항
	phone_book의 길이는 1 이상 1,000,000 이하입니다.
	각 전화번호의 길이는 1 이상 20 이하입니다.
	같은 전화번호가 중복해서 들어있지 않습니다.
 * */
public class PhoneNumBook {
	
	public static void main(String[] args) {
		
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //길이 순으로 정렬
        Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
        
        Map<String, Integer> pMap = new HashMap<String, Integer>();
        for(int i = 0; i < phone_book.length; i++) {
        	
        	for(int j = 0; j < phone_book[i].length(); j++) {
        		if(pMap.get(phone_book[i].substring(0, j+1)) != null) {
        			System.out.println(phone_book[i].substring(0, j+1));
        			return false;
        		}
        	}
        	
        	pMap.put(phone_book[i], 1);
        }
        
        return answer;
    }

}
