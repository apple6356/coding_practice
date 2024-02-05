package level0;

import java.util.Arrays;

public class Sequence_0 {
    public static void main(String[] args) {
        Sequence_0 se = new Sequence_0();
        int[] a = {1, 2, 3, 100, 99, 98};
        System.out.println(Arrays.toString(se.solution(a)));
    }

    public int[] solution(int[] arr) {
        int[] answer = {};

        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 50 && (arr[i] % 2 == 0)){
                arr[i] = arr[i] / 2;
            }
            else if(arr[i] < 50 && (arr[i] % 2 == 1)){
                arr[i] = arr[i] * 2;
            }
        }
        answer = arr;

        return answer;
    }

    /* 다른 사람의 풀이
    public int[] solution(int[] arr) {
        return Arrays.stream(arr).map(operand -> operand >= 50 && operand % 2 == 0 ? operand / 2 : operand < 50 && operand % 2 == 1 ? operand * 2 : operand).toArray();
    }*/
}
