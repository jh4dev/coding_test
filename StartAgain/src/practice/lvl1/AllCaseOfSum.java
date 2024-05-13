package practice.lvl1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 
 * 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 * */
public class AllCaseOfSum {

	public static void main(String[] args) {
		
		int[] numbers = {5,0,2,7};
		System.out.println(Arrays.toString(solution(numbers)));
	}
	
	public static int[] solution(int[] numbers) {
        int[] answer = {};
        
        //TreeSet -> 자동 정렬
        Set<Integer> sumSet = new TreeSet<Integer>();
        
        for(int i = 0; i < numbers.length - 1; i++) { for(int j = i+1; j <
        numbers.length; j++) { sumSet.add(numbers[i] + numbers[j]); } }
		 
        List<Integer> tempList = new ArrayList<Integer>(sumSet);
        answer = tempList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}
