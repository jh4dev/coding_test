package practice.lvl1;

/*
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 * */
public class CheckSqrt {

	public static void main(String[] args) {
		System.out.println(solution_best(4));
	}
	
	public static long solution_best(long n) {
		
		if(Math.pow((long)Math.sqrt(n), 2) == n) {
			return (long)Math.pow((Math.sqrt(n) + 1), 2);
		} else return -1;
	}
	public static long solution(long n) {
		double d = Math.sqrt((double)n);

		String dStr = String.valueOf(d);
		
		if(dStr.length() == dStr.indexOf(".") + 2) {
			return (long) Math.pow((d+1), 2);
		} else {
			return -1;
		}
	}
}
