package practice.lvl1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 개인 정보 파기
 * */
public class IndividualInfoUsingMethod {

	public static void main(String[] args) {
		
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.07.01 B", "2022.02.19 C", "2022.02.20 C", "2021.05.02 A"};
		
		System.out.println(Arrays.toString(solution(today, terms, privacies)));
	}
	
	public static int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answerList = new ArrayList<Integer>();
        
        LocalDate todayDate = toLocalDate(today);
        
        Map<String, Integer> termsMap = new HashMap<String, Integer>();
        String[] termArr = {};
        for(int t = 0; t < terms.length; t++) {
        	termArr = terms[t].split(" ");
        	termsMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }
        
        String[] prvArr = {};
        for(int i = 0; i < privacies.length; i++) {
        	
        	prvArr = privacies[i].split(" ");
        	if(isExpire(todayDate, toLocalDate(prvArr[0]), termsMap.get(prvArr[1]))) {
        		answerList.add(i + 1);
        	}
        }
        
        return answerList.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

	public static boolean isExpire(LocalDate todayDate, LocalDate agreeDate, int expirePeriod) {
		if(todayDate.isEqual(agreeDate.plusMonths(expirePeriod)) 
				|| todayDate.isAfter(agreeDate.plusMonths(expirePeriod))) {
			return true;
		} else {
			return false;
		}
	}
	
	public static LocalDate toLocalDate(String s) {
		
		String[] tmpArr = s.split("\\.");
		return LocalDate.of(Integer.parseInt(tmpArr[0]), Integer.parseInt(tmpArr[1]), Integer.parseInt(tmpArr[2]));
	}
	
}
