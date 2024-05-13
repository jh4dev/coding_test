package practice.lvl1;

public class CheckCharacter {

	public static void main(String[] args) {
		
		System.out.println(solution("pyyp"));
	}
	
	static boolean solution(String s) {
	
		s = s.toUpperCase();
	    
	    int cnt = 0;
	    for(char c : s.toCharArray()) {
	    	
	    	if(c == 'P') cnt++;
	    	else if(c == 'Y') cnt--;
	    	else continue;
	    		
	    }
	    
	    return cnt == 0 ? true : false;
	}
}
