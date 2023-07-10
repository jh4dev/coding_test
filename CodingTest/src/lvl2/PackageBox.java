package lvl2;

import java.util.Stack;

//택배상자 
public class PackageBox {

	public static void main(String[] args) {
		
		int[] order = {4, 3, 1, 2, 5};
//		int[] order = {5, 4, 3, 2, 1};
		System.out.println(solution(order));
	}
	
	public static int solution(int[] order) {
		
		int answer = 0;
		Stack<Integer> tmpStack = new Stack<>();
		
		int ordIdx = 0;
		
		for(int i = 1; i <= order.length; i++) {
			
			if(order[ordIdx] == i) {
				answer+=1;
				ordIdx+=1;
				
				while(!tmpStack.isEmpty() && tmpStack.peek() == order[ordIdx]) {
					tmpStack.pop();
					answer+=1;
					ordIdx+=1;
				}
			} else {
				tmpStack.push(i);
			}
		}
		
		
		return answer;
	}
}
