package level1;

import java.util.Arrays;

// 프로그래머스 체육복
public class GymUniform {

    public static void main(String[] args) {
        GymUniform gymUniform = new GymUniform();
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(gymUniform.solution(5, lost, reserve));

        lost = new int[]{2, 4};
        reserve = new int[]{3};
        System.out.println(gymUniform.solution(5, lost, reserve));

        lost = new int[]{3};
        reserve = new int[]{1};
        System.out.println(gymUniform.solution(3, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer;
        int cnt = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 체육복을 잃어버린 사람과 여분이 있는 사람이 같은지 체크
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    cnt++;              // 체육복이 있는 사람 추가
                    lost[i] = -1;       // 빌릴 수 없는 상태로 변환
                    reserve[j] = -1;    // 빌려줄 수 없는 상태로 변환
                    break;
                }
            }
        }

        // 여분이 있는 사람이 빌려줄 수 있는지 체크
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] != 0 && lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1 ) {
                    cnt++;              // 체육복이 있는 사람 추가
                    reserve[j] = -1;    // 빌려줄 수 없는 상태로 변환
                    break;
                }
            }
        }

        answer  = n - lost.length + cnt;

        return answer;
    }

}
