package practice.lvl2;

import java.util.ArrayDeque;
import java.util.HashMap;
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
public class JoyStick_FAIL {

	public static void main(String[] args) {
		
		String name = "ZAZAAAAZAAZ";
		System.out.println(solution(name));
	}
	
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
        System.out.println(alphabets);

        //상,하 스틱 계산
        for(int i = 0; i < name.length(); i++) {
        	answer += alphabets.get(name.charAt(i));
        }
        
        //좌측 진행 시 마지막은 가장 처음 나오는 A들의 마지막 A
        //우측 진행 시 마지막은 가장 마지막에 나오는 A들의 처음 A
        int leftLastIdx, rightLastIdx;
        int leftSize, rightSize;
        String remain = name;
        while(true) {
        	
        	leftLastIdx 	= getLeftLastIdx(remain);
        	leftSize = remain.length() - leftLastIdx;
        	rightLastIdx 	= getRightLastIdx(remain);
        	
        	
        	break;
        }
        
        return answer;
    }
	
	public static int getLeftLastIdx(String remain) {
		int leftLastIdx = remain.indexOf('A');
	    if(leftLastIdx > 1) {
	    	leftLastIdx = 1;
	    } else {
	    	while(remain.charAt(leftLastIdx) == 'A') {
	    		leftLastIdx++;
	    	}
	    }
	    return leftLastIdx;
	}
	
	public static int getRightLastIdx(String remain) {
		int rightLastIdx = remain.indexOf('A');
		if(remain.length() - 1 > rightLastIdx) {
        	rightLastIdx = remain.length() - 1;
        } else {
        	while(remain.charAt(rightLastIdx) == 'A') {
            	rightLastIdx--;
            }
        }
		return rightLastIdx;
	}
}
