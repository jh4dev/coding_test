package practice.lvl1;

public class SplitString {

	public static void main(String[] args) {
	
		String s = "aaabbaccccabba";
		
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		
		int answer = 0;
		
		char first = s.charAt(0);
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int i = 0; i < s.length(); i++) {
		
			if(s.charAt(i) == first) cnt1++;
			else cnt2++;
			
			if(cnt1 + cnt2 > 0 && cnt1 == cnt2) {
				answer++;
				if(i < s.length() - 1) {
					first = s.charAt(i+1);
				}
			} else if (i == s.length() - 1) {
				answer++;
			}
		}
		
		return answer;
	}
}
