package level2;

import java.util.*;

public class Process {

    public static void main(String[] args) {
        int[] priorities = new int[]{2, 1, 3, 2};
        System.out.println(solution(priorities, 2));

        priorities = new int[]{1, 1, 9, 1, 1, 1};
        System.out.println(solution(priorities, 0));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        // PriorityQueue(우선순위 큐) 사용해 푸는 방법 존재
        Queue<Integer> queue = new LinkedList<>();  // 우선순위 저장할 큐
        List<Integer> list = new ArrayList<>(); // 큐는 인덱스로 접근 불가 하기 때문에 큐의 순서 저장

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
            list.add(i);
        }

        while (!queue.isEmpty()) {
            boolean b = true;   // 우선순위가 높은 프로세스가 있는지 확인
            int peek = queue.poll();    // 큐의 첫 값을 저장
            int current = list.get(0);  // 큐의 첫 값의 인덱스
            list.remove(0);

            for (int i = 0; i < list.size(); i++) {
                // 우선순위가 더 높은 프로세스가 있는지 확인
                if (peek < priorities[list.get(i)]) {
                    queue.offer(peek);  // 큐의 제일 뒤로 이동
                    list.add(current);
                    b = false;
                    break;
                }
            }

            // 우선순위가 더 높은 값이 없고, 현재 값이 목표 값일때
            if (b && current == location) {
                answer++;
                return answer;
            } else if (b) { // 우선순위가 높은 값은 없지만 현재 값이 목표 값이 아닐 때
                answer++;
            }
        }

        return answer;
    }

}
