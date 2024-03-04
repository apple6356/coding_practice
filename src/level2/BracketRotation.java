package level2;

import java.util.Stack;

public class BracketRotation {

    public static void main(String[] args) {
        BracketRotation br = new BracketRotation();
        System.out.println(br.solution("[](){}"));
        System.out.println(br.solution("}]()[{"));
        System.out.println(br.solution("[)(]"));
        System.out.println(br.solution("}}}"));

    }

    public int solution(String s) {
        int answer = 0;
        Stack<Character> st = new Stack<>();

        int LCount = 0;
        int RCount = 0;

        // 문자열에 괄호가 왼쪽 혹은 오른쪽만 있는 것을 검사
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') LCount++;
            else RCount++;
        }

        // 괄호가 한쪽만 있을경우 0리턴
        if (LCount == 0 || RCount == 0) {
            return 0;
        }


        for (int i = 0; i < s.length(); i++) {
            // 올바른 괄호문자열인지 stack을 활용해 검사
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(' || s.charAt(j) == '{' || s.charAt(j) == '[') {
                    st.push(s.charAt(j));
                } else if (!st.isEmpty()) {
                    if (st.peek() == '(' && s.charAt(j) == ')') st.pop();
                    else if (st.peek() == '{' && s.charAt(j) == '}') st.pop();
                    else if (st.peek() == '[' && s.charAt(j) == ']') st.pop();
                }
            }

            // 스택이 비었다면 올바른 괄호열이기 때문에 answer에 1 추가
            if (st.isEmpty()) answer++;
            // 다음 루프를 위해 스택 클리어
            st.clear();

            // 문자열 왼쪽으로 한번 돌리기
            s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }
}
