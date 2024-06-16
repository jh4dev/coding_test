package practice.lvl2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 숫자 카드 나누기
 * 
 * 철수와 영희는 선생님으로부터 숫자가 하나씩 적힌 카드들을 절반씩 나눠서 가진 후, 
 * 다음 두 조건 중 하나를 만족하는 가장 큰 양의 정수 a의 값을 구하려고 합니다.

	철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고 영희가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
	영희가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 철수가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
	예를 들어, 카드들에 10, 5, 20, 17이 적혀 있는 경우에 대해 생각해 봅시다. 만약, 철수가 [10, 17]이 적힌 카드를 갖고, 영희가 [5, 20]이 적힌 카드를 갖는다면 두 조건 중 하나를 만족하는 양의 정수 a는 존재하지 않습니다. 하지만, 철수가 [10, 20]이 적힌 카드를 갖고, 영희가 [5, 17]이 적힌 카드를 갖는다면, 철수가 가진 카드들의 숫자는 모두 10으로 나눌 수 있고, 영희가 가진 카드들의 숫자는 모두 10으로 나눌 수 없습니다. 따라서 철수와 영희는 각각 [10, 20]이 적힌 카드, [5, 17]이 적힌 카드로 나눠 가졌다면 조건에 해당하는 양의 정수 a는 10이 됩니다.
	
	철수가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayA와 영희가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayB가 주어졌을 때, 주어진 조건을 만족하는 가장 큰 양의 정수 a를 return하도록 solution 함수를 완성해 주세요. 만약, 조건을 만족하는 a가 없다면, 0을 return 해 주세요.

제한사항
	1 ≤ arrayA의 길이 = arrayB의 길이 ≤ 500,000
	1 ≤ arrayA의 원소, arrayB의 원소 ≤ 100,000,000
	arrayA와 arrayB에는 중복된 원소가 있을 수 있습니다.
	
 * */
public class SeperateNumberCard {

	public static void main(String[] args) {
		
		int[] arrayA = {10, 17};
		int[] arrayB = {5,20};
		
		System.out.println(solution(arrayA, arrayB));
	}
	
	public static int solution(int[] arrayA, int[] arrayB) {
      
		if(arrayA.length == 1) {
			return arrayA[0] == arrayB[0] ? 0 : Math.max(arrayA[0], arrayB[0]);
		}
		
		Integer[] arrA = Arrays.stream(arrayA).boxed().toArray(Integer[]::new);
		Integer[] arrB = Arrays.stream(arrayB).boxed().toArray(Integer[]::new);
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		int gcdA = arrA[0];
		int gcdB = arrB[0];
		
		for(int i = 1; i < arrA.length; i++) {
			gcdA = getGCD(gcdA, arrA[i]);
			gcdB = getGCD(gcdB, arrB[i]);
		}	
		
		int maxA = 0;
		int maxB = 0;
		for(int i = 0; i < arrA.length; i++) {
			if(gcdA != 1 && arrB[i] % gcdA != 0) {
    		   maxA = gcdA;
			} else {
				maxA = 0;
				break;
			}
		}
		
		for(int i = 0; i < arrB.length; i++) {
			if(gcdB != 1 && arrA[i] % gcdB != 0) {
    		   maxB = gcdB;
			} else {
				maxB = 0;
				break;
			}
		}	
		return Math.max(maxA, maxB);
    }
	
	//최대공약수
	public static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a%b);
    }
	
	public static List<Integer> getDivisor(int number) {
		
		List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
            	//모든 수의 약수인 1 제외
            	if(i > 1) {
            		divisors.add(i);
            	}
                if (i != number / i) {
                    divisors.add(number / i);
                }
            }
        }
        divisors.sort((o1, o2) -> o1-o2);
        return divisors;
	}
}
