package practice.lvl2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/*
 * 방문 길이
 * 
 * 게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.

	U: 위쪽으로 한 칸 가기
	
	D: 아래쪽으로 한 칸 가기
	
	R: 오른쪽으로 한 칸 가기
	
	L: 왼쪽으로 한 칸 가기
	
	캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
	
	방문길이1_qpp9l3.png
	
	예를 들어, "ULURRDLLU"로 명령했다면
	
	방문길이2_lezmdo.png
	
	1번 명령어부터 7번 명령어까지 다음과 같이 움직입니다.
	방문길이3_sootjd.png
	
	8번 명령어부터 9번 명령어까지 다음과 같이 움직입니다.
	방문길이4_hlpiej.png
	
	이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다. 예를 들어 위의 예시에서 게임 캐릭터가 움직인 길이는 9이지만, 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다. (8, 9번 명령어에서 움직인 길은 2, 3번 명령어에서 이미 거쳐 간 길입니다)
	
	단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.
 * */
public class VisitLength {

	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		System.out.println(solution(dirs));
		
	}
	
	public static int solution(String dirs) {
        //U D R L
        Map<String, int[]> moveMap = new HashMap<String, int[]>();
        moveMap.put("U", new int[] {1, 0});
        moveMap.put("D", new int[] {-1, 0});
        moveMap.put("R", new int[] {0, 1});
        moveMap.put("L", new int[] {0, -1});
        
        Set<MovePath> visitSet = new HashSet<MovePath>();
        
        int[] now 		= {0, 0};
        int targetX, targetY = 0;
        for(String d : dirs.split("")) {
        	System.out.println(Arrays.toString(now));
        	targetX = now[0] + moveMap.get(d)[0];
        	targetY = now[1] + moveMap.get(d)[1];
        	
        	//범위 밖 무시
        	if(targetX < -5 || targetX > 5 || targetY < -5 || targetY > 5) continue;
        	
        	MovePath mp = new MovePath(now[0], now[1], targetX, targetY);
        	if(!visitSet.contains(mp)) {
        		visitSet.add(mp);
        	}
        	now[0] = targetX;
        	now[1] = targetY;
        }
        
        return visitSet.size();
    }
	
	public static class MovePath {
		
		int startX, startY;
		int targetX, targetY;
		
		public MovePath(int sx, int sy, int tx, int ty) {
			startX = sx;
			startY = sy;
			targetX = tx;
			targetY = ty;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        MovePath point = (MovePath) o;
	        return (startX == point.startX && startY == point.startY && targetX == point.targetX && targetY == point.targetY) ||
	               (startX == point.targetX && startY == point.targetY && targetX == point.startX && targetY == point.startY);
	    }

	    @Override
	    public int hashCode() {
	        // 두 경우에 대해 동일한 해시 코드를 반환하도록 설계
	        int hash1 = Objects.hash(startX, startY, targetX, targetY);
	        int hash2 = Objects.hash(targetX, targetY, startX, startY);
	        return hash1 ^ hash2; // 두 해시 값을 XOR 연산
	    }
		@Override
		public String toString() {
			return "MovePath [startX=" + startX + ", startY=" + startY + ", targetX=" + targetX + ", targetY=" + targetY
					+ "]";
		}
		
	}
}
