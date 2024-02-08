package level1;

public class NegaPosiAdd {
    public static void main(String[] args) {
        NegaPosiAdd npa = new NegaPosiAdd();
        int[] a = {4, 7, 12};
        boolean[] s = {true, false, true};
        System.out.println(npa.solution(a, s));
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) {
            // answer += absolutes[i] * (signs[i]? 1: -1);  * 삼항연산자를 사용하면 더 깔끔하다
            if(signs[i] == false) {
                absolutes[i] *= -1;
            }
            answer += absolutes[i];
        }
        return answer;
    }

}
