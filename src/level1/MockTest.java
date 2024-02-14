package level1;

import java.util.*;

public class MockTest {

    public static void main(String[] args) {
        MockTest mt = new MockTest();
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(mt.solution(arr));
    }

    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if(arr1[i % arr1.length] == answers[i]) cnt[0]++;
            if(arr2[i % arr2.length] == answers[i]) cnt[1]++;
            if(arr3[i % arr3.length] == answers[i]) cnt[2]++;
        }

        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));   // 3개의 수 중 가장 큰 수를 찾는 것
        for (int i = 0; i < cnt.length; i++) {
            if(max == cnt[i]) answer.add(i + 1);
        }

        return answer;
    }
    
}
