package level2;

import java.util.ArrayList;
import java.util.List;

public class News {

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        double d = 0;
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length() - 1; i++) {

        }

        answer = (int) (d * 65536);
        return answer;
    }
}
