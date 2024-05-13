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
public class IndividualInfoUsingObject {

	public static void main(String[] args) {
		
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		System.out.println(Arrays.toString(solution(today, terms, privacies)));
	}
	
	public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
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
        	IdInfo id = new IdInfo(
    			i + 1						/* index */
    			, toLocalDate(prvArr[0])	/* 동의 일자 */
    			, prvArr[1]					/* 약관 유형 */
    			, termsMap.get(prvArr[1])	/* 약관 만료 기간 */
    			, todayDate					/* 오늘 날짜 */
			);
        	
        	if(id.isExpire) {
        		answerList.add(id.index);
        	}
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

	public static LocalDate toLocalDate(String s) {
		
		String[] tmpArr = s.split("\\.");
		return LocalDate.of(Integer.parseInt(tmpArr[0]), Integer.parseInt(tmpArr[1]), Integer.parseInt(tmpArr[2]));
	}
	
	public static class IdInfo {
		
		private int index;
		private int expirePeriod;
		private LocalDate agreeDate;
		
		private String type;
		private boolean isExpire;
		
		public IdInfo(int iindex, LocalDate iagreeDate, String itype, int iexpirePeriod, LocalDate todayDate) {
			
			this.index = iindex;
			this.expirePeriod = iexpirePeriod;
			this.agreeDate = iagreeDate;
			this.type = itype;
			this.isExpire = isExpire(todayDate);
		}
		
		public boolean isExpire(LocalDate todayDate) {
			if(todayDate.isEqual(this.agreeDate.plusMonths(this.expirePeriod)) 
					|| todayDate.isAfter(this.agreeDate.plusMonths(this.expirePeriod))) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public String toString() {
			return "IdInfo [index=" + index + ", expirePeriod=" + expirePeriod + ", agreeDate=" + agreeDate + ", type="
					+ type + ", isExpire=" + isExpire + "]";
		}
		
	}
}
