package level0;

public class String_mul {
    public static void main(String[] args) {
        String_mul sm = new String_mul();
        System.out.println(sm.solution("string", 3));
        System.out.println(sm.solution("love", 10));
    }

    public String solution(String my_string, int k) {
        String answer = "";
        int i = 0;

        while(i < k){
            answer = answer + my_string;
            i++;
        }

        return answer;
    }

    /* 다른 사람의 풀이
    class Solution {
        public String solution(String my_string, int k) {
            return my_string.repeat(k);     // repeat 메서드를 사용해 간단히 해결가능하다
        }
    }*/
}
