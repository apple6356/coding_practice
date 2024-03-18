package level2;

public class DigitPrime {

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);  // n을 k진수로 변환 | 10진수로 변환시 parseInt 사용

        String[] str = s.split("0");    // 0을 기준으로 나눈다

        // 다른 사람 풀이 참조
        for (String s1 : str) {
            if (s1.equals("")) continue;

            boolean isPrime = true;
            long l = Long.parseLong(s1);

            if (l == 1) continue;   // 값이 1이면 건너뛴다

            // 소수 판별
            for (int i = 2; i <= Math.sqrt(l); i++) {
                if (l % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            // 소수면 answer +1
            if (isPrime) answer++;
        }

/*
        처음 풀었던 코드
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                str += s.charAt(i);
            } else if (s.charAt(i) == '0' && !str.isEmpty()) {
                Long p = Long.parseLong(str);
                if (p == 1) {
                    str = "";
                    continue;
                }
                boolean isPrime = true;

                for (int j = 2; j <= Math.sqrt(p); j++) {
                    if (p % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) answer++;
                str = "";
            }
        }

        if (!str.isEmpty()) {
            Long p = Long.parseLong(str);
            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(p); j++) {
                if (p % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (p == 1) isPrime = false;
            if (isPrime) answer++;
        }
*/

        return answer;
    }
}
