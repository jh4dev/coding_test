package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination2 {
	public static void main(String[] args) {
        Set<String> sets = new HashSet<>(Arrays.asList("+", "-", "*"));
        List<String> combinations = getAllCombinations(sets);
        
        System.out.println(combinations);
    }

    public static List<String> getAllCombinations(Set<String> sets) {
        List<String> result = new ArrayList<>();
        getAllCombinationsHelper(new ArrayList<>(sets), "", result);
        return result;
    }

    private static void getAllCombinationsHelper(List<String> remaining, String current, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(current);
        } else {
            for (int i = 0; i < remaining.size(); i++) {
                String next = remaining.remove(i);
                getAllCombinationsHelper(remaining, current + next, result);
                remaining.add(i, next);
            }
        }
    }
}
