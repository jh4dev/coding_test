package practice.lvl2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 조이스틱
 * 
 * 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
	ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
	
	조이스틱을 각 방향으로 움직이면 아래와 같습니다.
	
	▲ - 다음 알파벳
	▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
	◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
	▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
	예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
	
	- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
	- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
	- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
	따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
	만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
	
	제한 사항
	name은 알파벳 대문자로만 이루어져 있습니다.
	name의 길이는 1 이상 20 이하입니다.
 * */
public class JoyStick_RETRY {

	public static void main(String[] args) {
		
		String name = "ZAZAAAAZAAZ";
		System.out.println(solution(name));
	}
	
	static List<Integer> answerList = new ArrayList<>();
	public static int solution(String name) {
        int answer = 0;
        //A 기준 알파벳별 스틱을 움직여야 하는 수
        Map<Character, Integer> alphabets = new HashMap<>();
        int moveCnt 	= 0;
        int dir	 		= 1; //1 up, 1 down
        
        //각 알파벳 별 조이스틱 조작 횟수 Map
        for(char c = 65; c <= 90; c++) {
        	alphabets.put(c, moveCnt);
        	if(moveCnt == 13) dir = -1;
        	moveCnt += dir;
        }

        //상,하 스틱 계산
        for(int i = 0; i < name.length(); i++) {
        	answer += alphabets.get(name.charAt(i));
        }
        
        //우측으로 쭉 진행 시, 끝나는 지점 
        int initRightLastIdx = getRightLastIdx(name);
        int initLeftLastIdx = getLeftLastIdx(name);
        //방향전환 없이 우측 진행 시, 종료되는 횟수
        answerList.add(initRightLastIdx);
        //방향전환 없이 좌측 진행 시, 종료되는 횟수 
        answerList.add(name.length() - initLeftLastIdx);
        
        //꺾는 것에 대한 체크 
        //우측 시작 
        dfs(0, name, false, 1, 0, initRightLastIdx);
        //좌측 시작
        dfs(0, name, false, -1, 0, initLeftLastIdx);
        
        
        answerList.sort((o1, o2) -> o1 - o2);
        answer += answerList.get(0);
        return answer;
        
	}
	
	public static void dfs(int now, String name, boolean isTurn, int dir, int moveCnt, int endIdx) {
		//A 를 만날때까지 진행 후,꺾는다
		
		now += dir;
 		moveCnt++;
		if(isTurn && now == endIdx) {
			answerList.add(moveCnt);
			return;
		}
		
		//맨앞 맨뒤 처리 
		if(now < 0) {
			now = name.length() -1;
		}
		if(now >= name.length()) {
			now = 0;
		}
		
		//더이상 탐색이 의미가 없음 (최대값이 정방향 진행인 name.length() - 1)
		if(moveCnt >= name.length()) {
			return;
		}
		
		if(!isTurn && name.charAt(now) == 'A') {
			int newEnd = now;
			int aCnt = 0;
			while(name.charAt(newEnd) == 'A') {
				if(newEnd + dir >= 0 && newEnd + dir < name.length() - 1) {
					newEnd += dir;
					aCnt++;
				} else {
					break;
				}
			}
			if(aCnt > 1) {
				//A가 둘 이상 연속되는 경우 꺾기 시전
				dfs(now - dir, name, true, dir * -1, moveCnt - 1, newEnd);
			}
		}
		
		dfs(now, name, isTurn, dir, moveCnt, endIdx);
	}
	
	public static int getLeftLastIdx(String remain) {
		int leftLastIdx = remain.indexOf('A');
	    if(leftLastIdx < 0 || leftLastIdx > 1) {
	    	leftLastIdx = 1;
	    } else {
	    	while(remain.charAt(leftLastIdx) == 'A' && leftLastIdx < remain.length() - 1) {
	    		leftLastIdx++;
	    	}
	    }
	    return leftLastIdx;
	}
	
	public static int getRightLastIdx(String remain) {
		int rightLastIdx = remain.lastIndexOf('A');
		if(remain.length() - 1 > rightLastIdx) {
        	rightLastIdx = remain.length() - 1;
        } else {
        	while(remain.charAt(rightLastIdx) == 'A' && rightLastIdx > 0) {
            	rightLastIdx--;
            }
        }
		return rightLastIdx;
	}
}
