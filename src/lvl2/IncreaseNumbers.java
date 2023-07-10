package lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncreaseNumbers {

    public static void main(String[] args) {

        int x = 2;
        int n = 5;
        System.out.println(Arrays.toString(solution(x, n)));
    }
    public static long[] solution(int x, int n) {
        long[] answer = {};

        List<Long> answerList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            answerList.add((long) x + (x * i));
        }

        return answerList.stream().mapToLong(Long::longValue).toArray();

    }
}
