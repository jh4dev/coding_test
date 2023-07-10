package lvl2;

public class TargetNumber_DFS {

    public static void main(String[] args) {

        int[] numbers = {1,2,3};
        int target = 0;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {

        return dfs(numbers, target, 0, 0);
    }

    private static int dfs(int[] numbers, int target, int sum, int idx) {

        int result = 0;

        if(idx == numbers.length) {
            if(sum == target) {
                return 1;
            } else return 0;
        }

        result += dfs(numbers, target, sum + numbers[idx], idx + 1);
        result += dfs(numbers, target, sum + numbers[idx] * -1, idx + 1);

        return result;
    }
}
