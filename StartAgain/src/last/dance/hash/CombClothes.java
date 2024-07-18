package last.dance.hash;

import java.util.HashMap;
import java.util.Map;

public class CombClothes {

	public static void main(String[] args) {
		
	}
	
	public static int solution(String[][] clothes) {
		int answer = 1;
		
		Map<String, Integer> cMap = new HashMap<String, Integer>();
		
		for(String[] c : clothes) {
			cMap.put(c[1], cMap.getOrDefault(c[1], 0) + 1);
		}

		//n개 중 1개를 입거나, 안입거나 (+1)
		for(int c : cMap.values()) {
			answer *= (c + 1);
		}
		
		//모두 안입는 경우는 없어야 함
		return answer - 1;
	}
	
}
