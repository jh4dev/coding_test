package lvl2;

public class JadenCase {

    public static void main(String[] args) {

        System.out.println(solution("test  3do this"));
    }

    public static String solution(String s) {
        String answer = "";

        boolean upperFlag = true;

        for(char c : s.toCharArray()) {
            if(Character.isSpaceChar(c)) {
                answer += c;
                upperFlag = true;
            } else {
                if(upperFlag) {
                    answer += Character.toUpperCase(c);
                } else {
                    answer += Character.toLowerCase(c);
                }
                upperFlag = false;
            }
        }

        return answer;
    }
}
