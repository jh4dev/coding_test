package lvl2;

public class ModIsOne {

    public static void main(String[] args) {

        int n = 900293409;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;

        for(int i = 2; i < n; i++) {

            if(n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
