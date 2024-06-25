package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyTest {

	public static void main(String[] args) {
		
		System.out.println(getGCD(3,7));
		System.out.println(getDivisors(16));
	}

	
	public static long getGCD(int a, int b) {
		
		if( a % b == 0) {
			return b;
		}
		
		return getGCD(a, a%b);
	}
	
	public static List<Integer> getDivisors(long num) {
		List<Integer> divList = null;
		Set<Integer> divSet = new HashSet<Integer>();
		
		for(int i = 1; i <= Math.sqrt(num); i++) {
			
			if(num % i == 0) {
				divSet.add(i);
				divSet.add((int)num / i);
				
//				if(num / i != i) {
//					divs.add((int)num/i);
//				}
			}
		}
		
		divList = new ArrayList<Integer>(divSet);
		divList.sort((o1, o2) -> o1 - o2);
		
		return divList;
	}
}
