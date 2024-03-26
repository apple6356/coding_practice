package level2;

public class NDecimalGame {

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";

        int i = 0;      // 현재 숫자
        int turn = 1;   // 현재 순서
        // answer.legth가 t보다 작을때 반복
        while (answer.length() < t) {
            String s = Integer.toString(i, n);  // i를 n진수로 변환
            s = s.toUpperCase();    // 문자의 경우 대문자로 변경
            for (int j = 0; j < s.length(); j++) {
                if (turn == p) {    // p가 현재 순서와 같으면 실행
                    answer += s.charAt(j);  // answer에 현재 문자 삽입
                    if (answer.length() >= t) break;    // 문자열이 t만큼 길어지면 정지
                }
                turn++;
                if (turn > m) turn = 1; // 순서가 m보다 커지면 1 로 초기화
            }
            i++;
        }

        return answer;
    }
}
