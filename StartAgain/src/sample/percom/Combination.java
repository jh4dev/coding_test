package sample.percom;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    
    public static List<List<String>> getCombinations(List<Integer> nums, int k) {
        List<List<String>> result = new ArrayList<>();
        backtrack(nums, k, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(List<Integer> nums, int k, int start, List<String> tempList, List<List<String>> result) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.size(); i++) {
                tempList.add(String.valueOf(nums.get(i)));
                backtrack(nums, k, i + 1, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        int k = 2;  // 조합의 크기

        List<List<String>> combinations = getCombinations(nums, k);
        for (List<String> combination : combinations) {
            System.out.println(combination);
        }
    }
}
