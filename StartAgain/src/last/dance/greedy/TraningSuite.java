package last.dance.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraningSuite {

	public static void main(String[] args) {
	
		int n = 4;
		
		int[] lost = {1,3};
		int[] reserve = {3,4};
		
		System.out.println(new Solution().solution(n, lost, reserve));
	}
	
	static class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	    	
	    	Map<Integer, Integer> rMap = new HashMap<>();
	    	List<Integer> lostList = new ArrayList<>();
	    	
	    	Arrays.sort(lost);
	    	Arrays.sort(reserve);
	    	
	    	for(int r : reserve) {
	    		rMap.put(r, 1);
	    	}
	    	
	    	for(int l : lost) {
	    		if(rMap.get(l) != null && rMap.get(l) == 1) {
	    			//여분을 가져왔으나 도난당해 빌려줄 수 없음
	    			rMap.remove(l);
	    		} else {
	    			lostList.add(l);
	    		}
	    	}

	    	int borrowCnt = 0;
	    	for(int i = 0; i < lostList.size(); i++) {
	    		if(rMap.get(lostList.get(i)-1) != null) {
	    			//앞사람이 빌려줌
	    			rMap.remove(lostList.get(i)-1);
	    			borrowCnt++;
	    		} else if(rMap.get(lostList.get(i)+1) != null) {
	    			//뒷사람이 빌려줌
	    			rMap.remove(lostList.get(i)+1);
	    			borrowCnt++;
	    		} else {
	    			//못빌려~
	    		}
	    	}
	    	
	    	return n - lostList.size() + borrowCnt; 
	    }
	}
}
