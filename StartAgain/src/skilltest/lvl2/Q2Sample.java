package skilltest.lvl2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q2Sample {

	
	static int calculate(String expression, List<Character> priorities) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Character> operatorStack = new ArrayDeque<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                while (!operatorStack.isEmpty() && priorities.indexOf(operatorStack.peek()) >= priorities.indexOf(c)) {
                    applyOperator(stack, operatorStack);
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            applyOperator(stack, operatorStack);
        }

        return stack.pop();
    }

    static void applyOperator(Deque<Integer> stack, Deque<Character> operatorStack) {
        int rightOperand = stack.pop();
        int leftOperand = stack.pop();
        char operator = operatorStack.pop();

        switch (operator) {
            case '+':
                stack.push(leftOperand + rightOperand);
                break;
            case '-':
                stack.push(leftOperand - rightOperand);
                break;
            case '*':
                stack.push(leftOperand * rightOperand);
                break;
        }
    }

    static int findMaximumValue(String expression) {
        int maxValue = Integer.MIN_VALUE;
        char[] operators = {'+', '-', '*'};
        List<Character> operatorList = new ArrayList<>();
        for (char op : operators) {
            operatorList.add(op);
        }

        for (List<Character> priorities : permute(operatorList)) {
            int result = calculate(expression, priorities);
            maxValue = Math.max(maxValue, result);
        }

        return maxValue;
    }

    static List<List<Character>> permute(List<Character> list) {
        List<List<Character>> result = new ArrayList<>();
        permuteHelper(list, new boolean[list.size()], new ArrayList<>(), result);
        return result;
    }

    static void permuteHelper(List<Character> list, boolean[] used, List<Character> current, List<List<Character>> result) {
        if (current.size() == list.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(list.get(i));
                permuteHelper(list, used, current, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        int maxValue = findMaximumValue(expression);
        System.out.println("Maximum value: " + maxValue);
    }
}
