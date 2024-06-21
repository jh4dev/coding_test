package practice.lvl2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 리코챗 로봇
 * 
 * 리코쳇 로봇이라는 보드게임이 있습니다.

	이 보드게임은 격자모양 게임판 위에서 말을 움직이는 게임으로, 시작 위치에서 목표 위치까지 최소 몇 번만에 도달할 수 있는지 말하는 게임입니다.
	
	이 게임에서 말의 움직임은 상, 하, 좌, 우 4방향 중 하나를 선택해서 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 한 번의 이동으로 칩니다.
	
	다음은 보드게임판을 나타낸 예시입니다.
	
	...D..R
	.D.G...
	....D.D
	D....D.
	..D....
	여기서 "."은 빈 공간을, "R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, "G"는 목표지점을 나타냅니다.
	위 예시에서는 "R" 위치에서 아래, 왼쪽, 위, 왼쪽, 아래, 오른쪽, 위 순서로 움직이면 7번 만에 "G" 위치에 멈춰 설 수 있으며, 
	이것이 최소 움직임 중 하나입니다.
	
	게임판의 상태를 나타내는 문자열 배열 board가 주어졌을 때, 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 
	return 하는 solution함수를 완성하세요. 만약 목표위치에 도달할 수 없다면 -1을 return 해주세요.
	
	제한 사항
		3 ≤ board의 길이 ≤ 100
		3 ≤ board의 원소의 길이 ≤ 100
		board의 원소의 길이는 모두 동일합니다.
		문자열은 ".", "D", "R", "G"로만 구성되어 있으며 각각 빈 공간, 장애물, 로봇의 처음 위치, 목표 지점을 나타냅니다.
		"R"과 "G"는 한 번씩 등장합니다.
 * */
public class RecochetRobot {

	public static void main(String[] args) {
		
		String[] board = {
				"...D..R", 
				".D.G...", 
				"....D.D", 
				"D....D.", 
				"..D...."
			};
		
		System.out.println(solution(board));
	}
	
	static List<Integer> answerList = new ArrayList<Integer>();
	static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	public static int solution(String[] board) {
        
        
        answerList.sort((o1, o2) -> o1 - o2);
        return answerList.get(0);
    }
	
	public Point getStopPoint(Point curPoint, int dir) {
		return null;
	}
	
	
	public class Point {
		int row;
		int col;
		int dir;
		int turnCnt;
		
		public Point(int row, int col, int dir, int turnCnt) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.turnCnt = turnCnt;
		}
		
		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", dir=" + dir + ", turnCnt=" + turnCnt + "]";
		}
		
		// equals 메소드 오버라이딩
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Point p = (Point) obj;
	        return this.row == p.row && this.col == p.col && this.dir == p.dir;
	    }

	    // hashCode 메소드도 오버라이딩 해야 합니다
	    @Override
	    public int hashCode() {
	    	return Objects.hash(row, col, dir);
	    }
	}
}
