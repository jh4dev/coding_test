package practice.lvl2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 점 찍기 
 * 좌표평면을 좋아하는 진수는 x축과 y축이 직교하는 2차원 좌표평면에 점을 찍으면서 놀고 있습니다. 진수는 두 양의 정수 k, d가 주어질 때 다음과 같이 점을 찍으려 합니다.

원점(0, 0)으로부터 x축 방향으로 a*k(a = 0, 1, 2, 3 ...), y축 방향으로 b*k(b = 0, 1, 2, 3 ...)만큼 떨어진 위치에 점을 찍습니다.
원점과 거리가 d를 넘는 위치에는 점을 찍지 않습니다.
예를 들어, k가 2, d가 4인 경우에는 (0, 0), (0, 2), (0, 4), (2, 0), (2, 2), (4, 0) 위치에 점을 찍어 총 6개의 점을 찍습니다.

정수 k와 원점과의 거리를 나타내는 정수 d가 주어졌을 때, 점이 총 몇 개 찍히는지 return 하는 solution 함수를 완성하세요.


 * */
public class Dot_DFS_FAIL {

	public static void main(String[] args) {
		
		int k = 1;
		int d = 100;
		
		System.out.println(solution(k, d));
		
	}
	
	public static long solution(int k, int d) {
        
        Set<Point> points = new HashSet<>();
        points.add(new Point(0,0));
        
        recursion(0, 0, points, d, k);
        return points.size();
    }
	
	public static void recursion(long x, long y, Set<Point> points, int d, int k) {
	
		if(getDistance(x, y) > d) {
			return;
		} else {
			points.add(new Point(x,y));
			if(x != y) {
				points.add(new Point(y,x));
			}
		}
		recursion(x + k, y + k, points, d, k);
		recursion(x, y + k, points, d, k);
	}
	
	public static double getDistance(long x, long y) {
		
		if(x == 0) return y;
		if(y == 0) return x;
		
		return Math.ceil(Math.sqrt(x*x + y*y));
	}
	
	public static class Point{
		long x;
		long y;
		
		public Point (long x, long y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Point point = (Point) o;
	        return this.x == point.x && this.y == point.y;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(x,y);
	    }
	}
}
