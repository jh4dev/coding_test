package lvl2;

public class CharacterCompare {

    public static void main(String[] args) {

        System.out.println(solution(""));
    }

    static boolean solution(String s) {
        boolean answer = true;

        String[] arrStr = s.split("");

        int count = 0;
        for(String ch : arrStr) {

            if("P".equalsIgnoreCase(ch)) {
                count += 1;
            } else if("Y".equalsIgnoreCase(ch)) {
                count -= 1;
            } else {
                continue;
            }
        }

        if(count != 0) {
            answer = false;
        }
        return answer;
    }
}
