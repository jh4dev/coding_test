package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[[\"a\",\"1\",\"aaa\",\"c\",\"ng\"],[\"a\",\"1\",\"bbb\",\"e\",\"g\"],[\"c\",\"1\",\"aaa\",\"d\",\"ng\"],[\"d\",\"2\",\"bbb\",\"d\",\"ng\"]]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
