package lvl2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//그리디
//맵정렬
//트리맵

public class GyulChoice {

	public static void main(String[] args) {
		int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
		
		System.out.println(solution(2, tangerine));
	}
	
	public static int solution(int k, int[] tangerine) {
		
		int answer = 0;
	
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        for(int i = 0; i < tangerine.length; i++) {
        	sortedMap.put(tangerine[i], sortedMap.getOrDefault(tangerine[i], 0) + 1);
        }

        // ArrayList로 변환
        ArrayList<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(sortedMap.entrySet());

        
        // 값을 기준으로 정렬
        Collections.sort(sortedList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
		
        int typeCnt = 0;
        
        for(Map.Entry<Integer, Integer> entry : sortedList) {
        	answer += 1;
        	typeCnt += entry.getValue();
        	
        	if(typeCnt >= k) {
        		break;
        	}
        }
        
		return answer;
	}
}
