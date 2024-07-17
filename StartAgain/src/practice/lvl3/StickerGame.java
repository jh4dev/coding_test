package practice.lvl3;

import java.util.Arrays;

public class StickerGame {

	public static void main(String[] args) {
	
		int[] sticker = {5, 1, 16, 17, 16};
		
		System.out.println(solution(sticker));
	}
	
	public static int solution(int sticker[]) {

        //3개 이하인 경우, 최대값 원소 1개 리턴
        if(sticker.length <= 3) {
        	Arrays.sort(sticker);
        	return sticker[sticker.length-1];
        }
        
        //첫번째부터 시작 -> 마지막 못고름
        int[] dp1 = new int[sticker.length - 1];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        dp1[2] = dp1[0] + sticker[2];
        
        //두번째부터 시작 -> 마지막 고름
        int[] dp2 = new int[sticker.length - 1];
        dp2[0] = sticker[1];
        dp2[1] = sticker[2];
        dp2[2] = dp2[0] + sticker[3];
        
        int max = Math.max(dp1[2], dp2[2]);
        int bigger = 0;
        for(int i = 3; i < dp1.length; i++) {
        	dp1[i] = Math.max(dp1[i-2], dp1[i-3]) + sticker[i];
        	dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + sticker[i+1];
        	
        	bigger = Math.max(dp1[i], dp2[i]);
        	if(max < bigger) {
        		max = bigger;
        	}
        }
        
        return max;
    }
	
}
