package level1;

import java.util.*;

public class NumAddSort {

    public static void main(String[] args) {
        NumAddSort nas = new NumAddSort();
        int[] arr = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(nas.solution(arr)));
        int[] arr2 = {5, 0, 2, 7};
        System.out.println(Arrays.toString(nas.solution(arr2)));
    }

    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int n = numbers[i] + numbers[j];
                if (list.isEmpty() || !list.contains(n)) {
                    list.add(n);
                }
            }
        }

        int[] answer = new int[list.size()];
        int cnt = 0;
        for (int i : list) {
            answer[cnt++] = i;
        }
//        int[] answer = list.stream().mapToInt(i -> i).toArray();

        /**정렬*/
        for (int i = 0; i < answer.length - 1; i++) {
            for (int j = i + 1; j < answer.length; j++) {
                if (answer[i] > answer[j]) {
                    int temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;
                }
            }
        }

        return answer;
    }

}
