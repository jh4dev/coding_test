package last.dance.bf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeNumber {

	public static void main(String[] args) {
	
		String numbers = "17";
		Solution sol = new Solution();
		
		
		System.out.println(sol.solution(numbers));
	}
	
	static class Solution {
	    static Set<Long> primeSet = new HashSet<Long>();
	    public int solution(String numbers) {
	    	
	    	List<String> numList = new ArrayList<>(Arrays.asList(numbers.split("")));
	    	
	    	//순열
	    	backtrack("", numList, new boolean[numList.size()]);
	    	
	    	System.out.println(primeSet);
	    	return primeSet.size();
	    }
	    
	    public void backtrack(String now, List<String> list, boolean[] used) {
	    	if(!now.isEmpty() && isPrimeNumber(Long.parseLong(now))) {
	    		primeSet.add(Long.parseLong(now));
	    	} 
	    	for(int i = 0; i < list.size(); i++) {
    			if(used[i]) continue;
    			String temp = now;
    			now += list.get(i);
    			used[i] = true;
    			backtrack(now, list, used);
    			now = temp;
    			used[i] = false;
    		}
	    }
	    
	    //소수 확인
	    public boolean isPrimeNumber(long num) {
	    	 
	    	if(num <= 1) {
	    		return false;
	    	}
	    	
	    	for(int i = 2; i <= Math.sqrt(num); i++) {
	    		if(num % i == 0) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	}
}
