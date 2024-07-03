package skilltest.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2_0630 {

	public static void main(String[] args) {
	
		int[][] users = {{40, 10000}, {25, 10000}};
		int[] emoticons = {7000, 9000};
		
		System.out.println(Arrays.toString(solution(users, emoticons)));
	}
	
	static int[] rates = {40, 30, 20, 10};
	
	public static int[] solution(int[][] users, int[] emoticons) {
        
		List<int[]> answerList = new ArrayList<>();
        
        List<List<Integer>> combinations = generateCombinations(emoticons.length);
        
        int subscribers = 0;
        int salesAmount = 0;
        
        //사용자 별 금액한도, 최소 할인비율 
        int uPay, uRate, tempPay;
        for(List<Integer> comb : combinations) {
        	
        	subscribers = 0;
        	salesAmount = 0;
        	for(int u = 0; u < users.length; u++) {
        		
        		uRate 	= users[u][0];
        		uPay 	= users[u][1];
        		tempPay = 0;
        		for(int e = 0; e < emoticons.length; e++) {
        			
        			//할인율 충족 
        			if(comb.get(e) >= uRate) {
        				tempPay += (emoticons[e] * ((double)(100 - comb.get(e)) / 100));
        			}
        			
        			//구매 한도인 경우 구독처리 
        			if(tempPay >= uPay) {
        				subscribers++;
        				tempPay = 0;
        				break;
        			}
        		}
        		
        		if(tempPay > 0) {
        			salesAmount += tempPay;
        		}
        	}
        	
        	answerList.add(new int[] {subscribers, salesAmount});
        }
        
        answerList.sort((o1, o2) -> {
        	//구독자가 많은게 우선 
        	int compare = o2[0] - o1[0];
        	//구독자가 같으면 금액이 높은 것으로 
        	if(compare == 0) {
        		return o2[1] - o1[1];
        	}
        	return compare;
        });
        
        return answerList.get(0);
    }
	
	public static List<List<Integer>> generateCombinations(int n) {
		List<List<Integer>> list = new ArrayList<>();
		
		generateCombinationsRecursive(n, new ArrayList<>(), list);
		
		
		return list;
	}
	
	public static void generateCombinationsRecursive(int n, ArrayList<Integer> now, List<List<Integer>> list) {
		
		if(now.size() == n) {
			list.add(new ArrayList<>(now));
			return;
		}
		
		for(int i : rates) {
			now.add(i);
			generateCombinationsRecursive(n, now, list);
			now.remove(now.size() - 1);
		}
	}
}

