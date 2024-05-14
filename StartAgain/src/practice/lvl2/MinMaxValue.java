package practice.lvl2;

/*
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
 * str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, 
 * solution을 완성하세요.
	예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

	제한 조건
	s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 * */
public class MinMaxValue {

	public static void main(String[] args) {
		
		String s = "";
		
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        int num = 0;
        for(String n : s.split(" ")) {
        	num = Integer.parseInt(n);
        	if(num < min) {
        		min = num;
        	}
        	
        	if(num > max) {
        		max = num;
        	}
        }
        
        return min + " " + max;
    }
}
