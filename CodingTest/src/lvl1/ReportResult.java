package lvl1;

import java.util.*;

public class ReportResult {

    public static void main(String[] args) {


        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        // id_list : 계정
        // report : 신고자 신고대상
        // k : 제재 대상 신고 수

        // 1. Array To List
        List<Map<String, String>> reportList = new ArrayList<>();
        for(String rp : report) {
            Map<String, String> rpMap = new HashMap<>();
            //신고대상 신고자
            rpMap.put(rp.split(" ")[1], rp.split(" ")[0]);
            reportList.add(rpMap);
        }

        // 2. List to Set (중복신고건 제거)
        Set<Map<String, String>> reportSet = new HashSet<>(reportList);

        // 3. 피신고자 별 피신고 횟수
        Map<String, Integer> reportCntMap = new HashMap<>();
        for (Iterator<Map<String, String>> it = reportSet.iterator(); it.hasNext(); ) {
            Map<String, String> map = it.next();

            for(Map.Entry<String, String> entry : map.entrySet()) {
                reportCntMap.put(entry.getKey(), reportCntMap.get(entry.getKey()) == null ? 1 : reportCntMap.get(entry.getKey()) + 1);
            }
        }

        //4. 신고자 피드백 횟수
        Map<String, Integer> feedbackCntMap = new HashMap<>();
        for (Iterator<Map<String, String>> it = reportSet.iterator(); it.hasNext(); ) {
            Map<String, String> map = it.next();

            for(Map.Entry<String, String> entry : map.entrySet()) {
                if(reportCntMap.get(entry.getKey()) >= k ) {
                    feedbackCntMap.put(entry.getValue(), feedbackCntMap.get(entry.getValue()) == null ? 1 : feedbackCntMap.get(entry.getValue()) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = feedbackCntMap.get(id_list[i]) == null ? 0 : feedbackCntMap.get(id_list[i]);
        }
        return answer;
    }
}
