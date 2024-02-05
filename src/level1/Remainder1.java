package level1;

public class Remainder1 {
    public static void main(String[] args) {
        Remainder1 re = new Remainder1();
        int n = 15;
        System.out.println(re.solution(n));
    }
    public int solution(int n) {
        int answer = 0;
        for(answer = 1; answer <= n; answer++){
            if(n % answer == 1) {
                break;
            }
        }
        return answer;
    }
}
