package practice.lvl2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 콜라츠 추측 (우박수열 정적분)
 * 
 * 콜라츠 추측이란 로타르 콜라츠(Lothar Collatz)가 1937년에 제기한 추측으로 모든 자연수 k에 대해 다음 작업을 반복하면 항상 1로 만들 수 있다는 추측입니다.

1-1. 입력된 수가 짝수라면 2로 나눕니다.
1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
2.결과로 나온 수가 1보다 크다면 1번 작업을 반복합니다.
예를 들어 주어진 수가 5 라면 5 ⇒ 16 ⇒ 8 ⇒ 4 ⇒2 ⇒ 1 이되어 총 5번만에 1이 됩니다.

수가 커졌다 작아지기를 반복하는 모습이 비구름에서 빗방울이 오르락내리락하며 우박이 되는 모습과 비슷하다고 하여 우박수 또는 우박수열로 불리기도 합니다.
 현재 이 추측이 참인지 거짓인지 증명되지 않았지만 약 1해까지의 수에서 반례가 없음이 밝혀져 있습니다.

은지는 우박수열을 좌표 평면 위에 꺾은선 그래프로 나타내보려고 합니다. 
초항이 k인 우박수열이 있다면, x = 0일때 y = k이고 다음 우박수는 x = 1에 표시합니다. 
이런 식으로 우박수가 1이 될 때까지 점들을 찍고 인접한 점들끼리 직선으로 연결하면 다음과 같이 꺾은선 그래프를 만들 수 있습니다.
 은지는 이렇게 만든 꺾은선 그래프를 정적분 해보고 싶어졌습니다. x에 대한 어떤 범위 [a, b]가 주어진다면 
 이 범위에 대한 정적분 결과는 꺾은선 그래프와 x = a, x = b, y = 0 으로 둘러 쌓인 공간의 면적과 같습니다. 
 은지는 이것을 우박수열 정적분이라고 정의하였고 다양한 구간에 대해서 우박수열 정적분을 해보려고 합니다.
  0 이상의 수 b에 대해 [a, -b]에 대한 정적분 결과는 x = a, x = n - b, y = 0 으로 둘러 쌓인 공간의 면적으로 정의하며, 
  이때 n은 k가 초항인 우박수열이 1이 될때 까지의 횟수를 의미합니다.

예를 들어, 5를 초항으로 하는 우박수열은 5 ⇒ 16 ⇒ 8 ⇒ 4 ⇒ 2 ⇒ 1 입니다. 이를 좌표 평면으로 옮기면 (0, 5), (1, 16), (2, 8), (3, 4), (4, 2), (5, 1) 에 점이 찍히고 
점들을 연결하면 꺾은선 그래프가 나옵니다. 
이를 [0,0] 구간에 대해 정적분 한다면 전체 구간에 대한 정적분이며, [1,-2] 구간에 대해 정적분 한다면 1 ≤ x ≤ 3인 구간에 대한 정적분입니다.

우박수의 초항 k와, 정적분을 구하는 구간들의 목록 ranges가 주어졌을 때 정적분의 결과 목록을 return 하도록 solution을 완성해주세요. 
단, 주어진 구간의 시작점이 끝점보다 커서 유효하지 않은 구간이 주어질 수 있으며 이때의 정적분 결과는 -1로 정의합니다.
 * */
public class CollatzGuess {	
	
	public static void main(String[] args) {
		
		int k = 5;
		int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
		
		System.out.println(Arrays.toString(solution(k, ranges)));
	}
	
	public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        //x 좌표, [y좌표, 넓이]
        Map<Integer, double[]> pointMap = new HashMap<>();
        
        int cnt = 0;
        pointMap.put(cnt++, new double[] {k, 0});
        
        getCollatz(k, cnt, pointMap);
        
        for(int i = 0; i < pointMap.size(); i++) {
        	System.out.println(i + " : " + Arrays.toString(pointMap.get(i)));
        }
        //n번만에 1이 됨
        int n = pointMap.size() - 1;
        int from, to;
        double sum;
        for(int i = 0; i < answer.length; i++) {
        	
        	from = ranges[i][0];
        	to = n + ranges[i][1];
        	
        	if(from > to) {
        		answer[i] = -1.0;
        		continue;
        	}
        	sum = 0;
        	for(int j = from+1; j <= to; j++) {
        		
        		sum += pointMap.get(j)[1];
        	}
        	
        	answer[i] = sum;
        	sum = 0;
        }
        
        return answer;
    }
	
	public static void getCollatz(int k, int cnt, Map<Integer, double[]> pointMap) {
		
		if(k == 1) return;
		
		if(k % 2 == 0) {
			pointMap.put(cnt, new double[] {k/2, k/2 + 0.5*(k - k/2)});
			getCollatz(k/2, cnt+1, pointMap);
			
		} else if(k % 2 == 1) {
			pointMap.put(cnt, new double[] {(k * 3 + 1), k + 0.5*(k*3+1 - k)});
			getCollatz(k * 3 + 1, cnt+1, pointMap);
		}
	}
}
