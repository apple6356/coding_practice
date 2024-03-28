package level2;

import java.util.*;

public class Hotter {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(scoville, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        // 우선순위 큐 사용 java에서 heap은 우선순위 큐를 사용하면 됨
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.offer(i);
        }

        while (pq.peek() < K) {
            // 조건을 맞출 수 없다면 -1
            if (pq.size() == 1 && pq.peek() < K) {
                answer = -1;
                break;
            }
            int n = pq.poll();
            n += pq.poll() * 2;
            pq.add(n);
            answer++;
        }

        return answer;
    }
}
