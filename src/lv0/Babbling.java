package lv0;

public class Babbling {

    public static void main(String[] args) {

        String bab[] = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println(solution(bab));
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        for(String str : babbling) {
            String[] canSay = new String[]{ "aya", "ye", "woo", "ma" };
            String tempStr = str;
            String result = "";
            for(String word : canSay) {
                 if(tempStr.contains(word)) {
                     tempStr = tempStr.substring(0, tempStr.indexOf(word))
                             .concat(" ")
                             .concat(tempStr.substring(tempStr.indexOf(word) + word.length()));
                    if(tempStr.trim().length() == 0) {
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
