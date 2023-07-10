package lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LastCharacter {

    public static void main(String[] args) {

        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n = 3;

        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0}; //default answer

        //중복단어 언급
        //끝 말 못이음

        //말한 단어 리스트
        List<String> saidWordsList = new ArrayList<>();

        int idx = 0;
        boolean flag = true;

        while(true) {

            if(idx > 0 && words[idx-1].charAt(words[idx-1].length() - 1) != words[idx].charAt(0)) {
                flag = false;
                break;
            }
            if(saidWordsList.contains(words[idx])) {
                flag = false;
                break;
            }
            saidWordsList.add(words[idx]);
            if(idx == words.length - 1) {
                break;
            }

            idx += 1;
        }
        if(!flag) {
            answer[0] = idx % n + 1;
            answer[1] = idx / n + 1;
        }
        return answer;
    }
}
