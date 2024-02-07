package level1;

import java.util.Arrays;

public class NaturalNumReverse {
    public static void main(String[] args) {
        NaturalNumReverse na = new NaturalNumReverse();
        System.out.println(Arrays.toString(na.solution(12345)));
    }
    public int[] solution(long n) {
        String str = "" + n;
        int[] answer = new int[str.length()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = (int) (n % 10); // (n % 10) 괄호 없으면 ((int)n) % 10으로 인식함
            n /= 10;
        }

        return answer;
    }
}
