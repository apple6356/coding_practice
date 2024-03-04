package level2;

public class JumpTeleport {

    public static void main(String[] args) {
        JumpTeleport jt = new JumpTeleport();
        System.out.println(jt.solution(5));
        System.out.println(jt.solution(6));
        System.out.println(jt.solution(5000));
    }

    public int solution(int n) {
        int ans = 0;

        /*
         * 주어진 N이 0이 될 때까지 다음 연산을 반복한다.
         * N이 짝수면 N /= 2
         * N이 홀수면 N -= 1
         * 다른 사람의 풀이 참조 해서 풀었음
         * */
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }

}
