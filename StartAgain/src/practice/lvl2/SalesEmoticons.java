package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 이모티콘 할인행사
 * 
 * 
 * */
public class SalesEmoticons {

	public static void main(String[] args) {
		
		int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};

		int[] emoticons = {1300, 1500, 1600, 4900};
		
		System.out.println(Arrays.toString(solution(users, emoticons)));
	}
	
	static int[] rates = {40, 30, 20, 10};
	public static int[] solution(int[][] users, int[] emoticons) {
        List<int[]> answerList = new ArrayList<>();
        //이게 맞나
        //4개의 할인율의 조합 추출 (이모티콘 최대 7개 이므로 4^7 탐색 가능)
        List<List<Integer>> combinations = generateCombinations(emoticons.length);

        int subscriberCnt = 0;
        int salesAmount = 0;
        
        int uRate = 0;
        int uLimit = 0;
        int pay	= 0;
        for (int i = 0; i < combinations.size(); i++) {
            subscriberCnt = 0;
            salesAmount = 0;
            for(int u = 0; u < users.length; u++) {
            	
            	uRate = users[u][0];
            	uLimit = users[u][1];
            	pay = 0;
            	for(int e = 0; e < emoticons.length; e++) {
                	
            		if(uRate <= combinations.get(i).get(e)) {
            			pay += emoticons[e] * (100 - combinations.get(i).get(e)) / 100;
            		} 
            		
            		if(pay >= uLimit) {
            			break;
            		}
                }
            	
            	if(pay >= uLimit) {
            		//개별 지불금액의 합이 개인 한도보다 크면 구독
        			subscriberCnt++;
            	} else {
            		//개별 지불금액의 합이 개인 한도보다 작으면 그대로 지불
            		salesAmount += pay;
            	}
            }
            
            answerList.add(new int[] {subscriberCnt, salesAmount});
        }
        
        answerList.sort((o1, o2) -> {
        	int compare = o2[0] - o1[0];
        	if(compare == 0) {
        		return o2[1] - o1[1];
        	}
        	return compare;
        });
        
        return answerList.get(0);
    }

    public static List<List<Integer>> generateCombinations(int length) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinationsRecursive(length, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinationsRecursive(int length, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i : rates) {
            current.add(i);
            generateCombinationsRecursive(length, current, result);
            current.remove(current.size() - 1);
        }
    }
}
