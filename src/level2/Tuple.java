package level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Tuple {

    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        System.out.println(Arrays.toString(tuple.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(tuple.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(tuple.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(tuple.solution("{{123}}")));
        System.out.println(Arrays.toString(tuple.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }

    public int[] solution(String s) {
        int[] answer = {};
        Map<Integer, String> map = new HashMap<>();
        s = s.substring(1, s.length());
        boolean flag = false;
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                flag = true;
                continue;
            } else if (s.charAt(i) == '}') {
                flag = false;
                idx++;
                continue;
            }

            if (flag) {
                String str;
                if (map.get(idx) != null) {
                    str = map.get(idx) + s.charAt(i);
                } else str = String.valueOf(s.charAt(i));

                map.put(idx, str);
                System.out.println(map.get(idx));
            }
        }

        return answer;
    }
}
