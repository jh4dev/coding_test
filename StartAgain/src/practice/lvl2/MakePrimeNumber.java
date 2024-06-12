package practice.lvl2;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

	각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
	종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
	
	제한사항
	numbers는 길이 1 이상 7 이하인 문자열입니다.
	numbers는 0~9까지 숫자만으로 이루어져 있습니다.
	"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
	
	11과 011은 같은 숫자로 취급합니다.
 * */
public class MakePrimeNumber {

	static Set<Long> primeSet = new HashSet<Long>();
	
	public static void main(String[] args) {
		
		String numbers = "1301345";
		
		System.out.println(solution(numbers));
	}
	
	public static int solution(String numbers) {
        String[] numArr = numbers.split("");
        
        boolean[] visited = new boolean[numArr.length];
    	dfs(visited, numArr, "");
        
        System.out.println(primeSet);
        return primeSet.size();
    }
	
	public static void dfs(boolean[] visited, String[] numArr, String now) {
		
		if(now.length() > 0 && isPrimeNumber(Long.parseLong(now))) {
			primeSet.add(Long.parseLong(now));
		}
		
		for(int i = 0; i < numArr.length; i++) {
			if(!visited[i]) {
				now += numArr[i];
				visited[i] = true;
				dfs(visited, numArr, now);
				/*호출 후 원상복구*/
				visited[i] = false;
				now = now.substring(0, now.length()-1);
			}
		}
	}
	
	//소수 판단
	public static boolean isPrimeNumber(long number) {
		
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
