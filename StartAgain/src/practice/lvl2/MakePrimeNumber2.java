package practice.lvl2;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

	각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
	종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
	
	제한사항
	numbers는 길이 1 이상 7 이하인 문자열입니다.
	numbers는 0~9까지 숫자만으로 이루어져 있습니다.
	"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
	
	11과 011은 같은 숫자로 취급합니다.
 * */

public class MakePrimeNumber2 {
	
    public static void main(String[] args) {
        int[] digits = {1, 3, 0, 1, 3, 4, 5};
        Set<Integer> primes = generatePrimesFromDigits(digits);
        
        System.out.println("Generated prime numbers: " + primes.size());
    }

    public static Set<Integer> generatePrimesFromDigits(int[] digits) {
        Set<Integer> primes = new HashSet<>();
        boolean[] used = new boolean[digits.length];
        generateNumbers(digits, used, new StringBuilder(), primes);
        return primes;
    }

    private static void generateNumbers(int[] digits, boolean[] used, StringBuilder current, Set<Integer> primes) {
        if (current.length() > 0) {
            int number = Integer.parseInt(current.toString());
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        
        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.append(digits[i]);
                generateNumbers(digits, used, current, primes);
                current.deleteCharAt(current.length() - 1);
                used[i] = false;
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
