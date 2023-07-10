package lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//무인도 여
public class UnknownIsland {

	
	public static int sum = 0;
	
	public static void main(String[] args) {
	
		String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
		System.out.println(Arrays.toString(solution(maps)));
	}
	
	public static int[] solution(String[] maps) {
		
		List<Integer> answer = new ArrayList<Integer>();
		
		String[][] maps2 = new String[maps.length][maps[0].length()];
		for(int i = 0; i < maps.length; i++) {
			for(int j = 0; j < maps[0].length(); j++) {
				maps2[i][j] = Character.toString(maps[i].charAt(j));
			}
		}
		
		
		boolean[][] isVisit = new boolean[maps.length][maps[0].length()];
		
		for(int i = 0; i < maps2.length; i++) {
			for(int j = 0; j < maps2[0].length; j++) {
				
				if(!"X".equalsIgnoreCase(maps2[i][j]) && !isVisit[i][j]) {
					dfs(i, j, isVisit, maps2);
					
					answer.add(sum);
					sum = 0;
				}
				
			}
		}
		if(answer.size() == 0) {
			answer.add(-1);
		}
		Collections.sort(answer);
		return answer.stream().mapToInt(integer -> integer).toArray();
		
	}
	
	public static void dfs(int x, int y, boolean[][] isVisit, String[][] maps2) {
		
		//범위 체크
		if(x < 0 || x >= maps2.length || y < 0 || y >= maps2[0].length) {
			return;
		}
		
		if("X".equals(maps2[x][y]) || isVisit[x][y]) {
			return;
			
		}
		
		isVisit[x][y] = true;
		sum += Integer.parseInt(maps2[x][y]);
		
		//동
		dfs(x, y+1, isVisit, maps2);
		//서
		dfs(x, y-1, isVisit, maps2);
		//남
		dfs(x+1, y, isVisit, maps2);
		//북
		dfs(x-1, y, isVisit, maps2);
	}
}
