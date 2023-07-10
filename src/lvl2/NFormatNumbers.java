package lvl2;

//N진
public class NFormatNumbers {

	public static void main(String[] args) {

		int n = 2;		//진
		int t = 4;		//미리 구할 숫자 
		int m = 2;		//게임 참가 인
		int p = 1;		//튜브 순
		
		System.out.println(solution(n, t, m, p));
		
	}
	
	public static String solution(int n, int t, int m, int p) {
		
		String answer = "";
		String tmp = "";
		
		int number = 0;
		
		while(tmp.length() < t * m) {
			tmp += Integer.toString(number++, n).toUpperCase();
		}
		
		int turn = 0;

		while(answer.length() < t) {
			answer += tmp.charAt((m * turn) + p - 1);
			turn += 1;
		}
		
		return answer;
	}
}
