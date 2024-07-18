package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[[60, 50], [30, 70], [60, 30], [80, 40]]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
