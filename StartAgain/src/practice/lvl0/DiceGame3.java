package practice.lvl0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class DiceGame3 {

	public static void main(String[] args) {
		
		System.out.println(solution(6, 4, 2, 5));
	}

	
	
	public static int solution(int a, int b, int c, int d) {
		
		int answer = 0;
		
		Map<Integer, Integer> diceMap = new HashMap<Integer, Integer>();
		
		diceMap.put(a, diceMap.get(a) == null ? 1 : (diceMap.get(a) + 1));
		diceMap.put(b, diceMap.get(b) == null ? 1 : (diceMap.get(b) + 1));
		diceMap.put(c, diceMap.get(c) == null ? 1 : (diceMap.get(c) + 1));
		diceMap.put(d, diceMap.get(d) == null ? 1 : (diceMap.get(d) + 1));
		
		int[][] diceArr = new int[diceMap.keySet().size()][2];
		int index = 0;
        for (Map.Entry<Integer, Integer> entry : diceMap.entrySet()) {
        	if(entry.getValue() > 0) {
        		diceArr[index][0] = entry.getKey();
            	diceArr[index][1] = entry.getValue();
        	}
        	index++;
        }
        
        //눈금이 많이 나온 순으로 정렬 
        Arrays.sort(diceArr, Comparator.comparingInt((int[] arr) -> arr[1]).reversed());
        
        
    	if(diceArr[0][1] == 4) {
    		answer = 1111 * diceArr[0][0];
    		
    	} else if (diceArr[0][1] == 3) {
    		answer = (int) Math.pow((10 * diceArr[0][0] + diceArr[1][0]), 2);
    		
    	} else if (diceArr[0][1] == 2 && diceArr[1][1] == 2) {
    		answer = (diceArr[0][0] + diceArr[1][0]) * Math.abs(diceArr[0][0] - diceArr[1][0]);
    		
    	} else if (diceArr.length == 3) {
    		answer = diceArr[1][0] * diceArr[2][0];
    		
    	} else if (diceArr.length == 4) {
    		answer = diceArr[0][0];
    		
    	}
        
		return answer;
	}
}
