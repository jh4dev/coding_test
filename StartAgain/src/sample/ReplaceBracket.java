package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[1300, 1500, 1600, 4900]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
