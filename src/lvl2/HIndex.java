package lvl2;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class HIndex {

    public static void main(String[] args) {

        int[] citations = {4,4,4,9,9,10,7};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int h = 0;
        for(int i = 0; i < citations.length; i++) {
                 h = citations.length - i; //잔여 논문 수
                 if(citations[i] >= h) {
                     answer = h;
                     break;
                 }
        }
        return answer;
    }
}
