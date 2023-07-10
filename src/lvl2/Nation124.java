package lvl2;

public class Nation124 {

	public static void main(String[] args) {
		
		System.out.println(solution(17));
	}
	
	public static String solution(int n ) {

		StringBuilder builder = new StringBuilder();
		
		while(n > 0) {
			
			int mod = n%3;
			if(mod == 0) {
				builder.insert(0, "4");
				n = n / 3 - 1;
			} else {
				builder.insert(0, mod);
				n = n/3;
			}
		}	
		
		return builder.toString();
	}
}
