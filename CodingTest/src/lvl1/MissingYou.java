package lvl1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingYou {

    public static void main(String[] args) {

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        System.out.println(Arrays.toString(solution(name, yearning, photo)));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> person = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            person.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];

        for(int i = 0; i < photo.length; i++) {
            int score = 0;

            for(int j = 0; j < photo[i].length; j++) {
                score += person.get(photo[i][j]) == null ? 0 : person.get(photo[i][j]);

            }
            answer[i] = score;
        }

        return answer;
    }
}
