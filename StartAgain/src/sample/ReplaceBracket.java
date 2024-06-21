package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[\"...D..R\", \".D.G...\", \"....D.D\", \"D....D.\", \"..D....\"]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
