package level1;

import java.util.Arrays;

public class LottoMaxMin {

    public static void main(String[] args) {
        LottoMaxMin lottoMaxMin = new LottoMaxMin();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(lottoMaxMin.solution(lottos, win_nums)));
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int win_cnt = 0;
        int zero_cnt = 0;

        // 당첨된 수와 빈 칸을 센다
        for (int i : lottos) {
            for (int j : win_nums) {
                if (j == i) win_cnt++;
            }
            if (i == 0) zero_cnt++;
        }

        answer[0] = min_Max(win_cnt + zero_cnt);
        answer[1] = min_Max((win_cnt));

        return answer;
    }

    /*
    * 몇 등인지 알려주는 기능
    * */
    public int min_Max(int num) {
        switch (num) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }

}
