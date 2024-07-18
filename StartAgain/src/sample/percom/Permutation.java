package sample.percom;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static List<List<String>> getPermutations(List<Integer> nums, int k) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.size()];
        backtrack(nums, k, new ArrayList<>(), result, used);
        return result;
    }

    private static void backtrack(List<Integer> nums, int k, List<String> tempList, List<List<String>> result, boolean[] used) {
        if (tempList.size() == k) {
        	System.out.println(tempList);
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if (used[i]) continue; // Element already used, skip
                used[i] = true;
                tempList.add(String.valueOf(nums.get(i)));
                backtrack(nums, k, tempList, result, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        int k = 3;  // 순열의 길이

        List<List<String>> permutations = getPermutations(nums, k);
        for (List<String> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
