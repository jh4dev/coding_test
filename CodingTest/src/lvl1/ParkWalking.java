package lvl1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkWalking {

    public static void main(String[] args) {

        String park[] = {"OSO","OOO","OXO","OOO"};
        String routes[] = {"E 2","S 3","W 1"};

        System.out.println(Arrays.toString(solution(park, routes)));
    }
    public static int[] solution(String[] park, String[] routes) {

        // 방향 정리
        Map<String, int[]> dirMap = new HashMap<>();
        dirMap.put("E", new int[] {0, 1});
        dirMap.put("W", new int[] {0, -1});
        dirMap.put("S", new int[] {1, 0});
        dirMap.put("N", new int[] {-1, 0});

        final int maxW = park[0].length();
        final int maxH = park.length;

        int startW = 0;
        int startH = 0;
        // 시작점 찾기
        for(int i = 0; i < maxH; i++) {
            if(park[i].indexOf("S") > -1) {
                startW = park[i].indexOf("S");
                startH = i;
                break;
            }
        }

        //시작
        int[] cur = {startH, startW};
        for(String route : routes) {
            String dir = route.split(" ")[0];
            int mv  = Integer.parseInt(route.split(" ")[1]);

            boolean flag = true;

            for(int i = 1; i <= mv; i++) {
                int tempW = cur[1] + (dirMap.get(dir)[1] * i);
                int tempH = cur[0] + (dirMap.get(dir)[0] * i);

                try {
                    if(park[tempH].charAt(tempW) == 'X') {
                        flag = false;
                        break;
                    }
                } catch(IndexOutOfBoundsException e) {
                    flag = false;
                    break;
                }

            }
            if(flag) {
                cur[0] = cur[0] + (dirMap.get(dir)[0] * mv);
                cur[1] = cur[1] + (dirMap.get(dir)[1] * mv);
            }
        }

        return cur;
    }
}
