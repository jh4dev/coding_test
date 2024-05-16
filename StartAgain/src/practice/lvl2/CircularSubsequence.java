package practice.lvl2;

import java.util.HashSet;
import java.util.Set;

/* 원형 수열 
 * 
 * 철호는 수열을 가지고 놀기 좋아합니다. 
 * 어느 날 철호는 어떤 자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 
 * 모두 몇 가지인지 알아보고 싶어졌습니다. 
 * 원형 수열이란 일반적인 수열에서 처음과 끝이 연결된 형태의 수열을 말합니다. 
 * 
 * 
 * 원형 수열은 처음과 끝이 연결되어 끊기는 부분이 없기 때문에 연속하는 부분 수열도 일반적인 수열보다 많아집니다.
	원형 수열의 모든 원소 elements가 순서대로 주어질 때, 
	원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 return 하도록 solution 함수를 완성해주세요.
	
	제한사항
	3 ≤ elements의 길이 ≤ 1,000
	1 ≤ elements의 원소 ≤ 1,000
 * */
public class CircularSubsequence {

	public static void main(String[] args) {
		
		int[] elements = {1,2,3,4};
		
		System.out.println(solution(elements));
	}
	
	public static int solution(int[] elements) {
        
        
        //System.arraycopy
        /*
         * params
         * 1. 원본 배열
         * 2. 원본 배열에서 복사를 시작할 위치의 인덱스
         * 3. 복사하여 생성할 배열
         * 4. 복사하여 생성할 배열에 시작 인덱스
         * 5. 복사할 요소의 개수
         * */
        
		int[] doubleArr = new int[elements.length * 2];
        // elements 의 0번부터 끝까지를 doubleArr 의 0번부터 elements 길이만큼 복사
		System.arraycopy(elements, 0, doubleArr, 0, elements.length);
		// elements 의 0번부터 끝까지를 doubleArr 의 elements 길이 번부터 elements 길이만큼 복사
        System.arraycopy(elements, 0, doubleArr, elements.length, elements.length);
        
        Set<Integer> sumSet = new HashSet<Integer>();

        int sum = 0;
        
        for(int i = 0; i < elements.length; i++) {
        	sum = 0;
        	for(int j = i; j < elements.length + i - 1; j++) {
        		sum+= doubleArr[j];
        		System.out.println(sum);
        		sumSet.add(sum);
        	}
        }
        
        // elements.length 크기의 답변 1개 고정
        return sumSet.size() + 1;
    }
}
