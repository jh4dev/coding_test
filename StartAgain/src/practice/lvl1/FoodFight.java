package practice.lvl1;

public class FoodFight {

	public static void main(String[] args) {
		
		int[] food = {1, 3, 4, 6};
		
		System.out.println(solution(food));
	}
	
	public static String solution(int[] food) {
        
        int idx = 1;
        StringBuffer sbf = new StringBuffer();

        //절반만 생성
        while(idx < food.length) {

        	if(food[idx] < 2) {
        		idx++;
        	} else {
        		sbf.append(idx);
            	food[idx] -= 2;
        	}
        }
        
        return sbf.toString() + "0" + sbf.reverse().toString();
    }
}
