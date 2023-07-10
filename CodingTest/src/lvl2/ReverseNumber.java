package lvl2;

import java.util.Arrays;

public class ReverseNumber {

    public static void main(String[] args) {

        long l = 100235;
        System.out.println(Arrays.toString(solution(l)));
    }
    public static int[] solution(long n) {

        String strNum = String.valueOf(n);

        int answer[] = new int[strNum.length()];
        int idx = 0;

        for(int i = strNum.length() - 1; i >= 0; i--) {
            answer[idx] = Integer.parseInt(strNum.split("")[i]);
            idx++;
        }

        return answer;
    }
}
