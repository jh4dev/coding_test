package practice.lvl2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * 피로도
 * 
 * XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 
 * 일정 피로도를 사용해서 던전을 탐험할 수 있습니다. 
 * 이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 
 * 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다. "최소 필요 피로도"는 
 * 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, 
 * "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다. 
 * 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 
 * 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.

이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다. 
유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때, 
유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
	k는 1 이상 5,000 이하인 자연수입니다.
	dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
	dungeons의 가로(열) 길이는 2 입니다.
	dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
	"최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
	"최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
	서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
	입출력 예
	k	dungeons	result
	80	[[80,20],[50,40],[30,10]]	3
 * */
public class ConditionDegree_bak {

	public static void main(String[] args) {
		
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}, {30, 10}, {30,20}};
		System.out.println(solution(k, dungeons));
	}
	
	public static int solution(int k, int[][] dungeons) {
        int answer = 0;
        
        List<Dungeon> dList = new ArrayList<Dungeon>();
        
        for(int[] dg : dungeons) {
        	dList.add(new Dungeon(dg));
        }
        
        dList.sort(new DungeonComparator());
        System.out.println(dList);

        Dungeon nowDg = null;
        for(int i = 0; i < dList.size(); i++) {
        	System.out.println(k);
        	nowDg = dList.get(i);
        	//최소 피로도 체크
        	if(k >= nowDg.least) {
        		
        		//소모 피로도 체크
        		if(k >= nowDg.use) {
        			k-= nowDg.use;
        			answer++;
        		} else {
        			continue;
        		}
        	}
        }
        
        return answer;
    }
	
	public static class Dungeon {
		
		int least;
		int use;
		
		public Dungeon(int[] dungeon) {
			this.least = dungeon[0];
			this.use = dungeon[1];
		}

		@Override
		public String toString() {
			return "Dungeon [least=" + least + ", use=" + use + "]";
		}
		
		
	}
	
	static class DungeonComparator implements Comparator<Dungeon> {

		@Override
		public int compare(Dungeon o1, Dungeon o2) {
			
			int first = o1.use - o2.use;
			if(first == 0) {
				
				return o2.least - o1.least;
			} else {
				return first;
			}
			
		}
    }
}
