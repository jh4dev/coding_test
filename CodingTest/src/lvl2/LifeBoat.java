package lvl2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LifeBoat {

    public static void main(String[] args) {

        int[] people = {40, 50, 60, 70, 80, 90, 100, 110, 120};
        int limit = 200;

        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {

        // people : 사람들의 몸무게 배열
        // limit : 보트 당 제한 무게
        // 투포인터로 해결?

        int answer = 0;

        //1. people 내림차순 정렬
        Integer[] integerArray = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArray, Collections.reverseOrder());

        //2. 루프 (시작 인덱스 ++/ 끝 인덱스 --)
        int start = 0;
        int end = integerArray.length - 1;
        int peopleCnt = 0;

        while(!(peopleCnt == people.length)) {
            answer++;

            if(start == end) {
                peopleCnt++;
                break;
            }

            if(integerArray[start] + integerArray[end] <= limit) {
                peopleCnt += 2;
                start++;
                end--;
            } else {
                peopleCnt++;
                start++;
            }
        }

        return answer;
    }

}
