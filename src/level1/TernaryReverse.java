package level1;

import java.util.Stack;

public class TernaryReverse {

    public static void main(String[] args) {
        TernaryReverse tr = new TernaryReverse();
        System.out.println(tr.solution(125));
    }

    public int solution(int n) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();

        while (n != 0) {
            st.push(n % 3);
            n /= 3;
        }

        int sSize = st.size();  // 스택, 큐의 사이즈만큼 반복을 돌리고 싶다면 << 처럼 하거나 while(stack.isEmpty()) 이렇게
        for (int i = 0; i < sSize; i++) {
            answer = answer + (st.pop() * (int) Math.pow(3, i));    // Math.pow를 사용해 거듭제곱을 구한다.
        }

        return answer;
    }

}
