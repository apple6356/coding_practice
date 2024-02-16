package level1;

public class DartGame {

    public static void main(String[] args) {
        DartGame dartGame = new DartGame();
        String str = "1S2D*3T";
        System.out.println(dartGame.solution(str));

        str = "1D2S#10S";
        System.out.println(dartGame.solution(str));

        str = "1D2S0T";
        System.out.println(dartGame.solution(str));

        str = "1S*2T*3S";
        System.out.println(dartGame.solution(str));

        str = "1D#2S*3S";
        System.out.println(dartGame.solution(str));

        str = "1T2D3D#";
        System.out.println(dartGame.solution(str));

        str = "1D2S3T*";
        System.out.println(dartGame.solution(str));
    }

    public int solution(String dartResult) {
        int answer = 0;
        int[] sum = new int[3]; // 각각의 점수 계산
        String score = "";  // 10 이상의 점수를 저장하기 위한 문자열

        for (int i = 0, j = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            // 문자가 숫자 일 때
            if (48 <= ch && ch <= 57) {
                score = String.valueOf(sum[j]) + (ch - '0');
                sum[j] = Integer.parseInt(score);
            }
            // S, D, T 일 때
            if (ch == 'S' || ch == 'D' || ch == 'T') {
                if(ch == 'S') sum[j] = (int) Math.pow(sum[j], 1);
                else if(ch == 'D') sum[j] = (int) Math.pow(sum[j], 2);
                else if(ch == 'T') sum[j] = (int) Math.pow(sum[j], 3);
                score = "";
                j++;
            }
            // *, # 일 때
            if (ch == '*' || ch == '#') {
                if (ch == '*') {
                    if (j > 1) sum[j - 2] *= 2;
                    sum[j - 1] *= 2;
                } else if (ch == '#') {
                    sum[j - 1] *= -1;
                }
            }
        }

        for (int i = 0; i < sum.length; i++) {
            answer += sum[i];
        }

        return answer;
    }

}
