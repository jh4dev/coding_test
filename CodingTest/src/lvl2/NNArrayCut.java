package lvl2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NNArrayCut {

    public static void main(String[] args) {

        int[][] a = {{1,2}, {2,3}, {3,4}};

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(10, 5));
        System.out.println(Math.max(Integer.MAX_VALUE, Math.pow(10, 5)));

        System.out.println(Arrays.toString(solution(3, 2, 5)));
    }

    public static int[] solution(int n, long left, long right) {

        List<Integer> list = new ArrayList<>();
        for(long i = left; i <= right; i++) {
            //주의 right - left < 10^5
            list.add((int) (Math.max(i/n, i%n) + 1));
        }

        int[] answer = new int [(int)(right - left + 1)];

        return list.stream().mapToInt(i -> i).toArray();
    }
}
