package Level0;

public class Hap_0 {
    public static void main(String[] args) {
        Hap_0 h = new Hap_0();
        System.out.println(h.solution(9, 91));
        System.out.println(h.solution(89, 8));
        System.out.println(h.solution(73, 9));
    }

    public int solution(int a, int b){
        int answer = 0;

        String str1 = Integer.toString(a);
        String str2 = Integer.toString(b);

        int ab = Integer.parseInt(str1 + str2);
        int ba = Integer.parseInt(str2 + str1);

        if(ab > ba) {
            answer = ab;
        }
        else {
            answer = ba;
        }

        return answer;
    }

    /* 다른 사람의 풀이
    class Solution {
        public int solution(int a, int b) {
            int answer = 0;
            int aLong = Integer.parseInt(""+a+b);   // 자바는 문자열 + 숫자 를 문자열로 처리하기 때문에 가능하다
            int bLong = Integer.parseInt(""+b+a);
            answer = aLong > bLong ? aLong : bLong; // 삼항연산자 사용하면 편하다

            return answer;
        }
    } */
}
