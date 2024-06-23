package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[[0,0],[0,-1],[2,-3],[3,-3]]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
