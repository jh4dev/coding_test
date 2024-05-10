package practice.lvl0;

import java.util.Arrays;

public class LineOverlap {

	public static void main(String[] args) {
		
		int[][] lines = {{-10, 0}, {1, 5}, {3, 9}};
		
		System.out.println(solution(lines));
	}
	
	public static int solution(int[][] lines) {
		
		int answer = 0;
		
		int starts[] = {lines[0][0], lines[1][0], lines[2][0]};
		int ends[] = {lines[0][1], lines[1][1], lines[2][1]};
		
		Arrays.sort(starts);
		Arrays.sort(ends);
		
		int cnt = 0;
		for(int i = starts[0]; i <= ends[ends.length-1]; i++) {
			
			cnt = 0;
			
			if(lines[0][0] <= i && i+1 <= lines[0][1]) cnt++;
			if(lines[1][0] <= i && i+1 <= lines[1][1]) cnt++;
			if(lines[2][0] <= i && i+1 <= lines[2][1]) cnt++;
			
			if(cnt > 1) answer++;
		}
		
		return answer;
	}
}
