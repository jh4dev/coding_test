package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[1, 2, 1], [2, 3, 3], [5, 2, 2], [1, 4, 2], [5, 3, 1], [5, 4, 2]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
