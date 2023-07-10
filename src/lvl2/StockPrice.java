package lvl2;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StockPrice {

	public static void main(String[] args) {
		
		int prices[] = {1, 2, 3, 2, 3}; 
		System.out.println(Arrays.toString(solution(prices)));
	}
	
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		Stack<int[]> stockStack = new Stack<>();
		// int[] -> prices index / prices value
		int[] stock = {};
		
		for(int i = 0; i < prices.length; i++) {
			
			while(!stockStack.isEmpty() && prices[i] < stockStack.peek()[1]) {
				stock = stockStack.pop();
				answer[stock[0]] = i - stock[0];
			}
			
			stockStack.push(new int[] {i, prices[i]});
		}
		
		while(!stockStack.isEmpty()) {
			stock = stockStack.pop();
			answer[stock[0]] = prices.length - 1 - stock[0];
		}
		
		return answer;
		
	}
	
	//스택에 가격과 시점을 쌍으로 적용.
	public static int[] solution2(int[] prices) {
        int[] res = new int[prices.length];
        Stack<List<Integer>> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            while (!stack.isEmpty() && prices[i] < stack.peek().get(0)){
                List<Integer> pair = stack.pop();
                res[pair.get(1)] = i - pair.get(1);
            }
            stack.push(List.of(prices[i], i));
        }

        while (!stack.isEmpty()){
            List<Integer> pair = stack.pop();
            res[pair.get(1)] = prices.length - pair.get(1) - 1;
        }

        return res;
    }

	public static int[] solution1(int[] prices) {
		
		int answer[] = new int[prices.length];
		
		int tmpPrices[] = {};
		
		for(int i = 0; i < prices.length; i++) {
		
			tmpPrices = Arrays.copyOfRange(prices, i + 1, prices.length);
			
			for(int j = 0; j < tmpPrices.length; j++) {
				if(tmpPrices[j] < prices[i]) {
					answer[i] = j + 1;
					break;
				}
				
				if(j == tmpPrices.length - 1) {
					answer[i] = tmpPrices.length;
				}
			}
		}
		
		return answer;
	}
}
