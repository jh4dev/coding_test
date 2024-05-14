package practice.lvl1;

public class StringToNumber {

	public static void main(String[] args) {

		System.out.println(solution("-2345"));
	}
	
	public static int solution(String s) {
        int answer = 0;
        
        if(Character.isDigit(s.charAt(0))) {
        	return Integer.parseInt(s);
        	
        } else {
        	
        	answer = Integer.parseInt(s.substring(1));
        	
        	if(s.charAt(0) == '+') return answer;
        	else return answer * -1;
        }
    }
}
