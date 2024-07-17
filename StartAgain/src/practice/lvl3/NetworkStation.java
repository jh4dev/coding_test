package practice.lvl3;

public class NetworkStation {

	public static void main(String[] args) {
		
		int n = 5;
		int w = 1;
		int[] stations = {1,2,3,4,5};
		
		System.out.println(solution(n, stations, w));
	}
	
	public static int solution(int n, int[] stations, int w) {
        int answer = 0;

        //n : 아파트 개수
        //stations : 현재 4g 기지국이 설치된 아파트 배열 정보
        //w : 전파의 도달 거리

        //기지국이 커버하는 범위
        int coverage = 2 * w + 1;
        //전파가 닿지 않는 범위의 시작점
        int nonStart = 1;
        
        //설치된 기지국 기준, 신호가 닿는 마지막 앞쪽 아파트
        int front;
        
        for(int i = 0; i < stations.length; i++) {
        	
        	front = stations[i] - w;
        	
        	if(nonStart < front) {
        		answer += (front - nonStart) / coverage;
        		if((front - nonStart) % coverage > 0) {
        			answer++;
        		}
        		
        	}
        	nonStart = stations[i] + w + 1;
        }
        
        //마지막 설치위치 확인
        if(nonStart <= n) {
        	answer += (n - nonStart + 1) / coverage;
        	if((n - nonStart + 1) % coverage > 0) {
        		answer++;
        	}
        }
        
        return answer;
    }
}
