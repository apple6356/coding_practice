package level2;

public class ExpectationMatches {

    public static void main(String[] args) {
        ExpectationMatches em = new ExpectationMatches();
        System.out.println(em.solution(8, 4, 7));
        System.out.println(em.solution(256, 250, 241));
    }

    public int solution(int n, int a, int b) {
        int answer = 1;

        while (true) {
            if (a + 1 == b && b % 2 == 0) break;
            if (b + 1 == a && a % 2 == 0) break;

            answer++;
            if (a % 2 == 0) a /= 2;
            else a = (a / 2) + 1;

            if (b % 2 == 0) b /= 2;
            else b = (b / 2) + 1;
        }

        return answer;
    }
}
