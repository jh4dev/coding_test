package lvl2;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(solution(6));
    }
    public static int solution(int n) {
        int answer = 0;

        int a = 0;
        int b = 1;

        for(int i = 2; i <= n; i++) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }

        return answer ;
    }
}
