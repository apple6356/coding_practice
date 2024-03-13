package level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class News {

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        double d = 0d;
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // A에 2글자씩 삽입
        for (int i = 0; i < str1.length() - 1; i++) {
            // 영문자가 아니면 버린다.
            if ('a' <= str1.charAt(i) && str1.charAt(i) <= 'z'
                    && 'a' <= str1.charAt(i + 1) && str1.charAt(i + 1) <= 'z') {
                A.add(str1.substring(i, i + 2));
            }
        }

        // ㅠ에 2글자씩 삽입
        for (int i = 0; i < str2.length() - 1; i++) {
            if ('a' <= str2.charAt(i) && str2.charAt(i) <= 'z'
                    && 'a' <= str2.charAt(i + 1) && str2.charAt(i + 1) <= 'z') {
                B.add(str2.substring(i, i + 2));
            }
        }

        double union = 0;           // 합집합
        double intersection = 0;    // 교집합
        List<String> sList = new ArrayList<>(); // 교집합 문자열

        for (int i = 0; i < A.size(); i++) {
            // 교집합을 검사한다, 이미 한번 검색한 것은 제외한다.
            if (B.contains(A.get(i)) && !sList.contains(A.get(i))) {
                int nA = 0;
                int nB = 0;
                for (String s : A) {
                    if (A.get(i).equals(s)) nA++;
                }
                for (String s : B) {
                    if (A.get(i).equals(s)) nB++;
                }
                sList.add(A.get(i));
                union += Math.max(nA, nB);          // 교집합은 합집에도 포함됨
                intersection += Math.min(nA, nB);   // 교집합 +1
            } else if (!sList.contains(A.get(i))) union++;  // 합집합 +1
        }

        for (String s : B) {
            // B집합의 합집합도 검사
            if (!sList.contains(s)) union++;
        }

        if (intersection == 0 && union == 0) d = 1;
        else d = intersection / union;

        answer = (int) (d * 65536);
        return answer;
    }
}
