package lvl1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubSequence {

    public static void main(String[] args) {

        int seq[] = {1,1,1,2,3,4,5};
        int k = 5;

        System.out.println(Arrays.toString(solution(seq, k)));
    }

    //Two Pointer
    public static int[] solution(int[] sequence, int k) {

        int lp = 0;
        int rp = 0;

        int sum = sequence[lp];

        List<int[]> answers = new ArrayList<>();

        while(rp < sequence.length && lp <= rp) {

            if(sum == k) {
                answers.add(new int[]{lp, rp});
            }
            if (sum <= k) {
                rp++;
                if(rp < sequence.length) sum += sequence[rp];
            } else if (sum > k) {
                if(lp < sequence.length) sum -= sequence[lp];
                lp++;
            }
        }

        answers.sort((o1, o2) -> (o2[1] - o2[0]) == (o1[1] - o1[0]) ? o1[0] - o2[0] : -1
        );

        return answers.get(0);
    }

    public static void print(List<int[]> ans) {

        for(int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }
}
