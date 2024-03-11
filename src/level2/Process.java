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

        int i = 0;
        boolean b = true;
        while (b) {
            if (i >= priorities.length) i = 0;

            for (int j = i + 1; j < priorities.length; j++) {
                if (priorities[i] < priorities[j]) {
                    System.out.println("i = " + i + ", j = " + j);
                    i = j;
                    break;
                } else if (j >= priorities.length - 1 && i == location) {
                    System.out.println("e1 answer = " + answer + ", i = " + i + ", j = " + j);
                    priorities[i] = -1;
                    answer++;
                    b = false;
                } else if (j >= priorities.length - 1) {
                    System.out.println("e2 answer = " + answer + ", i = " + i + ", j = " + j);
                    priorities[i] = -1;
                    answer++;
                    i++;
                }
            }
        }
        return answer;
    }

}
