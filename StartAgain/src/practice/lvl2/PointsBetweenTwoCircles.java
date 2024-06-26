package practice.lvl2;

/**
 * 두 원 사이의 정수쌍
 * */
public class PointsBetweenTwoCircles {
	
	public static void main(String[] args) {
		
		int r1 = 10;
		int r2 = 20;
		
		double a = 9.9;
		System.out.println(Math.floor(a));
		System.out.println((long) a);
//		System.out.println(solution(r1, r2));
	}
	
	public static long solution(int r1, int r2) {
        
		long qt = 0;
        //피타고라스 정리 사용하여, x = i 인 y축과 평행한 축의 정수 포인트 갯수 추출
        double y1;
        double y2;
        for(int i = 1; i <= r2; i++) {
        	y1 = getHeightIntValue(r1, i);
        	y2 = getHeightIntValue(r2, i);
        	qt += ((long)Math.floor(y2) - (long)Math.floor(y1));
        	
        	//작은 원의 포인트가 정수인 경우 + 1
        	if(Math.floor(y1) == y1) {
        		qt +=1;
        	}
        	//작은 원의 범위 밖인 경우, 
        	if(i > r1) {
        		qt += 1;
        	}
        }
        
        return qt * 4;
    }
	
	public static double getHeightIntValue(int radius, int x) {
		//반지름과 x축으로 높이 산출
		return Math.sqrt((long)radius * radius - (long)x * x);
	}
}
