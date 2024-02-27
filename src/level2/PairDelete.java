package level2;

import java.util.Stack;

public class PairDelete {

    public static void main(String[] args) {
        PairDelete pd = new PairDelete();
        System.out.println(pd.solution("baabaa"));
        System.out.println(pd.solution("cdcd"));
    }

    public int solution(String s) {
        // stack 사용을 다른 사람의 풀이를 보고 알았음.
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // stack이 비었으면 push후 continue
            if (st.isEmpty()) {
                st.push(s.charAt(i));
                continue;
            }
            if (st.peek() == s.charAt(i)) st.pop(); // stack과 비교 후 맞으면 pop
            else st.push(s.charAt(i));  // 아니면 push
        }

        return st.isEmpty() ? 1 : 0;    // 삼항 연산자를 사용해 stack이 비었으면(모든 문자가 제거되면 1, 아니면 0 return
    }
}
