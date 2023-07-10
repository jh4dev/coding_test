package lvl2;

public class SumIndividualNumbers {

    public static void main(String[] args) {

        System.out.println(solution(1233));
    }
        public static int solution(int n) {
            int answer = 0;

            String strNumber = String.valueOf(n);

            for(String s : strNumber.split("")) {

                answer += Integer.parseInt(s);
            }

            return answer;
        }
}
