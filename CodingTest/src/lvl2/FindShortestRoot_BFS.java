package lvl2;

import java.util.LinkedList;
import java.util.Queue;

public class FindShortestRoot_BFS {

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

        //좌 우 상 하
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        final int _MAX_ROWS = maps[0].length - 1;
        final int _MAX_COLS = maps.length - 1;

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Point> queue =  new LinkedList<>();

        visited[0][0] = true;
        queue.add(new Point(0, 0, 1));

        while(!queue.isEmpty()) {

            Point curPoint = queue.remove();

            if(curPoint.row == _MAX_ROWS && curPoint.col == _MAX_COLS) {
                return curPoint.distance;
            }


            for(int i = 0; i < direction.length; i++) {

                int nextRow = curPoint.row + direction[i][0];
                int nextCol = curPoint.col + direction[i][1];

                //범위 밖
                if(nextRow < 0 || nextRow > _MAX_ROWS || nextCol < 0 || nextCol > _MAX_COLS) {
                    continue;
                }
                //기방문지점
                if(visited[nextRow][nextCol] == true) {
                    continue;
                }
                //벽 체크
                if(maps[nextRow][nextCol] == 0) {
                    continue;
                }
                queue.add(new Point(nextRow, nextCol, curPoint.distance + 1));
                visited[nextRow][nextCol] = true;
            }
        }
        return -1; // 탐색 실패 시
    }

    static class Point {
        Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
        int row, col, distance;
    }
}
