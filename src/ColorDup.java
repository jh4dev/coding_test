public class ColorDup {

    public static void main(String[] args) {

        int section[] = {1,2, 3,4};
        int n = 4;
        int m = 1;

        System.out.println(solution(n, m, section));
    }

    private static int solution(int n, int m, int[] section) {

        int answer = 0;
        int lastColoredIdx = 0;

        for(int i = 0; i < section.length; i++) {
            if(lastColoredIdx < section[i]) {
                lastColoredIdx = section[i] + m - 1;
                answer++;
            }
        }


        return answer;
    }
}
