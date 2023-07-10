package lvl2;

import java.util.LinkedList;
import java.util.Queue;

public class FindShortestRoot_BFS2 {

    public static void main(String[] args) {

        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };

        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        boolean[][] isChecked = new boolean[maps.length][maps[0].length];
        int[][] distanceMap = new int[maps.length][maps[0].length];

        bfs(maps, isChecked, distanceMap);

        return distanceMap[distanceMap.length - 1][distanceMap[0].length - 1] == 0 ? -1 : distanceMap[distanceMap.length - 1][distanceMap[0].length - 1];
    }

    public static void bfs(int[][] maps, boolean[][] isChecked, int[][] distanceMap) {

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, 0, 1});
        isChecked[0][0] = true;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int y = xy[1];
            int x = xy[0];
            int distance = xy[2];

            distanceMap[y][x] = distance;

            int[][] ALL = {{x - 1, y}, {x + 1, y}, {x, y + 1}, {x, y - 1}};

            for (int[] XY : ALL) {
                int X = XY[0];
                int Y = XY[1];
                if ((0 <= X && X < maps[0].length)
                        && (0 <= Y && Y < maps.length)
                        && (maps[Y][X] == 1)
                        && (isChecked[Y][X] == false)) {
                    q.add(new int[]{X, Y, distance + 1});
                    isChecked[Y][X] = true;
                }
            }
        }
    }
}
