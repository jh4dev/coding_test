package practice.lvl2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 수식 최대화
 * 
 * 연산자의 우선순위대로 계산하여 최대값을 도출하기
 * 
 * 
 * IT 벤처 회사를 운영하고 있는 라이언은 매년 사내 해커톤 대회를 개최하여 우승자에게 상금을 지급하고 있습니다.
	이번 대회에서는 우승자에게 지급되는 상금을 이전 대회와는 다르게 다음과 같은 방식으로 결정하려고 합니다.
	해커톤 대회에 참가하는 모든 참가자들에게는 숫자들과 3가지의 연산문자(+, -, *) 만으로 이루어진 연산 수식이 전달되며, 참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여 만들 수 있는 가장 큰 숫자를 제출하는 것입니다.
	단, 연산자의 우선순위를 새로 정의할 때, 같은 순위의 연산자는 없어야 합니다. 즉, + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,-처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다. 수식에 포함된 연산자가 2개라면 정의할 수 있는 연산자 우선순위 조합은 2! = 2가지이며, 연산자가 3개라면 3! = 6가지 조합이 가능합니다.
	만약 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출하며 제출한 숫자가 가장 큰 참가자를 우승자로 선정하며, 우승자가 제출한 숫자를 우승상금으로 지급하게 됩니다.
	
	예를 들어, 참가자 중 네오가 아래와 같은 수식을 전달받았다고 가정합니다.
	
	"100-200*300-500+20"
	
	일반적으로 수학 및 전산학에서 약속된 연산자 우선순위에 따르면 더하기와 빼기는 서로 동등하며 곱하기는 더하기, 빼기에 비해 우선순위가 높아 * > +,- 로 우선순위가 정의되어 있습니다.
	대회 규칙에 따라 + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,- 처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다.
	수식에 연산자가 3개 주어졌으므로 가능한 연산자 우선순위 조합은 3! = 6가지이며, 그 중 + > - > * 로 연산자 우선순위를 정한다면 결괏값은 22,000원이 됩니다.
	반면에 * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은 -60,420 이지만, 규칙에 따라 우승 시 상금은 절댓값인 60,420원이 됩니다.
	
	참가자에게 주어진 연산 수식이 담긴 문자열 expression이 매개변수로 주어질 때, 우승 시 받을 수 있는 가장 큰 상금 금액을 return 하도록 solution 함수를 완성해주세요.
	
	[제한사항]
		expression은 길이가 3 이상 100 이하인 문자열입니다.
		expression은 공백문자, 괄호문자 없이 오로지 숫자와 3가지의 연산자(+, -, *) 만으로 이루어진 올바른 중위표기법(연산의 두 대상 사이에 연산기호를 사용하는 방식)으로 표현된 연산식입니다. 잘못된 연산식은 입력으로 주어지지 않습니다.
		즉, "402+-561*"처럼 잘못된 수식은 올바른 중위표기법이 아니므로 주어지지 않습니다.
		expression의 피연산자(operand)는 0 이상 999 이하의 숫자입니다.
		즉, "100-2145*458+12"처럼 999를 초과하는 피연산자가 포함된 수식은 입력으로 주어지지 않습니다.
		"-56+100"처럼 피연산자가 음수인 수식도 입력으로 주어지지 않습니다.
		expression은 적어도 1개 이상의 연산자를 포함하고 있습니다.
		연산자 우선순위를 어떻게 적용하더라도, expression의 중간 계산값과 최종 결괏값은 절댓값이 263 - 1 이하가 되도록 입력이 주어집니다.
		같은 연산자끼리는 앞에 있는 것의 우선순위가 더 높습니다.
 * */
public class PriorityOfOperator {

	public static void main(String[] args) {
		String expression = "200-300-0-0-0-500-600*40+500+500";
		System.out.println(solution(expression));
	}
	
	public static long solution(String expression) {
        long answer = 0;
        
        ArrayList<Long> 	numbers = new ArrayList<>();
        ArrayList<String> 	opers 	= new ArrayList<>();
        StringBuffer sbf = new StringBuffer();
        for(char c : expression.toCharArray()) {
        	if(Character.isDigit(c)) sbf.append(c);
        	else {
        		numbers.add(Long.parseLong(sbf.toString()));
        		sbf.setLength(0);
        		opers.add(String.valueOf(c));
        	}
        }
        numbers.add(Long.parseLong(sbf.toString()));
        
        ArrayDeque<Long> copyNums = null;
        ArrayDeque<String> copyOpers = null;
        ArrayDeque<Long> tempNums = new ArrayDeque<>();
        ArrayDeque<String> tempOpers = new ArrayDeque<>();
        
        String nowOper = "";
        long popValue = 0;
        for(Stack<String> os : makeOperList(opers)) {
        	//계산
        	copyNums 	= new ArrayDeque<>(numbers);
        	copyOpers 	= new ArrayDeque<>(opers);
        	tempNums.clear();
        	tempOpers.clear();
        	
        	while(!os.isEmpty()) {
        		//현재 우선순위 연산자
        		nowOper = os.peek();
        		if(nowOper.equals(copyOpers.peek())) {
        			long calc = calculate(copyNums.pop(), copyNums.pop(), copyOpers.pop());
        			copyNums.push(calc);
        			
        		} else {
        			if(copyOpers.isEmpty()) {
        				os.pop();
        				while(!tempNums.isEmpty()) {
            				copyNums.push(tempNums.poll());
            			}
            			while(!tempOpers.isEmpty()) {
            				copyOpers.push(tempOpers.poll());
            			}
        				continue;
        			}
        			tempOpers.push(copyOpers.pop());
        			tempNums.push(copyNums.pop());
        		}
        	}
        	popValue = Math.abs(copyNums.pop());
        	if(answer < popValue) answer = popValue;
        }
        
        return answer;
    }
	
	public static long calculate(long num1, long num2, String operator) {
		
		switch(operator) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		default:
			return 0;
		}
	}
	
	public static List<Stack<String>> makeOperList(List<String> ops) {
		List<Stack<String>> operList = new ArrayList<>();
		
		Set<String> opSet = new HashSet<String>(ops);
		List<String> remain = new ArrayList<String>(opSet);
		
		List<String> combList = new ArrayList<String>();
		makeOperListHelper(remain, "", combList);
		
		for(String os : combList) {
			Stack<String> st = new Stack<String>();
			Collections.addAll(st, os.split(""));
			operList.add(st);
		}
		
		return operList;
	}
	
	public static void makeOperListHelper(List<String> remain, String comb, List<String> combList) {
		if (remain.isEmpty()) {
			combList.add(comb);
			return;
        } else {
            for (int i = 0; i < remain.size(); i++) {
            	String next = remain.remove(i);
            	makeOperListHelper(remain, comb + next, combList);
                remain.add(i, next);
            }
        }
	}
	
	
}
