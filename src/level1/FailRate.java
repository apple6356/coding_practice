package level1;

import java.util.*;

public class FailRate {

    public static void main(String[] args) {
        FailRate failRate = new FailRate();
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(failRate.solution(N, stages)));
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> rate = new LinkedHashMap<>();  // 실패율을 저장하는 Map
        int count;  // stage에 도달하지 못하는 유저수를 체크하는 변수
        double v;   // double 계산을 쉽게 하기 위해 작성

        // 실패율 계산 반복문
        for (int i = 1; i <= N; i++) {
            rate.put(i, 0.0);
            count = 0;
            for (int j : stages) {
                if (i == j) {
                    v = rate.get(i) + 1;
                    rate.replace(i, v);  // 해당 stage에 도달한 유저 체크
                }
                if (i > j) count++; // 해당 stage에 도달하지 못한 유저를 센다.
            }
            v = rate.get(i) / (stages.length - count);
            rate.replace(i, v);
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = i + 1; j < answer.length; j++) {

            }
        }

        return answer;
    }

}
