package skilltest.lvl2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Question2 {

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));
	}
	
	public static long solution(String expression) {
        long answer = 0;
        
        List<Long> numList = new ArrayList<>();
        List<String> operList = new ArrayList<>();
        
        StringBuffer sbf = new StringBuffer();
        char c;
        for(int i = 0; i < expression.length(); i++) {
        	c = expression.charAt(i);
        	if(Character.isDigit(c)) {
        		sbf.append(c);
        		
        		if(i == expression.length() - 1) {
        			numList.add(Long.parseLong(sbf.toString()));
        		}
        	} else {
        		numList.add(Long.parseLong(sbf.toString()));
        		sbf.setLength(0);
        		operList.add(String.valueOf(c));
        	}
        }
        
        
        List<Long> answerList = new ArrayList<>();
        
        Set<String> operSet = new HashSet<>(operList);
        operSet = findAllCombinations(operSet);

        char nowOper;
        int indexOfOper = -1;
        String original = expression;
        Stack<Character> operStack = new Stack<Character>();
        for(String oper : operSet) {
        	operStack = getOperStack(oper);
        	expression = original;
        	while(!operStack.isEmpty()) {
        		nowOper = operStack.peek();
        		indexOfOper = findIndexOf(expression, nowOper);
        		if(indexOfOper > 0) {
        			expression = calculate(expression, nowOper, indexOfOper);
        		} else {
        			operStack.pop();
        		}
        	}
        	System.out.println(expression);
        	answerList.add(Long.valueOf(expression));
        }
        
        System.out.println(answerList);
        
        return answer;
    }
	
	public static int findIndexOf(String str, char ch) {
		int firstIndexOf = str.indexOf(ch);
		
		if(firstIndexOf == 0 && ch == '-') {
			return str.substring(1).indexOf(ch) + 1;
		} else {
			return firstIndexOf;
		}
    }
	
	public static String calculate(String expression, char operator, int index) {
		
		String front = "";
		String cal = "";
		String back = "";
		
		long num1 = 0;
		long num2 = 0;
		StringBuffer sbf = new StringBuffer();
		
		boolean isNegative = false;
		
		for(int i = index - 1; i >= 0; i--) {
			System.out.println(expression.charAt(i));
			if(Character.isDigit(expression.charAt(i))) {
				sbf.insert(0, expression.charAt(i));
			} else {
				if(i == 0 && expression.charAt(i) == '-') {
					isNegative = true;
					break;
				}
				front = expression.substring(0, i + 1);
				break;
			}
		}
		num1 = Long.parseLong(sbf.toString());
		if(isNegative) {
			num1 *= -1;
		}
		
		sbf.setLength(0);
		for(int i = index + 1; i < expression.length(); i++) {
			if(Character.isDigit(expression.charAt(i))) {
				sbf.append(expression.charAt(i));
			} else {
				back = expression.substring(i);
				break;
			}
		}
		num2 = Long.parseLong(sbf.toString());
		
		cal = String.valueOf(calculateHelper(num1, num2, operator));
		
		return front + cal + back;
	}
	
	public static long calculateHelper(long num1, long num2, char operator) {
		
		switch(operator) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		default:
			return 0;
		}
	}
	
	public static Stack<Character> getOperStack(String opers) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = opers.length() - 1; i >= 0; i--) {
			stack.push(opers.charAt(i));
		}
		return stack;
	}
	
	
	// 세 개의 문자열로 만들 수 있는 모든 조합을 찾는 함수
    public static HashSet<String> findAllCombinations(Set<String> opers) {
        HashSet<String> combinations = new HashSet<>();
        StringBuffer sbf = new StringBuffer();
        for(String oper : opers) {
        	sbf.append(oper);
        }
        findAllCombinationsHelper("", sbf.toString(), combinations);
        return combinations;
    }

    // 재귀적으로 모든 조합을 찾는 보조 함수
    private static void findAllCombinationsHelper(String prefix, String suffix, HashSet<String> combinations) {
        int n = suffix.length();
        // 재귀 종료 조건: suffix의 길이가 0이면 prefix를 combinations에 추가
        if (n == 0) {
            combinations.add(prefix);
        } else {
            // suffix의 각 문자에 대해 반복하여 새로운 prefix와 새로운 suffix로 재귀 호출
            for (int i = 0; i < n; i++) {
                findAllCombinationsHelper(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, n), combinations);
            }
        }
    }
//	while(!operStack.isEmpty()) {
//	
//	operList 	= List.copyOf(afterOperList);
//	numList 	= List.copyOf(afterNumList);
//	
//	afterOperList.clear();
//	afterNumList.clear();
//	
//	nowOper = operStack.pop();
//	//operList 의 i 번째 연산자는 numList 의 i 번째와 i + 1 번째의 연산자
//	for(int i = 0; i < operList.size(); i++) {
//		if(String.valueOf(nowOper).equals(operList.get(i))) {
//			tempValue = calculate(numList.get(i), numList.get(i + 1), nowOper);
//			afterNumList.add(tempValue);
//			isOperated = true;
//		} else {
//			afterOperList.add(operList.get(i));
//			if(!isOperated) {
//				afterNumList.add(numList.get(i));
//			} else {
//				isOperated = false;
//			}
//			
//			if(i == operList.size() - 1) {
//				afterNumList.add(numList.get(i + 1));
//			}
//		}
//	}
//	
//	System.out.println(afterNumList);
//	System.out.println(afterOperList);
//}
}
