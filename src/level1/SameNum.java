package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SameNum {

    public static void main(String[] args) {
        SameNum sn = new SameNum();
        int[] arr = {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(sn.solution(arr)));
    }

    public int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if(stack.empty() || stack.peek() != arr[i]) stack.push(arr[i]);
        }

        answer = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
