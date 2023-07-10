package lvl1;


import java.time.LocalDate;
import java.util.*;

public class IndividualExpire {

    public static void main(String[] args) {

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {

        // today = 오늘 날짜 yyyy.mm.dd
        // terms = 약관종류 유효기간
        // privacies = yyyy.mm.dd 약관종류

        List<Integer> answerList = new ArrayList<>();
        int answerIdx = 0;

        final String _SPACE = " ";

        Map<String, Integer> termsMap = new HashMap<String, Integer>();
        String[] termArr;
        for(String term : terms) {
            termArr = term.split(_SPACE);
            termsMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }

        String[] privacyArr;
        for(int i = 0; i < privacies.length; i++) {
            privacyArr = privacies[i].split(_SPACE);
            if(isExpiredData(privacyArr[0], termsMap.get(privacyArr[1]), today)){
                answerList.add(i+1);
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        //answerList.stream().mapToInt(integer -> integer).toArray()
        return answer;
    }

    private static boolean isExpiredData(String strColDate, int duration, String strToday) {

        String[] arrColDate = strColDate.split("\\.");
        String[] arrToday = strToday.split("\\.");

        System.out.println(Arrays.toString(arrColDate));
        System.out.println(Arrays.toString(arrToday));

        LocalDate collectDate = LocalDate.of(Integer.parseInt(arrColDate[0]), Integer.parseInt(arrColDate[1]), Integer.parseInt(arrColDate[2])).plusMonths(duration);
        LocalDate todayDate = LocalDate.of(Integer.parseInt(arrToday[0]), Integer.parseInt(arrToday[1]), Integer.parseInt(arrToday[2]));


        return collectDate.isEqual(todayDate) || collectDate.isBefore(todayDate);
    }
}
