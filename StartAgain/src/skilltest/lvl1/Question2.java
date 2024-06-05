package skilltest.lvl1;

public class Question2 {

	
	public static void main(String[] args) {
	
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		
		System.out.println(solution(s, skip, index));
	}
	
	public static String solution(String s, String skip, int index) {
        int size = 26 - skip.length() + index;
        StringBuffer sbf = new StringBuffer();
        
        //97 ~ 122
        char ac = 97;
        while(sbf.length() < size) {
        	
        	if(!skip.contains(String.valueOf(ac))) {
        		sbf.append(ac);
        	}
        	ac++;
        	if(ac > 122) {
        		ac = 97;
        	}
        }
        
        int sIdx = 0;
        StringBuffer ansbf = new StringBuffer();
        
        for(String str : s.split("")) {
        	
        	if(sbf.indexOf(str) + index >= sbf.length()) {
        		sIdx = sbf.lastIndexOf(str);
        	} else {
        		sIdx = sbf.indexOf(str);
        	}
        	ansbf.append(sbf.charAt(sIdx + index));
        }
        
        return ansbf.toString();
    }
}


