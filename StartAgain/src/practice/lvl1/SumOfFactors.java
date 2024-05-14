package practice.lvl1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfFactors {

	//약수들의 합
	public static void main(String[] args) {
		
		System.out.println(solution(1));
	}
	
	public static int solution(int n) {
		
		int answer = 0;
		Set<Integer> set = new HashSet<Integer>();
		if(n == 1) return 1;
		for(int i = 1; i <= n/2; i++) {
			if(n % i == 0) {
				set.add(i);
				set.add(n/i);
			}
		}
		
		System.out.println(set);
		List<Integer> list = new ArrayList<Integer>(set);
		
		for(int i : list) {
			answer+= i;
		}
		return answer;
	}
}
