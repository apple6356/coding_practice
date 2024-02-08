package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class NonNumAdd {
    public static void main(String[] args) {
        NonNumAdd nna = new NonNumAdd();
        int[] nums = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(nna.solution(nums));
    }

    public int solution(int[] numbers) {
        int answer = 0;
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == numbers[i]) {
                    arr[j] = -1;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer += (arr[i] != -1) ? arr[i] : 0;
        }

        return answer;
    }

/*  다른 사람의 풀이
    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
    */
}
