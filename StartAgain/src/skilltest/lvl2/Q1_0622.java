package skilltest.lvl2;

public class Q1_0622 {

	
	public static void main(String[] args) {
		
		String s = "abcdcdabab";
		
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
        int answer = s.length();
        StringBuffer check 	= new StringBuffer();
        StringBuffer next	= new StringBuffer();
        StringBuffer result	= new StringBuffer();
        
        int cIdx = 1;
        int nIdx = 1;
        int cnt = 1;
        
        while(cIdx <= s.length() / 2) {
        	
        	check.setLength(0);
        	check.append(s.substring(0, cIdx));
        	
        	nIdx = cIdx;
        	result.setLength(0);
        	while(nIdx <= s.length()) {
        		
        		int endIdx = Math.min(cIdx + nIdx, s.length());
        		
        		next.setLength(0);
        		next.append(s.substring(nIdx, endIdx));
        		
        		if(check.toString().equals(next.toString())) {
        			cnt++;
        		} else {
        			if(cnt > 1) {
        				result.append(cnt);
        			}
        			result.append(check);
        			check.setLength(0);
        			check.append(next);
        			cnt = 1;
        		}
        		nIdx += cIdx;
        	}
        	result.append(check);   
            answer = Math.min(answer, result.length());
            cIdx++;
        }
            
        return answer;
    }
}
