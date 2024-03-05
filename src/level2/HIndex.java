package level2;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {

    public static void main(String[] args) {
        HIndex hi = new HIndex();
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(hi.solution(citations));
        citations = new int[]{6, 5, 5, 5, 3, 2, 1, 0};
        System.out.println(hi.solution(citations));
        citations = new int[]{5, 5, 5, 5};
        System.out.println(hi.solution(citations));
        citations = new int[]{22, 42};
        System.out.println(hi.solution(citations));
        citations = new int[]{20, 19, 18, 1};
        System.out.println(hi.solution(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = citations.length - 1; i >= 0; i--) {
            int k = 0;
            int l = 0;
            for (int j = citations.length - 1; j >= 0; j--) {
                if (citations[i] < citations[j]) k++;
                else if (citations[i] > citations[j]) l++;
            }
            if (k >= citations[i] && l <= citations[i]) {
                answer = k;
                break;
            }
            if (citations[i] >= citations.length) {
                answer = citations.length;
            }
        }

        return answer;
    }
}
