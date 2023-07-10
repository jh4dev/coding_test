package lvl2;

import java.util.EmptyStackException;
import java.util.Stack;

public class BracketPair {

    public static void main(String[] args) {

        String str = "((())()(()))()))()())()";

        System.out.println(solution(str));
    }

    private static boolean solution(String s) {
        boolean answer = true;

        final char open = '(';
        final char close = ')';

        Stack<Character> stack = new Stack<>();

        try {
            for(char c : s.toCharArray()) {
                if(open == c ) {
                    stack.push(open);
                } else if (close == c) {
                    stack.pop();
                } else continue;
            }
        } catch (EmptyStackException ese ) {
            return false;
        }
        return stack.size() == 0 ? true : false;
    }
}
