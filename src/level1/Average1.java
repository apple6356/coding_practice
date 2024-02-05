package level1;

import java.util.Arrays;

public class Average1 {
    public static void main(String[] args) {
        Average1 av = new Average1();
        int[] arr = {1, 2, 3, 4};
        System.out.println(av.solution(arr));
    }
    public double solution(int[] arr) {
        double answer = 0;
        for(int i = 0; i < arr.length ; i++){
            answer = answer + arr[i];
        }
        answer = answer / arr.length;
        return answer;
    }

    /* 다른 사람의 풀이
    public int getMean(int[] array) {
        return (int) Arrays.stream(array).average().orElse(0); // stream을 사용하여 한 줄로 해결
    }
    */
}
