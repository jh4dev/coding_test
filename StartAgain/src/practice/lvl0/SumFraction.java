package practice.lvl0;

import java.util.Arrays;

//분수 더하기 
public class SumFraction {

	public static void main(String[] args) {
		
		
		System.out.println(Arrays.toString(solution(1, 5, 4, 5)));
	}
	
	public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
		

		//일단 더해버려 
		int newDenom = denom1 * denom2;
		int newSumNumer = numer1 * denom2 + numer2 * denom1;
	
		int forDiv = 2;
		
		//기약분수화 
		while(forDiv <= newDenom) {
			
			if(newDenom % forDiv == 0 && newSumNumer % forDiv == 0) {
				newDenom /= forDiv;
				newSumNumer /= forDiv;
				
			} else {
				forDiv++;
			}
		}
		
		//최대공약수로 처리하기
		int gcd = getGCD(newSumNumer, newDenom);
		
		newSumNumer /= gcd;
		newDenom /= gcd;
		
		return new int[] {newSumNumer, newDenom};
	}
	
	public static int getGCD(int a, int b) {
		if(a % b == 0) {
			return b;
		}
		return getGCD(b, a%b);
	}
}
