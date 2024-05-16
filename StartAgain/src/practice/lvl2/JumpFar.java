package practice.lvl2;

/*
 * 멀리 뛰기
 * 
 * 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 
 * 칸이 총 4개 있을 때, 효진이는
	(1칸, 1칸, 1칸, 1칸)
	(1칸, 2칸, 1칸)
	(1칸, 1칸, 2칸)
	(2칸, 1칸, 1칸)
	(2칸, 2칸)
	의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 
	
	멀리뛰기에 사용될 칸의 수 n이 주어질 때, 
	효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 
	여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 
	예를 들어 4가 입력된다면, 5를 return하면 됩니다.
 * */
public class JumpFar {

	static long count = 0;
	
	public static void main(String[] args) {
		
		System.out.println(solution(6));
	}
	
	public static long solution(int n) {
		
		long answer = 0;
		
		/*
		 * n 번째 칸에 도착하기 위해서는, 아래 두 케이스가 있음 
		 * 	n-1 칸에서 1칸 점프
		 *  n-2 칸에서 2칸 점프
		 *  
		 *  피보나치 수열
		 *  
		 * */
		
		long a = 0;
		long b = 1;

        for(int i = 1; i <= n; i++) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }
		
		return answer % 1234567;
	}
	
	public static long solution_dfs(int n) {
        jumping(n);
        return count % 1234567;
    }
	
	public static void jumping(int remain) {
		if(remain == 0) {
			count++; return;
			
		} else if(remain < 0) return;
		else {
			jumping(remain -1);
			jumping(remain -2);
		}
	}
}
