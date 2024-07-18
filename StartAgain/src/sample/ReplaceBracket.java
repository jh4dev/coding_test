package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[[2, 5, 3], [4, 4, 1], [1, 7, 3]]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
