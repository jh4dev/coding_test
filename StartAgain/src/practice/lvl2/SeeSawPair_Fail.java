package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 시소 짝꿍
 * 
 * 어느 공원 놀이터에는 시소가 하나 설치되어 있습니다. 이 시소는 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에 좌석이 하나씩 있습니다.
	이 시소를 두 명이 마주 보고 탄다고 할 때, 시소가 평형인 상태에서 각각에 의해 시소에 걸리는 토크의 크기가 서로 상쇄되어 완전한 균형을 이룰 수 있다면 그 두 사람을 시소 짝꿍이라고 합니다. 
	즉, 탑승한 사람의 무게와 시소 축과 좌석 간의 거리의 곱이 양쪽 다 같다면 시소 짝꿍이라고 할 수 있습니다.
	사람들의 몸무게 목록 weights이 주어질 때, 시소 짝꿍이 몇 쌍 존재하는지 구하여 return 하도록 solution 함수를 완성해주세요.

제한 사항
	2 ≤ weights의 길이 ≤ 100,000
	100 ≤ weights[i] ≤ 1,000
	몸무게 단위는 N(뉴턴)으로 주어집니다.
	몸무게는 모두 정수입니다.	
 * */
public class SeeSawPair_Fail {

	public static void main(String[] args) {
	
		int[] weights = {100,180,360,100,270,200};
		
		System.out.println(solution(weights));
	}
	
	public static long solution(int[] weights) {
        
		long answer = 0;
        Arrays.sort(weights);
        
        //최대공약수로 접근?
        //최대공약수로 나눈 몫이 1/2/3/4 이면 pair
        //오래걸릴거같은데...
        List<Long> quotients = new ArrayList<>();
        quotients.add(1l);
        quotients.add(2l);
        quotients.add(3l);
        quotients.add(4l);
        
        long gcd = 0;
        long q1, q2;
        for(int i = 0; i < weights.length - 1; i++) {
        	for(int j = i + 1; j < weights.length; j++) {
        		gcd = getGCD(weights[i], weights[j]);
        		if(gcd == 1) {
        			continue;
        		}
        		q1 = weights[i]/gcd;
        		q2 = weights[j]/gcd;
        	
        		
        		if(quotients.contains(q1) && quotients.contains(q2)) {
        			answer++;
        		}
        	}
        }
       
        return answer;
    }
	
	public static long getGCD(long a, long b) {
        if (a % b == 0) {
            return b;
        }

        return getGCD(b, a%b);
    }
}
