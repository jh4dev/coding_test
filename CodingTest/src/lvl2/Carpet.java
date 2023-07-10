package lvl2;

import java.util.Arrays;

public class Carpet {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        int wh = brown + yellow;
        int a = 0;
        int b = 0;
        for(int i = 1; i <= wh/2; i++) {
            if(wh % i == 0) {
                a = i;
                b = wh/i;

                if(checkAnswer(a >= b ? a : b, a >= b ? b : a, brown, yellow)){
                    answer[0] = a >= b ? a : b;
                    answer[1] = a >= b ? b : a;
                    break;
                }
            }
        }
        return answer;
    }

    public static boolean checkAnswer(int width, int height, int brown, int yellow) {

        //가로*세로 = brown + yellow
        if(!(width * height == brown + yellow)) {
            return false;
        }

        //yellow 로 검산
        if(!((width -2) * (height -2) == yellow)) {
            return false;
        }

        return true;
    }

}
