package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import practice.lvl2.EscapeMaze.Point;

/**
 * 거리두기 확인
 * 
 * 개발자를 희망하는 죠르디가 카카오에 면접을 보러 왔습니다.

	코로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데 개발 직군 면접인 만큼
	아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.
	
	대기실은 5개이며, 각 대기실은 5x5 크기입니다.
	거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
	단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
	
	제한사항
		places의 행 길이(대기실 개수) = 5
		places의 각 행은 하나의 대기실 구조를 나타냅니다.
		places의 열 길이(대기실 세로 길이) = 5
		places의 원소는 P,O,X로 이루어진 문자열입니다.
		places 원소의 길이(대기실 가로 길이) = 5
		P는 응시자가 앉아있는 자리를 의미합니다.
		O는 빈 테이블을 의미합니다.
		X는 파티션을 의미합니다.
		
		입력으로 주어지는 5개 대기실의 크기는 모두 5x5 입니다.
		return 값 형식
			1차원 정수 배열에 5개의 원소를 담아서 return 합니다.
			places에 담겨 있는 5개 대기실의 순서대로, 거리두기 준수 여부를 차례대로 배열에 담습니다.
			각 대기실 별로 모든 응시자가 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 담습니다.

	두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, 
	T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다. 
 * */
public class CheckDistance {

	public static void main(String[] args) {
	
		String[][] places = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
			};
		
		System.out.println(Arrays.toString(solution(places)));
	}
	
	static final char _PERSON 		= 'P';
	static final char _PARTITION 	= 'X';
	static final char _EMPTY 		= 'O';

	public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        char[][] room = null;
        for(int i = 0; i < places.length; i++) {
        	ArrayList<Point> personList = new ArrayList<Point>();
        	room = changeRoomFormat(places[i], personList);
        	print(room);
        	answer[i] = isKeepDistancing(room, personList) ? 1 : 0;
        }
        
        return answer;
    }
	
	public static boolean isKeepDistancing(char[][] room, ArrayList<Point> personList) {
		
		boolean flag = true;
		
		for(Point p : personList) {
			
			Point now			= null;
	        Queue<Point> queue 	= new LinkedList<Point>();
	        queue.add(p);
	        
	        boolean[][] visited = new boolean[room.length][room[0].length];
	        while(!queue.isEmpty()) {
	        	
	        	now = queue.poll();
	        	System.out.println(queue);
	        	System.out.println(now);
	        	if(now.distance > 2) continue;
	        	
	        	//범위 밖 확인
	        	if(now.row >= room.length || now.row < 0 || now.col >= room[0].length || now.col < 0) {
	        		continue;
	        	}
	        	//파티션 확인
	        	if(room[now.row][now.col] == _PARTITION) {
	        		continue;
	        	}
	        	
	        	//방문 확인
	        	if(visited[now.row][now.col]) continue;
	        	else {
	        		visited[now.row][now.col] = true;
	        	}
	        	
	        	//맨해튼 거리 2 이하의 사람 확인
	        	if(room[now.row][now.col] == _PERSON && now.distance > 0 && now.distance <= 2) {
	        		flag = false;
	        		break;
	        	}
	        	queue.add(new Point(now.row, now.col-1, now.distance+1));	//좌
	        	queue.add(new Point(now.row, now.col+1, now.distance+1));	//우
	        	queue.add(new Point(now.row-1, now.col, now.distance+1));	//상
	        	queue.add(new Point(now.row+1, now.col, now.distance+1));	//하
	        	
	        }
			
		}
		return flag;
	}

	
	public static char[][] changeRoomFormat(String[] place, ArrayList<Point> personList) {
		
		char[][] room = new char[place.length][place[0].length()];
		for(int i = 0; i < place.length; i++) {
			for(int j = 0; j < place[0].length(); j++) {
				room[i][j] = place[i].charAt(j);
				
				if(room[i][j] == _PERSON) {
					personList.add(new Point(i, j, 0));
				}
			}
		}
		return room;
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
	
	public static void print(char[][] room) {
		
		for(char[] c : room) {
			System.out.println(Arrays.toString(c));
		}
		
		System.out.println("----------------------------");
	}
	
}
