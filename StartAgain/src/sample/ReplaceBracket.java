package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
