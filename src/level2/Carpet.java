package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carpet {

    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        System.out.println(Arrays.toString(carpet.solution(10, 2)));
        System.out.println(Arrays.toString(carpet.solution(8, 1)));
        System.out.println(Arrays.toString(carpet.solution(24, 24)));
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        List<Integer> yellowDivisor = new ArrayList<>();    // 노란색의 약수 모음

        // 노란색의 약수 저장
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) yellowDivisor.add(i);
        }

        for (int i = 0; i < yellowDivisor.size(); i++) {
            // 약수가 1개 밖에 없을 때
            if (yellowDivisor.size() == 1) {
                answer[0] = (int) Math.sqrt(sum);
                answer[1] = (int) Math.sqrt(sum);
                break;
            }
            // 노란색의 (가로 * 2) + (세로 * 2) + 4 가 갈색과 같을 때
            else if (((yellowDivisor.get(i) * 2) + (yellowDivisor.get((yellowDivisor.size() - 1) - i) * 2) + 4) == brown) {
                answer[0] = yellowDivisor.get((yellowDivisor.size() - 1) - i) + 2;
                answer[1] = yellowDivisor.get(i) + 2;
                break;
            }
        }

        return answer;
    }

}
