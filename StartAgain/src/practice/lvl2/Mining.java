package practice.lvl2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 광물 캐기
 * 
 * Greedy
 * 
 * 마인은 곡괭이로 광산에서 광석을 캐려고 합니다. 마인은 다이아몬드 곡괭이, 철 곡괭이, 돌 곡괭이를 각각 0개에서 5개까지 가지고 있으며, 
 * 곡괭이로 광물을 캘 때는 피로도가 소모됩니다. 각 곡괭이로 광물을 캘 때의 피로도는 아래 표와 같습니다.

	예를 들어, 철 곡괭이는 다이아몬드를 캘 때 피로도 5가 소모되며, 철과 돌을 캘때는 피로도가 1씩 소모됩니다. 
	각 곡괭이는 종류에 상관없이 광물 5개를 캔 후에는 더 이상 사용할 수 없습니다.
	
	마인은 다음과 같은 규칙을 지키면서 최소한의 피로도로 광물을 캐려고 합니다.
	
	사용할 수 있는 곡괭이중 아무거나 하나를 선택해 광물을 캡니다.
	한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다.
	광물은 주어진 순서대로만 캘 수 있습니다.
	광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캡니다.
	즉, 곡괭이를 하나 선택해서 광물 5개를 연속으로 캐고, 다음 곡괭이를 선택해서 광물 5개를 연속으로 캐는 과정을 반복하며,
 	더 사용할 곡괭이가 없거나 광산에 있는 모든 광물을 캘 때까지 과정을 반복하면 됩니다.
	
	마인이 갖고 있는 곡괭이의 개수를 나타내는 정수 배열 picks와 광물들의 순서를 나타내는 문자열 배열 minerals가 매개변수로 주어질 때, 마인이 작업을 끝내기까지 필요한 최소한의 피로도를 return 하는 solution 함수를 완성해주세요.
	
	제한사항
	picks는 [dia, iron, stone]과 같은 구조로 이루어져 있습니다.
		0 ≤ dia, iron, stone ≤ 5
		dia는 다이아몬드 곡괭이의 수를 의미합니다.
		iron은 철 곡괭이의 수를 의미합니다.
		stone은 돌 곡괭이의 수를 의미합니다.
		곡괭이는 최소 1개 이상 가지고 있습니다.
		5 ≤ minerals의 길이 ≤ 50
	minerals는 다음 3개의 문자열로 이루어져 있으며 각각의 의미는 다음과 같습니다.
		diamond : 다이아몬드
		iron : 철
		stone : 돌
 * */
public class Mining {

	public static void main(String[] args) {
	
		int[] picks = {0,1,1};
		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
		
		System.out.println(solution(picks, minerals));
	}
	
	public static int solution(int[] picks, String[] minerals) {
        
		Queue<String> pickQueue = new LinkedList<String>();
        for(int i = 0; i < picks.length; i++) {
        	int count = picks[i];
        	while(count > 0) {
        		if(i == 0) {
        			pickQueue.add("dia");
        		} else if (i == 1) {
        			pickQueue.add("iron");
        		} else {
        			pickQueue.add("stone");
        		}
        		count--;
        	}
        }
        
        //5개씩 나눠서, 광물의 가중치가 큰 순으로 정렬
        //가중치가 큰 세트를 효율이 좋은 곡괭이로 사용
        Map<Integer, Integer> wMap = new HashMap<Integer, Integer>();
        
        int weight = 0;
        int key = 1;
        int idx = 0;
        
        int finish = Math.min(pickQueue.size() * 5, minerals.length);
        while(true) {
        	if(idx % 5 == 0 && idx > 0) {
        		wMap.put(key, weight);
        		key++;
        		weight = 0;
        	}
        	
        	if(idx >= finish) {
        		if(weight > 0) {
        			wMap.put(key, weight);
        		}
        		break;
        	}
        	
        	switch (minerals[idx]) {
			case "diamond":
				weight += 25;
				break;
			case "iron":
				weight += 5;
				break;
			case "stone":
				weight += 1;
			default:
				break;
			}
        	idx++;
        }
        
        // ArrayList로 변환
        ArrayList<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(wMap.entrySet());
        // 값을 기준으로 정렬
        Collections.sort(sortedList, (o1, o2) -> o2.getValue() - o1.getValue());

        //피로도 계산
        int result = 0;
        String pick = "";
        
        for(Map.Entry<Integer, Integer> entry : sortedList) {
        	
        	if(!pickQueue.isEmpty()) {
        		pick = pickQueue.poll();
            	for(int i = 5 * (entry.getKey() - 1); i < Math.min(5 * (entry.getKey() - 1) + 5, minerals.length); i++) {
            		result += mining(pick, minerals[i]);
            	}
        	}
        	else break;
        }
        
        return result;
    }
	
	public static int mining(String pick, String mineral) {
		//다이아 곡괭이 
		if("dia".equals(pick)) return 1;
		//철 곡괭이 
		else if("iron".equals(pick)) {
			if("diamond".equals(mineral)) return 5;
			else return 1;
		}
		//돌 곡괭이 
		else {
			if("diamond".equals(mineral)) return 25;
			else if("iron".equals(mineral)) return 5;
			else return 1;
		}
	}
}
