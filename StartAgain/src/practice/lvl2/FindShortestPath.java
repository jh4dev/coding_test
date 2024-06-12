package practice.lvl2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 최단 경로 찾기 > BFS
 * 
 * 제한사항
	maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
	n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
	maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
	처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
 * */
public class FindShortestPath {

	
	public static void main(String[] args) {
		int[][] maps = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}
				};
		
		System.out.println(solution(maps));
	}
	
	public static int solution(int[][] maps) {
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<int[]>();
        
        
        //동서남북
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        //시작점 셋팅
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        int[] now = null;
        int nextRow;
        int nextCol;
        while(!q.isEmpty()) {
        	
        	now = q.poll();
        	
        	if(now[0] == maps.length - 1 && now[1] == maps[0].length - 1) {
        		break;
        	}
        	
        	for(int i = 0; i < dir.length; i++) {
        		
        		nextRow = now[0] + dir[i][0];
        		nextCol = now[1] + dir[i][1];
        		
        		if(nextRow >= maps.length || nextRow < 0|| nextCol >= maps[0].length || nextCol < 0) {
        			//범위 초과
        			continue;
        			
        		} else if(visited[nextRow][nextCol] || maps[nextRow][nextCol] == 0) {
        			//기방문 위치 또는 벽
        			continue;
        		}
        		
        		q.add(new int[] {nextRow, nextCol, now[2] + 1});
        		visited[nextRow][nextCol] = true;
        	}
        }
        
        return now[2] > 1 ? now[2] : -1;
    }
}
