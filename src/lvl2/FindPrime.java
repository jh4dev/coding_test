package lvl2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//소수 찾기 
public class FindPrime {

	public static void main(String[] args) {
		
		String numbers = "011";
		System.out.println(solution(numbers));

	}
	
	public static int solution(String numbers) {
		
		int answer = 0;
		
		//0으로 시작하는 숫자 문자열을 제거하기 위해 Set<Integer> 로 변
		Set<Integer> numberSet = new HashSet<Integer>();
		recursive("", numbers, numberSet);
		
		List<Integer> numberList = new ArrayList<>(numberSet);
		for(Integer numStr : numberList) {
			if(isPrime(numStr)) {
				answer++;
			}
		}
		
		return answer;
	}
	
	private static void recursive(String nowStr, String remain, Set<Integer> numberSet) {
	
		if(!"".equals(nowStr)) {
			numberSet.add(Integer.parseInt(nowStr));
		}
		
		for(int i = 0; i < remain.length(); i++) {
			recursive(nowStr + remain.charAt(i), remain.substring(0, i) + remain.substring(i + 1), numberSet);
		}
	}
	
	private static boolean isPrime(int number) {
		
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
}
