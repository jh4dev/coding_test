package sample;

import java.util.HashSet;

public class FindCombination {

	public static void main(String[] args) {
		
		
		System.out.println(findAllCombinations("a", "b", "c"));
	}
	
	// 세 개의 문자열로 만들 수 있는 모든 조합을 찾는 함수
    public static HashSet<String> findAllCombinations(String str1, String str2, String str3) {
        HashSet<String> combinations = new HashSet<>();
        findAllCombinationsHelper("", str1 + str2 + str3, combinations);
        return combinations;
    }

    // 재귀적으로 모든 조합을 찾는 보조 함수
    private static void findAllCombinationsHelper(String prefix, String suffix, HashSet<String> combinations) {
        int n = suffix.length();
        // 재귀 종료 조건: suffix의 길이가 0이면 prefix를 combinations에 추가
        if (n == 0) {
            combinations.add(prefix);
        } else {
            // suffix의 각 문자에 대해 반복하여 새로운 prefix와 새로운 suffix로 재귀 호출
            for (int i = 0; i < n; i++) {
                findAllCombinationsHelper(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, n), combinations);
            }
        }
    }
}
