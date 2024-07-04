package practice.lvl2;

import java.util.ArrayList;
import java.util.List;

/**
 * 석유 시추
 * 
 * 접근
 * 1. 컬럼 기준으로 시추량이 정해짐
 * 2. [최소컬럼, 최대컬럼, 매장량] 형태의 List<int[]> DFS 탐색
 * 3. 컬럼별 최대 매장량 확인
 * */
public class OilDrilling {
	
	public static void main(String[] args) {
		int[][] land = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
		
		System.out.println(solution(land));
	}

	static List<int[]> oilList = new ArrayList<>();
	static boolean[][] visited;
	static int minCol, maxCol, value;
	
	public static int solution(int[][] land) {
        
        visited = new boolean[land.length][land[0].length];
        for(int i = 0; i < land.length; i++) {
        	for(int j = 0; j < land[i].length; j++) {
        		
        		if(land[i][j] == 1 && !visited[i][j]) {
        			minCol = j;
        			maxCol = j;
        			value = 0;
        			
        			dfs(i, j, land);
        			
        			if(value > 0) {
        				oilList.add(new int[] {minCol, maxCol, value});
        			}
        			
        		}
        	}
        }
        //column 최소 인덱스 오름차순 정렬
        oilList.sort((o1, o2) -> {
        	int compare = o1[0] - o2[0];
        	if(compare == 0) {
        		return o1[1] - o2[0];
        	}
        	return compare;
        });
        
        int max = 0;
        int sum = 0;
        for(int i = 0; i < land[0].length; i++) {
        	
        	sum = 0;
        	for(int[] oil : oilList) {
        		if(i < oil[0]) {
        			break;
        		}
        		
        		if(i >= oil[0] && i <= oil[1]) {
        			sum += oil[2]; 
        		}
        		
        	}
        	
        	if(sum > max) {
        		max = sum;
        	}
        }
        
        return max;
    }
	
	public static void dfs(int row, int col, int[][] land) {
		
		//기방문 or 범위밖
		if(row < 0 || row >= land.length || col < 0 || col >= land[0].length || visited[row][col]) {
			return;
		}
		visited[row][col] = true;
		
		if(land[row][col] == 1) {
			value++;
			if(col < minCol) minCol = col;
			if(col > maxCol) maxCol = col;
			//상 하 좌 우
			dfs(row - 1, col, land);
			dfs(row + 1, col, land);
			dfs(row, col - 1, land);
			dfs(row, col + 1, land);
		}
	}
}
