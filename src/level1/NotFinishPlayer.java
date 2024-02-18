package level1;

import java.util.*;

public class NotFinishPlayer {

    public static void main(String[] args) {
        NotFinishPlayer notFinishPlayer = new NotFinishPlayer();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(notFinishPlayer.solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(notFinishPlayer.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String string : participant) {
            // getOrDefault 사용하면 더 가독성 좋음
            if (map.containsKey(string)) map.put(string, map.get(string) + 1);
            else map.put(string, 1);
        }

        for (String string : completion) {
            map.put(string, map.get(string) - 1);
        }

        for (String string : map.keySet()) {
            if (map.get(string) != 0) {
                answer = string;
                // break; 넣으면 더 탐색하지 않음
            }
        }

        return answer;
    }
}
