package level1;

import java.util.Arrays;

public class Bubget {
    public static void main(String[] args) {
        Bubget bg = new Bubget();
        int[] d = { 1, 3, 2, 5, 4 };
        int budget = 9;
        System.out.println(bg.solution(d, budget));

        int[] d2 = { 2, 2, 3, 3 };
        budget = 10;
        System.out.println(bg.solution(d2, budget));
    }

    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        int cnt = 0;

        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            cnt++;
        }

        while (sum > budget) {
            if (sum > budget) {
                sum -= d[cnt-1];
                cnt--;
            }
        }

        return answer = cnt;
    }
}
