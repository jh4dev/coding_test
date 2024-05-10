package practice.lvl0;

import java.util.HashSet;
import java.util.Set;

//2차함수 평행(기울기)
public class Parallel {

	public static void main(String[] args) {
	
		int[][] dots = {{1,4}, {9,2}, {3,8}, {11,6}};
		System.out.println(solution(dots));
	}
	
	public static int solution(int[][] dots) {
		
		int answer = 0;
		
		//4개의 점으로 구성할 수 있는 선분의 수 4C2 > 6
		Set<Double> parlSet = new HashSet<Double>();
		
		//실패 ->같은 점에서 시작하는 두 선분을 비교하게 됨  
		double parl = 0;
		for(int i = 0; i < dots.length; i++) {
			for(int j = i + 1; j < dots.length; j++) {

				parl = (double)(dots[i][1] - dots[j][1]) / (double)(dots[i][0] - dots[j][0]);
				parlSet.add(parl);
			}
		}
//		return parlSet.size() < 6 ? 1 : 0;
		
		
		for(int i = 0; i < dots.length; i++) {
			
			double d1 = (double)(dots[i][1] - dots[(i+1)%4][1]) / (double)(dots[i][0] - dots[(i+1)%4][0]);
			double d2 = (double)(dots[(i+2)%4][1] - dots[(i+3)%4][1]) / (double)(dots[(i+2)%4][0] - dots[(i+3)%4][0]);
			
			System.out.println(d1);
			System.out.println(d2);
			if(d1 == d2) return 1;

		}
		
		return 0;
	}
}
