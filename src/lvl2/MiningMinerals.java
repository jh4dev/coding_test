package lvl2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//광물캐기 
public class MiningMinerals {

	public static void main(String[] args) {
		int[] picks = {0,1,1};
		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
		System.out.println(solution(picks, minerals));
	}
	
	public static int solution(int[] picks, String[] minerals) {
		int answer = 0;

		//곡괭이 정의
		List<Pick> pickList = new ArrayList<>();
		for(int i = 0; i < picks.length; i++) {
			if(picks[i] > 0) {
				for(int j = 0; j < picks[i]; j++) {
					switch(i) {
					case 0:
						pickList.add(new Pick("diamond", 1, 1, 1));
						break;
					case 1:
						pickList.add(new Pick("iron", 5, 1, 1));
						break;
					case 2:
						pickList.add(new Pick("stone", 25, 5, 1));
					} 
				}
			}
		}
        
		int val = 0;
		int mapIdx = 0;
		Map<Integer, Integer> costMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < minerals.length; i++) {
			if("diamond".equals(minerals[i])) {
				val+= 25;
			} else if("iron".equals(minerals[i])) {
				val+= 5;
			} else if("stone".equals(minerals[i])) {
				val+= 1;
			}
			
			if((i > 0 && i % 4 == 0) || i == minerals.length - 1) {
				costMap.put(mapIdx, val);
				val = 0;
				mapIdx++;
			}
		}

		// ArrayList로 변환
        ArrayList<Map.Entry<Integer, Integer>> costList = new ArrayList<>(costMap.entrySet());

        // 값을 기준으로 정렬
        Collections.sort(costList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o2.getValue());
            }
        });

        int start = 0;
        int end = 0;
        Pick nowPick = null;
        
        for(int i = 0; i < costList.size(); i++) {
        	start = costList.get(i).getKey() * 5;
        	end = start + 5;
        	
        	//곡괭이 확인
        	if(i < pickList.size()) {
        		nowPick = pickList.get(i);
        	} else {
        		//곡괭이 소진
        		break;
        	}
        	
        	for(int j = start; j < Math.min(end, minerals.length); j++) {
        		if(minerals[j].equals("diamond")) {
        			answer += nowPick.diaEff;
        		} else if (minerals[j].equals("iron")) {
        			answer += nowPick.ironEff;
        		} else if (minerals[j].equals("stone")) {
        			answer += nowPick.stoneEff;
        		}
        	}
        	
        }
        
		return answer;
	}
	
	public static class Pick{
		String type;
		int diaEff;
		int ironEff;
		int stoneEff;
		
		public Pick(String type, int dia, int iron, int stone) {
			
			this.type = type;
			this.diaEff = dia;
			this.ironEff = iron;
			this.stoneEff = stone;
		}

		@Override
		public String toString() {
			return "Pick [type=" + type + ", diaEff=" + diaEff + ", ironEff=" + ironEff + ", stoneEff=" + stoneEff
					+ "]";
		}

		
	}
}
