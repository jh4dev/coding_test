package practice.lvl1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 포켓몬의 종류가 담겨있는 배열 nums (중복 숫자 있음)
 * 2/nums.length 까지만 선택 가능함
 * 가장 많은 종류의 포켓몬을 고르도록
 * */
public class PokemonPick {

	public static void main(String[] args) {
		
		int nums[] = {3,3,3,2,2,2};
		System.out.println(solution(nums));
	}
	
	public static int solution(int[] nums) {
		
		// 최대로 고를 수 있는 숫자인 nums.length / 2 값이, 중복을 제거한 포켓몬의 수보다 작은 경우 -> nums.length/2
		// 반대인 경우, 중복을 제거한 포켓몬의 수
		
		Set<Integer> ps = new HashSet<Integer>();
		for(int i : nums) {
			ps.add(i);
		}
		
		return Math.min(ps.size(), nums.length/2);
	}
	
	public static int solution_shit(int[] nums) {

		Map<Integer, Integer> monMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> answerMap = new HashMap<Integer, Integer>();
		
		//포멧몬별 카운트
        for(int i : nums) {
        	monMap.put(i, monMap.get(i) == null ? 1 : monMap.get(i) + 1);
        }
        
        List<Integer> monList = new ArrayList<Integer>(monMap.keySet());
        monList.sort((o1, o2) -> monMap.get(o1).compareTo(monMap.get(o2)));
        
        int choiceCnt = 0;
        Loop1 :
        while(true) {
        	for(int i = 0; i < monList.size(); i++) {
        		if(monMap.get(monList.get(i)) > 0) {
        			answerMap.put(monList.get(i), answerMap.get(monList.get(i)) == null ? 1 : answerMap.get(monList.get(i)) + 1);
        			monMap.put(monList.get(i), monMap.get(monList.get(i)) - 1);
        			choiceCnt++;
        		}
        		if(choiceCnt >= nums.length / 2) {
        			break Loop1;
        		}
        	}
        }
        return answerMap.size();
    }
}
