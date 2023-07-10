import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Race {

    public static void main(String[] args) {

        String players[] = {"mumu", "soe", "poe", "kai", "mine"};
        String callings[] = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(solution(players, callings)));
    }
    public static String[] solution(String[] players, String[] callings) {

        Map<String, Integer> rankMap = new HashMap<String, Integer>();

        for(int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        for(String callName : callings) {

            int curRank = rankMap.get(callName);

            //앞 등수 선수 이름
            String prevPlayer = players[curRank - 1];
            rankMap.put(prevPlayer, curRank);
            rankMap.put(callName, curRank - 1);
            players[curRank] = prevPlayer;
            players[curRank - 1] = callName;
        }

        return players;
    }
}
