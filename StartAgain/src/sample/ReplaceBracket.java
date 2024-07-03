package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[[40, 10000], [25, 10000]]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
