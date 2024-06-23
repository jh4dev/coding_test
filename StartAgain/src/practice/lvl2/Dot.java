package practice.lvl2;

/**
 * 점 찍기 
 * 좌표평면을 좋아하는 진수는 x축과 y축이 직교하는 2차원 좌표평면에 점을 찍으면서 놀고 있습니다. 진수는 두 양의 정수 k, d가 주어질 때 다음과 같이 점을 찍으려 합니다.

원점(0, 0)으로부터 x축 방향으로 a*k(a = 0, 1, 2, 3 ...), y축 방향으로 b*k(b = 0, 1, 2, 3 ...)만큼 떨어진 위치에 점을 찍습니다.
원점과 거리가 d를 넘는 위치에는 점을 찍지 않습니다.
예를 들어, k가 2, d가 4인 경우에는 (0, 0), (0, 2), (0, 4), (2, 0), (2, 2), (4, 0) 위치에 점을 찍어 총 6개의 점을 찍습니다.

정수 k와 원점과의 거리를 나타내는 정수 d가 주어졌을 때, 점이 총 몇 개 찍히는지 return 하는 solution 함수를 완성하세요.


 * */
public class Dot {

	public static void main(String[] args) {
		
		int k = 2;
		int d = 4;
		
		System.out.println(solution(k, d));
		
	}
	
	public static long solution(int k, int d) {
        
		long answer = 0;
		
		long y = 0;
		for(long x = 0; x <= d; x += k) {
			y = getMaxPoint(x, d);
			System.out.println(x + ", " + y);
			answer += y/k + 1; //y가 0인 경우 포함시키기 위해 +1
		}
		
		return answer;
    }
	
	public static long getMaxPoint(long x, int d) {
		return (long) Math.floor(Math.sqrt((long)d*d - x*x));
	}
	
}
