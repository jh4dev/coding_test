package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
