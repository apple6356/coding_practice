package level2;

import java.util.Stack;

public class RightBracket {

    public static void main(String[] args) {
        RightBracket rb = new RightBracket();
        System.out.println(rb.solution("()()"));
        System.out.println(rb.solution("(())()"));
        System.out.println(rb.solution(")()("));
        System.out.println(rb.solution("(()("));
    }

    boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') st.push(ch);
            else if (st.isEmpty() && ch == ')') return false;
            else if (st.peek() == '(' && ch == ')') st.pop();
        }

        if (!st.isEmpty()) return false;

        return true;
    }
}
