package last.dance.bf;

import java.util.HashMap;
import java.util.Map;

public class DicMap {

	public static void main(String[] args) {
		
		String word = "AAAAA";
		
		System.out.println(new Solution().solution(word));
	}
	
	static class Solution {
	    int cnt = 1;
		String findWord;
		public int solution(String word) {
			findWord = word;
			
			Map<String, Integer> dicMap = new HashMap<String, Integer>();
			String[] arr = {"A", "E", "I", "O", "U"};
			
			for(int i = 0; i < arr.length; i++) {
				dfs(arr, 1, arr[i], dicMap);
			}
			
			return dicMap.get(word);
		}
		
		public void dfs(String[] arr, int depth, String now, Map<String, Integer> dicMap) {
			
			if(depth > 5) {
				return;
			}
			if(dicMap.get(now) == null) {
				dicMap.put(now, cnt++);
				
				if(now.equals(findWord)) return;
			}
			
			for(int i = 0; i < arr.length; i++) {
				dfs(arr, depth + 1, now + arr[i], dicMap);
			}
		}
	}
}
