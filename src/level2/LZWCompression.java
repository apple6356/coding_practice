package level2;

import java.util.*;

public class LZWCompression {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
    }

    public static int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();     // 출력 저장
        Map<String, Integer> map = new HashMap<>(); // 사전

        char c = 'A';
        int n = 1;
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(c++), n++);
        }

        while (!msg.isEmpty()) {
            String w = "";

            for (int i = 0; i <= msg.length(); i++) {
                w = msg.substring(0, i);
                if (i == msg.length()) {
                    list.add(map.get(w));
                    msg = "";
                    break;
                }
                if (!map.containsKey(w + msg.charAt(i))) {
                    list.add(map.get(w));
                    map.put(w + msg.charAt(i), n++);
                    msg = msg.substring(i);
                    break;
                }
            }
        }

//        System.out.println("msg.length() = " + msg.length());
//        for (int i = 0; i < msg.length(); i++) {
//            String w = "";
//            for (int j = msg.length() - 1; j >= 0; j--) {
//                if (i + j >= msg.length()) continue;
//                w = msg.substring(i, i + j);
//                c = msg.charAt(i + j);
//                if (i == msg.length() - 1) System.out.println("last i = " + i + ", j = " + j + ", w = " + w + ", c = " + c);
//                if (map.containsKey(w)) {
//                    list.add(map.get(w));
//                    map.put(w + c, n++);
//                    i += j - 1;
//                    System.out.println("i = " + i + ", j = " + j + ", w = " + w + ", c = " + c);
//                    System.out.println("map.get(w) = " + map.get(w) + ", map.get(w + c) = " + map.get(w + c));
//                    break;
//                }
//            }
//        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
