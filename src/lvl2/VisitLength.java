package lvl2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VisitLength {

    public static void main(String[] args) {

        System.out.println(solution("ULURRDLLU"));
    }

    public static int solution(String dirs) {

        int answer = 0;

        //움직인 좌표 저장 ( xx nn / nn xx )
        Set<String> pathSet = new HashSet<>();
        int[] now = {0, 0};
        int[] after = {0, 0};

        final int _MIN = -5;
        final int _MAX = 5;

        for(int i = 0; i < dirs.length(); i++) {

            switch(dirs.charAt(i)) {

                case 'L':
                    after[0] -= 1;
                    break;
                case 'R':
                    after[0] += 1;
                    break;
                case 'U':
                    after[1] += 1;
                    break;
                case 'D':
                    after[1] -= 1;
                    break;
            }

            if(after[0] >= _MIN && after[0] <= _MAX && after[1] >= _MIN && after[1] <= _MAX) {
                pathSet.add(Arrays.toString(now) + Arrays.toString(after));
                pathSet.add(Arrays.toString(after) + Arrays.toString(now));
                now[0] = after[0];
                now[1] = after[1];
            } else {
                after[0] = now[0];
                after[1] = now[1];
            }
        }

        return pathSet.size() / 2;
    }
}
