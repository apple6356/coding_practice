package level2;

import java.util.Arrays;

public class NSquare2 {

    public static void main(String[] args) {
        NSquare2 ns = new NSquare2();
        System.out.println(Arrays.toString(ns.solution(3, 2, 5)));
        System.out.println(Arrays.toString(ns.solution(4, 7, 14)));
    }

    public int[] solution(int n, long left, long right) {
        int m = (int) (right - left);
        int[] answer = new int[m + 1];
        int[] arr2 = new int[n * n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int max = Math.max(i, j);
                arr2[idx++] = max + 1;
            }
        }

        for (int i = 0; i <= m; i++) {
            answer[i] = arr2[(int) left + i];
        }

        return answer;
    }
}
