package last.dance.bf;

import java.util.Arrays;

public class MinimumRectangle {

	public static void main(String[] args) {
		
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		
		System.out.println(new Solution().solution(sizes));
	}
	
	static class Solution {
	    public int solution(int[][] sizes) {
	        
	        int shortv 	= Integer.MIN_VALUE;
	        int longv 	= Integer.MIN_VALUE;
	        for(int[] size : sizes) {
	        	Arrays.sort(size);
	        	
	        	System.out.println(Arrays.toString(size));
	        	
	        	if(size[0] > shortv) shortv = size[0];
	        	if(size[1] > longv) longv = size[1];
	        }
	        return shortv * longv;
	    }
	}
}
