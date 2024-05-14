package practice.lvl1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpsideDownNumber {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solution(1)));
	}
	
	public static int[] solution(long n) {
		
		List<Integer> tempList = new ArrayList<Integer>();

		while(true) {
			
			if(n < 10) {
				tempList.add((int)n);
				break;
			}
			
			tempList.add((int)(n % 10));
			n /= 10;
		}
		
		return tempList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
	}
}
