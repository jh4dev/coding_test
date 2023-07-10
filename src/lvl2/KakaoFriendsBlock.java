package lvl2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class KakaoFriendsBlock {

	
	public static void main(String[] args) {
		
		int m = 4;
		int n = 5;
		
//		String[] table = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		String[] table = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		
		System.out.println(solution(m, n, table));
		
	}
	
	public static int solution(int m, int n, String[] table) {
		
		int answer = 0;
//		String[] friends = {"R", "M", "A", "F", "N", "T", "J", "C"};
		
		Map<Integer, Stack<Character>> lineMap = new HashMap<Integer, Stack<Character>>();
		
		for(int i = 0; i < table[0].length(); i++) {
			Stack<Character> stack = new Stack<>();
			
			for(int j = table.length - 1; j >= 0 ; j--) {
				stack.push(table[j].charAt(i));
			}
			lineMap.put(i, stack);
		}
		
		LinkedHashSet<String> removableSet = new LinkedHashSet<>();
		
		int removeCnt = 0;
		
		while(true) {
			
			removeCnt = 0;
			
			for(int i = 0; i <= lineMap.size() - 2; i++) {
				
				for(int j = 0; j < lineMap.get(i).size() - 1; j++) {
					// j, j + 1 이 같으면, lineMap.get(i+1)의 j, j+1 확인
					// 모두 같으면 removableStack 에 add
					
//					System.out.println(lineMap.get(i).get(j));
//					System.out.println(lineMap.get(i).get(j + 1));
//					System.out.println(lineMap.get(i + 1).get(j));
//					System.out.println(lineMap.get(i + 1).get(j + 1));
					
					if(lineMap.get(i).get(j) == lineMap.get(i).get(j + 1)
							&& lineMap.get(i).get(j) == lineMap.get(i + 1).get(j)
							&& lineMap.get(i).get(j) == lineMap.get(i + 1).get(j + 1)) {
						
						System.out.printf("i : %d, j : %d", i, j);
						removableSet.add(i + "," + j);
						removableSet.add(i + "," + (j + 1));
						removableSet.add((i + 1) + "," + j);
						removableSet.add((i + 1) + "," + (j + 1));
						
						removeCnt++;
					}
				}
			}
			
			if(removeCnt == 0) {
				break;
			}
			
			if(removableSet.size() > 0) {
				answer += removableSet.size();

				List<String> removeList = new ArrayList<>(removableSet);
				Collections.reverse(removeList);
				
				for(String removeItem : removeList) {
					lineMap.get(Integer.parseInt(removeItem.split(",")[0]))
					.remove(Integer.parseInt(removeItem.split(",")[1]));
				}
				
				
				removableSet.clear();
			}
			
		}
		
		return answer;
	}
	
}