package lvl2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class HeapSortPriorityQueue {


    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {

        int answer = 0;

        /*
        *   scoville의 길이는 2 이상 1,000,000 이하입니다.
            K는 0 이상 1,000,000,000 이하입니다.
            scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
            모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
        * */

        // 2 <= scoville.length <= 1000000
        // 0 <= K <= 1000000000
        // 0 <= scoville[] <= 1000000

        PriorityQueue<Integer> pq = Arrays.stream(scoville)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        int first, second, newFood;

        while(true) {

            // 모든 음식이 K 보다 스코빌 지수가 높은 경우 -> 큐 가장 앞 음식이 K보다 큰 경우
            if(pq.peek() >= K) {
                break;
            }
            // scoville.length == 2 인데, 큐 가장 앞 음식이 K보다 작은 경우
            if(pq.size() == 1 && pq.peek() < K) {
                answer = -1;
                break;
            }

            answer += 1;

            first = pq.poll();
            second = pq.poll();

            //최소 힙 first = 최소값 보장
            newFood = first + (second * 2);
            pq.offer(newFood);

        }
        return answer;
    }

}
