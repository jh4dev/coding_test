package lvl2;

import java.awt.print.Pageable;
import java.util.*;

public class DeployFunction {

    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();

        int point = 0;
        int deployCnt = 0;

        while(true) {

            if(point < progresses.length && progresses[point] >= 100) {
                //배포 가능
                deployCnt += 1;
                point += 1;
                continue;

            } else {
                if(deployCnt > 0) {
                    answerList.add(deployCnt);
                    deployCnt = 0;
                }
            }

            if(point == progresses.length) {
                break;
            }

            //개발 진행
            for(int i = 0; i < progresses.length; i++) {
                if(progresses[i] < 100) {
                    progresses[i] += speeds[i];
                }
            }

        }

        return answerList.stream().mapToInt(i->i).toArray();
    }
}
