package practice.lvl1;

import java.util.Arrays;

public class BestWorstLotto {

	
	public static void main(String[] args) {
		
		int[] lottos	= {1,2,3,0,5,6};
		int[] win_nums	= {1,2,3,4,5,7};
		
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
	}
	
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        
        // lottes 고른 번호
        // win_nums 당첨 번호
        // return {최고, 최저}
		
		int unknCnt = 0;
		int correct = 0;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        for(int i = 0; i < lottos.length; i++) {
        	if(lottos[i] == 0) {
        		unknCnt++;
        	} else {
        		
        		for(int j = 0; j < win_nums.length; j++) {
        			if(lottos[i] == win_nums[j]) {
        				correct++;
        				break;
        			}
        		}
        	}
        }
        
        int best 	= 7 - (correct + unknCnt) >= 6 ? 6 : 7 - (correct + unknCnt);
        int worst 	= 7 - (correct) >= 6 ? 6 : 7 - (correct);
        
        return new int[] {best, worst};
    }
}
