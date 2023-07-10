package lvl2;

import java.awt.print.Pageable;
import java.util.Stack;

public class RemovePair {


    public static void main(String[] args) {

        System.out.println(solution("abbabb"));


    }


    public static int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch)
                stack.pop();
            else
                stack.push(ch);
        }
        return stack.size() == 0 ? 1 : 0;

    }
}
