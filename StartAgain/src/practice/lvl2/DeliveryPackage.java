package practice.lvl2;

/**
 * 택배 배달 수거
 * 
 * 접근법
 * 1. Greedy
 * 		a. 배송지 or 수거지 중 가장 멀리있는 곳부터 가야함
 * 		b. 출발하며 cap 만큼 싣고 a 위치까지 이동 
 * 			b-1. 가장 멀리있는 배송지로부터 차감을 시키나, 실질적으로는 멀리있는 배송지로 가면서 하차
 * 				ex) cap = 4 / deliveries = {1, 1, 2, 2, 1} --> {1, 1, 1, 0, 0}
 * 			b-2. 가장 멀리있는 수거지부터 cap개 채워서 복귀
 * 
 * */
public class DeliveryPackage {

	public static void main(String[] args) {
		
		int cap = 2;
		int n = 2;
		int[] deliveries 	= {};
		int[] pickups 		= {};
		
		System.out.println(solution(cap, n, deliveries, pickups));
	}
	
	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        //Greedy
        //남은 갯수 / cap개 Min 싣고 출발 > 뒤에서부터 없애지만 제일 이동 거리는 제일 마지막 칸
        //배송 후, 가장 마지막 수거 상자부터 cap개 채워서 복귀
        
        long distance = 0;
        
        int dLast = deliveries.length - 1;
        int pLast = pickups.length - 1;
        
        int dSum = 0;
        int pSum = 0;
        
        while(true) {
        	
        	//가장 멀리있는 배송지 / 수거지 탐색
        	dLast = findLastHomeIndex(deliveries, dLast);
        	pLast = findLastHomeIndex(pickups, pLast);
        	
            //모두 탐색 후 종료
        	if(dLast == 0 && deliveries[dLast] == 0 && pLast == 0 && pickups[pLast] == 0) {
        		break;
        	}
            
        	//거리 계산 (집은 1부터 시작하므로 +1)
        	distance += (Math.max(dLast, pLast) + 1) * 2;
        	
        	dSum = 0;
        	pSum = 0;
        	
        	//배송 진행
        	while(dSum < cap && deliveries[dLast] > 0) {
        		dSum += 1;
        		deliveries[dLast] -= 1;
        		
        		if(deliveries[dLast] == 0) {
        			dLast = findLastHomeIndex(deliveries, dLast);
        		}
        	}
        	
        	//수거 진행
        	while(pSum < cap && pickups[pLast] > 0) {
        		pSum += 1;
        		pickups[pLast] -= 1;
        		
        		if(pickups[pLast] == 0) {
        			pLast = findLastHomeIndex(pickups, pLast);
        		}
        	}
        }
        
        return distance;
    }
	
	//배송,수거 배열의 0이 아닌 마지막 인덱스 확인
	public static int findLastHomeIndex(int[] array, int lastIdx) {
		while(lastIdx > 0 && array[lastIdx] == 0) {lastIdx--;}
		return lastIdx;
	}
}
