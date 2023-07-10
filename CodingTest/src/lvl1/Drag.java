package lvl1;
import java.util.Arrays;

public class Drag {

    public static void main(String[] args) {

        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};

        System.out.println(solution(wallpaper));
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = {};

        int minX = wallpaper.length;
        int maxX = 0;
        int minY = wallpaper[0].length();
        int maxY = 0;

        String file = "#";

        int xVal = 0;

        for(String wall : wallpaper) {

            int start = wall.indexOf(file);
            int end = wall.lastIndexOf(file);

            if(start > -1 && end > -1) {
                if(start < minY) minY = start;
                if(end > maxY) maxY = end;

                if(xVal < minX) minX = xVal;
                if(xVal > maxX) maxX = xVal;
            }

            xVal++;
        }

        System.out.println(minX);
        System.out.println(minY);
        System.out.println(++maxX);
        System.out.println(++maxY);

        return answer;
    }
}
