package level1;

public class DivisorAddMinus {

    public static void main(String[] args) {
        DivisorAddMinus dam = new DivisorAddMinus();
        System.out.println(dam.solution(13, 17));
    }

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int div = 0;
            for (int j = 1; j <= i; j++) {
                if(i % j == 0) div++;
            }
            if(div % 2 == 0) answer += i;
            else answer -= i;
        }

        return answer;
    }
}
