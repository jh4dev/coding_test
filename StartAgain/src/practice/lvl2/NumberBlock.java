package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * */
public class NumberBlock {

	public static void main(String[] args) {
		
		long begin = 999995000;
		
		long end = 999999999;
		
		System.out.println(Arrays.toString(solution(begin, end)));
	}
	
	public static int[] solution(long begin, long end) {
        
		int size = (int) (end - begin + 1);
		int[] answer = new int[size];

        int idx = size - 1;
        for(long i = end; i >= begin; i--) {
        	answer[idx] = getMinimumDvidable(i);
        	idx--;
        }
        
        return answer;
    }
	//소수 판단
	public static int getMinimumDvidable(long number) {
		if(number == 1) return 0;
		
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0 ) {
				if(number / i <= 10000000) {
					return (int)number / i;
				} else {
					temp.add(i);
				}
			}
		}
		
		if(temp.size() > 0) {
			temp.sort((o1, o2) -> o2 - o1);
			return temp.get(0);
		}
		
		//소수
		return 1;
	}
}
