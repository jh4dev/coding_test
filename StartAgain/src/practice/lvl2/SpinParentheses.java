package practice.lvl2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/*
 * 괄호 회전하기
 * 
 * 문제 설명
	다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
	
	(), [], {} 는 모두 올바른 괄호 문자열입니다.
	만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 
	예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
	만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 
	예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
	대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 
	이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 
	s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
	
	제한사항
	s의 길이는 1 이상 1,000 이하입니다.

 * */
public class SpinParentheses {

	public static void main(String[] args) {
		
		String s = "{{}";
		System.out.println(solution(s));
		
	}
	
	public static int solution(String s) {
        int answer = 0;
        
        char[] open = {'(', '{', '['};
        char[] close = {')', '}', ']'};
        
        //Arrays.binarySerach() 사용을 위한 정렬
        Arrays.sort(open);
        Arrays.sort(close);
        
        //문자열 회전시킬 덱
        Deque<Character> strDq = new ArrayDeque<Character>();
        for(char c : s.toCharArray()) {
        	strDq.add(c);
        }
        
        //체크용 스택
        Stack<Character> rmStack 	= new Stack<Character>();
        Stack<Integer> 	idxStack 	= new Stack<Integer>();
        
        int loopCnt 	= 0;
        int openIdx 	= -1;
        int closeIdx 	= -1;
        
        char nowPop;
        Deque<Character> tempDq = new ArrayDeque<Character>(strDq);
        
        boolean isSpin = false;
        
        while(loopCnt < s.length()) {
        	
        	//회전 여부 체크
        	if(isSpin) {
        		loopCnt++;
        		if(loopCnt == s.length()) break;
        		strDq.add(strDq.pop());
    			rmStack.clear();
    			tempDq = new ArrayDeque<Character>(strDq);
        	}
        	
        	nowPop = tempDq.pop();
        	openIdx = Arrays.binarySearch(open,  nowPop);
        	closeIdx = Arrays.binarySearch(close,  nowPop);
        	isSpin = false;
        	
        	//체크
        	if(openIdx >= 0) {
        		//여는 괄호 등장
        		rmStack.push(nowPop);
        		idxStack.push(openIdx);
        		
        	} else if(closeIdx >= 0) {
        		//닫는 괄호 등장
        		
        		//첫 문자가 닫는 괄호
        		if(rmStack.isEmpty()) {
        			//틀린 괄호 문자열 > 회전
        			isSpin = true;
        			continue;
        		}
        		
        		//pair
        		if(idxStack.peek() == closeIdx) {
        			rmStack.pop();
        			idxStack.pop();
        			
        		} else {
        			//열린 괄호와 닫는 괄호가 다름
        			isSpin = true;
        			continue;
        		}
        	}
        	
        	//올바른 문자열 확인 완료
        	if(tempDq.isEmpty()) {
        		if(rmStack.isEmpty()) answer++;
        		isSpin = true;
    			continue;
        	}
        }
        
        return answer;
    }
}
