import java.util.Arrays;

public class Score {

    public static void main(String[] args) {

        int[] score = 	{1, 2, 3, 1, 2, 3, 1};
        int k = 3;
        int m = 4;

        System.out.println(solution(k,m,score));
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length-1; i >= 0; i--) {

            if((score.length - i) % m == 0) {
                answer += score[i] * m;
            }
        }
        return answer;
    }
}

