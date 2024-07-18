package sample;

public class Test {

	public static void main(String[] args) {
		
		
		System.out.println(changeNumberFormat(18, 2));
	}
	
	public static long changeNumberFormat(long num, int format) {
		
		StringBuffer sbf = new StringBuffer();
		
		while(true) {
			
			sbf.insert(0, num % format);
			
			if(num / format == 1) {
				sbf.insert(0, 1);
			} 
			num /= format;
			
			if(num == 1) {
				break;
			}
		}
		
		return Long.parseLong(sbf.toString());
	}
}
