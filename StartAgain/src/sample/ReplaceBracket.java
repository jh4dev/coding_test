package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
