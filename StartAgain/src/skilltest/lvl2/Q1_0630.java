package skilltest.lvl2;

public class Q1_0630 {

	public static void main(String[] args) {
		
	}
	
	public static String solution(String s) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String num : s.split(" ")) {
        	
        	if(min > Integer.parseInt(num)) min = Integer.parseInt(num);
        	if(max < Integer.parseInt(num)) max = Integer.parseInt(num);
        }
        		
        return min + " " + max;
    }
}

