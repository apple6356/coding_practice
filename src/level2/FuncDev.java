package level2;

import java.util.*;

public class FuncDev {

    public static void main(String[] args) {
        FuncDev fd = new FuncDev();
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));

        progresses = new int[]{95, 90, 99, 99, 80, 99};
        speeds = new int[]{1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));

        progresses = new int[]{98, 99};
        speeds = new int[]{1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[0];
        List<Integer> list = new ArrayList<>();

        // 개발까지 걸리는 시간을 list에 저장
        for (int i = 0; i < progresses.length; i++) {
            for (int j = 0; ; j++) {
                if (progresses[i] >= 100) {
                    list.add(j);
                    break;
                } else progresses[i] += speeds[i];
            }
        }

        int n = 1;
        int max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            // max가 뒤의 개발 기간보다 크거나 같으면 배포되는 기능(n) +1
            if (max >= list.get(i)) {
                n++;
            }
            // max가 작으면 리턴 배열에 n 값 추가, max 교체
            else if (max < list.get(i)) {
                int s = answer.length;
                answer = Arrays.copyOf(answer, s + 1);
                answer[s] = n;
                n = 1;
                max = list.get(i);
            }
            // 마지막 반복문 일 때
            if (i == list.size() - 1) {
                int s = answer.length;
                answer = Arrays.copyOf(answer, s + 1);
                answer[s] = n;
            }
        }

        return answer;
    }
}
