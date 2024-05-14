package practice.lvl1;

import java.util.Arrays;

/*
 * 지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다. 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.

	["방향 거리", "방향 거리" … ]
	예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
	
	주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
	주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
	위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
	공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.

	공원을 나타내는 문자열 배열 park, 
	로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때, 
	로봇 강아지가 모든 명령을 수행 후 놓인 위치를 
	[세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * */
public class WalkPark {

	public static void main(String[] args) {
		
		String[] park = {"OOOSOOOOO", "OOOOOOOOO", "OOOOOOOOO"};
		String[] routes = {"E 3", "W 3"};
		
//		System.out.println(getColString(park, 0, 0 + 1, 2 + 1));
		
		System.out.println(Arrays.toString(solution(park, routes)));
	}
	
	public static int[] solution(String[] park, String[] routes) {
        //동,서,남,북
//        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        /* caution 
         * 장애물 또는 공원 밖으로 나가는 경우, 해당 요소 자체를 무시
         * */
        int[] nowPos = null;
        //시작점 찾기
        loop1:
        for(int i = 0; i < park.length; i++) {
        	for(int j = 0; j < park[0].length(); j++) {
        		
        		if(park[i].charAt(j) == 'S') {
        			nowPos = new int[] {i, j};
        			break loop1;
        		}
        	}
        }
        
        final int	_MIN		= 0;						//가로,세로 최소
        final int 	_COL_MAX 	= park[0].length() - 1;		//가로 최대
        final int	_ROW_MAX	= park.length - 1;			//세로 최대
        
        String 	dir 	= "";
        int 	move 	= 0;
        for(int i = 0; i < routes.length; i++) {
        	
        	dir = routes[i].split(" ")[0];
        	move = Integer.parseInt(routes[i].split(" ")[1]);
        	
        	switch (dir) {
    		case "E":
    			if((nowPos[1] + move) > _COL_MAX 
    				|| park[nowPos[0]].substring(nowPos[1] + 1, nowPos[1] + move + 1).contains("X")) {
    				continue;
    			} else {
    				nowPos[1] += move;
    			}
    			break;
    			
    		case "W":
    			if((nowPos[1] - move) < _MIN 
    				|| park[nowPos[0]].substring(nowPos[1] - move, nowPos[1]).contains("X")) {
    				continue;
    			} else {
    				nowPos[1] -= move;
    			}
    			break;
    			
    		case "S":
    			if((nowPos[0] + move) > _ROW_MAX
    				|| getColString(park, nowPos[1], nowPos[0] + 1, nowPos[0] + move + 1).contains("X")) {
    				continue;
    			} else {
    				nowPos[0] += move;
    			}
    			break;
    			
    		case "N":
    			if((nowPos[0] - move) < _MIN
    				|| getColString(park, nowPos[1], nowPos[0] - move, nowPos[0]).contains("X")) {
    				continue;
    			} else {
    				nowPos[0] -= move;
    			}
    			break;

    		default:
    			break;
    		}
        	
        }
        
        return nowPos;
    }
	
	public static String getColString(String[] park, int col, int rowStart, int rowEnd) {
		String result = "";
		
		for(int i = rowStart; i < rowEnd; i++) {
			result+= park[i].charAt(col);
		}
		
		return result;
	}
}
