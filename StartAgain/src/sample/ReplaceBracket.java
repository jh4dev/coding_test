package sample;

public class ReplaceBracket {

	
	public static void main(String[] args) {

		String s = "[\"I -45\", \"I 653\", \"D 1\", \"I -642\", \"I 45\", \"I 97\", \"D 1\", \"D -1\", \"I 333\"]";
		
		s = s.replace("[", "{");
		s = s.replace("]", "}");
		
		System.out.println(s);
	}
	
}
