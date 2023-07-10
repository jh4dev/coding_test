package lvl2;

public class TestClass {

	
	public static void main(String[] args) {
		
		String file = "test123";
		int firstDigitIdx = 0;
		int lastDigitIdx = file.length() - 1;
		
		boolean isFirst = true;
        for (int i = 0; i < file.length(); i++) {
            if (isFirst && Character.isDigit(file.charAt(i))) {
                firstDigitIdx = i;
                isFirst = false;
                continue;
            }

            if(!isFirst && !Character.isDigit(file.charAt(i))) {
                lastDigitIdx = i;
                break;
            }
        }
        
        System.out.println(firstDigitIdx);
        System.out.println(lastDigitIdx);
        System.out.println(file.substring(lastDigitIdx));
	}
}
