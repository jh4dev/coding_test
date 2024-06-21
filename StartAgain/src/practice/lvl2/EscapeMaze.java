package practice.lvl2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로 탈출
 * 
 * 1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 
 * 각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 
 * 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다.
 * 따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 
 * 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 
 * 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.

	미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요. 만약, 탈출할 수 없다면 -1을 return 해주세요.
	
	제한사항
		5 ≤ maps의 길이 ≤ 100
		5 ≤ maps[i]의 길이 ≤ 100
		maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
		S : 시작 지점
		E : 출구
		L : 레버
		O : 통로
		X : 벽
		시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
		출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.
 * */
public class EscapeMaze {

	public static void main(String[] args) {
		
		String[] maps = {"SOOXL","XXXXX","OOOOO","OXXXX","OOOOE"};
		
		System.out.println(solution(maps));
	}
	
	static char _START 	= 'S';	//시작지점
	static char _EXIT 	= 'E';	//출구
	static char _LEVER 	= 'L';	//레버
	static char _PATH 	= 'O';	//통로
	static char _WALL 	= 'X';	//벽
	
	static char[][] maze;
	
	public static int solution(String[] maps) {
        int answer = 0;

        maze = new char[maps.length][maps[0].length()];
        
        int[] startPoint 	= null;
        int[] exitPoint 	= null;
        int[] leverPoint 	= null;
        
        for(int i = 0; i < maze.length; i++) {
        	for(int j = 0; j < maze[i].length; j++) {
        		maze[i][j] = maps[i].charAt(j);
        		if(maze[i][j] == _START) {
        			startPoint = new int[] {i,j};
        		}
        		if(maze[i][j] == _EXIT) {
        			exitPoint = new int[] {i,j};
        		}
        		if(maze[i][j] == _LEVER) {
        			leverPoint = new int[] {i,j};
        		}
        	}
        }
        
        Point now			= null;
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(startPoint[0], startPoint[1], 0));
        
        boolean leverFlag = false;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        while(!queue.isEmpty()) {
        	now = queue.poll();

        	//1. Start to Lever 최단경로 확인
        	if(now.row == leverPoint[0] && now.col == leverPoint[1] && !leverFlag) {
        		//레버까지의 거리 확인 완료
        		//lever 시작점으로 설정하고 방문기록 초기화 후 반복
        		queue.clear();
        		queue.add(now);
        		leverFlag = true;
        		visited = new boolean[maze.length][maze[0].length];
        		continue;
        	}
        	
        	//2. Lever to Exit 최단경로 확인
        	if(now.row == exitPoint[0] && now.col == exitPoint[1] && leverFlag) {
        		answer = now.distance;
        		break;
        	}
        	
        	//범위 밖 확인
        	if(now.row >= maze.length || now.row < 0 || now.col >= maze[0].length || now.col < 0) {
        		continue;
        	}
        	
        	//벽 확인
        	if(maze[now.row][now.col] == _WALL) {
        		continue;
        	}
        	
        	if(visited[now.row][now.col]) continue;
        	else {
        		visited[now.row][now.col] = true;
        	}
        	
        	queue.add(new Point(now.row+1, now.col, now.distance+1));
        	queue.add(new Point(now.row-1, now.col, now.distance+1));
        	queue.add(new Point(now.row, now.col+1, now.distance+1));
        	queue.add(new Point(now.row, now.col-1, now.distance+1));
        	
        }
        
        return answer == 0 ? -1 : answer;
    }
	
	public static class Point {
		int row;
		int col;
		int distance;

		public Point(int row, int col, int distance) {
			this.row = row;
			this.col = col;
			this.distance = distance;
		}
		
		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", distance=" + distance + "]";
		}
	}
	
	public static void print() {

		for(char[] arr : maze) {
			System.out.println(Arrays.toString(arr));
		}
	}
}
