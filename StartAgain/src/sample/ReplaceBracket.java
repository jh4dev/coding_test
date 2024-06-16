package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[1, 2, 4], [1, 3, 1], [3, 4, 1], [4, 2, 1], [2, 5, 1]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
