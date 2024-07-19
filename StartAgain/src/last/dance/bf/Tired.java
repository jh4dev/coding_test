package last.dance.bf;

public class Tired {

	public static void main(String[] args) {
		
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		
		System.out.println(new Solution().solution(k, dungeons));
	}
	
	static class Solution {
		
		int maxClear = 0;
		
		public int solution(int k, int[][] dungeons) {
			
			backtrack(dungeons, k, 0, new boolean[dungeons.length]);
			
			return maxClear;
		}
		
		public void backtrack(int[][] dungeons, int td, int clearCnt, boolean[] cleared) {

			if(maxClear < clearCnt) {
				maxClear = clearCnt;
			}
			
			for(int i = 0; i < dungeons.length; i++) {
				if(cleared[i]) continue;
				
				if(td >= dungeons[i][0] && td - dungeons[i][1] >= 0) {
					
					td -= dungeons[i][1];
					clearCnt += 1;
					cleared[i] = true;
					
					backtrack(dungeons, td, clearCnt, cleared);
					
					td += dungeons[i][1];
					clearCnt -= 1;
					cleared[i] = false;
					
				} else {
					if(maxClear < clearCnt) {
						maxClear = clearCnt;
					}
				}
			}
		}
	}
}
