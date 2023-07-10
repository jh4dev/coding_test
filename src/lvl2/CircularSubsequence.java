package lvl2;

import java.util.*;

public class CircularSubsequence {

    public static void main(String[] args) {

        int[] elements = { 4,7,9,1,1};

        System.out.println(solution(elements));
    }

    public static int solution(int[] elements) {
        int answer = 0;

        Set<Integer> sets = new HashSet<>();
        List<Integer> list = new ArrayList<Integer>();

        for(int i : elements) {
            list.add(i);
        }

        //기본 리스트 복사
        list.addAll(list);

        for(int i = 0; i < elements.length; i++) {
            int sum = 0;
            for(int j = i; j < i + elements.length; j++) {
                sum += list.get(j);
                sets.add(sum);
            }

        }
        return sets.size();

    }
}
