package practice.lvl3;

import java.util.Arrays;

public class CheckCamera {

	public static void main(String[] args) {
		
		int[][] routes = {{-100, 100}, {50, 170}, {150, 200}, {-50, -10}, {10, 20}, {30, 40}};
		
		System.out.println(solution(routes));
		System.out.println(solution2(routes));
	}
	
	public static int solution(int[][] routes) {
        int answer = 0;
        
        //시작점이 작은 순, 같으면 종료가 작은 순으로 정렬
        Arrays.sort(routes, (o1, o2) -> {
        	int compare = o1[0] - o2[0];
        	if(compare == 0) {
        		return o1[1] - o2[1];
        	}
        	return compare;
        });
        
        int end = routes[0][1];
        
        int[] r;
        for(int i = 1; i < routes.length; i++) {
        	r = routes[i];

        	if(r[0] > end) {
        		//기존 진출 지점이, 새 자동차의 진입 지점보다 작은 경우, 기존 진출 지점에 카메라 설치 후 새로운 진출 지점 설정
        		answer++;
        		end = r[1];
        	} else {
        		//기존 진출 지점이, 새 자동차의 진입 지점보다 큰 경우, 다음 탐색에 사용할 진출 지점을 가까운 진출 지점으로 설정
        		end = Math.min(end, r[1]);
        	}
        }
        
        return answer + 1;
    }
	
	public static int solution2(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes,(o1,o2)->(o1[1]-o2[1]));
        System.out.println(Arrays.deepToString(routes));
        
        int max = routes[0][1];

        for(int i=1;i<routes.length;i++){
            if(routes[i][0]<=max && routes[i][1]>=max){
                continue;
            }else{
                max = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
